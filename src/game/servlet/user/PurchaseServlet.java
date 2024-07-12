package game.servlet.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.Game;
import game.bean.User;
import game.dao.GameDaoImpl;
import game.dao.PurchaseDaoImpl;
import game.dao.UserDaoImpl;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gid = request.getParameter("gid");
		String uid = request.getParameter("uid");
		request.setAttribute("gid", gid);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String otime = formatter.format(date);

		// 获取用户当前积分
		User user = new User();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try {
			user = userDaoImpl.queryUserByUid(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double upoint = Double.parseDouble(user.getUpoint());

		// 获取购买所需的积分
		Game game = new Game();
		GameDaoImpl gameDaoImpl = new GameDaoImpl();
		try {
			game = gameDaoImpl.queryGameByGid(gid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double gprice = Double.parseDouble(game.getGprice());

		// 更新用户积分
		Double upoint2 = upoint - gprice;
		if (upoint2 < 0) {
			request.setAttribute("msg", "积分不足，购买失败！");
			request.getRequestDispatcher("afterPurchase.jsp").forward(request, response);
		} else {
			String newUpoint = upoint2 + "";
			user.setUpoint(newUpoint);
			// 更新购买记录
			PurchaseDaoImpl PurchaseImpl = new PurchaseDaoImpl();
			String onumber = null;
			System.out.println("gid="+gid);
			System.out.println("uid="+uid);
			System.out.println("otime="+otime);
			
			try {
				onumber = PurchaseImpl.insertPurchase(gid, uid, otime);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (onumber == null) {
				request.setAttribute("msg", "购买失败！");
				request.getRequestDispatcher("afterPurchase.jsp").forward(request, response);
			} else
				try {
					if(userDaoImpl.updateUserByUid(user) > 0) {
						request.setAttribute("onumber", onumber);
						HttpSession session = request.getSession();
						request.setAttribute("msg", "购买成功！");
						session.setAttribute("Login_user", user);
						request.getRequestDispatcher("afterPurchase.jsp").forward(request, response);
					}else {
						request.setAttribute("msg", "购买失败！");
						request.getRequestDispatcher("afterPurchase.jsp").forward(request, response);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
