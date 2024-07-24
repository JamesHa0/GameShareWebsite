package game.servlet.user;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadGameServlet.do")
public class DownloadGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//前端数据
		String gid = request.getParameter("gid");
		
		//下载业务：
		String filename = gid+".zip";
		System.out.println("filename="+filename);
		ServletContext servletcontext = this.getServletContext();
		String realpath = servletcontext.getRealPath("/game/"+filename);
		File file = new File(realpath);
		
		if (file.exists()) {
			String minetype = servletcontext.getMimeType(filename);
			response.setHeader("Content-type", minetype!=null ? minetype : "application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename,"UTF-8"));
			
			try (FileInputStream fis = new FileInputStream(realpath);
	             BufferedInputStream bis = new BufferedInputStream(fis);
	             OutputStream os = response.getOutputStream()) {
	            byte[] buffer = new byte[4096];
	            int i;
	            while ((i = bis.read(buffer)) != -1) {
	                os.write(buffer, 0, i);
	            }
	        } catch (IOException e) {
	            //response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error occurred while processing the download request.");
	        }
		} else {
	        //response.sendError(HttpServletResponse.SC_NOT_FOUND, "File does not exist.");
	    }
		//response.setContentType("text/html;charset=UTF-8");
		//response.sendRedirect("DetailServlet.do?gid="+gid);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
