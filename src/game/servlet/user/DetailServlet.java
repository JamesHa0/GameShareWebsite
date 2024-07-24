package game.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import game.bean.Game;
import game.bean.Purchase;
import game.bean.User;
import game.bean.UserLog;
import game.dao.GameDaoImpl;
import game.dao.PurchaseDaoImpl;
import game.dao.UserDaoImpl;

//查询user、game、purchase的servlet。无论结果如何，转发至detail.jsp。
@WebServlet("/DetailServlet.do")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        if("0".equals(Login_uid)) {//未登录
        	System.out.println("！servlet-Q:usergamelog");
        	response.sendRedirect("LR.jsp");
        	return;
        }
        
        //前端数据
        String uid=Login_uid;
        String gid=request.getParameter("gid");
		
        //1，用户查询
        User user=new User();
        UserDaoImpl userImp=new UserDaoImpl();
        try {
        	user=userImp.queryUserByUid(Login_uid);
        }catch (Exception e) {
			System.out.println("!500 servlet-detail");
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "显示游戏详情：500-1", "失败");
		}
        //2，游戏查询
		Game game = new Game();
		GameDaoImpl GameImp = new GameDaoImpl();
		try {
			game = GameImp.queryGameByGid(gid);
		} catch (Exception e) {
			System.out.println("!500 servlet-detail-2");
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "显示游戏详情：500-2", "失败");
		}
		//3，订单查询
		Purchase purchase = new Purchase();
		PurchaseDaoImpl purchaseDaoImpl = new PurchaseDaoImpl();
		try {
			purchase = purchaseDaoImpl.queryOnePurchase(uid,gid);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("!500 servlet-detail-3");
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "显示游戏详情：500-3", "失败");
		}
		
		if(user!=null) {
			request.setAttribute("user", user);
		}
		if(game!=null) {
			request.setAttribute("game", game);
		}
		if(purchase!=null) {
			request.setAttribute("purchase", purchase);
		}
		//走你
		request.getRequestDispatcher("detail.jsp").forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
