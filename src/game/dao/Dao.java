package game.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import game.bean.UserLog;

public interface Dao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://127.0.0.1:3306/Game?characterEncoding=utf-8";
	String username="root";
	String password="root";
	//获得连接
	public default Connection getConnection() {
		UserLog userLog=new UserLog();
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("!!! Dao接口：获取连接对象失败。");
			userLog.logOperation("!", "!", "!", "Dao接口：获取连接对象失败。", "失败");
		}
		
		return conn;
	}

	//关闭资源（查询操作）
	public default void closeResources_for_query(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
	//关闭资源（更新操作）
	public default void closeResources_for_update(Connection conn, PreparedStatement ps) {
        try {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
}
