package game.servlet.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.User;
import game.bean.UserLog;
import game.dao.PurchaseDaoImpl;

@WebServlet("/DeletePurchaseServlet.do")
public class DeletePurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserLog userLog = new UserLog();
		PurchaseDaoImpl purchaseDaoImpl = new PurchaseDaoImpl();
		HttpSession session=request.getSession();

		String onumber=request.getParameter("onumber");
System.out.print("【删除购买记录】---前端传来的onumber为："+onumber);
		
		//测试-暂时
		User Login_user=(User) session.getAttribute("Login_user");
		String Login_uid=Login_user.getUid();
		String Login_urole=Login_user.getUrole();
		String Login_uname=Login_user.getUname();
	//		String Login_uid="114514";
	//		String Login_urole="admin";
	//		String Login_uname="管理员先生";
		
		try {
			if(purchaseDaoImpl.deletePurchaseByOnumber(onumber) <=0) {
				System.out.println("！删除gameLog失败:"+onumber);
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员删除购买记录，记录id："+onumber, "失败");
				response.setStatus(500);	//500服务器内部错误
				request.setAttribute("msg", "删除失败。");
				request.setAttribute("path", "../QueryAllGameLogServlet.do");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			
			}else {
				System.out.println("删除gameLog成功:"+onumber);
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员删除购买记录，记录id："+onumber, "成功");
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
