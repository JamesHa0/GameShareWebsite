package game.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.dao.GameDaoImpl; 
import game.bean.Game;
import game.bean.UserLog;

@WebServlet("/InsertGameServlet.do")
public class InsertGameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public InsertGameServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
    	String SESSIONID=(String) session.getAttribute("SESSIONID");
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
        
        // 前端数据
        String gname = request.getParameter("gname");
        String gprice = request.getParameter("gprice");
        String gdeveloper = request.getParameter("gdeveloper");
        String gpublisher = request.getParameter("gpublisher");
        String grelease_date = request.getParameter("grelease_date");
        String gdescription = request.getParameter("gdescription");
        String gzhname = request.getParameter("gzhname");
        String gtag = request.getParameter("gtag");
        Game in_game=new Game(gname, gprice, gdeveloper, gpublisher, grelease_date, gdescription, gzhname, gtag);
        System.out.println("【插入游戏】---前端数据："+in_game);

		
        
        try {
            //检查游戏是否已存在：
            Game game_test = gameDao.queryGameByGname(gname);
            if(game_test != null) {
                System.out.println("！409 servlet-game-insert:插入失败！游戏名称已存在。");
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员新增游戏数据：游戏名称已存在", "失败");
                response.setStatus(409); // 409 冲突
//                return;
            } else {
                // 插入数据到数据库
                Game game_new = new Game(gname, gprice, gdeveloper, gpublisher, grelease_date, gdescription, gzhname, gtag);
                if(gameDao.insertGame(game_new) <= 0) {
                    System.out.println("！500 servlet-game-insert:插入失败！");
                    userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员新增游戏数据", "失败");
                    response.setStatus(500);
//                    return;
                }
                // 插入成功
                System.out.println("√  servlet-game-insert:插入成功");
                userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员新增游戏数据，游戏名：" + gname, "成功");
                
                //向紧接着的操作（UploadGameServlet）传参gid：（这里直接传game对象）
                Game Insert_game=gameDao.queryGameByGname(gname);
                session.setAttribute("Insert_game_"+SESSIONID, Insert_game);
                
                response.setStatus(200); //200
            }
        } catch (Exception e) {
            System.out.println("！servlet-game-insert:报错。");
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员新增游戏数据:500", "失败");
            response.setStatus(500);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}