package crf.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crf.dao.LoginDao;
import crf.dao.LoginDaoImpl;
import crf.system.entity.Operation;
import crf.system.entity.UserBean;
import crf.system.entity.menu.Item;
import crf.system.entity.menu.Menu;
import crf.system.entity.menu.ParentMenu;
import net.sf.json.JSONArray;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	LoginDao dao = new LoginDaoImpl();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"--"+password);
		try {
			UserBean user = dao.queryUserByUsernameAndPassword(username, password);
			if (user==null) {
				System.out.println("用户名或密码错误");
				response.sendRedirect("login.jsp");
			} else {
				System.out.println("登录成功");
				request.getSession().setAttribute("name", user.getRealname());
				request.getSession().setAttribute("username", user.getUsername());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JSONArray json = new JSONArray();
		List<Operation> operaList;
		try {
			//根据用户名查询菜单
			operaList=dao.queryUserMenu(username);
			if (operaList.size()!=0) {
				//将所有菜单的父节点存入list
				List<String> parentIds= new ArrayList<String>();
				for(Operation operation:operaList){
					parentIds.add(operation.getParent_id());
				}
				//通过父节点list查询所有父节点list信息
				List<Operation> parentList = dao.queryUserParnetMenu(parentIds);
				ParentMenu pm = new ParentMenu();
				pm.setId("");
				List<Menu> menu = new ArrayList<Menu>();
				List<Item> itemList = null;
				Menu m=null;
				Item item=null;
				//父菜单加入menu集合
				for(Operation ow:parentList){
					itemList = new ArrayList<Item>();
					m=new Menu();
					m.setText(ow.getOperation_name());
					for(Operation on:operaList){
						if (ow.getOperation_no().equals(on.getParent_id())) {
							item = new Item();
							item.setId(on.getOperation_no());
							item.setText(on.getOperation_name());
							item.setHref(on.getOperation_url());
							itemList.add(item);
						}
					}
					m.setItems(itemList);
					menu.add(m);
				}
				pm.setMenu(menu);
				json.add(pm);
				request.getSession().setAttribute("json", json);
				response.sendRedirect("index.jsp");
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

}
