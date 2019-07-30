
import java.io.Serializable;

/**  
* @Title: ${tableNameFormat}DTO.java
* @Package
* @Description:
* @author yanlianglong
* @date ${.now?date}
*/ 
public class ${tableNameFormat}DTO implements Serializable{

	private static final long serialVersionUID = ${serialVersionUID1?c}L ;
<#list baseResultMapVoList as baseResultMapVo >
    private ${baseResultMapVo.DTOType} ${baseResultMapVo.property};//${baseResultMapVo.columnComment}
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
