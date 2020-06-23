import lombok.Data;
/**  
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@Data
public class ${tableNameFormat}Output extends ${tableNameFormat}Input{

	private static final long serialVersionUID = ${serialVersionUID3}L ;

	/**
	 * 是否删除
	 */
	private boolean delete;
}
