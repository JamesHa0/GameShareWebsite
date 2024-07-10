package game.servlet.admin;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.User;
import game.dao.UserDaoImpl;

@WebServlet("/x")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DeleteUserServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDaoImpl userdao=new UserDaoImpl();
		HttpSession session=request.getSession();

		String uid=request.getParameter("uid");
		String urole= ((User)session.getAttribute("Login_user")).getUrole();//获取角色
		try {
			if(userdao.deleteUser(uid) <=0) {
				System.out.println("！删除student失败:"+uid);
				
			}else {
				System.out.println("删除user成功:"+uid);
				//紧接着，如果不是管理员在操作，也要移除登录状态：
				if( !("admin".equals(urole)) ) {
					session.invalidate();
					System.out.println("已移除登录状态。");
				}
				request.setAttribute("msg", "删除成功。");
				request.setAttribute("path", "jsp_admin/admin_login.jsp");
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
