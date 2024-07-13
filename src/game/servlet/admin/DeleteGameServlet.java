package game.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.User;
import game.bean.UserLog;
import game.dao.GameDaoImpl; // 假设您有一个GameDaoImpl来处理游戏数据

@WebServlet("/DeleteGameServlet.do")
public class DeleteGameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteGameServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserLog userLog = new UserLog();
        GameDaoImpl gameDao = new GameDaoImpl(); 
        HttpSession session = request.getSession();

        String in_gid = request.getParameter("gid"); 

        System.out.println("---前端传来的gid为："+in_gid);

        //测试-暂时
		User Login_user=(User) session.getAttribute("Login_user");
		String Login_uid=Login_user.getUid();
		String Login_urole=Login_user.getUrole();
		String Login_uname=Login_user.getUname();
//		String Login_uid="114514";
//		String Login_urole="admin";
//		String Login_uname="管理员先生";

        try {
            if (gameDao.deleteGameByGId(in_gid) <= 0) { 
                System.out.println("！500 删除游戏失败:" + in_gid);
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员删除游戏", "失败");
                
                response.setStatus(500); // 500服务器内部错误
                //request.setAttribute("msg", "删除失败。");
                //request.setAttribute("path", "../QueryAllGameServlet.do"); // 假设这是查询所有游戏的servlet
                //request.getRequestDispatcher("error.jsp").forward(request, response);

            } else {
                System.out.println("√ 删除游戏成功:" + in_gid);
                response.setStatus(200); // 200顺利
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员删除游戏", "成功");

                //request.setAttribute("msg", "删除成功。");
                //request.setAttribute("path", "../QueryAllGameServlet.do");
                //request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (Exception e) {
            System.out.println("！500 servlet-game-delete");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}