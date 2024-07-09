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
		String uid=request.getParameter("uid");
		String utel=request.getParameter("utel");
		String uemal =request.getParameter("uemail");
		
		try {
			User user=new UserDaoImpl().queryUserByUid(uid);
			if(stu==null )
				System.out.println("servlet：query:查找该学生返回为空。");
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("jsp/disp_Student.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println("Servlet：query:User查询报错。");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
