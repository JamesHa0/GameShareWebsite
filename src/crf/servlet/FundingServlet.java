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
import crf.dao.FundingDao;
import crf.dao.FundingDaoImpl;
import crf.invest.entity.Funding;
import crf.util.NumberUtil;
import crf.util.PageUtil;
@WebServlet("/fundingController.do")
public class FundingServlet extends HttpServlet{

	FundingDao dao = new FundingDaoImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FundingServlet");
		String method = request.getParameter("method");
		if (method.equals("queryObList")) {
			request.getRequestDispatcher("views/jsp/Funding/ob_list.jsp").forward(request, response);;
		}
		if (method.equals("queryObListTable")) {
			String fundPhoneNo = CommonMethod.getParameter(request, "fundPhoneNo");
			String startTime = CommonMethod.getParameter(request, "startTime");
			String endTime = CommonMethod.getParameter(request, "endTime");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("fundPhoneNo", fundPhoneNo);
			if (!"".equals(startTime)) {
				startTime=startTime+" 00:00:00";
			}else {
				startTime = "1900-00-00 00:00:00";
			}
			if (!"".equals(endTime)) {
				endTime=endTime+" 23:59:59";
			}else {
				endTime = CommonMethod.getNowDate();
			}
			map.put("startTime", startTime);
			map.put("endTime", endTime);
			map.put("pageNum", PageUtil.pageNum);
			
			String currentPage = CommonMethod.getParameter(request, "currentPage");
			String pageTurn = CommonMethod.getParameter(request, "pageTurn");
			try {
				long totalCount=dao.getObListCount(map);
				CommonMethod.setPageInfo(request, currentPage, totalCount, pageTurn, map);
				List<Funding> list=dao.queryObListTable(map);
				request.setAttribute("list",list);
				Double sum=dao.getObSumMoney(map);
				if (sum!=null) {
					request.setAttribute("sumMoney", NumberUtil.doubleFormat(sum));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("views/jsp/Funding/ob_list_table.jsp").forward(request, response);
		}
		
		
		
		
	}
}
