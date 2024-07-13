package game.servlet.admin;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadGameServlet.do" )
@MultipartConfig(location = "D:\\", fileSizeThreshold = 1024*100)//100KB
public class UploadGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String getFilename(Part part) {
		String fname = null;
		String header = part.getHeader("content-disposition");
		System.out.println(header);
		fname = header.substring(header.lastIndexOf("=") + 2, header.length() - 1);
		return fname;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Part p = request.getPart("addFile");
		if(p==null) {
			System.out.println("【文件上传】！ part=null");
			response.sendRedirect("jsp_admin/admin_Module05_GameMng.jsp");
		}
			
		String fname = getFilename(p);	//文件名
		System.out.print("【文件上传】---上传文件名为："+fname+" ; ");
		if (p.getSize() > 100 * 1024 * 1024) {//100MB
			p.delete();
			System.out.println("! 文件太大。上传失败");
		} else {
			String path = "/game"+File.separator;
			File f = new File(path);
			path=f.getAbsolutePath();
			
			
			ServletContext context = getServletContext();
			String absolutePath = context.getRealPath(".metadata");
			System.out.println(".metadata绝对路径: " + absolutePath);
			
//			context = getServletContext();
//			path = context.getRealPath("/game") + File.separator;

			System.out.println(" path="+path);
			if (!f.exists()) {
				f.mkdirs();
			}
			p.write("game/" + fname);//写入文件
			System.out.println("√ 上传成功。位置在 "+path+"\\"+fname);

		}
		
//		response.sendRedirect("jsp_admin/admin_Module05_GameMng.jsp");
		request.getRequestDispatcher("jsp_admin/admin_Module05_GameMng.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}