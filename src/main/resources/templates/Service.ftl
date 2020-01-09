

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
     * 删除
     */
    Result delete(Long id);

    /**
     * 编辑
     */
    Result update(${tableNameFormat}DTO record);

    /**
     * 查询
     */
    QueryResult<${tableNameFormat}DTO> queryList(${tableNameFormat}Query query);

    /**
    * 单个查询
    */
    SingleResult<${tableNameFormat}VO> querySingle(${tableNameFormat}Query query);
}

