package game.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import game.bean.Game;
import game.bean.User;
import game.dao.GameDaoImpl;

@WebServlet("/DetailServlet.do")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证是否处于登录状态
		HttpSession session = request.getSession();
		User isHaveUser = new User();
		isHaveUser = (User)session.getAttribute("Login_user");
		if (isHaveUser==null) {
			request.getRequestDispatcher("LR.jsp").forward(request, response);
		}
		String gid = request.getParameter("gid");
		Game game = new Game();
		GameDaoImpl GameImp = new GameDaoImpl();
		try {
			game = GameImp.queryGameByGid(gid);
		} catch (Exception e) {
			
		}
		if(game==null) {
			request.setAttribute("msg", "gamenotfound");
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}
		request.setAttribute("game", game);
		request.getRequestDispatcher("detail.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
