
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**  
* @Title: LiquidationHisQuery.java
* @Package
* @Description:
* @author yanlianglong
* @date 2019-12-26
*/ 
public class LiquidationHisQuery extends PageQuery implements Serializable{

	private static final long serialVersionUID = 1297998080399938L ;
	private Long liquidationId;
	private String orderId;
	private Long accountId;
	private String accountCode;
	private String accountName;
	private String termCode;
	private String accountType;
	private String organLevel;
	private Long organId;
	private Long productId;
	private String transType;
	private String transKind;
	private String clearType;
	private String feeType;
	private String cashType;
	private Long cashAccountId;
	private String cardNo;
	private String clearState;
	private String clearDate;
	private String settlePeriod;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date clearTime;
	private Long amount;
	private Long orgAmount;
	private String accountRate;
	private String accountFee;
	private Long organ2Id;
	private String organ2Rate;
	private Long organ2Fee;
	private Long organ1Id;
	private String organ1Rate;
	private Long organ1Fee;
	private Long gorganId;
	private Long gorganFee;
	private Long channelId;
	private String channelRate;
	private Long channelCost;
	private String settleFlag;
	private String settleBatchno;
	private String affiliateTransFlag;
	private String extField1;
	private String extField2;
	private String extField3;
	private String extField4;
	private Integer splitColumn;
    public Long getLiquidationId(){
		return liquidationId;
	}
	public void setLiquidationId(Long liquidationId){
		this.liquidationId = liquidationId;
	}
    public String getOrderId(){
		return orderId;
	}
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
    public Long getAccountId(){
		return accountId;
	}
	public void setAccountId(Long accountId){
		this.accountId = accountId;
	}
    public String getAccountCode(){
		return accountCode;
	}
	public void setAccountCode(String accountCode){
		this.accountCode = accountCode;
	}
    public String getAccountName(){
		return accountName;
	}
	public void setAccountName(String accountName){
		this.accountName = accountName;
	}
    public String getTermCode(){
		return termCode;
	}
	public void setTermCode(String termCode){
		this.termCode = termCode;
	}
    public String getAccountType(){
		return accountType;
	}
	public void setAccountType(String accountType){
		this.accountType = accountType;
	}
    public String getOrganLevel(){
		return organLevel;
	}
	public void setOrganLevel(String organLevel){
		this.organLevel = organLevel;
	}
    public Long getOrganId(){
		return organId;
	}
	public void setOrganId(Long organId){
		this.organId = organId;
	}
    public Long getProductId(){
		return productId;
	}
	public void setProductId(Long productId){
		this.productId = productId;
	}
    public String getTransType(){
		return transType;
	}
	public void setTransType(String transType){
		this.transType = transType;
	}
    public String getTransKind(){
		return transKind;
	}
	public void setTransKind(String transKind){
		this.transKind = transKind;
	}
    public String getClearType(){
		return clearType;
	}
	public void setClearType(String clearType){
		this.clearType = clearType;
	}
    public String getFeeType(){
		return feeType;
	}
	public void setFeeType(String feeType){
		this.feeType = feeType;
	}
    public String getCashType(){
		return cashType;
	}
	public void setCashType(String cashType){
		this.cashType = cashType;
	}
    public Long getCashAccountId(){
		return cashAccountId;
	}
	public void setCashAccountId(Long cashAccountId){
		this.cashAccountId = cashAccountId;
	}
    public String getCardNo(){
		return cardNo;
	}
	public void setCardNo(String cardNo){
		this.cardNo = cardNo;
	}
    public String getClearState(){
		return clearState;
	}
	public void setClearState(String clearState){
		this.clearState = clearState;
	}
    public String getClearDate(){
		return clearDate;
	}
	public void setClearDate(String clearDate){
		this.clearDate = clearDate;
	}
    public String getSettlePeriod(){
		return settlePeriod;
	}
	public void setSettlePeriod(String settlePeriod){
		this.settlePeriod = settlePeriod;
	}
    public Date getCreateTime(){
		return createTime;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
    public Date getOrderTime(){
		return orderTime;
	}
	public void setOrderTime(Date orderTime){
		this.orderTime = orderTime;
	}
    public Date getClearTime(){
		return clearTime;
	}
	public void setClearTime(Date clearTime){
		this.clearTime = clearTime;
	}
    public Long getAmount(){
		return amount;
	}
	public void setAmount(Long amount){
		this.amount = amount;
	}
    public Long getOrgAmount(){
		return orgAmount;
	}
	public void setOrgAmount(Long orgAmount){
		this.orgAmount = orgAmount;
	}
    public String getAccountRate(){
		return accountRate;
	}
	public void setAccountRate(String accountRate){
		this.accountRate = accountRate;
	}
    public String getAccountFee(){
		return accountFee;
	}
	public void setAccountFee(String accountFee){
		this.accountFee = accountFee;
	}
    public Long getOrgan2Id(){
		return organ2Id;
	}
	public void setOrgan2Id(Long organ2Id){
		this.organ2Id = organ2Id;
	}
    public String getOrgan2Rate(){
		return organ2Rate;
	}
	public void setOrgan2Rate(String organ2Rate){
		this.organ2Rate = organ2Rate;
	}
    public Long getOrgan2Fee(){
		return organ2Fee;
	}
	public void setOrgan2Fee(Long organ2Fee){
		this.organ2Fee = organ2Fee;
	}
    public Long getOrgan1Id(){
		return organ1Id;
	}
	public void setOrgan1Id(Long organ1Id){
		this.organ1Id = organ1Id;
	}
    public String getOrgan1Rate(){
		return organ1Rate;
	}
	public void setOrgan1Rate(String organ1Rate){
		this.organ1Rate = organ1Rate;
	}
    public Long getOrgan1Fee(){
		return organ1Fee;
	}
	public void setOrgan1Fee(Long organ1Fee){
		this.organ1Fee = organ1Fee;
	}
    public Long getGorganId(){
		return gorganId;
	}
	public void setGorganId(Long gorganId){
		this.gorganId = gorganId;
	}
    public Long getGorganFee(){
		return gorganFee;
	}
	public void setGorganFee(Long gorganFee){
		this.gorganFee = gorganFee;
	}
    public Long getChannelId(){
		return channelId;
	}
	public void setChannelId(Long channelId){
		this.channelId = channelId;
	}
    public String getChannelRate(){
		return channelRate;
	}
	public void setChannelRate(String channelRate){
		this.channelRate = channelRate;
	}
    public Long getChannelCost(){
		return channelCost;
	}
	public void setChannelCost(Long channelCost){
		this.channelCost = channelCost;
	}
    public String getSettleFlag(){
		return settleFlag;
	}
	public void setSettleFlag(String settleFlag){
		this.settleFlag = settleFlag;
	}
    public String getSettleBatchno(){
		return settleBatchno;
	}
	public void setSettleBatchno(String settleBatchno){
		this.settleBatchno = settleBatchno;
	}
    public String getAffiliateTransFlag(){
		return affiliateTransFlag;
	}
	public void setAffiliateTransFlag(String affiliateTransFlag){
		this.affiliateTransFlag = affiliateTransFlag;
	}
    public String getExtField1(){
		return extField1;
	}
	public void setExtField1(String extField1){
		this.extField1 = extField1;
	}
    public String getExtField2(){
		return extField2;
	}
	public void setExtField2(String extField2){
		this.extField2 = extField2;
	}
    public String getExtField3(){
		return extField3;
	}
	public void setExtField3(String extField3){
		this.extField3 = extField3;
	}
    public String getExtField4(){
		return extField4;
	}
	public void setExtField4(String extField4){
		this.extField4 = extField4;
	}
    public Integer getSplitColumn(){
		return splitColumn;
	}
	public void setSplitColumn(Integer splitColumn){
		this.splitColumn = splitColumn;
	}
}
