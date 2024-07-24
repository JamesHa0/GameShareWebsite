package game.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.UserLog;
import game.dao.GameDaoImpl; // 假设您有一个GameDaoImpl来处理游戏数据

//删除游戏的业务。
@WebServlet("/DeleteGameServlet.do")
public class DeleteGameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteGameServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserLog userLog = new UserLog();
        GameDaoImpl gameDao = new GameDaoImpl(); 
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
        
        //前端数据
        String in_gid = request.getParameter("gid"); 
        System.out.println("【删除游戏】---前端传来的gid为："+in_gid);

        try {
            if (gameDao.deleteGameByGId(in_gid) <= 0) { 
                System.out.println("！500 删除游戏失败:" + in_gid);
                response.setStatus(500); // 500服务器内部错误
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员删除游戏：500", "失败");

            } else {
                System.out.println("√ 删除游戏成功:" + in_gid);
                response.setStatus(200); // 200顺利
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员删除游戏", "成功");
            }

        } catch (Exception e) {
            System.out.println("！500 servlet-game-delete");
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员删除游戏：500-2", "失败");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}