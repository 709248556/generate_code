
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @ClassName: GarbageDao
 * @Description:
 * @author yanlianglong
 * @date 2019-12-2
 */
@Mapper
public interface GarbageDao {

    /**
     * 新增
     */
    int insert(GarbageDTO record);

   /**
     * 根据Id删除
     */
    int deleteById(long id);


    /**
     * 编辑
     */
    int update(GarbageDTO record);

    /**
     * 查询
     */
	List<GarbageDTO> queryList(GarbageQuery query);

    /**
    * 根据id查询
    */
    GarbageDTO querySingle(Long id);
}