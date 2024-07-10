package game.dao;

import java.util.List;

import game.bean.User;

public interface UserDao extends Dao{
	//查询所有用户
	public List<User> queryAllUser()throws Exception;
	
	//查询单个用户（三种方式）
	public User queryUserByUid(String uid)throws Exception;			//by uid
	public User queryUserByUtel(String utel)throws Exception;		//by utel
	public User queryUserByUemail(String uemail)throws Exception;	//by uemail

	//插入用户
	public int insertUser(User user)throws Exception;
	
	//更新用户信息
	public int updateUserByUid(User user)throws Exception;
	
	//删除用户
	public int deleteUser(String uid)throws Exception;


}
