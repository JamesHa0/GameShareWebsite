package crf.invest.entity;

import java.util.Date;

import crf.util.DateUtil;

/**
 * <p>Title:赎回实体�?</p>
 * <p>Description: </p>
 * <p>Company: 上海信�?富金融信息服务有限公�?/p>
 * @author zhiwang 
 * @date 2015-5-29
 */
public class Fetch implements java.io.Serializable {

	private static final long serialVersionUID = -2364733632452965427L;
	
	private Long fetchId;
	private long fetchFFundId;
	private long fetchFUserId;
	private long fetchFUbcId;
	private String fetchSeq;
	private Date fetchCreateTime;
	private String fetchIncome;
	private String fetchMoney;
	private String fetchChannel;
	private String fetchState;
	private String fetchIsWithdraw;
	
	//�����ݿ��ֶ�
	private String fetchName;//����
	
	public String getFetchName() {
		return fetchName;
	}
	public void setFetchName(String fetchName) {
		this.fetchName = fetchName;
	}
	public Long getFetchId() {
		return fetchId;
	}
	public void setFetchId(Long fetchId) {
		this.fetchId = fetchId;
	}
	public long getFetchFFundId() {
		return fetchFFundId;
	}
	public void setFetchFFundId(long fetchFFundId) {
		this.fetchFFundId = fetchFFundId;
	}
	public long getFetchFUserId() {
		return fetchFUserId;
	}
	public void setFetchFUserId(long fetchFUserId) {
		this.fetchFUserId = fetchFUserId;
	}
	public long getFetchFUbcId() {
		return fetchFUbcId;
	}
	public void setFetchFUbcId(long fetchFUbcId) {
		this.fetchFUbcId = fetchFUbcId;
	}
	public String getFetchSeq() {
		return fetchSeq;
	}
	public void setFetchSeq(String fetchSeq) {
		this.fetchSeq = fetchSeq;
	}
	public Date getFetchCreateTime() {
		return fetchCreateTime;
	}
	public void setFetchCreateTime(Date fetchCreateTime) {
		this.fetchCreateTime = fetchCreateTime;
	}
	public String getFetchIncome() {
		return fetchIncome;
	}
	public void setFetchIncome(String fetchIncome) {
		this.fetchIncome = fetchIncome;
	}
	public String getFetchMoney() {
		return fetchMoney;
	}
	public void setFetchMoney(String fetchMoney) {
		this.fetchMoney = fetchMoney;
	}
	public String getFetchChannel() {
		return fetchChannel;
	}
	public void setFetchChannel(String fetchChannel) {
		this.fetchChannel = fetchChannel;
	}
	public String getFetchState() {
		return fetchState;
	}
	public void setFetchState(String fetchState) {
		this.fetchState = fetchState;
	}
	public String getFetchIsWithdraw() {
		return fetchIsWithdraw;
	}
	public void setFetchIsWithdraw(String fetchIsWithdraw) {
		this.fetchIsWithdraw = fetchIsWithdraw;
	}
	public String getFetchCreateTimeStr(){
		return DateUtil.dateToStr(fetchCreateTime,"yyyy-MM-dd HH:mm:ss");
	}
}