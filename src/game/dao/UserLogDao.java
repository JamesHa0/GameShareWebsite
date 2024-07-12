package game.dao;

import java.util.List;

import game.bean.UserLog;

public interface UserLogDao extends Dao{
	//查询所有
	public List<UserLog> queryAllUserLog()throws Exception;
	
	//单查
	public UserLog queryUserLogByLogOperatorId(String logOperatorId)throws Exception;			//by id
	public UserLog queryUserLogByLogOperatorName(String logOperatorName)throws Exception;		//by name

	//插入
	public int saveLogToDatabase(UserLog log)throws Exception;
	


}
