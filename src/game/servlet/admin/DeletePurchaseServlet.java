package game.servlet.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.UserLog;
import game.dao.PurchaseDaoImpl;

//删除订单的业务。无论结果如何，都携带msg和path_SESSIONID参数，转到error.jsp。
@WebServlet("/DeletePurchaseServlet.do")
public class DeletePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//initial
		UserLog userLog = new UserLog();
		PurchaseDaoImpl purchaseDaoImpl = new PurchaseDaoImpl();
		HttpSession session=request.getSession();
    	String SESSIONID=(String) session.getAttribute("SESSIONID");
    	
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
		String onumber=request.getParameter("onumber");
		System.out.print("【删除订单】---前端传来的onumber为："+onumber);
		
		
		try {
			if(purchaseDaoImpl.deletePurchaseByOnumber(onumber) <=0) {
				System.out.println("！删除gameLog失败:"+onumber);
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员删除购买记录，订单id："+onumber, "失败");
				response.setStatus(500);	//500服务器内部错误
				request.setAttribute("msg", "删除失败。");
				request.setAttribute("path", "../QueryAllGameLogServlet.do");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			
			}else {
				System.out.println("删除gameLog成功:"+onumber);
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员删除购买记录，订单id："+onumber, "成功");
				response.setStatus(200); 	//200顺利
				request.setAttribute("msg", "删除成功。");
				request.setAttribute("path", "../QueryAllGameLogServlet.do");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员删除购买记录：500", "失败");
			System.out.println("servlet-deleteuser：删除时报错。");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
