package game.servlet.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.Game;
import game.bean.GameLog;
import game.bean.Purchase;
import game.bean.UserLog;
import game.dao.GameDaoImpl;
import game.dao.PurchaseDaoImpl;

@WebServlet("/QueryUserGameLogServlet.do")
public class QueryUserGameLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
System.out.println("这里是servlet，sir。");
		UserLog userLog=new UserLog();
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
        if("0".equals(Login_uid)) {//未登录（见鬼）
        	System.out.println("！servlet-Q:usergamelog见鬼了");
        	response.sendRedirect("LR.jsp");
        }
		
        //查询
		String uid = request.getParameter("uid");
		PurchaseDaoImpl purchaseDaoImpl = new PurchaseDaoImpl();
		List<Purchase> list = new ArrayList<>();//存放含指定uid的购买日志
		try {
			list = purchaseDaoImpl.queryPurchaseByUid(uid);
		} catch (Exception e) {
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "查询个人购买记录：500", "失败");
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
				userLog.logOperation(Login_uid, Login_uname, Login_urole, "查询个人购买记录：500-2", "失败");
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
