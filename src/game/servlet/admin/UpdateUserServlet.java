package game.servlet.admin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.User;
import game.bean.UserLog;
import game.dao.UserDaoImpl;
import game.other.MD5;

//更新用户的业务。
@WebServlet("/UpdateUserServlet.do")
public class UpdateUserServlet extends  HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//initial
    	UserLog userLog = new UserLog();
        UserDaoImpl daoImp = new UserDaoImpl();
        
        //从Cookie获取当前登录者信息：
        String Login_uid = "0";
        String Login_uname = "获取cookie（Login_uname）失败";
        String Login_urole = "获取cookie（Login_urole）失败";
        Cookie[] cookie=request.getCookies();
        if(cookie !=null) {
        	for(Cookie c:cookie) {
        		if("Login_uid".equals(c.getName())) {
        			Login_uid=c.getValue();
        		}else if("Login_uname".equals(c.getName())) {
        			Login_uname=c.getValue();
        		}else if("Login_urole".equals(c.getName())) {
        			Login_urole=c.getValue();
        		}
        	}
        }
		
        // 前端数据
        String uid = request.getParameter("uid");
        String uname = request.getParameter("uname"); 
        String utel = request.getParameter("utel"); 
        String uemail = request.getParameter("uemail"); 
        String urole = request.getParameter("urole_" + uid); // 用户角色（注意特殊处理）
        if (urole == null) urole = request.getParameter("urole"); // 处理未传入特定用户角色情况
        String ugender = request.getParameter("ugender");
        String uaddress = request.getParameter("uaddress"); 
        String upsw = request.getParameter("upsw"); 
        String upoint = request.getParameter("upoint"); 
        
        
        // 如果密码未加密（假设未加密的密码长度小于等于18），则进行MD5加密
        if (upsw.length() <= 18) {
            try {
                upsw = MD5.MD5Encoder(upsw);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("！Servlet-update：加密报错。");
            }
        }
        User user = new User(uid, uname, utel, uemail, urole, ugender, uaddress, upsw, upoint);
        
        
        
        //main
        try {
            int updateResult = daoImp.updateUserByUid(user); 
            if (updateResult <= 0) {
                System.out.println("!插入失败。");
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "修改User信息", "失败");
                response.setStatus(500); //服务器内部错误
            } else {
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "修改User信息", "成功");
                response.setStatus(200); // 成功
            }
        } catch (Exception e) {
            System.out.println("!500 Servlet-user-update");
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "修改User信息：500", "失败");
            response.setStatus(500);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
