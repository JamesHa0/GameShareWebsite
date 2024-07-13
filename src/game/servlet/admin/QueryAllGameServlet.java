package game.servlet.admin;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.Game;
import game.dao.GameDaoImpl;

@WebServlet("/QueryAllGameServlet.do")
public class QueryAllGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public QueryAllGameServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GameDaoImpl gamedao=new GameDaoImpl();
		HttpSession session=request.getSession();
		
		String path_param=request.getParameter("path");
		String path=(String) session.getAttribute("path");//session中
		if(path_param!=null) path=path_param;
		System.out.print("【game全查】---前端传递的path（game全查）="+path +" ; ");
		
		try {
			List<Game> li =gamedao.queryAllGame();
			if(li.isEmpty()) {
				System.out.println("!404 servlet-game全查:li是空的。");
				response.setStatus(404);
				return;
			}else {
				System.out.println("√ servlet-game全查:li非空。");
			}
			request.setAttribute("allGames", li);
			response.setStatus(200);//200
			request.getRequestDispatcher("jsp_admin/"+path).forward(request, response);
		} catch (Exception e) {
			System.out.println("!500 servlet-game全查");
			response.setStatus(500);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
