
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @ClassName: ${tableNameFormat}Dao
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@Mapper
public interface ${tableNameFormat}Dao {

    /**
     * 新增
     */
    int insert(${tableNameFormat}DTO record);

   /**
     * 根据Id删除
     */
    int deleteById(long id);


    /**
     * 编辑
     */
    int update(${tableNameFormat}DTO record);

    /**
     * 查询
     */
	List<${tableNameFormat}DTO> queryList(${tableNameFormat}Query query);

    /**
    * 单个查询
    */
    ${tableNameFormat}DTO querySingle(${tableNameFormat}Query query);
}