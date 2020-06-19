import lombok.Data;
import com.autumn.zero.common.library.application.dto.tree.output.TreeOutput;

/**  
* @Description:
* @author yanlianglong
* @date ${.now?date}
*/
@Data
public class ${tableNameFormat}Output extends TreeOutput{

	private static final long serialVersionUID = ${serialVersionUID3}L ;

	/**
	 * 是否删除
	 */
	private boolean delete;
}
