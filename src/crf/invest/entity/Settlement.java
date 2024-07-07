package crf.invest.entity;

import java.util.Date;

import crf.util.DateUtil;

/**
 * <p>Title: 交易流水记录实体类</p>
 * <p>Description: </p>
 * <p>Company: 上海信而富金融信息服务有限公司</p>
 * @author zhiwang 
 * @date 2015-6-1
 */
public class Settlement implements java.io.Serializable {

	private static final long serialVersionUID = -1392312051274422282L;
	
	private Long seId;
	private long seFUserId;
	private String seSeq;
	private String seType;
	private String seReqMess;
	private Date seReqTime;
	private String seResMess;
	private Date seResTime;
	private String seResult;
	
	public Settlement(){}
	
	public Settlement(long setFUserId,String setSeq, String setType,
			String setReqMess, Date setReqTime, String setResMess,
			Date setResTime, String setResult) {
		this.seFUserId = setFUserId;
		this.seSeq = setSeq;
		this.seType = setType;
		this.seReqMess = setReqMess;
		this.seReqTime = setReqTime;
		this.seResMess = setResMess;
		this.seResTime = setResTime;
		this.seResult = setResult;
	}

	public Long getSeId() {
		return seId;
	}

	public void setSeId(Long seId) {
		this.seId = seId;
	}

	public long getSeFUserId() {
		return seFUserId;
	}

	public void setSeFUserId(long seFUserId) {
		this.seFUserId = seFUserId;
	}

	public String getSeType() {
		return seType;
	}

	public void setSeType(String seType) {
		this.seType = seType;
	}

	public String getSeReqMess() {
		return seReqMess;
	}

	public void setSeReqMess(String seReqMess) {
		this.seReqMess = seReqMess;
	}

	public Date getSeReqTime() {
		return seReqTime;
	}

	public void setSeReqTime(Date seReqTime) {
		this.seReqTime = seReqTime;
	}

	public String getSeResMess() {
		return seResMess;
	}

	public void setSeResMess(String seResMess) {
		this.seResMess = seResMess;
	}

	public Date getSeResTime() {
		return seResTime;
	}

	public void setSeResTime(Date seResTime) {
		this.seResTime = seResTime;
	}

	public String getSeResult() {
		return seResult;
	}

	public void setSeResult(String seResult) {
		this.seResult = seResult;
	}

	public String getSeSeq() {
		return seSeq;
	}

	public void setSeSeq(String seSeq) {
		this.seSeq = seSeq;
	}
	public String getSeReqTimeStr(){
		return DateUtil.dateToStr(seReqTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getSeResTimeStr(){
		return DateUtil.dateToStr(seResTime, "yyyy-MM-dd HH:mm:ss");
	}
}