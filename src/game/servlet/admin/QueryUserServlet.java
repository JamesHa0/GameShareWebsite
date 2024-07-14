package game.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.User;
import game.dao.UserDaoImpl;

@WebServlet("/QueryUserServlet.do")
public class QueryUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public QueryUserServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取path
        HttpSession session = request.getSession();
        String path_param = request.getParameter("path");
        String path = (String) session.getAttribute("path"); // 从session中获取path
        if (path_param != null)
            path = path_param;
        System.out.println("---前端传递path（user单查）=" + path);

        // 前端传来的数据
        String uid = request.getParameter("uid");
        String utel = request.getParameter("utel");
        String uemail = request.getParameter("uemail");
        System.out.println("---前端传来的数据是（user单查）："
                + "\n     uid=" + uid
                + "\n     utel=" + utel
                + "\n     uemail=" + uemail);

        try {
            UserDaoImpl userdao = new UserDaoImpl();
            User user = new User();
            if (uid != null && !"".equals(uid)) {
                user = userdao.queryUserByUid(uid); // 根据uid查询用户
            } else if (utel != null && !"".equals(utel)) {
                user = userdao.queryUserByUtel(utel); // 根据手机号查询用户
            } else if (uemail != null && !"".equals(uemail)) {
                user = userdao.queryUserByUemail(uemail); // 根据邮箱查询用户
            } else {
                // 如果所有查询条件都为空
                response.sendRedirect("jsp_admin/" + path + "?query=queryAll"); // 重定向到查询所有用户的页面
            }

            if (user == null) {
                System.out.println("[null] Servlet-user单查：user=空。数据库里没有该用户。");
                response.sendRedirect("jsp_admin/" + path + "?query=none"); // 重定向到未找到用户的页面
            } else {
                System.out.println("√ Servlet-user单查:成功获取user。");
                // 将用户装载到列表中
                List<User> userList = new ArrayList<>();
                userList.add(user);
                session.setAttribute("allUsers", userList); // 将用户列表存入session中
                response.sendRedirect("jsp_admin/" + path + "?query=get_it"); // 重定向到获取用户成功的页面
            }
        } catch (Exception e) {
            System.out.println("!500 Servlet-user单查。");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 处理POST请求，直接调用doGet方法
        doGet(request, response);
    }
}
