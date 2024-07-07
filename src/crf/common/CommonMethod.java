package crf.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import crf.util.PageUtil;

public class CommonMethod {
	
	/**
	 * @2015-3-18 
	 */
	public static String getParameter(HttpServletRequest request,String param){
		String s=request.getParameter(param);
		if(s==null){
			s="";
		}else{
			s=s.trim();
		}
		return s;
	}
	
	/**
	 * ���÷�ҳ
	 *����  @2015-3-18 ����:
	 */
	public static void setPageInfo(HttpServletRequest request,String currentPage,
			Long totalCount,String pageTurn,Map<String,Object>map){
		if("".equals(currentPage) || currentPage==null || 
				!"turn".equals(CommonMethod.getParameter(request, "turn"))){
			currentPage="1";
		}
		PageUtil pageUtil = new PageUtil(currentPage,totalCount);
		long totalPage=pageUtil.getTotalPage();
		long index=pageUtil.getIndex();
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("totalCount", totalCount);
		//����ҳ
		if("NO".equals(pageTurn)){
			request.setAttribute("currentPage", 1);
			request.setAttribute("totalPage", 1);
		}
		map.put("pageTurn", pageTurn);
		//sql��ҳ����
		map.put("index", index);
		map.put("pageNum", PageUtil.pageNum);
	}
	
	/**
	 * ��ȡsession��ߵ���Ϣ
	 * @param request
	 * @param param
	 * @return
	 */
	public static Object getSessionInfo(HttpServletRequest request,String param) {
		Object reStr = request.getSession().getAttribute(param);
		return reStr;
	}
	
	/**
	 * ��ȡ��ǰϵͳʱ�䣬ת����YYYY-MM-dd HH:mm:ss �ĸ�ʽ���
	 * @return
	 */
	public static String getNowDate() {
		Date date = new Date();
		String formatStr = "YYYY-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}
}
