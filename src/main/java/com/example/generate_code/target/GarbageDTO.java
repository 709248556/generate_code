
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**  
* @Title: GarbageDTO.java
* @Package
* @Description:
* @author yanlianglong
* @date 2019-12-2
*/ 
public class GarbageDTO implements Serializable{

	private static final long serialVersionUID = 9593524947495692L ;
	private Long id;
	private Long parentId;
	private String name;
	private Long price;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastTime;
    public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
    public Long getParentId(){
		return parentId;
	}
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}
    public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
    public Long getPrice(){
		return price;
	}
	public void setPrice(Long price){
		this.price = price;
	}
    public Date getLastTime(){
		return lastTime;
	}
	public void setLastTime(Date lastTime){
		this.lastTime = lastTime;
	}
}
