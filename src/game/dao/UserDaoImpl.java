package game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import game.bean.User;

public class UserDaoImpl implements UserDao{
	
	// 查询所有用户
    @Override
    public List<User> queryAllUser() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT * FROM userinfo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String uid = rs.getString("uid");
                String uname = rs.getString("uname");
                String utel = rs.getString("utel");
                String uemail = rs.getString("uemail");
                String urole = rs.getString("urole");
                String ugender = rs.getString("ugender");
                String uaddress = rs.getString("uaddress");
                String upsw = rs.getString("upsw");
                String upoint = rs.getString("upoint");

                User user = new User(uid, uname, utel, uemail, urole, ugender, uaddress,upsw,upoint);	
                userList.add(user);
            }
        }catch (Exception e) {
			System.out.println("！userdaoimpl:查询All");
		} finally {
            closeResources(conn, ps, rs); // 关闭资源的方法
        }

        return userList;
    }

    //********************************************************************
    //********************************************************************query:							
    // 查询单个用户 by uid
    @Override
    public User queryUserByUid(String uid) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = getConnection();
            String sql = "SELECT * from userinfo WHERE uid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            rs = ps.executeQuery();

            if (rs.next()) {
                String uname = rs.getString("uname");
                String utel = rs.getString("utel");
                String uemail = rs.getString("uemail");
                String urole = rs.getString("urole");
                String ugender = rs.getString("ugender");
                String uaddress = rs.getString("uaddress");
                String upsw = rs.getString("upsw");
                String upoint = rs.getString("upoint");

                user = new User(uid, uname, utel, uemail, urole, ugender, uaddress,upsw,upoint);
            }
        }catch (Exception e) {
			System.out.println("！userdaoimpl:查询 by uid");
		} finally {
            closeResources(conn, ps, rs);
        }

        return user;
    }

    // 查询单个用户 by utel
    @Override
    public User queryUserByUtel(String utel) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = getConnection();
            String sql = "SELECT * FROM userinfo WHERE utel=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, utel);
            rs = ps.executeQuery();

            if (rs.next()) {
                String uid = rs.getString("uid");
                String uname = rs.getString("uname");
                String uemail = rs.getString("uemail");
                String urole = rs.getString("urole");
                String ugender = rs.getString("ugender");
                String uaddress = rs.getString("uaddress");
                String upsw = rs.getString("upsw");
                String upoint = rs.getString("upoint");

                user = new User(uid, uname, utel, uemail, urole, ugender, uaddress,upsw,upoint);
            }
        }catch (Exception e) {
			System.out.println("！userdaoimpl:查询 by utel");
		} finally {
            closeResources(conn, ps, rs);
        }

        return user;
    }

    // 查询单个用户 by uemail
    @Override
    public User queryUserByUemail(String uemail) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = getConnection();
            String sql = "SELECT * FROM userinfo WHERE uemail=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uemail);
            rs = ps.executeQuery();

            if (rs.next()) {
                String uid = rs.getString("uid");
                String uname = rs.getString("uname");
                String utel = rs.getString("utel");
                String urole = rs.getString("urole");
                String ugender = rs.getString("ugender");
                String uaddress = rs.getString("uaddress");
                String upsw = rs.getString("upsw");
                String upoint = rs.getString("upoint");

                user = new User(uid, uname, utel, uemail, urole, ugender, uaddress,upsw,upoint);
            }
        }catch (Exception e) {
			System.out.println("！userdaoimpl:查询 by uemail");
		} finally {
            closeResources(conn, ps, rs);
        }

        return user;
    }
    //																		  **
    //																		  **
    //**************************************************************************
    //**************************************************************************
    
    
    
    // 插入用户
    @Override
    public int insertUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows = 0;

        try {
            conn = getConnection();
            String sql = "INSERT INTO userinfo(uname, utel, uemail, urole, ugender, uaddress ,upsw) VALUES (?, ?, ?, ?, ?, ?, ?)"; 	//注意这里不填uid和upoint
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUname());
            ps.setString(2, user.getUtel());
            ps.setString(3, user.getUemail());
            ps.setString(4, user.getUrole());
            ps.setString(5, user.getUgender());
            ps.setString(6, user.getUaddress());
            ps.setString(7, user.getUpsw());

            affectedRows = ps.executeUpdate();
        }catch (Exception e) {
			System.out.println("！userdaoimpl:插入");
		} finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return affectedRows;
    }

    // 更新用户信息 by uid
    @Override
    public int updateUserByUid(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows = 0;

        try {
            conn = getConnection();
            String sql = "UPDATE userinfo SET uname=?, utel=?, uemail=?, urole=?, ugender=?, uaddress=?, upsw=?, upoint=? WHERE uid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUname());
            ps.setString(2, user.getUtel());
            ps.setString(3, user.getUemail());
            ps.setString(4, user.getUrole());
            ps.setString(5, user.getUgender());
            ps.setString(6, user.getUaddress());
            ps.setString(7, user.getUpsw());
            ps.setString(8, user.getUpoint());
            ps.setString(9, user.getUid());

            affectedRows = ps.executeUpdate();
        }catch (Exception e) {
			System.out.println("！userdaoimpl:更新");
		} finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return affectedRows;
    }

    // 删除用户 by uid
    @Override
    public int deleteUser(String uid) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows = 0;

        try {
            conn = getConnection();
            String sql = "DELETE FROM userinfo WHERE uid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            affectedRows = ps.executeUpdate();
        }catch (Exception e) {
			System.out.println("！userdaoimpl:删除");
		} finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }

        return affectedRows;
    }


    // 关闭数据库资源
    private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
    

}
