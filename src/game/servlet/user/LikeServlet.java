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

import game.bean.Like;
import game.bean.UserLog;
import game.dao.LikeDaoImpl;

//用于标记点赞或取消点赞的servlet。是Ajax。
@WebServlet("/LikeServlet.do")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLog userLog=new UserLog();
		LikeDaoImpl likeDaoImpl=new LikeDaoImpl();
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
        String action=request.getParameter("action");
        String uid=request.getParameter("uid");
        String gid=request.getParameter("gid");
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ltime=sdf.format(new Date());
        
        //main
        if("like".equals(action)) { //点赞业务：插入
        	Like like=new Like(uid, gid, ltime);
        	try {
				likeDaoImpl.insertLike(like);
		        response.setStatus(200);
				
			} catch (Exception e) {
				System.out.println("!500 Servlet-like-1");
				userLog.logOperation(Login_uid, Login_uname, Login_urole, "点赞入库：500", "失败");
				response.setStatus(500);
				return;
			}
        }else if("unlike".equals(action)) { //取消点赞业务：删除
        	try {
				likeDaoImpl.deleteLikeByUidAndGid(uid, gid);
		        response.setStatus(200);
				
			} catch (Exception e) {
				System.out.println("!500 Servlet-like-2");
				userLog.logOperation(Login_uid, Login_uname, Login_urole, "取消点赞入库：500", "失败");
				response.setStatus(500);
				return;
			}
        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
