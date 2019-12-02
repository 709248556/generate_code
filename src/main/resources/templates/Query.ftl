
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**  
* @Title: ${tableNameFormat}Query.java
* @Package
* @Description:
* @author yanlianglong
* @date ${.now?date}
*/ 
public class ${tableNameFormat}Query extends PageQuery implements Serializable{

	private static final long serialVersionUID = ${serialVersionUID2?c}L ;
<#list baseResultMapVoList as baseResultMapVo >
	<#if baseResultMapVo.DTOType =="Date">
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private ${baseResultMapVo.DTOType} ${baseResultMapVo.property};
	<#else>
	private ${baseResultMapVo.DTOType} ${baseResultMapVo.property};
	</#if>
</#list>
<#list baseResultMapVoList as baseResultMapVo >
    public ${baseResultMapVo.DTOType} get${baseResultMapVo.columnNameUpperCase}(){
		return ${baseResultMapVo.property};
	}
	public void set${baseResultMapVo.columnNameUpperCase}(${baseResultMapVo.DTOType} ${baseResultMapVo.property}){
		this.${baseResultMapVo.property} = ${baseResultMapVo.property};
	}
</#list>
}
