package crf.invest.entity;

import java.io.Serializable;
/*
 * 對Excel操作
 */
public class Excel implements Serializable {
	
	private String date;
	private String time;
	private String userId;//实际是加密后的用户手机号
	private String phoneNo;
	private String openAccount;//是否开户；1表示开户，0 表示未开户
	private String totalMoney;//入金金额
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getOpenAccount() {
		return "1".equals(openAccount)?"已开户":"未开户";
	}
	public void setOpenAccount(String openAccount) {
		this.openAccount = openAccount;
	}
	public String getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}
	@Override
	public String toString() {
		return "Excel [date=" + date + ", time=" + time + ", userId=" + userId
				+ ", phoneNo=" + phoneNo + ", openAccount=" + openAccount
				+ ", totalMoney=" + totalMoney + "]";
	}
	
}
