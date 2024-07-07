/**
 * 
 */
package crf.invest.entity;

import java.util.Date;

import crf.util.DateUtil;

/**
 * <p>Title: Znmessage</p>
 * <p>Description: 站内信息</p>
 * <p>Company: </p> 
 * @author whb
 * @date 2016-4-12 上午11:32:08
 */
public class Znmessage {
	private Long mes_id; 
	private Long mes_user_id; //消息用户ID
	private String mes_content; //消息内容
	private Date mes_date;      //消息插入时间
	private String mes_status; //消息状态	0为未读1为已读 默认为0
	
	
	private String mes_user_name;


	public Long getMes_user_id() {
		return mes_user_id;
	}


	public void setMes_user_id(Long mes_user_id) {
		this.mes_user_id = mes_user_id;
	}


	public String getMes_content() {
		return mes_content;
	}


	public void setMes_content(String mes_content) {
		this.mes_content = mes_content;
	}


	public Date getMes_date() {
		return mes_date;
	}


	public void setMes_date(Date mes_date) {
		this.mes_date = mes_date;
	}


	public String getMes_status() {
		return mes_status;
	}


	public void setMes_status(String mes_status) {
		this.mes_status = mes_status;
	}


	public String getMes_user_name() {
		return mes_user_name;
	}


	public void setMes_user_name(String mes_user_name) {
		this.mes_user_name = mes_user_name;
	}
	
	
	public String getMessageTime() {
		return DateUtil.dateToStr(mes_date, "yyyy-MM-dd HH:mm:ss");
	}
	
}
