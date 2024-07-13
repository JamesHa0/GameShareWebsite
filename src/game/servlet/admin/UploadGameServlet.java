package game.servlet.admin;

import java.io.*;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadGameServlet.do" )
@MultipartConfig(location = "D:\\", fileSizeThreshold = 1024)
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
		String userName = request.getParameter("username");
		String userId = request.getParameter("userId");
		String fType = request.getParameter("filetype");
		String date = request.getParameter("userDate");
		Part p = request.getPart("filename");
		String message = "";
		if (p.getSize() > 10 * 1024 * 1024) {//限制大小10MB
			p.delete();
			message = "文件太大，不能上传！";
		} else {
			path = path + "\\source\\" + userId +"\\"+ fType;
			File f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
			}
			String fname = getFilename(p);
			System.out.println(fname);
			p.write(path + "\\" + fname);

			fileBean fb = new fileBean(fname,fType,userName,date,userId);//将参数存入fileBean传递
			request.setAttribute("fb", fb);
			request.getRequestDispatcher("/fileDownload.jsp");
			
			message = "文件上传成功！";
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("/fileDownload.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}