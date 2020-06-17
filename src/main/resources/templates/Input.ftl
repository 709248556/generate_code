import com.autumn.application.dto.EntityDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**  
* @Description:${tableRemark}Input类
* @author yanlianglong
* @date ${.now?date}
*/
@Data
public class ${tableNameFormat}Input extends EntityDto<Long>{

    private static final long serialVersionUID = ${serialVersionUID2}L ;

<#assign inputsMap = inputs />
<#assign  keys=inputsMap?keys/>
<#list keys as key>
<#list baseResultMapVoList as baseResultMapVo >
	<#if key == baseResultMapVo.column>
	/**
	* ${baseResultMapVo.columnComment}
	*/
		<#if inputsMap[key]>
	<#if baseResultMapVo.DTOType =="String">@NotEmpty(message = "${baseResultMapVo.columnComment}不能为空")
	<#elseif  baseResultMapVo.DTOType =="Long">@NotNull(message = "${baseResultMapVo.columnComment}不能为空")
	<#elseif  baseResultMapVo.DTOType =="Integer">@NotNull(message = "${baseResultMapVo.columnComment}不能为空")
	</#if>
		</#if>
	@ApiModelProperty(value = "${baseResultMapVo.columnComment}")
	private ${baseResultMapVo.DTOType} ${baseResultMapVo.property};
	</#if>
</#list>
</#list>
}
