
import java.io.Serializable;

/**  
* @Title: CustomerAddressQuery.java
* @Package
* @Description:
* @author yanlianglong
* @date 2019-11-27
*/ 
public class CustomerAddressQuery extends PageQuery implements Serializable{

	private static final long serialVersionUID = 8063630905819167L ;
    private Long custAddrId;
    private Long customerId;
    private String contactsName;
    private String contactsPhone;
    private String contactsGender;
    private String provinceCode;
    private String provinceName;
    private String cityCode;
    private String cityName;
    private String districtCode;
    private String districtName;
    private Long streetId;
    private String streetName;
    private Long communityId;
    private String address;
    private String isDefault;
    private Date createTime;
    private Date lastTime;
    private String extField1;
    public Long getCustAddrId(){
		return custAddrId;
	}
	public void setCustAddrId(Long custAddrId){
		this.custAddrId = custAddrId;
	}
    public Long getCustomerId(){
		return customerId;
	}
	public void setCustomerId(Long customerId){
		this.customerId = customerId;
	}
    public String getContactsName(){
		return contactsName;
	}
	public void setContactsName(String contactsName){
		this.contactsName = contactsName;
	}
    public String getContactsPhone(){
		return contactsPhone;
	}
	public void setContactsPhone(String contactsPhone){
		this.contactsPhone = contactsPhone;
	}
    public String getContactsGender(){
		return contactsGender;
	}
	public void setContactsGender(String contactsGender){
		this.contactsGender = contactsGender;
	}
    public String getProvinceCode(){
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode){
		this.provinceCode = provinceCode;
	}
    public String getProvinceName(){
		return provinceName;
	}
	public void setProvinceName(String provinceName){
		this.provinceName = provinceName;
	}
    public String getCityCode(){
		return cityCode;
	}
	public void setCityCode(String cityCode){
		this.cityCode = cityCode;
	}
    public String getCityName(){
		return cityName;
	}
	public void setCityName(String cityName){
		this.cityName = cityName;
	}
    public String getDistrictCode(){
		return districtCode;
	}
	public void setDistrictCode(String districtCode){
		this.districtCode = districtCode;
	}
    public String getDistrictName(){
		return districtName;
	}
	public void setDistrictName(String districtName){
		this.districtName = districtName;
	}
    public Long getStreetId(){
		return streetId;
	}
	public void setStreetId(Long streetId){
		this.streetId = streetId;
	}
    public String getStreetName(){
		return streetName;
	}
	public void setStreetName(String streetName){
		this.streetName = streetName;
	}
    public Long getCommunityId(){
		return communityId;
	}
	public void setCommunityId(Long communityId){
		this.communityId = communityId;
	}
    public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
    public String getIsDefault(){
		return isDefault;
	}
	public void setIsDefault(String isDefault){
		this.isDefault = isDefault;
	}
    public Date getCreateTime(){
		return createTime;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
    public Date getLastTime(){
		return lastTime;
	}
	public void setLastTime(Date lastTime){
		this.lastTime = lastTime;
	}
    public String getExtField1(){
		return extField1;
	}
	public void setExtField1(String extField1){
		this.extField1 = extField1;
	}
}
