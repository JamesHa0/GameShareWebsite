package crf.system.taglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class ActorBtnTag extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String value;
	
	public int doStartTag() throws JspTagException {
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspTagException {
		StringBuffer sb = new StringBuffer();
		try {
			if(value != null && !"".equals(value)){
				String [] array = value.split(",");
				sb.append("<script type=\"text/javascript\">\n");
				sb.append("var btn_id;\n");
				for(String id : array){
					sb.append("btn_id = document.getElementById('"+id+"');\n");
					sb.append("if(btn_id != null)\n");
					sb.append("btn_id.style.display='';\n");
				}
				sb.append("</script>");
			}
			pageContext.getOut().write(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return EVAL_PAGE;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
