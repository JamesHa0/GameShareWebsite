package game.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.Game;
import game.bean.GameLog;
import game.bean.Purchase;
import game.bean.User;
import game.dao.GameDaoImpl;
import game.dao.PurchaseDaoImpl;

@WebServlet("/QueryGameLogServlet")
public class QueryGameLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 验证是否处于登录状态
		HttpSession session = request.getSession();
		User isHaveUser = new User();
		isHaveUser = (User) session.getAttribute("Login_user");
		if (isHaveUser == null) {
			request.getRequestDispatcher("LR.jsp").forward(request, response);
		}

		String uid = request.getParameter("uid");
		PurchaseDaoImpl purchaseDaoImpl = new PurchaseDaoImpl();
		List<Purchase> list = new ArrayList<>();
		try {
			list = purchaseDaoImpl.queryPurchaseByUid(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		GameDaoImpl gameDaoImpl = new GameDaoImpl();
		Game game = new Game();
		List<GameLog> list2 = new ArrayList<>();
		for (Purchase i : list) {
			try {
				game = gameDaoImpl.queryGameByGid(i.getGid());
				GameLog gameLog = new GameLog(i.getGid(), i.getOnumber(), i.getUid(), i.getOtime(), game.getGzhname(),game.getGprice());
				list2.add(gameLog);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("gameLogList", list2);
		request.getRequestDispatcher("gameLog.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
