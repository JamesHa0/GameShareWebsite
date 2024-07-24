package game.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.Game;
import game.bean.UserLog;
import game.dao.GameDaoImpl;

//单查游戏的业务。无论结果如何，都将携带allGames数组，跳转到jsp_admin/%path%，并传递参数query的值。
@WebServlet("/QueryGameServlet.do")
public class QueryGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryGameServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//initial
		UserLog userLog = new UserLog();
		GameDaoImpl gamedao=new GameDaoImpl();
		Game game=new Game();
		List<Game> li = new ArrayList<Game>();
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
		
		//前端传来的数据
		String path=request.getParameter("path");
		System.out.print("【单查游戏】---前端传递path="+path+" ; ");
		String gid=request.getParameter("gid");
		String gname=request.getParameter("gname");
		String uemail =request.getParameter("uemail");
		System.out.println("\n\t gid="+gid+ "\n\t gname="+gname+ "\n\t uemail="+uemail);
		
		//main
		try {//根据不空的项来定义查找关键字
			if(gid!=null && !"".equals(gid)) {
				game=gamedao.queryGameByGid(gid);
			}else if(gname !=null && !"".equals(gname)) {
				game=gamedao.queryGameByGname(gname);
			}else {//全都是空的！
				response.sendRedirect("jsp_admin/"+path+"?query=queryAll");//*********1
			}
			
			if(game==null) {
				System.out.println("[null] Servlet-game单查：game=空。数据库里没有该游戏。");
				response.sendRedirect("jsp_admin/"+path+"?query=none");//************2
			}else {
				System.out.println("√ Servlet-game单查:成功获取game。");
				li.add(game);
				request.setAttribute("allGames", li);
//			    response.sendRedirect("jsp_admin/"+path+"?query=get_it");
				request.getRequestDispatcher("jsp_admin/"+path+"?query=get_it").forward(request, response);//***********3
			}
		} catch (Exception e) {
			System.out.println("!500 Servlet-game单查。");
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "单查游戏：500", "失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
