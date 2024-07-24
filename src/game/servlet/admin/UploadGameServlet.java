package game.servlet.admin;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import game.bean.Game;
import game.bean.UserLog;

//上传游戏的业务。
@WebServlet("/UploadGameServlet.do" )
@MultipartConfig(fileSizeThreshold = 1024*100)//100KB
public class UploadGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//initial
    	UserLog userLog = new UserLog();
		HttpSession session=request.getSession();
    	String SESSIONID=(String) session.getAttribute("SESSIONID");
		Game game=(Game) (session.getAttribute("Insert_game"+SESSIONID)) ;
		String gid=game.getGid();//刚刚插入到数据库中的游戏的id
		
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
		Part p = request.getPart("addFile");
		if(p==null) {
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员上传游戏：游戏为空" , "失败");
			System.out.println("【文件上传】！ part=null");
			response.sendRedirect("jsp_admin/admin_Module05_GameMng.jsp");
		}
		
		
		//main
		String fname = getFilename(p);	//上传时的文件名。我们不要。
		if(gid!=null) {
			fname=gid+".zip";		//例如100000003.zip
		}
		System.out.print("【文件上传】---上传文件名为："+fname+" ; ");
		
		if (p.getSize() > 100 * 1024 * 1024) {//100MB
			p.delete();
			System.out.println("! 文件太大。上传失败");
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员上传游戏：游戏过大" , "失败");
		} else {
			String path = getUploadPath();
			File f=new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			p.write(path+File.separator+ fname);//写入文件
			System.out.println("√ 上传成功。位置在 "+path+File.separator+fname);
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员上传游戏，游戏名：" + game.getGname(), "成功");
		}
		response.sendRedirect("jsp_admin/admin_Module05_GameMng.jsp"); 
	}
	


	private String getFilename(Part part) {//方法1
		String fname = null;
		String header = part.getHeader("content-disposition");
		fname = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
		return fname;
	}
	
	private String getUploadPath() {//方法2
		ServletContext context = this.getServletContext();
		String nowPath = context.getRealPath("/game/");
		return nowPath;
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}