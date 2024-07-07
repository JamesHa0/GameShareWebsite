package crf.system.taglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import crf.util.PageUtil;

public class PageTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String method; // action对应查询方法
	private String tarFrame; // 对应frame
	private String pageTurn; // 是否翻页

	public int doStartTag() throws JspTagException {
		return SKIP_BODY;
	}

	public int doEndTag() throws JspTagException {
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<div>");
			sb.append("<iframe name=\""+this.tarFrame+"\" id=\""+this.tarFrame+"\" frameborder=\"0\" scrolling=\"no\"   width=\"100%\" src=\"\" ></iframe>");
			sb.append("</div>");
			sb.append("<input name=\"method\" id=\"method\" type=\"hidden\" value=\""+this.method+"\">");
			sb.append("<input name=\"pageTurn\" id=\"pageTurn\" type=\"hidden\" value=\""+this.pageTurn+"\"> ");
			sb.append("<input name=\"selectlist\" id=\"selectlist\" type=\"hidden\"> ");
			//是否显示分页
			if(PageUtil.TURN_YES.equals(this.pageTurn)){
				sb.append("<div id=\"page_div\" class=\"pages\" >");
				sb.append("<span style=\"font-size: 13px;\">");
				sb.append("共<font id=\"totalCount_font\"></font>条记录，");
				sb.append("第<font id=\"currentPage_font\"></font>/<font id=\"totalPage_font\"></font>页");
				sb.append("</span>");
				sb.append("<a href=\"javascript:turn('first');\">首页</a>");
				sb.append("<a href=\"javascript:turn('-1');\">上一页</a>");
				sb.append("<a href=\"javascript:turn('+1');\">下一页</a>");
				sb.append("<a href=\"javascript:turn('end');\">尾页</a>");
				sb.append("<span>跳转至<input type=\"text\" name=\"jumpPage\" style=\"width: 30px;\">页 ");
				sb.append("<a href=\"javascript:turn('jump');\">跳转</a>");
				sb.append("</span>");
				sb.append("</div>");
			}
			sb.append("<input name=\"currentPage\" id=\"currentPage\" type=\"hidden\" value=\"\">");
			sb.append("<input name=\"totalPage\" id=\"totalPage\" type=\"hidden\" value=\"\">");
			sb.append("<input name=\"turn\" id=\"turn\" type=\"hidden\" value=\"\">");
			sb.append("<script type=\"text/javascript\">");
			sb.append("var url=document.getElementById(\"method\").value;");
			sb.append("document.forms[0].action = url;");
			sb.append("document.forms[0].target=\"frame1\";");
			sb.append("document.forms[0].submit();");
			sb.append("function turn(type){");
			sb.append("if(type==\"first\"){");
			sb.append("document.forms[0].currentPage.value=1;");
			sb.append("}else if(type==\"end\"){");
			sb.append("document.forms[0].currentPage.value=document.forms[0].totalPage.value;");
			sb.append("}else if(type==\"+1\"){");
			sb.append("var currentPage=eval(document.forms[0].currentPage.value)+1;");
			sb.append("if(eval(currentPage)>eval(document.forms[0].totalPage.value)){");
			sb.append("return ;");
			sb.append("currentPage=document.forms[0].totalPage.value;");
			sb.append("}");
			sb.append("document.forms[0].currentPage.value=currentPage;");
			sb.append("}else if(type==\"-1\"){");
			sb.append("var currentPage=eval(document.forms[0].currentPage.value)-1;");
			sb.append("if(eval(currentPage)<=0){return ; currentPage=1;}");
			sb.append("document.forms[0].currentPage.value=currentPage;");
			sb.append("}else if(type==\"jump\"){");
			sb.append("var jumpPage=document.forms[0].jumpPage.value;");
			sb.append("if(jumpPage!=\"\"){");
			sb.append("if(eval(jumpPage)>eval(document.forms[0].totalPage.value)){");
			sb.append("document.forms[0].currentPage.value=document.forms[0].totalPage.value;}");
			sb.append("if(eval(jumpPage)<=0){document.forms[0].currentPage.value=1;}");
			sb.append("if(!(eval(jumpPage)>eval(document.forms[0].totalPage.value) &&");
			sb.append("(!eval(jumpPage)<=0))){document.forms[0].currentPage.value=jumpPage;}");
			sb.append("document.forms[0].jumpPage.value=\"\";}}");
			sb.append("document.getElementById(\"turn\").value=\"turn\";");
			sb.append("var url=document.getElementById(\"method\").value;");
			sb.append("document.forms[0].action = url;");
			sb.append("document.forms[0].target=\""+this.tarFrame+"\";");
			sb.append("document.forms[0].submit();");
			sb.append("document.getElementById(\"turn\").value=\"\";}");
			sb.append("</script>");
			sb.append("<br>");
			if(PageUtil.TURN_NO.equals(this.pageTurn))
				sb.append("<br>");
			pageContext.getOut().write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return EVAL_PAGE;
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getTarFrame() {
		return tarFrame;
	}

	public void setTarFrame(String tarFrame) {
		this.tarFrame = tarFrame;
	}

	public String getPageTurn() {
		return pageTurn;
	}

	public void setPageTurn(String pageTurn) {
		this.pageTurn = pageTurn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
