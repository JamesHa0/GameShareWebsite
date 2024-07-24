package game.servlet.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.Game;
import game.bean.User;
import game.bean.UserLog;
import game.dao.GameDaoImpl;
import game.dao.PurchaseDaoImpl;
import game.dao.UserDaoImpl;

//进行购买业务。若成功，则设置gid、upoint、onumber。然后无论结果如何，都将设置msg，并跳转到afterPurchase.jsp。
@WebServlet("/PurchaseServlet.do")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
        }
		
        
		//前端数据
		String gid = request.getParameter("gid");
		
		String uid = Login_uid;
		request.setAttribute("gid", gid);
		String otime=new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		// 获取用户当前积分
		User user = new User();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try {
			user = userDaoImpl.queryUserByUid(uid);
		} catch (Exception e) {
			System.out.println("!500 servlet-Purchase");
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "购买游戏：500", "失败");
		}
		Double upoint = Double.parseDouble(user.getUpoint());

		// 获知购买所需的积分
		Game game = new Game();
		GameDaoImpl gameDaoImpl = new GameDaoImpl();
		try {
			game = gameDaoImpl.queryGameByGid(gid);
		} catch (Exception e) {
			System.out.println("!500 servlet-Purchase-2");
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "购买游戏：500-2", "失败");
		}
		Double gprice = Double.parseDouble(game.getGprice());

		// 更新积分业务
		Double upoint2 = upoint - gprice;
		if (upoint2 < 0) {
			request.setAttribute("msg", "积分不足，购买失败！");
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "购买游戏：积分不足", "失败");
		} else {
			String newUpoint = upoint2 + "";
			user.setUpoint(newUpoint);
			request.setAttribute("upoint", newUpoint);
			// 更新购买记录
			PurchaseDaoImpl PurchaseImpl = new PurchaseDaoImpl();
			String onumber = null;
			System.out.println("gid="+gid);
			System.out.println("uid="+uid);
			System.out.println("otime="+otime);
			
			try {
				onumber = PurchaseImpl.insertPurchase(gid, uid, otime);
			} catch (Exception e) {
				System.out.println("!500 servlet-Purchase-3");
				userLog.logOperation(Login_uid, Login_uname, Login_urole, "购买游戏：500-3", "失败");
			}

			if (onumber == null) {//见鬼了
				request.setAttribute("msg", "购买失败！");
				userLog.logOperation(Login_uid, Login_uname, Login_urole, "购买游戏：订单号为空", "失败");
			}
			
			try {
				if(userDaoImpl.updateUserByUid(user) > 0) {
					request.setAttribute("onumber", onumber);
					request.setAttribute("msg", "购买成功！");
					userLog.logOperation(Login_uid, Login_uname, Login_urole, "购买游戏", "成功");
				}else {
					request.setAttribute("msg", "购买失败！");
					userLog.logOperation(Login_uid, Login_uname, Login_urole, "购买游戏：用户数据更新失败", "失败");
				}
			} catch (Exception e) {
				System.out.println("!500 servlet-Purchase-4");
				userLog.logOperation(Login_uid, Login_uname, Login_urole, "购买游戏：500-4", "失败");
			}
		}
		//走你：
		request.getRequestDispatcher("afterPurchase.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
