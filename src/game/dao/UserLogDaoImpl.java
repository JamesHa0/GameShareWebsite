package game.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import game.bean.UserLog;

public class UserLogDaoImpl implements UserLogDao {
    
    @Override
    public List<UserLog> queryAllUserLog() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserLog> li = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT * FROM userlog";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserLog log = new UserLog();
                log.setLogId(rs.getString("logId"));
                log.setLogOperatorId(rs.getString("logOperatorId"));
                log.setLogOperatorRole(rs.getString("logOperatorRole"));
                log.setLogTime(rs.getString("logTime"));
                log.setLogDetails(rs.getString("logDetails"));
                log.setLogSuccess(rs.getString("logSuccess"));
                li.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("!imp-userlog:500");
        } finally {
            closeResources_for_query(conn, ps, rs);
        }

        return li;
    }

    @Override
    public List<UserLog> queryUserLogByLogOperatorId(String logOperatorId) throws Exception {
        // 这个方法需要返回一个UserLog列表，因为可能有多个日志属于同一个操作者
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserLog> li = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT * FROM userlog WHERE logOperatorId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, logOperatorId);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserLog log = new UserLog();
                log.setLogId(rs.getString("logId"));
                log.setLogOperatorId(rs.getString("logOperatorId"));
                log.setLogOperatorRole(rs.getString("logOperatorRole"));
                log.setLogTime(rs.getString("logTime"));
                log.setLogDetails(rs.getString("logDetails"));
                log.setLogSuccess(rs.getString("logSuccess"));
                li.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("500:imp-userlog");
        } finally {
            closeResources_for_query(conn, ps, rs);
        }

        return li;
    }

    @Override
    public List<UserLog> queryUserLogByLogOperatorName(String logOperatorName) throws Exception {
    	// 这个方法需要返回一个UserLog列表，因为可能有多个日志属于同一个操作者
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserLog> userLogs = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT * FROM userlog WHERE logOperatorName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, logOperatorName);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserLog log = new UserLog();
                log.setLogId(rs.getString("logId"));
                log.setLogOperatorId(rs.getString("logOperatorId"));
                log.setLogOperatorRole(rs.getString("logOperatorRole"));
                log.setLogTime(rs.getString("logTime"));
                log.setLogDetails(rs.getString("logDetails"));
                log.setLogSuccess(rs.getString("logSuccess"));
                userLogs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("500:imp-userlog");
        } finally {
            closeResources_for_query(conn, ps, rs);
        }

        return userLogs;
    }

    @Override
    public int saveLogToDatabase(UserLog log) throws Exception {
    	Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows = 0;

        try {
            conn = getConnection(); // 确保这个函数存在并返回有效的数据库连接
            String sql = "INSERT INTO userlog (logOperatorId,logOperatorName,logOperatorRole,"
            		+ "logTime,logDetails,logSuccess) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, log.getLogOperatorId());
            ps.setString(2, log.getLogOperatorName());
            ps.setString(3, log.getLogOperatorRole());
            
            ps.setString(4, log.getLogTime()); 
            ps.setString(5, log.getLogDetails()); 
            ps.setString(6, log.getLogSuccess());

            affectedRows = ps.executeUpdate();
            if(affectedRows>=0) {
            	System.out.println("imp-userlog：插入日志成功");
            }else {
            	System.out.println("！imp-userlog：插入日志失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("！imp-userlog：插入日志:500");
        }  finally {
        	ResultSet rs = null;
            closeResources_for_query(conn, ps, rs);
        }
		return affectedRows;
    }
}