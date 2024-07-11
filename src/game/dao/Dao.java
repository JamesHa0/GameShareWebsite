package game.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public interface Dao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://127.0.0.1:3306/Game?characterEncoding=utf-8";
	String username="root";
	String password="root";
	//获得连接
	public default Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
}
