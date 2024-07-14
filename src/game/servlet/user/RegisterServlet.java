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


@WebServlet("/RegisterServlet.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	UserLog userLog = new UserLog();
    	HttpSession session=request.getSession();
		
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
		String checkcode_session = (String) session.getAttribute("checkcode_session");
		if (!checkcode_session.equalsIgnoreCase(checkinput)) {// 未正确输入验证码（忽略大小写）
			userLog.logOperation("未登录","未登录", "未登录",  "用户注册：验证码错误", "失败");
			request.setAttribute("msg", "请正确输入验证码。");
			request.setAttribute("path", "LR.jsp");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			//验证码通过：
			try {
				UserDaoImpl userdao =new UserDaoImpl();
				User user_test=userdao.queryUserByUtel(utel);
				if(user_test !=null) {
					userLog.logOperation("未登录","未登录", "未登录",  "用户注册：该用户已存在", "失败");
					request.setAttribute("msg", "注册失败：该User已存在。");
					request.setAttribute("path", "LR.jsp");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				else {//insert数据入库：
					User user_new=new User(uname, utel, uemail, urole, ugender, uaddress, upsw);
					if(userdao.insertUser(user_new) <=0) {//user_new还没有uid值
						userLog.logOperation("未登录","未登录", "未登录",  "用户注册：500", "失败");
						System.out.println("！插入学生记录失败！");
						request.setAttribute("msg", "注册失败：500。");
						request.setAttribute("path", "LR.jsp");
						request.getRequestDispatcher("error.jsp").forward(request, response);
					}
					//注册成功，则跳转：
					userLog.logOperation("未登录","未登录", "未登录",  "用户注册", "成功");
					if(session.getAttribute("Login_uid") == null) {//若为未登录状态
						User user=userdao.queryUserByUtel(utel);
						String uid=user.getUid();
						session.setAttribute("Login_uid", uid);//*********************************************session填入登录信息
						session.setAttribute("Login_uname",uname);
						session.setAttribute("Login_user", user);
						System.out.println("----当前用户："+session.getAttribute("Login_uid"));
					}
						
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				userLog.logOperation("未登录","未登录", "未登录",  "用户注册：500", "失败");
				System.out.println("！注册页面报错。");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
