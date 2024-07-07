package crf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crf.invest.entity.Book;
import crf.system.entity.UserBean;

public class BookDaoImpl implements BookDao{
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
	public long getBookListCount(String bookname) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="select count(*) from book where 1=1 ";
		if (bookname!="") {
			sql+=" and bookname='"+bookname+"'";
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
	public List<Book> queryBookListTable(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();//获取连接
		Statement state = conn.createStatement();//创建声明
		String sql="select * from book where 1=1 ";
		if (map.get("bookname")!="") {
			sql+=" and bookname='"+map.get("bookname")+"'";
		}
		ResultSet rs = state.executeQuery(sql);	
		List<Book> list = new ArrayList<Book>();
		while(rs.next()) {
			Book b = new Book();
			String id = rs.getString("id");
			String bookname = rs.getString("bookname");
			String price = rs.getString("price");
			String author = rs.getString("author");
			b.setId(Integer.parseInt(id));
			b.setBookname(bookname);
			b.setPrice(price);
			b.setAuthor(author);
			list.add(b);
		}
		rs.close();
		state.close();
		conn.close();
		return list;
	}
	@Override
	public Book queryBookById(String id) throws Exception {
		Connection conn = getConnection();//获取连接
		Statement state = conn.createStatement();//创建声明
		String sql="select * from book where id='"+id+"' ";
		ResultSet rs = state.executeQuery(sql);	
		Book b = null;
		while(rs.next()) {
			b = new Book();
			String ids = rs.getString("id");
			String bookname = rs.getString("bookname");
			String price = rs.getString("price");
			String author = rs.getString("author");
			b.setId(Integer.parseInt(ids));
			b.setBookname(bookname);
			b.setPrice(price);
			b.setAuthor(author);
		}
		rs.close();
		state.close();
		conn.close();
		return b;
	}
	@Override
	public int insertBook(HashMap<String, Object> map) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="insert into book(bookname,price,author) values('"+map.get("bookname")+"','"+map.get("price")+"','"+map.get("author")+"')";
		System.out.println(sql);
		int tiao = state.executeUpdate(sql);	
		state.close();
		conn.close();
		return tiao;
	}
	@Override
	public int updateBookById(HashMap<String, Object> map) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="update  book set bookname='"+map.get("bookname")+"',price='"+map.get("price")+"',author='"+map.get("author")+"' where id='"+map.get("id")+"'";
		System.out.println(sql);
		int tiao = state.executeUpdate(sql);	
		state.close();
		conn.close();
		return tiao;
	}
	@Override
	public int deleteBookById(String id) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="delete from book where id='"+id+"'";
		System.out.println(sql);
		int tiao = state.executeUpdate(sql);	
		state.close();
		conn.close();
		return tiao;
	}

}
