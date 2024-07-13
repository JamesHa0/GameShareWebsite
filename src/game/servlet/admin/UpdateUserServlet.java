package game.servlet.admin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.User;
import game.bean.UserLog;
import game.dao.UserDaoImpl;
import game.other.MD5;


@WebServlet("/UpdateUserServlet.do")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDaoImpl daoImp; 

    public UpdateUserServlet() {
        super();
        daoImp = new UserDaoImpl(); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	UserLog userLog = new UserLog();
        
        String uid = request.getParameter("uid");
        String uname = request.getParameter("uname");
        String utel = request.getParameter("utel");
        String uemail = request.getParameter("uemail");
        String urole = request.getParameter("urole_"+uid);//!!!!!!切记urole特殊
        	if(urole==null)urole=request.getParameter(urole);
        String ugender = request.getParameter("ugender");
        String uaddress = request.getParameter("uaddress");
        String upsw = request.getParameter("upsw");
        String upoint = request.getParameter("upoint");	//9


        if(upsw.length() <= 18) { // 若未加密：(简单判断密码是否已经加密（假设未加密密码长度小于等于18）
            try {
                upsw = MD5.MD5Encoder(upsw);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("！Servlet-update：加密报错。");
            }
        }
        
        //测试-暂时
		//User Login_user=(User) session.getAttribute("Login_user");
		//String Login_uid=Login_user.getUid();
		String Login_uid="114514";
		//String Login_urole=Login_user.getUrole();
		String Login_urole="admin";
		//String Login_uname=Login_user.getUname();
		String Login_uname="管理员先生";
		
        User user = new User(uid, uname, utel, uemail, urole, ugender, uaddress, upsw, upoint);
        try {
            int updateResult = daoImp.updateUserByUid(user); 
            if(updateResult<=0) {
            	System.out.println("!插入失败。");
				userLog.logOperation(Login_uid,Login_uname, Login_urole,  "修改User信息", "失败");
            	response.setStatus(500);//500了
            } else {
				userLog.logOperation(Login_uid,Login_uname, Login_urole,  "修改User信息", "成功");
            	response.setStatus(200);//200万岁
            }
        } catch (Exception e) {
            System.out.println("!500 Servlet-user-update");
            response.setStatus(500);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}