package crf.invest.entity;

import java.util.Date;

import crf.util.DateUtil;


/**
 * <p>Title: 提现实体类</p>
 * <p>Description: </p>
 * <p>Company: 上海信而富金融信息服务有限公司</p>
 * @author zhiwang 
 * @date 2015-6-2
 */
public class Withdraw implements java.io.Serializable {

	private static final long serialVersionUID = 510229694020189425L;
	
	private Long withdrawId;               //主键ID
	private long withdrawFUserId;          //用户表ID
	private long withdrawFUbcId;           //用户银行卡表ID
	private String withdrawSeq;            //流水号
	private Date withdrawCreateTime;       //创建时间
	private String withdrawChannel;        //交易渠道 1 富友 2 银联 3 通联 4 财付通
	private String withdrawMoney;          //提现金额
	private String withdrawState;          //状态    0失败 1成功
	private String withdrawRemark;         //备注
	
	
	private String withdrawFuiouLoginId;     //富友登录用户名
	private String withdrawRespCode;		 //富友结果返回结果码
	private String withdrawRespDesc;		 //富友结果返回结果描述
	private Date withdrawRespTime;		 	 //富友结果返回时间
	private String isUploadSuccess;		 	 //上传核心系统 0默认 1成功
	private Date withdrawUploadTime;		 //上传核心系统时间
	
	//非数据库字段
	private String withdrawName;//姓名
	
	public Withdraw(){}
	
	public Withdraw(Long withdrawId){
		this.withdrawId = withdrawId;
	}
	
	public Withdraw(String withdrawSeq){
		this.withdrawSeq = withdrawSeq;
	}
	
	public Withdraw( long rechargeFUserId,String rechargeSeq, String rechargeMoney,
			String rechargeRemark, String rechargeFuiouLoginId){
		this.withdrawFUserId = rechargeFUserId;
		this.withdrawChannel = "1";
		this.withdrawSeq = rechargeSeq;
		this.withdrawMoney = rechargeMoney;
		this.withdrawState = "0";
		this.withdrawRemark = rechargeRemark;
		this.withdrawFuiouLoginId = rechargeFuiouLoginId;
		this.isUploadSuccess="0";
	}
	
	public Long getWithdrawId() {
		return withdrawId;
	}
	public void setWithdrawId(Long withdrawId) {
		this.withdrawId = withdrawId;
	}
	public long getWithdrawFUserId() {
		return withdrawFUserId;
	}
	public void setWithdrawFUserId(long withdrawFUserId) {
		this.withdrawFUserId = withdrawFUserId;
	}
	public long getWithdrawFUbcId() {
		return withdrawFUbcId;
	}
	public void setWithdrawFUbcId(long withdrawFUbcId) {
		this.withdrawFUbcId = withdrawFUbcId;
	}
	public String getWithdrawSeq() {
		return withdrawSeq;
	}
	public void setWithdrawSeq(String withdrawSeq) {
		this.withdrawSeq = withdrawSeq;
	}
	public Date getWithdrawCreateTime() {
		return withdrawCreateTime;
	}
	public void setWithdrawCreateTime(Date withdrawCreateTime) {
		this.withdrawCreateTime = withdrawCreateTime;
	}
	public String getWithdrawChannel() {
		return withdrawChannel;
	}
	public void setWithdrawChannel(String withdrawChannel) {
		this.withdrawChannel = withdrawChannel;
	}
	public String getWithdrawMoney() {
		return withdrawMoney;
	}
	public void setWithdrawMoney(String withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}
	public String getWithdrawState() {
		return withdrawState;
	}
	public void setWithdrawState(String withdrawState) {
		this.withdrawState = withdrawState;
	}
	public String getWithdrawRemark() {
		return withdrawRemark;
	}
	public void setWithdrawRemark(String withdrawRemark) {
		this.withdrawRemark = withdrawRemark;
	}
	public String getWithdrawFuiouLoginId() {
		return withdrawFuiouLoginId;
	}
	public void setWithdrawFuiouLoginId(String withdrawFuiouLoginId) {
		this.withdrawFuiouLoginId = withdrawFuiouLoginId;
	}
	public String getWithdrawRespCode() {
		return withdrawRespCode;
	}
	public void setWithdrawRespCode(String withdrawRespCode) {
		this.withdrawRespCode = withdrawRespCode;
	}
	public Date getWithdrawRespTime() {
		return withdrawRespTime;
	}
	public void setWithdrawRespTime(Date withdrawRespTime) {
		this.withdrawRespTime = withdrawRespTime;
	}
	public String getIsUploadSuccess() {
		return isUploadSuccess;
	}
	public void setIsUploadSuccess(String isUploadSuccess) {
		this.isUploadSuccess = isUploadSuccess;
	}
	public Date getWithdrawUploadTime() {
		return withdrawUploadTime;
	}
	public void setWithdrawUploadTime(Date withdrawUploadTime) {
		this.withdrawUploadTime = withdrawUploadTime;
	}
	
	public String getWithdrawRespDesc() {
		return withdrawRespDesc;
	}

	public void setWithdrawRespDesc(String withdrawRespDesc) {
		this.withdrawRespDesc = withdrawRespDesc;
	}

	public String getWitDateStr(){
		return DateUtil.dateToStr(withdrawCreateTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getWithdrawRespTimeStr(){
		return DateUtil.dateToStr(withdrawRespTime, "yyyy-MM-dd HH:mm:ss");
	}
	
	public String getWithdrawUploadTimeStr(){
		return DateUtil.dateToStr(withdrawUploadTime, "yyyy-MM-dd HH:mm:ss");
	}

	public String getWithdrawName() {
		return withdrawName;
	}

	public void setWithdrawName(String withdrawName) {
		this.withdrawName = withdrawName;
	}
}
