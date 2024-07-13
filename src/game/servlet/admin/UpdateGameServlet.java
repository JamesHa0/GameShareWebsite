package game.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.Game;
import game.bean.UserLog;
import game.dao.GameDaoImpl;

@WebServlet("/UpdateGameServlet.do")
public class UpdateGameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserLog userLog = new UserLog();
        GameDaoImpl gamedao=new GameDaoImpl();
        
        // 获取前端输入的数据
        String gid = request.getParameter("gid");
        String gname = request.getParameter("gname");
        String gprice = request.getParameter("gprice");
        String gdeveloper = request.getParameter("gdeveloper");
        String gpublisher = request.getParameter("gpublisher");
        String grelease_date = request.getParameter("grelease_date");
        String gdescription = request.getParameter("gdescription");
        String gzhname = request.getParameter("gzhname");
        String gtag = request.getParameter("gtag");

        	//测试-暂时
      		//User Login_user=(User) session.getAttribute("Login_user");
      		//String Login_uid=Login_user.getUid();
      		String Login_uid="114514";
      		//String Login_urole=Login_user.getUrole();
      		String Login_urole="admin";
      		//String Login_uname=Login_user.getUname();
      		String Login_uname="管理员先生";

        Game game = new Game(gid, gname, gprice, gdeveloper, gpublisher, grelease_date, gdescription, gzhname, gtag);
        try {
            if (gamedao.updateGameByGId(game) <= 0) {
                System.out.println("!500 servlet-game-update ");
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "修改游戏信息", "失败");
                response.setStatus(500); // 500 服务器内部错误
            } else {
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "修改游戏信息", "成功");
                response.setStatus(200); // 200 OK
            }
        } catch (Exception e) {
            System.out.println("!500 servlet-game-update 更新游戏信息时发生错误。");
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "修改游戏信息:500", "失败");
            response.setStatus(500);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}