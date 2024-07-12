package game.servlet.admin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.User;
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
        
User tmp=new User(uid, uname, utel, uemail, urole, ugender, uaddress, upsw, upoint);
System.out.println(tmp);

        if(upsw.length() <= 18) { // 若未加密：(简单判断密码是否已经加密（假设未加密密码长度小于等于18）
            try {
                upsw = MD5.MD5Encoder(upsw);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("！Servlet-update：加密报错。");
            }
        }

        User user = new User(uid, uname, utel, uemail, urole, ugender, uaddress, upsw, upoint);
        try {
            int updateResult = daoImp.updateUserByUid(user); 
            if(updateResult<=0) {
            	System.out.println("!插入失败。");
            	response.setStatus(500);//500了
            } else {
            	response.setStatus(200);//200万岁
            }
        } catch (Exception e) {
            System.out.println("!Servlet:update时报错。");
            response.setStatus(500);
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}