package game.servlet.admin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.User;
import game.bean.UserLog;
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
		UserLog userLog = new UserLog();
    	HttpSession session=request.getSession();
    	String SESSIONID=(String) session.getAttribute("SESSIONID");
		
		// 前台信息：
		String in_utel = request.getParameter("utel");
		String in_checkcode = request.getParameter("checkinput");
		String in_upsw = request.getParameter("upsw");

		// MD5加密
		try {
			in_upsw = MD5.MD5Encoder(in_upsw);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("servlet:login:Md5异常");
		}
		System.out.println("login页面前端传递的参数：\n\t utel:"+in_utel+ "\n\t checkinput:"+in_checkcode+"\n\t upsw:"+in_upsw);
		
		
		// 检查验证码是否正确：
		String checkcode_session = (String) session.getAttribute("checkcode_session_"+SESSIONID);
		if (!checkcode_session.equalsIgnoreCase(in_checkcode)) {// 未正确输入验证码（忽略大小写）
			userLog.logOperation("未登录","未登录", "未登录",  "管理员登录：验证码错误", "失败");
			request.setAttribute("msg", "请正确输入验证码。");
			request.setAttribute("path", "jsp_admin/admin_login.jsp");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			// 验证码正确，检查用户是否存在：
			try {
				UserDaoImpl userdao=new UserDaoImpl();
				User user=userdao.queryUserByUtel(in_utel);
				if(user == null) {//用户不存在
					userLog.logOperation("未登录","未登录", "未登录",  "管理员登录：用户不存在", "失败");
					request.setAttribute("msg", "您尚未注册。");
					request.setAttribute("path", "jsp_admin/admin_login.jsp");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}else {
					//用户存在，检查角色是否为管理员：
					String uid=user.getUid();
					String uname=user.getUname();
					String urole=user.getUrole();
					String upsw=user.getUpsw();
					if(!("admin".equals(user.getUrole())) ) {//不是管理员
						userLog.logOperation(uid,uname, urole,  "管理员登录：不是管理员", "失败");
						request.setAttribute("msg", "请使用管理员账号登录。");
						request.setAttribute("path", "jsp_admin/admin_login.jsp");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}else {
						//是管理员，检查密码是否正确：
						System.out.println("用户输入密码：\t"+in_upsw+"\n应输入的密码：\t"+upsw);
						if(!in_upsw.equals(upsw)){//密码错误
							userLog.logOperation(uid,uname, urole,  "管理员登录：密码错误", "失败");
							request.setAttribute("msg", "密码错误。");
							request.setAttribute("path", "jsp_admin/admin_login.jsp");
							request.getRequestDispatcher("error.jsp").forward(request, response);
						}else {
								//密码正确，登录成功：
								System.out.println("登录成功。");
								userLog.logOperation(uid,uname, urole,  "管理员登录：密码正确", "成功");
								response.addCookie(new Cookie("Login_uid", uid));
								response.addCookie(new Cookie("Login_uname",uname));
								response.addCookie(new Cookie("Login_urole",urole));
								
								response.sendRedirect("jsp_admin/admin.jsp");
						}
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("!500 Servlet:login报错");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
