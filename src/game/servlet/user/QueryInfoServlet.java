package game.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.User;
import game.bean.UserLog;
import game.dao.UserDaoImpl;

@WebServlet("/QueryInfoServlet.do")
public class QueryInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserLog userlog=new UserLog();
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
        
        if("0".equals(Login_uid)) {
        	System.out.println("!404 servlet-Q:info 什么都没查到。");
        	response.setStatus(404);
        	response.sendRedirect("LR.jsp");
        }else {
        	UserDaoImpl userdao=new UserDaoImpl();
        	User user=null;
			try {
				user = userdao.queryUserByUid(Login_uid);
			} catch (Exception e) {
				userlog.logOperation(Login_uid, Login_uname, Login_urole,"查询个人信息" ,"失败" );
				System.out.println("!500 servlet-queryinfo");
			}
			if(user==null)System.out.println("!404 servlet-Q:info 什么都没查到2。");
        	request.setAttribute("Info_user", user);
        	request.getRequestDispatcher("info.jsp").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
