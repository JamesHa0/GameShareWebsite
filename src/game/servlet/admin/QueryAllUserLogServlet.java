package game.servlet.admin;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.User;
import game.bean.UserLog;
import game.dao.UserDaoImpl;

@WebServlet("/QueryAllUserLogServlet.do")
public class QueryAllUserLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public QueryAllUserLogServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDaoImpl userdao=new UserDaoImpl();
		
		String path=(String) request.getAttribute("path");
		System.out.println("path="+path);
		
		try {
			List<UserLog> li =userdao.queryAllUser();
			if(li.isEmpty()) {
				System.out.println("!servlet-queryAll:li是空的。");
				response.setStatus(400);
				return;
			}else {
				System.out.println("servlet-queryAll:li成功获取数据。");
			}
			request.setAttribute("allUsers", li);
			response.setStatus(200);//200
			request.getRequestDispatcher("jsp_admin/"+path).forward(request, response);
		} catch (Exception e) {
			System.out.println("!servlet:queryAllUser报错。");
			response.setStatus(500);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
