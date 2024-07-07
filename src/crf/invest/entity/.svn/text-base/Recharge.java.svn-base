package crf.invest.entity;

import java.util.Date;

import crf.util.DateUtil;

/**
 * <p>Title: 充值实体类</p>
 * <p>Description: </p>
 * <p>Company: 上海信而富金融信息服务有限公司</p>
 * @author zhiwang 
 * @date 2015-5-29
 */
public class Recharge implements java.io.Serializable {

	private static final long serialVersionUID = 5615344267029910392L;
	
	private Long rechargeId;                 //主键ID
	private long rechargeFUserId;            //用户表ID
	private String rechargeChannel;          //交易渠道  1 富友 2 银联 3 通联 4 财付通
	private String rechargeSeq;              //流水号
	private String rechargeMoney;            //充值金额
	private Date rechargeCreateTime;         //创建时间
	private String rechargeState;            //充值状态  0 失败  1 成功  
	private String rechargeRemark;           //备注
	private String rechargeFuiouLoginId;     //富友登录用户名
	private String rechargeRespCode;		 //富友结果返回结果码
	private String rechargeRespDesc;		 //富友结果返回结果描述
	private Date rechargeRespTime;		 	 //富友结果返回时间
	private String isUploadSuccess;		 	 //上传核心系统 0默认 1成功 2失败
	private Date rechargeUploadTime;		 //上传核心系统时间
	
	//非数据库字段
	private String rechargeName;//出资人姓名
	
	public Recharge(){}
	
	public Recharge(Long rechargeId){
		this.rechargeId = rechargeId;
	}
	public Recharge(String rechargeSeq){
		this.rechargeSeq = rechargeSeq;
	}
	
	public Recharge( long rechargeFUserId,String rechargeSeq, String rechargeMoney,
			String rechargeRemark, String rechargeFuiouLoginId){
		this.rechargeFUserId = rechargeFUserId;
		this.rechargeChannel = "1";
		this.rechargeSeq = rechargeSeq;
		this.rechargeMoney = rechargeMoney;
		this.rechargeState = "0";
		this.rechargeRemark = rechargeRemark;
		this.rechargeFuiouLoginId = rechargeFuiouLoginId;
		this.isUploadSuccess="0";
	}

	public Long getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(Long rechargeId) {
		this.rechargeId = rechargeId;
	}
	public long getRechargeFUserId() {
		return rechargeFUserId;
	}
	public void setRechargeFUserId(long rechargeFUserId) {
		this.rechargeFUserId = rechargeFUserId;
	}
	public String getRechargeChannel() {
		return rechargeChannel;
	}
	public String getRechargeSeq() {
		return rechargeSeq;
	}
	public void setRechargeSeq(String rechargeSeq) {
		this.rechargeSeq = rechargeSeq;
	}
	public void setRechargeChannel(String rechargeChannel) {
		this.rechargeChannel = rechargeChannel;
	}
	public String getRechargeMoney() {
		return rechargeMoney;
	}
	public void setRechargeMoney(String rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}
	public Date getRechargeCreateTime() {
		return rechargeCreateTime;
	}
	public void setRechargeCreateTime(Date rechargeCreateTime) {
		this.rechargeCreateTime = rechargeCreateTime;
	}
	public String getRechargeState() {
		return rechargeState;
	}
	public void setRechargeState(String rechargeState) {
		this.rechargeState = rechargeState;
	}
	public String getRechargeRemark() {
		return rechargeRemark;
	}
	public void setRechargeRemark(String rechargeRemark) {
		this.rechargeRemark = rechargeRemark;
	}
	public String getRechargeFuiouLoginId() {
		return rechargeFuiouLoginId;
	}
	public void setRechargeFuiouLoginId(String rechargeFuiouLoginId) {
		this.rechargeFuiouLoginId = rechargeFuiouLoginId;
	}

	public String getRechargeRespCode() {
		return rechargeRespCode;
	}

	public void setRechargeRespCode(String rechargeRespCode) {
		this.rechargeRespCode = rechargeRespCode;
	}

	public Date getRechargeRespTime() {
		return rechargeRespTime;
	}

	public void setRechargeRespTime(Date rechargeRespTime) {
		this.rechargeRespTime = rechargeRespTime;
	}

	public String getIsUploadSuccess() {
		return isUploadSuccess;
	}

	public void setIsUploadSuccess(String isUploadSuccess) {
		this.isUploadSuccess = isUploadSuccess;
	}

	public Date getRechargeUploadTime() {
		return rechargeUploadTime;
	}

	public void setRechargeUploadTime(Date rechargeUploadTime) {
		this.rechargeUploadTime = rechargeUploadTime;
	}
	
	public String getRechargeRespDesc() {
		return rechargeRespDesc;
	}

	public void setRechargeRespDesc(String rechargeRespDesc) {
		this.rechargeRespDesc = rechargeRespDesc;
	}

	public String getRecDateStr(){
		return DateUtil.dateToStr(rechargeCreateTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getRechargeRespTimeStr(){
		return DateUtil.dateToStr(rechargeRespTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getRechargeUploadTimeStr(){
		return DateUtil.dateToStr(rechargeUploadTime, "yyyy-MM-dd HH:mm:ss");
	}

	public String getRechargeName() {
		return rechargeName;
	}

	public void setRechargeName(String rechargeName) {
		this.rechargeName = rechargeName;
	}
}