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
import crf.dao.BookDao;
import crf.dao.BookDaoImpl;
import crf.invest.entity.Book;
import crf.system.entity.UserBean;
import crf.util.PageUtil;
@WebServlet("/bookController.do")
public class BookServlet extends HttpServlet {
	BookDao dao = new BookDaoImpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if (method.equals("queryBookList")) {
			request.getRequestDispatcher("views/jsp/book/booklist.jsp").forward(request, response);
		}
		if (method.equals("queryBookListTable")) {
			Map<String, Object> map = new HashMap<String, Object>();
			String bookname = CommonMethod.getParameter(request, "bookname");
			map.put("bookname", bookname);
			try {
				long totalCount = dao.getBookListCount(bookname);
				System.out.println(totalCount);
				map.put("pageNum", PageUtil.pageNum);
				String currentPage = CommonMethod.getParameter(request, "currentPage");
				String pageTurn = CommonMethod.getParameter(request, "pageTurn");
				// 查询用户信息进行分页设置
				CommonMethod.setPageInfo(request, currentPage, totalCount, pageTurn, map);
				List<Book> list = dao.queryBookListTable(map);
				request.setAttribute("bookList", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("views/jsp/book/booklist_table.jsp").forward(request, response);
			
		}
		//跳转添加修改页
		if (method.equals("addOrUpdateBook")) {
			String flag = CommonMethod.getParameter(request, "flag");
			request.setAttribute("flag", flag);
			if (flag.equals("add")) {
				request.getRequestDispatcher("views/jsp/book/addOrUpdateBook.jsp").forward(request, response);
			} else {
				try {
					String id = request.getParameter("id");
					Book book=dao.queryBookById(id);
					request.setAttribute("book", book);
					request.getRequestDispatcher("views/jsp/book/addOrUpdateBook.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		//保存添加或修改
		if (method.equals("saveBook")) {
			String flag = CommonMethod.getParameter(request, "flag");
			String bookname = CommonMethod.getParameter(request, "bookname");
			String price = CommonMethod.getParameter(request, "price");
			String author = CommonMethod.getParameter(request, "author");
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("bookname", bookname);
			map.put("price", price);
			map.put("author", author);
			if (flag.equals("add")) {
				
				try {
					int tiao=dao.insertBook(map);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("views/jsp/book/booklist.jsp").forward(request, response);
			} else {
				String id = CommonMethod.getParameter(request, "id");
				map.put("id", id);
				try {
					int tiao=dao.updateBookById(map);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("views/jsp/book/booklist.jsp").forward(request, response);
			}
		}
		
		//删除
		if (method.equals("deleteBook")) {
			String id = CommonMethod.getParameter(request, "id");
			try {
				int tiao=dao.deleteBookById(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("views/jsp/book/booklist.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
