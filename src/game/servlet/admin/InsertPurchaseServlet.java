package game.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import game.dao.PurchaseDaoImpl;
import game.dao.UserDaoImpl;
import game.other.MD5;
import game.bean.Purchase;
import game.bean.User;

@WebServlet("/InsertPurchaseServlet.do")
public class InsertPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InsertPurchaseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		// 获取前端输入的数据
		String uid = request.getParameter("uid");
		String gid = request.getParameter("gid");

		// 生成订单时间
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String otime = formatter.format(date);

		try {
			PurchaseDaoImpl purchaseDaoImpl = new PurchaseDaoImpl();
			// insert数据入库：
			String onumber = null;
			onumber = purchaseDaoImpl.insertPurchase(gid, uid, otime);
			if (onumber == null) {// 未插入数据
				System.out.println("！servlet-insert:失败！");
				response.setStatus(400);
				out.print("！servlet-insert:失败！");
				return;
			}
			// 插入成功：
			response.setStatus(200);// 200
			return;
		} catch (

		Exception e) {
			System.out.println("！servlet-insert:报错。");
			out.print("！servlet-insert:报错。");
			response.setStatus(500);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}