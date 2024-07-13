package game.servlet.admin;

import java.io.*;

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
		
		String path = this.getServletContext().getRealPath("/");
		Part p = request.getPart("filename");
		String fname = getFilename(p);	//文件名
		System.out.print("---上传文件名为："+fname);
		if (p.getSize() > 100 * 1024 * 1024) {//100MB
			p.delete();
			System.out.println("! 文件太大。上传失败");
		} else {
			path = path + "\\game\\" + fname;
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			System.out.println(fname);
			p.write(path + "\\" + fname);//写入文件
			System.out.println("√ 上传成功。");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}