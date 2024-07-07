package crf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import crf.invest.entity.Funding;
import crf.system.entity.UserBean;

public class UserDaoImpl implements UserDao{
	String driver = "com.mysql.jdbc.Driver";
	String url="jdbc:mysql://127.0.0.1:3306/aaa?characterEncoding=utf-8";
	String username="root";
	String password="22023237";
	//获得连接
	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
	@Override
	public long getUserListCount(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="select count(*) from user where 1=1 ";
		if (map.get("username")!="") {
			sql+=" and username='"+map.get("username")+"'";
		}
		ResultSet rs = state.executeQuery(sql);	
		if (rs.next()) {
			return rs.getInt(1);
		}
		rs.close();
		state.close();
		conn.close();
		return 0;
	}

	@Override
	public List<UserBean> queryUserListTable(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();//获取连接
		Statement state = conn.createStatement();//创建声明
		String sql="select *,(select realname from user b where a.createid=b.username )as createname from user a where 1=1 ";
		if (map.get("username")!="") {
			sql+=" and username='"+map.get("username")+"'";
		}
		ResultSet rs = state.executeQuery(sql);	
		List<UserBean> list = new ArrayList<UserBean>();
		while(rs.next()) {
			UserBean user = new UserBean();
			String id = rs.getString("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String realname = rs.getString("realname");
			String email = rs.getString("email");
			String mobile = rs.getString("mobile");
			String is_enable = rs.getString("is_enable");
			String createid = rs.getString("createid");
			String createtime = rs.getString("createtime");
			String last_login_time = rs.getString("last_login_time");
			String last_login_ip = rs.getString("last_login_ip");
			String createname = rs.getString("createname");
			user.setId(Long.parseLong(id));
			user.setUsername(username);
			user.setPassword(password);
			user.setRealname(realname);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setIs_enable(is_enable);
			user.setCreateid(createid);
			user.setCreatetime(createtime);
			user.setLast_login_ip(last_login_ip);
			user.setLast_login_time(last_login_time);
			user.setCreatename(createname);
			list.add(user);
		}
		rs.close();
		state.close();
		conn.close();
		return list;
	}
	@Override
	public UserBean queryUserByUsername(String username) throws Exception {
		Connection conn = getConnection();//获取连接
		Statement state = conn.createStatement();//创建声明
		String sql="select * from user where username='"+username+"'";
		ResultSet rs = state.executeQuery(sql);	
		UserBean user = null;
		while(rs.next()) {
			user = new UserBean();
			String id = rs.getString("id");
			String name = rs.getString("username");
			String password = rs.getString("password");
			String realname = rs.getString("realname");
			String email = rs.getString("email");
			String mobile = rs.getString("mobile");
			String is_enable = rs.getString("is_enable");
			String createid = rs.getString("createid");
			String createtime = rs.getString("createtime");
			String last_login_time = rs.getString("last_login_time");
			String last_login_ip = rs.getString("last_login_ip");
			user.setId(Long.parseLong(id));
			user.setUsername(name);
			user.setPassword(password);
			user.setRealname(realname);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setIs_enable(is_enable);
			user.setCreateid(createid);
			user.setCreatetime(createtime);
			user.setLast_login_ip(last_login_ip);
			user.setLast_login_time(last_login_time);
			
		}
		rs.close();
		state.close();
		conn.close();
		return user;
	}
	@Override
	public int insertUser(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="insert into user(username,password,realname,email,mobile,is_enable,createid,createtime) values('"+map.get("username")+"','"+map.get("password")+"','"+map.get("realname")+"','"+map.get("email")+"','"+map.get("mobile")+"','"+map.get("is_enable")+"','"+map.get("createid")+"','"+map.get("createtime")+"')";
		System.out.println(sql);
		int tiao = state.executeUpdate(sql);	
		state.close();
		conn.close();
		return tiao;
	}
	@Override
	public int update(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="  		update user set password='"+map.get("password")+"',realname='"+map.get("realname")+"',email='"+map.get("email")+"'," + 
				"   			mobile='"+map.get("mobile")+"' where username='"+map.get("username")+"'";
		int tiao = state.executeUpdate(sql);	
		state.close();
		conn.close();
		return tiao;
	}
	@Override
	public int deleteUser(String username) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql=" delete from user where username='"+username+"'";
		int tiao = state.executeUpdate(sql);	
		state.close();
		conn.close();
		return tiao;
	}

}
