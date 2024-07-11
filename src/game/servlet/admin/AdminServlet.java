package game.servlet.admin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.User;
import game.dao.UserDaoImpl;
import game.other.MD5;

@WebServlet("/AdminServlet.do")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取前端输入的数据
		String utel = request.getParameter("utel");
		String checkinput = request.getParameter("checkinput");
		String upsw = request.getParameter("upsw");

		// MD5加密upsw
		try {
			upsw = MD5.MD5Encoder(upsw);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("servlet:login:Md5异常");
		}
		
System.out.println("login页面前端传递的参数："	//测试用
		+ "\n	 utel:"+utel
		+ "\n	 upsw:"+upsw);
		
		// 检查验证码是否正确：
		HttpSession session = request.getSession();
		String checkcode_session = (String) session.getAttribute("checkcode_session");
		if (!checkcode_session.equalsIgnoreCase(checkinput)) {// 未正确输入验证码（忽略大小写）
			request.setAttribute("msg", "请正确输入验证码。");
			request.setAttribute("path", "jsp_admin/admin_login.jsp");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			// 验证码正确，检查用户是否存在：
			try {
				UserDaoImpl userdao=new UserDaoImpl();
				User user_test=userdao.queryUserByUtel(utel);
				if(user_test == null) {//用户不存在
					request.setAttribute("msg", "您尚未注册。");
					request.setAttribute("path", "jsp_admin/admin_login.jsp");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}else {
					//用户存在，检查角色是否为管理员：
					if(!("admin".equals(user_test.getUrole())) ) {//不是管理员
						request.setAttribute("msg", "请使用管理员账号登录。");
						request.setAttribute("path", "jsp_admin/admin_login.jsp");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}else {
						//是管理员，检查密码是否正确：
						String psw=user_test.getUpsw();//数据库中MD5加密的密码
						System.out.println("用户输入密码：\t"+upsw+"\n应输入的密码：\t"+psw);
						if(!upsw.equals(psw)){//密码错误
							request.setAttribute("msg", "密码错误。");
							request.setAttribute("path", "jsp_admin/admin_login.jsp");
							request.getRequestDispatcher("error.jsp").forward(request, response);
						}else {
								//密码正确，登录成功：
								//**************************把uid和user对象存入session：***********************************************************
								String uid=user_test.getUid();
								session.setAttribute("uid", uid);
								session.setAttribute("user", user_test);
								System.out.println("登录成功。");
								session.setAttribute("uid", uid);//session标记为登录状态，记录登录用户名
								response.sendRedirect("jsp_admin/admin_login.jsp");
						}
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Servlet:login报错");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
