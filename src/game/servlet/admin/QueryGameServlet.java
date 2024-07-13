package game.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.Game;
import game.dao.GameDaoImpl;



@WebServlet("/QueryGameServlet.do")
public class QueryGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryGameServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取path
		HttpSession session=request.getSession();
		String path_param=request.getParameter("path");
		String path=(String) session.getAttribute("path");//session中
			if(path_param!=null) path=path_param;
		System.out.println("---前端传递path（game单查）="+path);
		
		//前端传来的数据
		String gid=request.getParameter("gid");
		String gname=request.getParameter("gname");
		String uemail =request.getParameter("uemail");
System.out.println("---前端传来的数据是（game单查）："
		+ "\n	 gid="+gid
		+ "\n 	 gname="+gname
		+ "\n 	 uemail="+uemail);
		
		try {
			GameDaoImpl gamedao=new GameDaoImpl();
			Game game=new Game();
			if(gid!=null && !"".equals(gid)) {
				game=gamedao.queryGameByGid(gid);
			}else if(gname !=null && !"".equals(gname)) {
				game=gamedao.queryGameByGname(gname);
			}else {
				//全都是空的！
				response.sendRedirect("jsp_admin/"+path+"?query=queryAll");//*********1
			}
			
			if(game==null) {
				System.out.println("[null] Servlet-game单查：game=空。数据库里没有该游戏。");
				response.sendRedirect("jsp_admin/"+path+"?query=none");//************2
			}else {
				System.out.println("√ Servlet-game单查:成功获取game。");
				//装载：
				List<Game> li = new ArrayList<Game>();
				li.add(game);
				session.setAttribute("allGames", li);
			    response.sendRedirect("jsp_admin/"+path+"?query=get_it");//***********3
			
			}
		} catch (Exception e) {
			System.out.println("!500 Servlet-game单查。");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
