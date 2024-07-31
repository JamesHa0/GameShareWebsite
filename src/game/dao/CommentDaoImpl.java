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
	
	//查询某游戏的全部评论
	@Override
	public List<Comment> queryAllCommentByGid(String gid) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Comment> li=new ArrayList<>();

        try {
            conn = getConnection(); 
            String sql = "select * from `comment` where gid= ? "; 
            ps = conn.prepareStatement(sql);
            ps.setString(1, gid);
            rs = ps.executeQuery();
            while(rs.next()) {
            	li.add(new Comment(rs.getString(1), rs.getString(2),
            			rs.getString(3), rs.getString(4),rs.getString(5)));
            }
            return li;

        }catch (Exception e) {
        	System.out.println("!500 imp-comment-queryAll");
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
            String sql = "insert into `comment`(uid,gid,ctime,comment) values(?,?,?,?) "; 
            ps = conn.prepareStatement(sql);
            ps.setString(1, comment.getUid());
            ps.setString(2, comment.getGid());
            ps.setString(3, comment.getCtime());
            ps.setString(4, comment.getComment());
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
	public int deleteCommentByUidAndGid(String uid, String gid) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;

        try {
            conn = getConnection(); 
            String sql = "delete from `comment` where uid=? and gid=? "; 
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setString(2, gid);
            rs = ps.executeUpdate();
            
            return rs;

        }catch (Exception e) {
        	System.out.println("!500 imp-comment-delete");
		}  finally {
			closeResources_for_update(conn, ps);
        }
        
        return 0;
	}
	
	
}