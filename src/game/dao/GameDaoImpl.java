package game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import game.bean.Game;

public class GameDaoImpl implements GameDao{
	
	//查询多条
	@Override
    public List<Game> queryAllGame() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Game> list = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "select * from gameinfo where 1=1";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String gid = rs.getString("gid");
                String gname = rs.getString("gname");
                String gprice = rs.getString("gprice");
                Game game = new Game(gid, gname, gprice);
                list.add(game);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return list;
    }
	
	//查询单条
	
	//**************************************************************query:
	@Override//by gid:
    public Game queryGameByGid(String gid) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Game game = null;

        try {
            conn = getConnection();
            String sql = "select * from gameinfo where gid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, gid);
            rs = ps.executeQuery();

            if (rs.next()) {
                String gname = rs.getString("gname");
                String gprice = rs.getString("gprice");
                game = new Game(gid, gname, gprice);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return game;
    }
	
	@Override//by gname:
	public Game queryGameByGname(String gname) throws Exception {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Game game = null;

        try {
            conn = getConnection();
            String sql = "select * from gameinfo where gname=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, gname);
            rs = ps.executeQuery();

            if (rs.next()) {
                String gid = rs.getString("gid");
                String gprice = rs.getString("gprice");
                game = new Game(gid, gname, gprice);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return game;
	}
	
	//************************************************************************8
	
	//插入
	@Override
    public int insertGame(Game game) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows = 0;

        try {
            conn = getConnection();
            String sql = "insert into Game(gid,gname, gprice) values (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, game.getGid());
            ps.setString(2, game.getGname());
            ps.setString(3, game.getGprice());
            affectedRows = ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return affectedRows;
    }
	
	//更新
	@Override
    public int updateGameByGId(Game game) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows = 0;

        try {
            conn = getConnection();
            String sql = "update Game set gname=?, gprice=? where gid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, game.getGid());
            ps.setString(2, game.getGname());
            ps.setString(3, game.getGprice());
            affectedRows = ps.executeUpdate();
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return affectedRows;
    }
	
	
	
	//删除
	 @Override
	    public int deleteGameByGId(String gid) throws Exception {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        int affectedRows = 0;

	        try {
	            conn = getConnection();
	            String sql = "delete from gameinfo where gid=?";
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, gid);
	            affectedRows = ps.executeUpdate();
	        } finally {
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        }

	        return affectedRows;
	    }

	
}