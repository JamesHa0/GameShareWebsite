package game.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.Game;
import game.bean.Purchase;
import game.dao.GameDaoImpl;
import game.dao.PurchaseDaoImpl;

@WebServlet("/QueryPurchaseServlet")
public class QueryPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gid = request.getParameter("gid");
		//获取游戏信息
		Game game = new Game();
		GameDaoImpl gameDaoImpl = new GameDaoImpl();
		try {
			game = gameDaoImpl.queryGameByGid(gid);
		} catch (Exception e) {
			request.getRequestDispatcher("detail.jsp?gid=#");
		}
		request.setAttribute("game", game);
		
		//查询用户是否已购买此游戏
		Purchase purchase = new Purchase();
		PurchaseDaoImpl purchaseDaoImpl = new PurchaseDaoImpl();
		try {
			purchase = purchaseDaoImpl.queryPurchaseByGid(gid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(purchase != null) {//已购买
			request.setAttribute("onumber", purchase.getOnumber());
		}
		request.getRequestDispatcher("purchase.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
