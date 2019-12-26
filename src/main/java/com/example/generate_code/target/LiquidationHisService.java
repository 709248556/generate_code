

import java.util.List;

/**
 * @ClassName: LiquidationHisService.java
 * @Description:
 * @author yanlianglong
 * @date 2019-12-26
 */
public interface LiquidationHisService {

    /**
     * 新增
     */
     Result insert(LiquidationHisDTO record);

    /**
     * 根据Id删除
     */
    Result deleteById(Long id);

    /**
     * 编辑
     */
    Result update(LiquidationHisDTO record);

    /**
     * 查询
     */
    QueryResult<LiquidationHisDTO> queryList(LiquidationHisQuery query);

    /**
    * 单个查询
    */
    SingleResult<LiquidationHisDTO> querySingle(LiquidationHisQuery query);
}

