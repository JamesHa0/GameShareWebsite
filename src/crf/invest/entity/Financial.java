/**
 * 
 */
package crf.invest.entity;

import java.util.Date;

import crf.util.DateUtil;

/**
 * <p>Title: Financial</p>
 * <p>Description: 理财师</p>
 * <p>Company: </p> 
 * @author whb
 * @date 2016-4-14 上午10:25:49
 */
public class Financial {
	private Long financial_id;
	private String financial_phone; //手机号
	private String financial_name;  //姓名
	private String financial_code;  //工号
	private String financial_state; //状态 1禁用 0正常
	private Date financial_create_time;  //创建时间
	private Long financial_create_id;  //创建者id
	private String financial_location;  //所属地区
	
	//非数据库字段
	private String financial_create_name;  //创建者姓名
	
	public String getFinancial_create_name() {
		return financial_create_name;
	}
	public void setFinancial_create_name(String financial_create_name) {
		this.financial_create_name = financial_create_name;
	}
	
	public String getFinancial_location() {
		return financial_location;
	}
	public void setFinancial_location(String financial_location) {
		this.financial_location = financial_location;
	}
	public Long getFinancial_id() {
		return financial_id;
	}
	public void setFinancial_id(Long financial_id) {
		this.financial_id = financial_id;
	}
	public String getFinancial_phone() {
		return financial_phone;
	}
	public void setFinancial_phone(String financial_phone) {
		this.financial_phone = financial_phone;
	}
	public String getFinancial_name() {
		return financial_name;
	}
	public void setFinancial_name(String financial_name) {
		this.financial_name = financial_name;
	}
	public String getFinancial_code() {
		return financial_code;
	}
	public void setFinancial_code(String financial_code) {
		this.financial_code = financial_code;
	}
	public String getFinancial_state() {
		return financial_state;
	}
	public void setFinancial_state(String financial_state) {
		this.financial_state = financial_state;
	}
	public Date getFinancial_create_time() {
		return financial_create_time;
	}
	public void setFinancial_create_time(Date financial_create_time) {
		this.financial_create_time = financial_create_time;
	}
	public Long getFinancial_create_id() {
		return financial_create_id;
	}
	public void setFinancial_create_id(Long financial_create_id) {
		this.financial_create_id = financial_create_id;
	}
	public String getFinancial_create_timeStr(){
		return DateUtil.dateToStr(financial_create_time,"yyyy-MM-dd HH:mm:ss");
	}
}
