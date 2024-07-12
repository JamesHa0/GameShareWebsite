package game.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import game.dao.*;
//logId,logOperatorId,logOperatorName,logOperatorRole,logTime,logDetails,logSuccess

//共7参
public class UserLog implements Dao{
    private String logId; // 日志id，通常由数据库自动生成

    private String logOperatorId; // 操作者id
    private String logOperatorName; // 操作者name
    private String logOperatorRole; // 操作角色
    private String logTime; // 操作时间
    private String logDetails; // 操作内容
    private String logSuccess; // 是否成功
    
	//5参（除自增的日志id）
    //uid,uname,urole,管理员登录,成功
	public void logOperation(String operatorId,String operatorName, String role, 
			String details, String success) {
        // 创建日志条目的逻辑
        this.logOperatorId = operatorId;
        this.logOperatorName = operatorName;
        this.logOperatorRole = role;
        
        Date date = new Date();
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        this.logTime = time; // 自动记录当前时间
        
        this.logDetails =  details;
        this.logSuccess = success;

        // 保存日志到数据库
        saveLogToDatabase(this);
    }
	


	private void saveLogToDatabase(UserLog log) {
        Connection conn = null;
        PreparedStatement ps = null;
        int affectedRows = 0;

        try {
            conn = getConnection(); // 确保这个函数存在并返回有效的数据库连接
            String sql = "INSERT INTO userlog (logOperatorId,logOperatorName,logOperatorRole,"
            		+ "logTime,logDetails,logSuccess) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, log.logOperatorId);
            ps.setString(2, log.logOperatorName);
            ps.setString(3, log.logOperatorRole);
            
            ps.setString(4, log.logTime); 
            ps.setString(5, log.logDetails); 
            ps.setString(6, log.logSuccess);

            affectedRows = ps.executeUpdate();
            if(affectedRows>=0) {
            	System.out.println("bean：插入日志成功");
            }else {
            	System.out.println("！bean：插入日志失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("！bean：插入日志:500");
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	
	//************************************get and set:


	public String getLogId() {
		return logId;
	}



	public void setLogId(String logId) {
		this.logId = logId;
	}



	public String getLogOperatorId() {
		return logOperatorId;
	}



	public void setLogOperatorId(String logOperatorId) {
		this.logOperatorId = logOperatorId;
	}



	public String getLogOperatorName() {
		return logOperatorName;
	}



	public void setLogOperatorName(String logOperatorName) {
		this.logOperatorName = logOperatorName;
	}



	public String getLogOperatorRole() {
		return logOperatorRole;
	}



	public void setLogOperatorRole(String logOperatorRole) {
		this.logOperatorRole = logOperatorRole;
	}



	public String getLogTime() {
		return logTime;
	}



	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}



	public String getLogDetails() {
		return logDetails;
	}



	public void setLogDetails(String logDetails) {
		this.logDetails = logDetails;
	}



	public String getLogSuccess() {
		return logSuccess;
	}



	public void setLogSuccess(String logSuccess) {
		this.logSuccess = logSuccess;
	}
	
	
    
}