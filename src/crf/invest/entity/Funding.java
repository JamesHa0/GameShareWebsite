package crf.invest.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import crf.util.DateUtil;

/**
 * <p>Title:出资实体类 </p>
 * <p>Description: </p>
 * <p>Company: 上海信而富金融信息服务有限公司</p>
 * @author zhiwang 
 * @date 2015-5-29
 */
public class Funding implements java.io.Serializable {

	private static final long serialVersionUID = 6815096711724975283L;
	
	private Long fundId;
	private long fundFUserId;
	private long fundFProId;
	private long fundFUbcId;
	private String fundSeq;
	private String fundMoney;
	private String fundSource;
	private Date fundCreateTime;
	private String fundState;//冻结成功 0失败 1成功 2交易过期3交易失效（取消）
	private Date fundFrostTime;//冻结时间
	private String fundReqState;//上传成功 0默认 1成功 2失败
	private Date fundDeductTime;//上传时间
	private String fundChannel;
	private Date fundBeginDate;
	private Date fundEndDate;
	private int fundHoldDays;
	private String fundCloseIncome;
	private String fundTotalIncome;
	private String fundFetchState;
	private String fundFuiouMchntTxnSsn;//冻结富友账户的流水号
	private Date fundFetchTime;         //赎回时间
	
	/**
	 * 非数据库字段
	 */
	private String fundProName;//出资产品名称
	private String fundPhoneNo;//出资人手机号
	private String fundName;//出资人姓名
	private String fundIdCard;//出资人身份证号
	
	
	//出资状态
	public static Map<String,String> fundStateMap(){
		Map<String, String>map=new HashMap<String,String>();
		map.put("0", "未冻结");
		map.put("1", "已冻结");
		map.put("2", "交易过期");
		map.put("3", "交易取消");
		return map;
	}
	
	//出资上传状态
	public static Map<String,String> fundReqStateMap(){
		Map<String, String>map=new HashMap<String,String>();
		map.put("0", "未上传");
		map.put("1", "已上传");
		map.put("2", "上传失败");
		return map;
	}
	
	public String getFundPhoneNo() {
		return fundPhoneNo;
	}
	public void setFundPhoneNo(String fundPhoneNo) {
		this.fundPhoneNo = fundPhoneNo;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getFundIdCard() {
		return fundIdCard;
	}
	public void setFundIdCard(String fundIdCard) {
		this.fundIdCard = fundIdCard;
	}
	public Date getFundFetchTime() {
		return fundFetchTime;
	}
	public void setFundFetchTime(Date fundFetchTime) {
		this.fundFetchTime = fundFetchTime;
	}
	public Long getFundId() {
		return fundId;
	}
	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}
	public long getFundFUserId() {
		return fundFUserId;
	}
	public void setFundFUserId(long fundFUserId) {
		this.fundFUserId = fundFUserId;
	}
	public long getFundFProId() {
		return fundFProId;
	}
	public void setFundFProId(long fundFProId) {
		this.fundFProId = fundFProId;
	}
	public long getFundFUbcId() {
		return fundFUbcId;
	}
	public void setFundFUbcId(long fundFUbcId) {
		this.fundFUbcId = fundFUbcId;
	}
	public String getFundSeq() {
		return fundSeq;
	}
	public void setFundSeq(String fundSeq) {
		this.fundSeq = fundSeq;
	}
	public String getFundMoney() {
		return fundMoney;
	}
	public void setFundMoney(String fundMoney) {
		this.fundMoney = fundMoney;
	}
	public String getFundSource() {
		return fundSource;
	}
	public void setFundSource(String fundSource) {
		this.fundSource = fundSource;
	}
	public Date getFundCreateTime() {
		return fundCreateTime;
	}
	public void setFundCreateTime(Date fundCreateTime) {
		this.fundCreateTime = fundCreateTime;
	}
	public String getFundState() {
		return fundState;
	}
	public void setFundState(String fundState) {
		this.fundState = fundState;
	}
	public Date getFundFrostTime() {
		return fundFrostTime;
	}
	public void setFundFrostTime(Date fundFrostTime) {
		this.fundFrostTime = fundFrostTime;
	}
	public String getFundReqState() {
		return fundReqState;
	}
	public void setFundReqState(String fundReqState) {
		this.fundReqState = fundReqState;
	}
	public Date getFundDeductTime() {
		return fundDeductTime;
	}
	public void setFundDeductTime(Date fundDeductTime) {
		this.fundDeductTime = fundDeductTime;
	}
	public String getFundChannel() {
		return fundChannel;
	}
	public void setFundChannel(String fundChannel) {
		this.fundChannel = fundChannel;
	}
	public Date getFundBeginDate() {
		return fundBeginDate;
	}
	public void setFundBeginDate(Date fundBeginDate) {
		this.fundBeginDate = fundBeginDate;
	}
	public Date getFundEndDate() {
		return fundEndDate;
	}
	public void setFundEndDate(Date fundEndDate) {
		this.fundEndDate = fundEndDate;
	}
	public int getFundHoldDays() {
		return fundHoldDays;
	}
	public void setFundHoldDays(int fundHoldDays) {
		this.fundHoldDays = fundHoldDays;
	}
	public String getFundCloseIncome() {
		return fundCloseIncome;
	}
	public void setFundCloseIncome(String fundCloseIncome) {
		this.fundCloseIncome = fundCloseIncome;
	}
	public String getFundTotalIncome() {
		return fundTotalIncome;
	}
	public void setFundTotalIncome(String fundTotalIncome) {
		this.fundTotalIncome = fundTotalIncome;
	}
	public String getFundFetchState() {
		return fundFetchState;
	}
	public void setFundFetchState(String fundFetchState) {
		this.fundFetchState = fundFetchState;
	}
	public String getFundFuiouMchntTxnSsn() {
		return fundFuiouMchntTxnSsn;
	}
	public void setFundFuiouMchntTxnSsn(String fundFuiouMchntTxnSsn) {
		this.fundFuiouMchntTxnSsn = fundFuiouMchntTxnSsn;
	}
	public String getFundProName() {
		return fundProName;
	}
	public void setFundProName(String fundProName) {
		this.fundProName = fundProName;
	}
	
	public String getFundStateDesc(){
		return fundStateMap().get(this.fundState);
	}
	
	public String getFundReqStateDesc(){
		return fundReqStateMap().get(this.fundReqState);
	}
	
	public String getFundCreateTimeStr(){
		return DateUtil.dateToStr(fundCreateTime,"yyyy-MM-dd HH:mm:ss");
	}
	public String getFundFrostTimeStr(){
		return DateUtil.dateToStr(fundFrostTime,"yyyy-MM-dd HH:mm:ss");
	}
	public String getFundDeductTimeStr(){
		return DateUtil.dateToStr(fundDeductTime,"yyyy-MM-dd HH:mm:ss");
	}
	
	
}