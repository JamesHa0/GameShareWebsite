package game.servlet.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.UserLog;
import game.dao.PurchaseDaoImpl;

@WebServlet("/InsertPurchaseServlet.do")
public class InsertPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertPurchaseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserLog userLog = new UserLog();
		PurchaseDaoImpl purchaseDaoImpl = new PurchaseDaoImpl();
		
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
		
		
		// 前端数据
		String uid = request.getParameter("uid");
		String gid = request.getParameter("gid");

		// 计算生成订单时间
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String otime = formatter.format(date);

		try {// insert数据入库：
			String onumber = null;
			onumber = purchaseDaoImpl.insertPurchase(gid, uid, otime);
			if (onumber == null) {// 未实际插入数据
				System.out.println("！servlet-insert:失败！");
				userLog.logOperation(Login_uid, Login_uname, Login_urole, "生成并插入订单", "失败");
				response.setStatus(500);// 500
			}else {// 插入成功：
				userLog.logOperation(Login_uid, Login_uname, Login_urole, "生成并插入订单", "成功");
				response.setStatus(200);// 200
			}
		} catch ( Exception e) {
			System.out.println("！servlet-insert:报错。");
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "生成并插入订单:500", "失败");
			response.setStatus(500);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}