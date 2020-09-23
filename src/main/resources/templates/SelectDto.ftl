import com.zjsm.sp.application.dto.BasePlatformPageInput;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**  
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@Data
public class ${tableNameFormat}SelectDto extends BasePlatformPageInput{

    private static final long serialVersionUID = ${serialVersionUID4}L ;

<#list selectDTOs as selectDTO >
<#list baseResultMapVoList as baseResultMapVo >
    <#if selectDTO == baseResultMapVo.column>
	/**
	 * ${baseResultMapVo.columnComment}
	 */
	@ApiModelProperty(value = "${baseResultMapVo.columnComment}")
    <#if "Date" == baseResultMapVo.DTOType>
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    </#if>
	private ${baseResultMapVo.DTOType} ${baseResultMapVo.property};

    </#if>
</#list>
</#list>
}
