package game.bean;

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
        UserLogDaoImpl logdao=new UserLogDaoImpl();
        try {
			logdao.saveLogToDatabase(this);
		} catch (Exception e) {
			System.out.println("500:UserLog");
			e.printStackTrace();
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
	
    @Override
	public String toString() {
		return "UserLog [logId=" + logId + ", logOperatorId=" + logOperatorId + ", logOperatorName=" + logOperatorName
				+ ", logOperatorRole=" + logOperatorRole + ", logTime=" + logTime + ", logDetails=" + logDetails
				+ ", logSuccess=" + logSuccess + "]";
	}



    
}