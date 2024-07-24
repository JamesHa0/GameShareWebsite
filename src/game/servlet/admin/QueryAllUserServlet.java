package game.servlet.admin;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.User;
import game.bean.UserLog;
import game.dao.UserDaoImpl;

//查询所有用户的业务。无论结果如何，都将携带allUsers数组，跳转到jsp_admin/%path%。
@WebServlet("/QueryAllUserServlet.do")
public class QueryAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public QueryAllUserServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//initial
		UserLog userLog = new UserLog();
		UserDaoImpl userdao=new UserDaoImpl();
//		HttpSession session=request.getSession();
//    	String SESSIONID=(String) session.getAttribute("SESSIONID");
//		String path=(String) session.getAttribute("path_"+SESSIONID);//session中
		
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
        
		//前端数据
		String path=request.getParameter("path");
		System.out.print("【查询所有用户】---前端传递的path（user全查）="+path);
		
		//main
		try {
			List<User> li =userdao.queryAllUser();
			if(li.isEmpty()) {
				System.out.println("!204 servlet-user全查:li是空的。");
			}else {
				System.out.println("√ servlet-user全查:li成功获取数据。");
			}
			request.setAttribute("allUsers", li);
			request.getRequestDispatcher("jsp_admin/"+path).forward(request, response);
		} catch (Exception e) {
			System.out.println("!500 servlet-User全查");
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "查询所有操作日志：500", "失败");
			response.setStatus(500);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
