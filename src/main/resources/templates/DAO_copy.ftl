
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: ${tableNameFormat}DAO
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@Mapper
public interface ${tableNameFormat}DAO {

    /**
     * 新增
     */
    int insert(${tableNameFormat}DTO record);

   /**
     * 根据Id删除
     */
    int deleteById(long id);

   /**
     * 删除
     */
    int deleteBy${tableNameFormat}DTO(${tableNameFormat}DTO record);

    /**
     * 编辑
     */
    int update(${tableNameFormat}DTO record);

    /**
     * 查询
     */
	List<${tableNameFormat}DTO> queryList(${tableNameFormat}Query query);

    /**
    * 根据id查询
    */
    ${tableNameFormat}DTO queryById(long id);
}