package game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import game.bean.Comment;

public class CommentDaoImpl implements CommentDao{
	//查某游戏的评论数
	@Override
	public int queryCommentNum(String gid) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int commentnum=0;

        try {
            conn = getConnection();
            String sql = "select count(*)  from `comment` where gid=?"; //****切记，这里comment是mysql保留字，需要加上反引号
            ps = conn.prepareStatement(sql);
            ps.setString(1, gid);
            rs = ps.executeQuery();
            if(rs.next()) {
            	commentnum=rs.getInt(1);
            }

        }catch (Exception e) {
        	System.out.println("!500 imp-comment-queryNum");
		}  finally {
			closeResources_for_query(conn, ps, rs);
        }

        return commentnum;
	}
	
	//查询某游戏的全部评论（CTE递归查询，考虑了回复评论的排版顺序）
	@Override
	public List<Comment> queryAllCommentByGid(String gid) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Comment> allComments=new ArrayList<>();

        try {
            conn = getConnection(); 
            String sql = "WITH RECURSIVE allComments(cid,uid,gid,uname,ctime,`comment`,clike,cparentid,cpath\r\n"
            		+ ") AS (\r\n"
            		+ "    -- 基础查询：获取所有一级评论（ac表）\r\n"
            		+ "    SELECT cid,uid,gid,uname,ctime,`comment`,clike,cparentid\r\n"
            		+ "	 	,CAST(\r\n"
            		+ "		 	concat(LPAD(99999-clike, 5, '0'),'[',ctime,']')\r\n"
            		+ "			 AS CHAR(255)) AS cpath\r\n"
            		+ "    FROM `comment` -- into allComments （即ac表）\r\n"
            		+ "    WHERE cparentid IS NULL  -- 一级评论的cparentid为NULL\r\n"
            		+ "    	AND gid= ? \r\n"	//通配符在这里
            		+ "    \r\n"
            		+ "\r\n"
            		+ "    UNION ALL\r\n"
            		+ "\r\n"
            		+ "    -- 递归查询：获取所有子评论（c表）\r\n"
            		+ "    SELECT c.cid,c.uid,c.gid,c.uname,c.ctime,c.`comment`,c.clike,c.cparentid\r\n"
            		+ "	 	,CONCAT(ac.cpath,'#',CONCAT('[',c.ctime,']')) AS cpath\r\n"
            		+ "    FROM `comment` c\r\n"
            		+ "    INNER JOIN allComments ac ON c.cparentid = ac.cid\r\n"
            		+ ")\r\n"
            		+ "-- 最终查询：选择所有评论，可以根据需要添加ORDER BY等子句\r\n"
            		+ "SELECT * FROM allComments \r\n"
            		+ "ORDER BY cpath ASC;\r\n"
            		+ ""; 
            ps = conn.prepareStatement(sql);
            ps.setString(1, gid);
            rs = ps.executeQuery();
            while(rs.next()) {
            	allComments.add(new Comment(
            			rs.getString("cid"),rs.getString("uid"),rs.getString("gid"),
            			rs.getString("uname"),rs.getString("ctime"),rs.getString("comment"),
            			rs.getString("clike"),rs.getString("cparentid"),rs.getString("cpath")));//9参
            }
            return allComments;

        }catch (Exception e) {
        	System.out.println("!500 imp-comment-queryAll");
        	e.printStackTrace();
		}  finally {
			closeResources_for_query(conn, ps, rs);
        }

        return null;
	}
	
	//插入
	@Override
	public int insertComment(Comment comment) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;

        try {
            conn = getConnection(); 
            String sql = "insert into `comment`(uid,gid,uname,ctime,`comment`,clike,cparentid) "
            		+ "values(?,?,?,?,?,?,?) "; 	//7参
            ps = conn.prepareStatement(sql);
            ps.setString(1, comment.getUid());
            ps.setString(2, comment.getGid());
            ps.setString(3, comment.getUname());
            ps.setString(4, comment.getCtime());
            ps.setString(5, comment.getComment());
            ps.setString(6, comment.getClike());
            ps.setString(7, comment.getCparentid());
            rs = ps.executeUpdate();
            
            return rs;

        }catch (Exception e) {
        	System.out.println("!500 imp-comment-insert");
		}  finally {
			closeResources_for_update(conn, ps);
        }
        
        return 0;
	}
	
	//删除
	@Override
	public int deleteCommentByCid(String cid) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;

        try {
            conn = getConnection(); 
            String sql = "delete from `comment` where cid=? "; 
            ps = conn.prepareStatement(sql);
            ps.setString(1, cid);
            rs = ps.executeUpdate();
            
            return rs;

        }catch (Exception e) {
        	System.out.println("!500 imp-comment-delete");
		}  finally {
			closeResources_for_update(conn, ps);
        }
        
        return 0;
	}

	@Override
	public int updateComment(Comment comment) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows = 0;
        
        try {
            conn = getConnection();
            String sql = "update `comment` set "
            		+ "`comment`=?,clike=?"
            		+ " where gid=?";
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, comment.getComment());
            ps.setString(2, comment.getClike());
            ps.setString(3, comment.getGid());
            
            affectedRows = ps.executeUpdate();
            
        }catch (Exception e) {
        	System.out.println("!500 imp-comment-update");
        	System.out.println("待update数据:"+comment);
		}  finally {
            closeResources_for_update(conn, ps);
        }

        return affectedRows;
	}
	
	
}