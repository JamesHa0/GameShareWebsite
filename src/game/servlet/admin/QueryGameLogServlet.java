package game.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import game.bean.Game;
import game.bean.Purchase;
import game.dao.GameDaoImpl;
import game.dao.PurchaseDaoImpl;

@WebServlet("/QueryGameLogServlet.do")
public class QueryGameLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryGameLogServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取path
		HttpSession session=request.getSession();
		String path_param=request.getParameter("path");
		String path=(String) session.getAttribute("path");//session中
			if(path_param!=null) path=path_param;
		System.out.println("---前端传递path（game单查）="+path);
		
		//前端传来的数据
		String gid=request.getParameter("gid");
		String uid=request.getParameter("uid");
System.out.println("---前端传来的数据是（game单查）："
		+ "\n	 gid="+gid
		+ "\n 	 uid="+uid);
		
		try {
			PurchaseDaoImpl purchaseDaoImpl = new PurchaseDaoImpl();
			List<Purchase> list = new ArrayList<>();
			if(gid!=null && !"".equals(gid)) {
				list = purchaseDaoImpl.queryPurchaseByGid(gid);
			}else if(uid !=null && !"".equals(uid)) {
				list = purchaseDaoImpl.queryPurchaseByUid(uid);
			}else {
				//全都是空的！
				response.sendRedirect("jsp_admin/"+path+"?query=queryAll");//*********1
			}
			
			if(list==null) {
				System.out.println("[null] Servlet-list单查：list=空。数据库里没有购买记录。");
				response.sendRedirect("jsp_admin/"+path+"?query=none");//************2
			}else {
				System.out.println("√ Servlet-list单查:成功获取购买记录。");

				session.setAttribute("allGameLogs", list);
			    response.sendRedirect("jsp_admin/"+path+"?query=get_it");//***********3
			
			}
		} catch (Exception e) {
			System.out.println("!500 Servlet-list单查。");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
