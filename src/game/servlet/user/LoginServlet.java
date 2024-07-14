package game.servlet.user;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.User;
import game.bean.UserLog;
import game.dao.UserDaoImpl;
import game.other.MD5;

@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	UserLog userLog = new UserLog();
    	HttpSession session=request.getSession();

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
		
		
System.out.println("登录页传来的数据为：\n电话："+utel
		+"，\n验证码："+checkinput
		+"，\n密码（加密后）："+upsw
		);   
		
		
		// 验证码部分：
		String checkcode_session = (String) session.getAttribute("checkcode_session");
		if (!checkcode_session.equalsIgnoreCase(checkinput)) {// 未正确输入验证码（忽略大小写）
			userLog.logOperation("未登录","未登录", "未登录",  "用户登录：验证码错误", "失败");
			request.setAttribute("msg", "请正确输入验证码。");
			request.setAttribute("path", "LR.jsp");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			// 验证码正确，则继续处理：
			try {
				UserDaoImpl userdao=new UserDaoImpl();
				User user=userdao.queryUserByUtel(utel);
				if(user == null) {//用户不存在
					userLog.logOperation("未登录","未登录", "未登录",  "用户登录：用户不存在", "失败");
					request.setAttribute("msg", "您尚未注册。");
					request.setAttribute("path", "LR.jsp");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}else {
					String uid=user.getUid();
					String uname=user.getUname();
					String urole=user.getUrole();
					String psw=user.getUpsw();//数据库中MD5加密的密码
					System.out.println("用户输入密码："+upsw+"\n应输入的密码："+psw);
					if(!upsw.equals(psw)){//密码错误
						userLog.logOperation(uid,uname, urole,  "用户登录：密码错误", "失败");
						request.setAttribute("msg", "密码错误。");
						request.setAttribute("path", "LR.jsp");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}else {//密码正确
						userLog.logOperation(uid,uname, urole,  "用户登录：密码正确", "成功");
						System.out.println("登录成功。");
						session.setAttribute("Login_uname", uname);//session标记为登录状态，记录登录用户名和user对象***********************************
						session.setAttribute("Login_uid", uid);
						session.setAttribute("Login_user", user);
						response.sendRedirect("index.jsp");
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Servlet:login报错");
				userLog.logOperation("未登录","未登录", "未登录",  "用户登录：500", "失败");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
