import com.zjsm.sp.application.admin.dto.BasePageInput;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**  
* @Description:
* @author yanlianglong
* @date ${.now?date}
*/
@Data
public class ${tableNameFormat}SelectDto extends BasePageInput{

    private static final long serialVersionUID = ${serialVersionUID4}L ;

<#list selectDTOs as selectDTO >
<#list baseResultMapVoList as baseResultMapVo >
    <#if selectDTO == baseResultMapVo.column>
	/**
	* ${baseResultMapVo.columnComment}
	*/
	@ApiModelProperty(value = "${baseResultMapVo.columnComment}")
	private ${baseResultMapVo.DTOType} ${baseResultMapVo.property};

    </#if>
</#list>
</#list>
}
