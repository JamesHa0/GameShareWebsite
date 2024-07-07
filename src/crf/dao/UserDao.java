package crf.dao;

import java.util.List;
import java.util.Map;

import crf.system.entity.UserBean;

public interface UserDao {
	public long getUserListCount(Map<String,Object> map)throws Exception;

	public List<UserBean> queryUserListTable(Map<String, Object> map)throws Exception;

	public UserBean queryUserByUsername(String username)throws Exception;

	public int insertUser(Map<String, Object> map)throws Exception;

	public int update(Map<String, Object> map)throws Exception;

	public int deleteUser(String username)throws Exception;


}
