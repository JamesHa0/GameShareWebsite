/**
 * 
 */
package crf.invest.entity;

import java.util.Date;

import crf.util.DateUtil;

/**
 * <p>Title: FeedBack</p>
 * <p>Description: 意见反馈</p>
 * <p>Company: </p> 
 * @author whb
 * @date 2016-4-20 上午9:45:08
 */
public class FeedBack implements java.io.Serializable{
	private static final long serialVersionUID = -2364733632452965427L;
	
	private Long id;
	private Long user_id; //用户id
	private String context; //反馈内容
	private Date create_date; //创建时间
	//非数据库字段
	private String user_name;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	} 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getCreate_dateStr() {
		return DateUtil.dateToStr(create_date, "yyyy-MM-dd HH:mm:ss");
	}
}
