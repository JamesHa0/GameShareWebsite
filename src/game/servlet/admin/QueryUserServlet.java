package game.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

//单查用户的业务。无论结果如何，都将携带allUsers数组，跳转到jsp_admin/%path%，并传递参数query的值。
@WebServlet("/QueryUserServlet.do")
public class QueryUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QueryUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//initial
    	UserLog userLog = new UserLog();
        UserDaoImpl userdao = new UserDaoImpl();
        List<User> userList = new ArrayList<>();
//		HttpSession session=request.getSession();
//    	String SESSIONID=(String) session.getAttribute("SESSIONID");
//		String path=(String) session.getAttribute("path_"+SESSIONID);//session中
		
		
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
		
        // 前端传来的数据
        String path = request.getParameter("path");
        System.out.print("【单查用户】---前端传递path="+path+" ; ");
        String uid = request.getParameter("uid");
        String utel = request.getParameter("utel");
        String uemail = request.getParameter("uemail");
        System.out.println("---前端传来的数据是：\n\t uid=" + uid + "\n\t utel=" + utel + "\n\t uemail=" + uemail);
        
        //main
        try {//根据不空的项来定义查找关键字
            User user = new User();
            if (uid != null && !"".equals(uid)) {
                user = userdao.queryUserByUid(uid); // 根据uid查询用户
            } else if (utel != null && !"".equals(utel)) {
                user = userdao.queryUserByUtel(utel); // 根据手机号查询用户
            } else if (uemail != null && !"".equals(uemail)) {
                user = userdao.queryUserByUemail(uemail); // 根据邮箱查询用户
            } else {// 都是空的！
                response.sendRedirect("jsp_admin/" + path + "?query=queryAll"); //*********1
            }

            if (user == null) {
                System.out.println("!204 Servlet-user单查：user=空。数据库里没有该用户。");
                response.sendRedirect("jsp_admin/" + path + "?query=none"); //************2
            } else {
                System.out.println("√ Servlet-user单查:成功获取user。");
                userList.add(user);
                request.setAttribute("allUsers", userList); 
//                response.sendRedirect("jsp_admin/" + path + "?query=get_it");
				request.getRequestDispatcher("jsp_admin/"+path+"?query=get_it").forward(request, response);//***********3
                
            }
        } catch (Exception e) {
            System.out.println("!500 Servlet-user单查。");
			userLog.logOperation(Login_uid, Login_uname, Login_urole, "单查用户：500", "失败");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 处理POST请求，直接调用doGet方法
        doGet(request, response);
    }
}
