import lombok.Data;
/**  
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@Data
public class ${tableNameFormat}Output extends ${tableNameFormat}Input{

<#list leftQueryVOS as leftQueryVO >
	/**
	* ${leftQueryVO.columnComment}
	*/
	private ${leftQueryVO.DTOType} ${leftQueryVO.property};
</#list>
}
