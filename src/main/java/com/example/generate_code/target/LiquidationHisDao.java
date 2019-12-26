
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @ClassName: LiquidationHisDao
 * @Description:
 * @author yanlianglong
 * @date 2019-12-26
 */
@Mapper
public interface LiquidationHisDao {

    /**
     * 新增
     */
    int insert(LiquidationHisDTO record);

   /**
     * 根据Id删除
     */
    int deleteById(long id);


    /**
     * 编辑
     */
    int update(LiquidationHisDTO record);

    /**
     * 查询
     */
	List<LiquidationHisDTO> queryList(LiquidationHisQuery query);

    /**
    * 单个查询
    */
    LiquidationHisDTO querySingle(LiquidationHisQuery query);
}