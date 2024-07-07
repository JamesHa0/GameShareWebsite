package crf.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * 连接数据库的工具类,被定义成不可继承且是私有访问
 * @author lanp
 * @since 2012-2-29 22:27
 */
public final class DbUtil {
	
	private static Logger log = Logger.getLogger(DbUtil.class);
	
//	static {
//		try {
//			Class.forName(PropertiesUtil.dbProp.getProperty("driver"));
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//	}
	private DbUtil() {}
	
//	/**
//	 * 获取数据库的连接
//	 * @return conn
//	 */
//	public static Connection getConnection() {
//		try {
//			if( conn == null  || conn.isClosed()) {
//				conn = DriverManager.getConnection(PropertiesUtil.dbProp.getProperty("url"), 
//						PropertiesUtil.dbProp.getProperty("username"), PropertiesUtil.dbProp.getProperty("password"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void closeResources(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(ps!=null){
				ps.close();
				ps=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
			log.info("*******CrfInvestWeb cloes Connection success!************");
		} catch (SQLException e) {
			log.error("*******CrfInvestWeb cloes Connection fail!************",e);
		}
	}
	
	/**
	 * tomcat管理数据库连接池
	 * @return conn
	 */
	public static Connection getConnection() {
		Connection conn = null;
        try {
        	Context initContext = new InitialContext(); 
        	Context envContext = (Context) initContext.lookup("java:/comp/env"); 
 			DataSource ds = (DataSource)envContext.lookup("CRF_INVEST_DATA_SORUCE"); 
            conn = ds.getConnection();
            log.info("*******CrfInvestWeb get Connection success!************");
        } catch (Exception e) {
        	log.error("*******CrfInvestWeb get Connection fail!************",e);
        } 
        return conn;
	}
}
