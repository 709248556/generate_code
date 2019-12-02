

import java.util.List;

/**
 * @ClassName: GarbageService.java
 * @Description:
 * @author yanlianglong
 * @date 2019-12-2
 */
public interface GarbageService {

    /**
     * 新增
     */
     Result insert(GarbageDTO record);

    /**
     * 根据Id删除
     */
    Result deleteById(Long id);

    /**
     * 编辑
     */
    Result update(GarbageDTO record);

    /**
     * 查询
     */
    QueryResult<GarbageDTO> queryList(GarbageQuery query);

    /**
    * 单个查询
    */
    SingleResult<GarbageDTO> querySingle(Long id);
}

