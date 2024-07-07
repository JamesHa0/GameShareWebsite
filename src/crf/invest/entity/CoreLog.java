package crf.invest.entity;

import java.util.Date;

import crf.util.DateUtil;

/**
 * 核心系统接口日志记录表实体
 * @author Administrator
 *
 */
public class CoreLog {
	
	private Long coreId;
	private Long coreUserId;
	private String coreType;
	private String coreTypeDesc;
	private String coreReqMess;
	private Date coreReqTime;
	private String coreResMess;
	private Date coreResTime;
	
	//非数据库字段
	private String userPhoneNo;
	
	public CoreLog(){}
	public CoreLog(long coreId){
		this.coreId = coreId;
	}
	
	public Long getCoreId() {
		return coreId;
	}
	public void setCoreId(Long coreId) {
		this.coreId = coreId;
	}
	public Long getCoreUserId() {
		return coreUserId;
	}
	public void setCoreUserId(Long coreUserId) {
		this.coreUserId = coreUserId;
	}
	public String getCoreType() {
		return coreType;
	}
	public void setCoreType(String coreType) {
		this.coreType = coreType;
	}
	public String getCoreTypeDesc() {
		return coreTypeDesc;
	}
	public void setCoreTypeDesc(String coreTypeDesc) {
		this.coreTypeDesc = coreTypeDesc;
	}
	public String getCoreReqMess() {
		return coreReqMess;
	}
	public void setCoreReqMess(String coreReqMess) {
		this.coreReqMess = coreReqMess;
	}
	public Date getCoreReqTime() {
		return coreReqTime;
	}
	public void setCoreReqTime(Date coreReqTime) {
		this.coreReqTime = coreReqTime;
	}
	public String getCoreResMess() {
		return coreResMess;
	}
	public void setCoreResMess(String coreResMess) {
		this.coreResMess = coreResMess;
	}
	public Date getCoreResTime() {
		return coreResTime;
	}
	public void setCoreResTime(Date coreResTime) {
		this.coreResTime = coreResTime;
	}
	public String getUserPhoneNo() {
		return userPhoneNo;
	}
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	public String getCoreReqTimeStr(){
		return DateUtil.dateToStr(coreReqTime, "yyyy-MM-dd HH:mm:ss");
	}
	public String getCoreResTimeStr(){
		return DateUtil.dateToStr(coreResTime, "yyyy-MM-dd HH:mm:ss");
	}
}
