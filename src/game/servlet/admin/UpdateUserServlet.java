package game.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateUserServlet.do")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		String sbir = request.getParameter("sbir");
		String sinstitude = request.getParameter("sinstitude");
		String spsw=request.getParameter("spsw");//不知道是否加密
		
		if(spsw.length()<=18) {//鉴别为未加密
			try {
				spsw=MD5.MD5Encoder(spsw);
			} catch (NoSuchAlgorithmException e) {
				System.out.println("！servlet：update加密报错。");
				e.printStackTrace();
			}
		}
		
		System.out.println("——>更新页传来的数据为：sno:"+sno+"，密码："+spsw+
				"，ssex："+ssex+"，sbir："+sbir+"，sinstitude："+sinstitude);

		
		Student stu = new Student(sno, sname, ssex, sbir, sinstitude,spsw);
		StudentDaoImp daoImp = new StudentDaoImp();
		try {
			if(daoImp.update(stu))
				out.print("<center><h3>更新成功。</h3></center>");
			else {
				out.print("<center><h3>更新失败。</h3></center>");
			}
			response.setHeader("Refresh","1;index.jsp");
		} catch (DaoException e) {
			System.out.println("Servlet:update时报错。");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
