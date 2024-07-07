package crf.invest.entity;

import java.util.Date;

import crf.util.DateUtil;

/**
 * 消息通知 fm_notice
 * @author Administrator
 *
 */
public class Notice {
	
	private Long noticeId;
	private String noticeContent;
	private Date noticeCreateTime;
	private String noticeCreateUsername;
	private String noticeStatus; //0删除  1未删
	private String noticeFlag;  //1不弹窗  2弹窗
	//private String noticeSendTo;  //发送到哪个平台
	
//	public String getNoticeSendTo() {
//		return noticeSendTo;
//	}
//	public void setNoticeSendTo(String noticeSendTo) {
//		this.noticeSendTo = noticeSendTo;
//	}
	//非数据库字段
	private String createname;
	
	public Long getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeCreateTime() {
		return noticeCreateTime;
	}
	public void setNoticeCreateTime(Date noticeCreateTime) {
		this.noticeCreateTime = noticeCreateTime;
	}
	public String getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}
	public String getNoticeFlag() {
		return noticeFlag;
	}
	public void setNoticeFlag(String noticeFlag) {
		this.noticeFlag = noticeFlag;
	}
	public String getNoticeCreateTimeStr() {
		return DateUtil.dateToStr(this.noticeCreateTime, "yyyy-MM-dd HH:mm:ss");
	}
	public String getCreatename() {
		return createname;
	}
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	public String getNoticeContentInx(){
		String text = "";
		if(this.noticeContent==null)
			return text;
		if(this.noticeContent.length()>15)
			text = (this.noticeContent.replace("\n", "")).substring(0, 15)+"....";
		else
			text =this.noticeContent.replace("\n", "");
		return text;
	}
	public String getNoticeCreateUsername() {
		return noticeCreateUsername;
	}
	public void setNoticeCreateUsername(String noticeCreateUsername) {
		this.noticeCreateUsername = noticeCreateUsername;
	}
	
}

