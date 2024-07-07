package crf.dao;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crf.system.entity.Operation;
import crf.system.entity.UserBean;

public class LoginDaoImpl implements LoginDao{
	String driver = "com.mysql.jdbc.Driver";
	String url="jdbc:mysql://127.0.0.1:3306/Game?characterEncoding=utf-8";
	String username="root";
	String password="root";
	//获得连接
	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
	
	
	
	
	@Override
	public UserBean queryUserByUsernameAndPassword(String username, String password) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="select * from user where username='"+username+"' and password='"+password+"'";
		ResultSet rs = state.executeQuery(sql);
		UserBean user=null;
		while(rs.next()) {
			user = new UserBean();
			String id = rs.getString("id");
			String name = rs.getString("username");
			String word = rs.getString("password");
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
			user.setPassword(word);
			user.setRealname(realname);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setIs_enable(is_enable);
			user.setCreateid(createid);
			user.setCreatetime(createtime);
			user.setLast_login_time(last_login_time);
			user.setLast_login_ip(last_login_ip);
		}
		return user;
	}




	@Override
	public List<Operation> queryUserMenu(String username) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="select * from operation where is_enable='1' and operation_no in( " + 
				"select operation_no from actor_operation where actor_no in( " + 
				"select actor_no from actor where is_enable='1' and actor_no in( " + 
				"select actor_no from user_actor where username='"+username+"' " + 
				") " + 
				") " + 
				")";
		ResultSet rs = state.executeQuery(sql);
		List<Operation> list = new ArrayList<Operation>();
		while(rs.next()) {
			String operation_no = rs.getString("operation_no");
			String operation_name = rs.getString("operation_name");
			String operation_url = rs.getString("operation_url");
			String parent_id = rs.getString("parent_id");
			Operation op =new Operation();
			op.setOperation_no(operation_no);
			op.setOperation_name(operation_name);
			op.setOperation_url(operation_url);
			op.setParent_id(parent_id);
			list.add(op);
		}
		rs.close();
		state.close();
		conn.close();
		return list;
	}




	@Override
	public List<Operation> queryUserParnetMenu(List<String> parentIds) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="select operation_no,operation_name from operation where operation_no in(";
			for (int i = 0; i < parentIds.size(); i++) {
				if (i!=parentIds.size()-1) {
					sql+=parentIds.get(i)+",";
				}else {
					sql+=parentIds.get(i);
				}
			}
		
		sql+=")";
		ResultSet rs = state.executeQuery(sql);
		List<Operation> list = new ArrayList<Operation>();
		while(rs.next()) {
			String operation_no = rs.getString("operation_no");
			String operation_name = rs.getString("operation_name");
			Operation op =new Operation();
			op.setOperation_no(operation_no);
			op.setOperation_name(operation_name);
			list.add(op);
		}
		rs.close();
		state.close();
		conn.close();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	

}
