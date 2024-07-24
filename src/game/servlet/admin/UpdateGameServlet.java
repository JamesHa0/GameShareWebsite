package game.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.Game;
import game.bean.UserLog;
import game.dao.GameDaoImpl;

//更新游戏的业务。
@WebServlet("/UpdateGameServlet.do")
public class UpdateGameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//initial
    	UserLog userLog = new UserLog();
    	GameDaoImpl gamedao=new GameDaoImpl();
	   
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
        String gid = request.getParameter("gid");
        String gname = request.getParameter("gname");
        String gprice = request.getParameter("gprice");
        String gdeveloper = request.getParameter("gdeveloper");
        String gpublisher = request.getParameter("gpublisher");
        String grelease_date = request.getParameter("grelease_date");
        String gdescription = request.getParameter("gdescription");
        String gzhname = request.getParameter("gzhname");
        String gtag = request.getParameter("gtag");
        Game game = new Game(gid, gname, gprice, gdeveloper, gpublisher, grelease_date, gdescription, gzhname, gtag);
        
        
        //main
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