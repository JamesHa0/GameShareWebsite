package game.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.UserLog;
import game.dao.LikeDaoImpl;

//Ajax 查询点赞数量的servlet，会在request装载likeNum变量。
@WebServlet("/QueryLikeServlet.do")
public class QueryLikeServlet extends HttpServlet {
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
        
        LikeDaoImpl likeDaoImpl=new LikeDaoImpl();
        int likeNum=0;
        try {
			likeNum=likeDaoImpl.queryLikeNum();
			
		} catch (Exception e) {
			System.out.println("!500 servlet-Q：like");
			userlog.logOperation(Login_uid, Login_uname, Login_urole, "查询点赞数：500", "失败");
		}
        
        request.setAttribute("likeNum", likeNum);
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
