package game.servlet.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.bean.User;
import game.dao.PurchaseDaoImpl;
import game.dao.UserDaoImpl;

@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gid = request.getParameter("gid");
		String uid = request.getParameter("uid");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String otime = formatter.format(date);
		PurchaseDaoImpl PurchaseImpl = new PurchaseDaoImpl();
		String onumber = null;
		try {
			onumber = PurchaseImpl.insertPurchase(gid,uid,otime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserDaoImpl userDaoImpl = new UserDaoImpl();

		if (onumber==null) {
			request.setAttribute("msg", " failed purchase");
			request.getRequestDispatcher("afterPurchase.jsp").forward(request, response);
		}else {
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
