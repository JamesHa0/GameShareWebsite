package game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import game.bean.Like;

public class LikeDaoImpl implements LikeDao{
	//查【指定游戏的】赞数
	@Override
	public int queryLikeNum(String gid) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int likenum=0;

        try {
            conn = getConnection();
            String sql = "select count(*)  from `like` where gid=?"; //****切记，这里like是mysql保留字，需要加上反引号
            ps = conn.prepareStatement(sql);
            ps.setString(1, gid);
            rs = ps.executeQuery();
            if(rs.next()) {
            	likenum=rs.getInt(1);
            }

        }catch (Exception e) {
        	System.out.println("!500 imp-like-queryNum");
		}  finally {
			closeResources_for_query(conn, ps, rs);
        }

        return likenum;
	}
	
	//查是否点过赞
	@Override
	public boolean queryIsLikedByUidAndGid(String uid, String gid) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            String sql = "select * from `like` where uid=? and gid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setString(2, gid);
            rs = ps.executeQuery();
            
            if(rs.next()) {
            	return true;
            }

        }catch (Exception e) {
        	System.out.println("!500 imp-like-queryIsLiked");
		}  finally {
			closeResources_for_query(conn, ps, rs);
        }

        return false;
	}
	
	//插入
	@Override
	public int insertLike(Like like) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows=0;

        try {
            conn = getConnection();
            String sql = "insert into `like`(uid,gid,ltime) value(?,?,?)";//3
            ps = conn.prepareStatement(sql);
            ps.setString(1, like.getUid());
            ps.setString(2, like.getGid());
            ps.setString(3,like.getLtime());
            affectedRows = ps.executeUpdate();
            
        }catch (Exception e) {
        	System.out.println("!500 imp-like-insert");
		}  finally {
			closeResources_for_update(conn, ps);
        }

        return affectedRows;
	}
	
	//删除
	@Override
	public int deleteLikeByUidAndGid(String uid, String gid) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows=0;

        try {
            conn = getConnection();
            String sql = "delete from `like` where uid=? and gid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setString(2, gid);
            affectedRows = ps.executeUpdate();
            
        }catch (Exception e) {
        	System.out.println("!500 imp-like-delete");
		}  finally {
			closeResources_for_update(conn, ps);
        }

        return affectedRows;
	}
	
	
}