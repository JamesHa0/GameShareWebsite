package crf.system.entity;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import crf.util.DateUtil;


/**
 * 在线用户
 * @author Administrator
 *
 */
public class OnlineUsers {
	private UserBean ub;
	private HttpSession session; 
	
	public OnlineUsers(){}
	
	public OnlineUsers(UserBean ub,HttpSession session){
		this.ub=ub;
		this.session=session;
	}
	//sessionMap 用来剔除用户
	public static Map<String, OnlineUsers> sessionMap=new LinkedHashMap <String,OnlineUsers>();
	
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public UserBean getUb() {
		return ub;
	}
	public void setUb(UserBean ub) {
		this.ub = ub;
	}
	
	public String getLastAccessedTime() {
		return DateUtil.longToDateTime(this.session.getLastAccessedTime());
	}
	
	/**
	 * 
	 *王浩  @2015-5-27 功能:根据用户名断开连接
	 */
	public static boolean removeSession(String username) {
		try{
			if(sessionMap.containsKey(username)){
				sessionMap.get(username).session.invalidate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sessionMap.remove(username);
		}
		return true;
	}
	/**
	 * 
	 *王浩  @2015-5-27
	 * 功能: 保证一个用户名只能在一台机器登录
	 * 	           如果有相同sessionId 则剔除
	 */
	public static boolean removeSession(String username,String session_id) {
		try{
			boolean boo = false;
			//用户在同一浏览器登录
			for(String key : OnlineUsers.sessionMap.keySet()){
				if(key.equals(username))
					boo = true;
				HttpSession s = OnlineUsers.sessionMap.get(key).getSession();
				if(session_id.equals(s.getId())){
					OnlineUsers.sessionMap.remove(key);
				}
			}
			//用户在不同浏览器登录
			if(boo){
				OnlineUsers.sessionMap.get(username).getSession().invalidate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
}
