package game.servlet.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.dao.UserDaoImpl;
import game.dao.UserLogDaoImpl;

@WebServlet("/DeleteUserLogServlet.do")
public class DeleteUserLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteUserLogServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserLogDaoImpl logdao=new UserLogDaoImpl();
		HttpSession session=request.getSession();

		String uid=request.getParameter("uid");
System.out.println("————前端传来的uid为："+uid);
String urole="admin";//测试-暂时
		//String urole= ((User)session.getAttribute("Login_user")).getUrole();//获取角色
		try {
			if(logdao.deleteUser(uid) <=0) {
				System.out.println("！删除student失败:"+uid);
				response.setStatus(500);	//500服务器内部错误
				request.setAttribute("msg", "删除失败。");
				request.setAttribute("path", "../QueryAllUserServlet.do");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			
			}else {
				System.out.println("删除user成功:"+uid);
				response.setStatus(200); 	//200顺利
				//紧接着，如果不是管理员在操作，也要移除登录状态：
				if( !("admin".equals(urole)) ) {
					session.invalidate();
					System.out.println("已移除登录状态。");
				}
				request.setAttribute("msg", "删除成功。");
				request.setAttribute("path", "../QueryAllUserServlet.do");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println("servlet-deleteuser：删除时报错。");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
