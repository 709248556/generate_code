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
    <#list leftQueryVOS as leftQueryVO >
	/**
	* ${leftQueryVO.columnComment}
	*/
	private ${leftQueryVO.DTOType} ${leftQueryVO.property};
    </#list>
}
