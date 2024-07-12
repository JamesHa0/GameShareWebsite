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
        List<UserLog> userLogs = new ArrayList<>();

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
                userLogs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error querying user logs");
        } finally {
            closeResources(conn, ps, rs);
        }

        return userLogs;
    }

    @Override
    public List<UserLog> queryUserLogByLogOperatorId(String logOperatorId) throws Exception {
        // 这个方法需要返回一个UserLog列表，因为可能有多个日志属于同一个操作者
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserLog> userLogs = new ArrayList<>();

        try {
            conn = getConnection();
            String sql = "SELECT * FROM userlog WHERE logOperatorId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, logOperatorId);
            rs = ps.executeQuery();

            while (rs.next()) {
                UserLog log = new UserLog();
                // 同上，设置属性...
                userLogs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error querying user logs by operator ID");
        } finally {
            closeResources(conn, ps, rs);
        }

        return userLogs;
    }

    // 注意：queryUserLogByLogOperatorName 方法需要实现，但看起来您可能想查询按操作者名称的日志
    // 这里提供一个基本的框架，您需要根据实际数据库结构调整

    @Override
    public List<UserLog> queryUserLogByLogOperatorName(String logOperatorName) throws Exception {
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
                // 同上，设置属性...
                userLogs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error querying user logs by operator name");
        } finally {
            closeResources(conn, ps, rs);
        }

        return userLogs;
    }

    @Override
    public int saveLogToDatabase(UserLog log) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows = 0;

        try {
            conn = getConnection();
            String sql = "INSERT INTO userlog (logOperatorId, logOperatorRole, logTime, logDetails, logSuccess) "
                    + "VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, log.getLogOperatorId());
            ps.setString(2, log.getLogOperatorRole());
            ps.setDate(3, new java.sql.Date(log.getLogTime().getTime()));
            ps.setString(4, log.getLogDetails());
            ps.setBoolean(5, log.isLogSuccess());

            affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Log inserted successfully");
            } else {
                System.out.println("Failed to insert log");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Error inserting log to database");
        } finally {
            closeResources(conn, ps, null); // 注意：这里rs是null，因为没有执行查询
        }

        return affectedRows;
    }

    // 这个方法应该返回数据库连接，您需要根据实际情况实现它
    private Connection getConnection() {
        // 实现获取数据库连接的逻辑
        return null;
    }

    // 关闭数据库资源的方法
    private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        // 资源关闭逻辑，您的原始代码中已有实现
    }
}