package crf.dao;

import java.util.List;

import crf.system.entity.Operation;
import crf.system.entity.UserBean;

public interface LoginDao {
	public UserBean queryUserByUsernameAndPassword(String username,String password)throws Exception;
	public List<Operation> queryUserMenu(String username)throws Exception;
	public List<Operation> queryUserParnetMenu(List<String> parentIds)throws Exception;
	

}
