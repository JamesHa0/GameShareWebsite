package game.servlet.admin;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import game.bean.Game;
import game.bean.User;
import game.bean.UserLog;

@WebServlet("/UploadGameServlet.do" )
@MultipartConfig(fileSizeThreshold = 1024*100)//100KB
public class UploadGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String getFilename(Part part) {
		String fname = null;
		String header = part.getHeader("content-disposition");
		//System.out.println(header);
		fname = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
		return fname;
	}
	
	private String getUploadPath() {
		ServletContext context = getServletContext();
		
		String rowPath=context.getRealPath("");
		int i = rowPath.indexOf(".metadata");
		String prefix = rowPath.substring(0, i);
		// 构建新的路径
		String nowPath = prefix + "GameShareWebsite\\WebContent\\game\\";
		return nowPath;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserLog userLog = new UserLog();
		
		//测试-暂时
		User Login_user=(User) session.getAttribute("Login_user");
		String Login_uid=Login_user.getUid();
		String Login_urole=Login_user.getUrole();
		String Login_uname=Login_user.getUname();
//		String Login_uid="114514";
//		String Login_urole="admin";
//		String Login_uname="管理员先生";
		
		Part p = request.getPart("addFile");
		Game game=(Game) (session.getAttribute("Insert_game")) ;
		String gid=game.getGid();
		if(p==null) {
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员上传游戏：游戏为空" , "失败");
			System.out.println("【文件上传】！ part=null");
			response.sendRedirect("jsp_admin/admin_Module05_GameMng.jsp");
		}
		
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
            userLog.logOperation(Login_uid, Login_uname, Login_urole, "管理员上传游戏：，游戏名：" + game.getGname(), "成功");

		}
		response.sendRedirect("jsp_admin/admin_Module05_GameMng.jsp"); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}