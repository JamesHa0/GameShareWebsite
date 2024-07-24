package game.servlet.admin;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.Purchase;
import game.bean.UserLog;
import game.dao.PurchaseDaoImpl;

//查询所有订单的业务。无论结果如何，都将携带allGameLogs数组，跳转到jsp_admin/%path%。
@WebServlet("/QueryAllGameLogServlet.do")
public class QueryAllGameLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public QueryAllGameLogServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//initial
		UserLog userLog = new UserLog();
		PurchaseDaoImpl purchaseDaoImpl = new PurchaseDaoImpl();
//		HttpSession session=request.getSession();
//    	String SESSIONID=(String) session.getAttribute("SESSIONID");
//		String path=(String) request.getAttribute("path_"+SESSIONID);
		
		
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
        
        //前端数据
        String path=request.getParameter("path");
        System.out.print("【查询所有订单】---path="+path);
		
		//main
		try {
			List<Purchase> li =purchaseDaoImpl.queryAllPurchase();
			if(li.isEmpty()) {
				System.out.println("!servlet-queryAll:li是空的。");
			}else {
				System.out.println("servlet-queryAll:li成功获取数据。");
			}
			request.setAttribute("allGameLogs", li);
			request.getRequestDispatcher("jsp_admin/"+path).forward(request, response);
		
		} catch (Exception e) {
			System.out.println("!servlet:queryAllUser报错。");
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "查询所有订单：500", "失败");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
