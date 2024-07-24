package game.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.UserLog;

@WebServlet("/LogoutServlet.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	UserLog userLog = new UserLog();
    	//从Cookie获取当前登录者信息：
    	String Login_uid = "0";
        String Login_uname = "获取cookie（Login_uname）失败";
        String Login_urole = "获取cookie（Login_urole）失败";
        Cookie[] cookie=request.getCookies();
        if(cookie !=null) {
        	for(Cookie c:cookie) {
        		if("Login_uid".equals(c.getName())) {
        			Login_uid=c.getValue();
        		}else if("Login_uname".equals(c.getName())) {
        			Login_uname=c.getValue();
        		}else if("Login_urole".equals(c.getName())) {
        			Login_urole=c.getValue();
        		}
        	}
        }
        
    	//注销cookie：（uid,uname,urole)
        userLog.logOperation(Login_uid, Login_uname, Login_urole, "登出", "成功");
    	Cookie del_cookie1= new Cookie("Login_uid", "");
    	Cookie del_cookie2= new Cookie("Login_uname", "");
    	Cookie del_cookie3= new Cookie("Login_urole", "");
    	del_cookie1.setMaxAge(0);
    	del_cookie2.setMaxAge(0);
    	del_cookie3.setMaxAge(0);
    	response.addCookie(del_cookie1);
    	response.addCookie(del_cookie2);
    	response.addCookie(del_cookie3);
    	
    	//注销session：（SESSIONID、验证码）
    	HttpSession session=request.getSession();
    	session.invalidate();
    	
    	response.sendRedirect("index.jsp");
    	
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
