
import java.io.Serializable;

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
