package crf.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crf.bean.User;
import crf.dao.UserDaoImpl;



@WebServlet("/QueryUserServlet.do")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryUserServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//前端传来的数据
		String uid=request.getParameter("uid");
		String utel=request.getParameter("utel");
		String uemail =request.getParameter("uemail");
		
		
		try {
			User user=null;
			if(uid!=null) {
				user=new UserDaoImpl().queryUserByUid(uid);
			}else if(utel !=null) {
				user=new UserDaoImpl().queryUserByUtel(utel);
			}else if(uemail!=null) {
				user=new UserDaoImpl().queryUserByUemail(uemail);
			}
			
			if(user==null) {
				System.out.println("!见鬼：servlet：query:user=空。");
			}
			
			//装载：
			request.setAttribute("user", user);
			request.getRequestDispatcher("jsp/disp_user.jsp").include(request, response);
		} catch (Exception e) {
			System.out.println("!Servlet：query:User查询报错。");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
