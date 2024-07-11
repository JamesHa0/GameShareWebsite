package game.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.dao.UserDaoImpl;
import game.other.MD5;
import game.bean.User; 

@WebServlet("/InsertUserServlet.do")
public class InsertUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InsertUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		PrintWriter out=response.getWriter();
    	
    	// 获取前端输入的数据
     		String utel 	= request.getParameter("utel");
     		String uemail 	=request.getParameter("uemail");
     		String upsw 	= request.getParameter("upsw");
     		String uname 	=request.getParameter("uname");
     		String ugender 	=request.getParameter("ugender");
     		String uaddress =request.getParameter("uaddress");//6
     		
     		//加密
     		try {
     			upsw=MD5.MD5Encoder(upsw);
     		}catch (NoSuchAlgorithmException e) {
     			System.out.println("！Servlet:注册时MD5转换报错。");
     			response.setStatus(500);
     			out.print("！Servlet:注册时MD5转换报错。");
     		}

 			try {
 				UserDaoImpl userdao =new UserDaoImpl();
 				User user_test=userdao.queryUserByUtel(utel);
 				if(user_test !=null) {
 					response.setStatus(500);
 					return;
 				}
 				else {//insert数据入库：
 					User user_new=new User(uname, utel, uemail, ugender, uaddress, upsw);
 					if(userdao.insertUser(user_new) <=0) {//user_new 目前还没有uid值
 						System.out.println("！servlet-insert:失败！");
 		     			response.setStatus(400);
 		     			out.print("！servlet-insert:失败！");
 						return;
 					}
 					//插入成功：
 					response.setStatus(200);//200
 					return;
 				}
 			} catch (Exception e) {
 				System.out.println("！servlet-insert:报错。");
     			out.print("！servlet-insert:报错。");
 				response.setStatus(500);
 			}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}