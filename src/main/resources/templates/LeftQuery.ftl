import com.autumn.mybatis.mapper.annotation.ViewTable;
import lombok.Data;
/**  
* @Description:${tableRemark}Output类
* @author yanlianglong
* @date ${.now?date}
*/

@Data
@ViewTable
public class ${tableNameFormat}${leftTableNameFormat}Query extends ${tableNameFormat}{

<#assign leftQuerysMap = leftQuerys />
<#assign  keys=leftQuerysMap?keys/>
<#list keys as key>
    <#list baseResultMapVoList as baseResultMapVo >
        <#if key == baseResultMapVo.column>
	/**
	* ${baseResultMapVo.columnComment}
	*/
	private ${baseResultMapVo.DTOType} ${baseResultMapVo.property};
        </#if>
    </#list>
</#list>
}
