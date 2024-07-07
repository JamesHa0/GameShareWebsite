package crf.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crf.common.CommonMethod;
import crf.dao.UserDao;
import crf.dao.UserDaoImpl;
import crf.invest.entity.Funding;
import crf.system.entity.UserBean;
import crf.util.PageUtil;

@WebServlet("/userController.do")
public class UserServlet extends HttpServlet {
	UserDao dao = new UserDaoImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 设置中文
		String method = request.getParameter("method");

		if (method.equals("getUserList")) {
			request.getRequestDispatcher("views/jsp/User/userlist.jsp").forward(request, response);
		}
		if (method.equals("queryUserListTable")) {
			Map<String, Object> map = new HashMap<String, Object>();
			String username = CommonMethod.getParameter(request, "username");
			map.put("username", username);

			try {
				long totalCount = dao.getUserListCount(map);
				map.put("pageNum", PageUtil.pageNum);
				String currentPage = CommonMethod.getParameter(request, "currentPage");
				String pageTurn = CommonMethod.getParameter(request, "pageTurn");
				// 查询用户信息进行分页设置
				CommonMethod.setPageInfo(request, currentPage, totalCount, pageTurn, map);
				List<UserBean> list = dao.queryUserListTable(map);
				request.setAttribute("userList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("views/jsp/User/userlist_table.jsp").forward(request, response);
		}

		// 跳转添加页
		if (method.equals("addOrUpdateUser")) {
			String flag = request.getParameter("flag");
			request.setAttribute("flag", flag);
			if (flag.equals("add")) {
				// 进入添加页
				request.getRequestDispatcher("views/jsp/User/addOrUpdateUser.jsp").forward(request, response);
			} else {
				// 进入修改页
				String username = request.getParameter("username");
				UserBean user;
				try {
					user = dao.queryUserByUsername(username);
					request.setAttribute("user", user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				request.getRequestDispatcher("views/jsp/User/addOrUpdateUser.jsp").forward(request, response);
			}
		}
		// 保存
		if (method.equals("saveUser")) {
			String flag = request.getParameter("flag");
			Map<String, Object> map = new HashMap<String, Object>();
			String username = CommonMethod.getParameter(request, "username");
			String password = CommonMethod.getParameter(request, "password");
			String mobile = CommonMethod.getParameter(request, "mobile");
			String email = CommonMethod.getParameter(request, "email");
			String realname = CommonMethod.getParameter(request, "realname");
			map.put("is_enable", "1");
			map.put("username", username);
			map.put("password", password);
			map.put("mobile", mobile);
			map.put("email", email);
			map.put("realname", realname);
			String createid = (String) request.getSession().getAttribute("username");
			System.out.println("createid" + createid);
			map.put("createid", createid);
			map.put("createtime", CommonMethod.getNowDate());
			if (flag.equals("add")) {
				try {
					int tiao = dao.insertUser(map);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					int tiao = dao.update(map);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			request.getRequestDispatcher("views/jsp/User/userlist.jsp").forward(request, response);

		}
		// 删除
		if (method.equals("deleteUser")) {
			String username = CommonMethod.getParameter(request, "username");
			try {
				int tiao=dao.deleteUser(username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("views/jsp/User/userlist.jsp").forward(request, response);
		}

	}

}
