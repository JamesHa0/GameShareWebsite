package game.dao;

import java.util.List;

import game.bean.UserLog;

public interface UserLogDao extends Dao{
	//查询所有
	public List<UserLog> queryAllUserLog()throws Exception;
	
	//单查
	public List<UserLog> queryUserLogByLogOperatorId(String logOperatorId)throws Exception;			//by id
	public List<UserLog> queryUserLogByLogOperatorName(String logOperatorName)throws Exception;		//by name

	//插入到数据库
	public int saveLogToDatabase(UserLog log)throws Exception;
}
