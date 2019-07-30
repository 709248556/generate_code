

import java.util.List;

/**
 * @ClassName: ${tableNameFormat}Service.java
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
public interface ${tableNameFormat}Service {

    /**
     * 新增
     */
     Result insert(${tableNameFormat}DTO record);

    /**
     * 根据Id删除
     */
    Result deleteById(long id);

    /**
     * 编辑
     */
    Result update(${tableNameFormat}DTO record);

    /**
     * 查询
     */
    QueryResult<${tableNameFormat}DTO> queryList(${tableNameFormat}Query query);

    /**
    * 根据id查询
    */
    SingleResult<${tableNameFormat}DTO> getSingleById(long id);
}

