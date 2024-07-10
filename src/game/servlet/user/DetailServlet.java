package game.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jmx.snmp.SnmpStringFixed;

import game.bean.Game;
import game.dao.GameDao;
import game.dao.GameDaoImpl;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gid = request.getParameter("gid");
		Game game = new Game();
		GameDaoImpl GameImp = new GameDaoImpl();
		try {
			game = GameImp.queryGameByGid(gid);
		} catch (Exception e) {
			
		}
		if(game==null) {
			request.setAttribute("msg", "gamenotfound");
			request.getRequestDispatcher("game/detail.jsp").forward(request, response);
		}
		request.setAttribute("game", game);
		request.getRequestDispatcher("game/detail.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
