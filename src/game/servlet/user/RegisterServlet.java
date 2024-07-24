package game.servlet.user;

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


@WebServlet("/RegisterServlet.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	UserLog userLog = new UserLog();
		UserDaoImpl userdao =new UserDaoImpl();
    	HttpSession session=request.getSession();
    	String SESSIONID=(String) session.getAttribute("SESSIONID");
		
		// 获取前端输入的数据
		String utel 	= request.getParameter("utel");
		String uemail 	=request.getParameter("uemail");
		String checkinput 	= request.getParameter("checkinput");
		String upsw 	= request.getParameter("upsw");
		String uname 	=request.getParameter("uname");
		String urole 	="user";
		String ugender 	=request.getParameter("ugender");
		String uaddress =request.getParameter("uaddress");
		
		//加密
		try {
			upsw=MD5.MD5Encoder(upsw);
		}catch (NoSuchAlgorithmException e) {
			System.out.println("！Servlet:注册时MD5转换报错。");
		}
		
		
		// 验证码部分：
		String checkcode_session = (String) session.getAttribute("checkcode_session_"+SESSIONID);
		if(checkcode_session==null) {
			System.out.println("！session中的checkcode_session值为空。考虑验证码生成问题、赋值问题或取值问题。");
			return;
		}
		if (!checkcode_session.equalsIgnoreCase(checkinput)) {// 未正确输入验证码（忽略大小写）
			userLog.logOperation("未登录",uname, urole,  "用户注册：验证码错误", "失败");
			request.setAttribute("msg", "请正确输入验证码。");
			request.setAttribute("path", "LR.jsp");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			//验证码通过：
			System.out.print("√ 验证码通过 ; ");
			try {
				User user_test=userdao.queryUserByUtel(utel);
				if(user_test !=null) {
					System.out.println("！注册失败（该用户已存在）。");
					userLog.logOperation("未登录",uname, urole,  "用户注册：该用户已存在", "失败");
					request.setAttribute("msg", "注册失败：该User已存在。");
					request.setAttribute("path", "LR.jsp");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				else {//insert数据入库：
					User user_new=new User(uname, utel, uemail, urole, ugender, uaddress, upsw);
					if(userdao.insertUser(user_new) <=0) {//插入失败
						System.out.println("！注册失败（500）。");
						userLog.logOperation("未登录",uname, urole ,  "用户注册：insert失败", "失败");
						request.setAttribute("msg", "注册失败：500。");
						request.setAttribute("path", "LR.jsp");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}else {//注册成功，则视为已登录：
						System.out.println("√ 注册成功。");
						userLog.logOperation("待生成",uname, urole,  "用户注册", "成功");
						User user=userdao.queryUserByUtel(utel);
						String uid=user.getUid();
						response.addCookie(new Cookie("Login_uid", uid));
						response.addCookie(new Cookie("Login_uname",uname));
						response.addCookie(new Cookie("Login_urole",urole));
							
						response.sendRedirect("index.jsp");
					}
				}
			} catch (Exception e) {
				System.out.println("！500 用户注册页面。");
				userLog.logOperation("未登录","未登录", "未登录",  "用户注册：500-2", "失败");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
