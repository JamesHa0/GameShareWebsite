package crf.servlet.user;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import crf.bean.User;
import crf.dao.UserDaoImpl;
import crf.other.MD5;


@WebServlet("/RegisterServlet.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
		HttpSession session = request.getSession();
		String checkcode_session = (String) session.getAttribute("checkcode_session");
		if (!checkcode_session.equalsIgnoreCase(checkinput)) {// 未正确输入验证码（忽略大小写）
			request.setAttribute("msg", "请正确输入验证码。");
			request.setAttribute("path", "LR.jsp");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		} else {
			
			//验证码通过：
			UserDaoImpl userdao =new UserDaoImpl();
			String uid=(String)session.getAttribute("uid");
			try {
				if(userdao.queryUserByUtel(utel) !=null) {
					request.setAttribute("msg", "注册失败：该User已存在。");
					request.setAttribute("path", "LR.jsp");
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				else {//insert数据入库：
					User user=new User(uname, utel, uemail, urole, ugender, uaddress, upsw);
					if(userdao.insertUser(user) <=0) {
						System.out.println("！插入学生记录失败！");
					}
					//注册成功，则跳转：
					System.out.println("----当前用户："+session.getAttribute("uid"));
					if(session.getAttribute("uid") == null)//未登录状态
						session.setAttribute("uid", uid);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				System.out.println("！注册页面报错。");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
