package crf.invest.entity;

import java.util.Date;

import crf.util.DateUtil;

/**
 * <p>Title: 开户实体类</p>
 * <p>Description: </p>
 * <p>Company: 上海信而富金融信息服务有限公司</p>
 * @author zhiwang 
 * @date 2015-5-29
 */
public class Account implements java.io.Serializable {

	private static final long serialVersionUID = -8128810665318640296L;
	
	private Long accountId;               //主键
	private long accountFUserId;        //用户表ID
	private long accountFUbcId;         //用户银行卡ID
	private String accountName;        //开户姓名
	private String accountIdNo;         //身份证号
	private String accountPhoneNo;      //手机号
	private String accountCardNo;      //银行卡号
	private String accountSeq;             //流水号
	private String accountChannel;      //交易渠道  1 富友 2 银联 3 通联 4 财付通
	private String accountLoginPass;    //登陆密码
	private String accountPayPass;      //支付密码
	private String accountIsSuccess;     //开户结果  1 成功 0 失败
	private Date accountCreateTime;     //创建时间
	private String accountIsUpload;      // 是否成功上传 0默认 1 是  2否
	private Date accountUploadTime;  	// 上传时间
	private String accountProvinceCode;  //省份编码
	private String accountCityCode; //城市编码
	private String accountBankCode; //银行代码
	
	
	public String getAccountIsUpload() {
		return accountIsUpload;
	}
	public void setAccountIsUpload(String accountIsUpload) {
		this.accountIsUpload = accountIsUpload;
	}
	public String getAccountProvinceCode() {
		return accountProvinceCode;
	}
	public void setAccountProvinceCode(String accountProvinceCode) {
		this.accountProvinceCode = accountProvinceCode;
	}
	public String getAccountCityCode() {
		return accountCityCode;
	}
	public void setAccountCityCode(String accountCityCode) {
		this.accountCityCode = accountCityCode;
	}
	public String getAccountBankCode() {
		return accountBankCode;
	}
	public void setAccountBankCode(String accountBankCode) {
		this.accountBankCode = accountBankCode;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public long getAccountFUserId() {
		return accountFUserId;
	}
	public void setAccountFUserId(long accountFUserId) {
		this.accountFUserId = accountFUserId;
	}
	public long getAccountFUbcId() {
		return accountFUbcId;
	}
	public void setAccountFUbcId(long accountFUbcId) {
		this.accountFUbcId = accountFUbcId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountIdNo() {
		return accountIdNo;
	}
	public void setAccountIdNo(String accountIdNo) {
		this.accountIdNo = accountIdNo;
	}
	public String getAccountPhoneNo() {
		return accountPhoneNo;
	}
	public void setAccountPhoneNo(String accountPhoneNo) {
		this.accountPhoneNo = accountPhoneNo;
	}
	public String getAccountCardNo() {
		return accountCardNo;
	}
	public void setAccountCardNo(String accountCardNo) {
		this.accountCardNo = accountCardNo;
	}
	public String getAccountSeq() {
		return accountSeq;
	}
	public void setAccountSeq(String accountSeq) {
		this.accountSeq = accountSeq;
	}
	public String getAccountChannel() {
		return accountChannel;
	}
	public void setAccountChannel(String accountChannel) {
		this.accountChannel = accountChannel;
	}
	public String getAccountLoginPass() {
		return accountLoginPass;
	}
	public void setAccountLoginPass(String accountLoginPass) {
		this.accountLoginPass = accountLoginPass;
	}
	public String getAccountPayPass() {
		return accountPayPass;
	}
	public void setAccountPayPass(String accountPayPass) {
		this.accountPayPass = accountPayPass;
	}
	public String getAccountIsSuccess() {
		return accountIsSuccess;
	}
	public void setAccountIsSuccess(String accountIsSuccess) {
		this.accountIsSuccess = accountIsSuccess;
	}
	public Date getAccountCreateTime() {
		return accountCreateTime;
	}
	public void setAccountCreateTime(Date accountCreateTime) {
		this.accountCreateTime = accountCreateTime;
	}
	public Date getAccountUploadTime() {
		return accountUploadTime;
	}
	public void setAccountUploadTime(Date accountUploadTime) {
		this.accountUploadTime = accountUploadTime;
	}
	public String getAccountCreateTimeStr(){
		return DateUtil.dateToStr(accountCreateTime,"yyyy-MM-dd HH:mm:ss");
	}
	public String getAccountUploadTimeStr(){
		return DateUtil.dateToStr(accountUploadTime,"yyyy-MM-dd HH:mm:ss");
	}
}
