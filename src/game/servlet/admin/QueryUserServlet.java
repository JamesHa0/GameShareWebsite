package game.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.User;
import game.dao.UserDaoImpl;



@WebServlet("/QueryUserServlet.do")
public class QueryUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryUserServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取path
		HttpSession session=request.getSession();
		String path = (String) session.getAttribute("path");
		System.out.println("path="+path);
		
		//前端传来的数据
		String uid=request.getParameter("uid");
		String utel=request.getParameter("utel");
		String uemail =request.getParameter("uemail");
System.out.println("---查询单条，前端传来的数据是："
		+ "\n uid="+uid
		+ "\n utel="+utel
		+ "\n uemail="+uemail);
		
		try {
			UserDaoImpl userdao=new UserDaoImpl();
			User user=new User();
			if(uid!=null) {
				user=userdao.queryUserByUid(uid);
			}else if(utel !=null) {
				user=userdao.queryUserByUtel(utel);
			}else if(uemail!=null) {
				user=userdao.queryUserByUemail(uemail);
			}
			
			if(user==null) {
				System.out.println("QueryUserServlet：user=空。数据库里没有该用户。");
			}else {
				System.out.println("QueryUserServlet:成功获取user。");
			}
			
			//装载：
			List<User> li = new ArrayList<User>();
			li.add(user);
			if (li == null || li.isEmpty()) {
			    li = new ArrayList<>(); // 确保 li 不为空，避免 NullPointerException
			    System.out.println("!servlet-query: li 是空的。");
			} else {
			    System.out.println("servlet-query: li 成功获取数据。");
			}
			request.setAttribute("allUsers", li);
			request.getRequestDispatcher("jsp_admin/"+path).forward(request, response);
		} catch (Exception e) {
			System.out.println("!Servlet：query:User查询报错。");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
