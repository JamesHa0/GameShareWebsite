package game.servlet.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import game.bean.Comment;
import game.bean.UserLog;
import game.dao.CommentDaoImpl;

//用于写评论入库（action=writeComment）的servlet。Ajax。
@WebServlet("/CommentServlet.do")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLog userLog=new UserLog();
		CommentDaoImpl commentDaoImpl=new CommentDaoImpl();
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
        if("0".equals(Login_uid)) {//见鬼了
        	System.out.println("没登录呢还");
        	response.sendRedirect("LR.jsp");
        	return;
        }
        
        //前端数据
        String uid=request.getParameter("uid");
        String gid=request.getParameter("gid");
        String comment=request.getParameter("comment");

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ctime=sdf.format(new Date());
        
        //main
    	try {//写评论入库
			Comment comment2=new Comment(uid, gid, ctime, comment);
			commentDaoImpl.insertComment(comment2);
			
			//response返回json，供给detail.js使用
			String json = new Gson().toJson(comment2);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    
	        response.setStatus(200);
			
		} catch (Exception e) {
			System.out.println("!500 Servlet-comment-2");
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "写评论入库：500", "失败");
			response.setStatus(500);
			return;
		}
        
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
