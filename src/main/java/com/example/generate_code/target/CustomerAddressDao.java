
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @ClassName: CustomerAddressDao
 * @Description:
 * @author yanlianglong
 * @date 2019-11-27
 */
@Mapper
public interface CustomerAddressDao {

    /**
     * 新增
     */
    int insert(CustomerAddressDTO record);

   /**
     * 根据Id删除
     */
    int deleteById(long id);


    /**
     * 编辑
     */
    int update(CustomerAddressDTO record);

    /**
     * 查询
     */
	List<CustomerAddressDTO> queryList(CustomerAddressQuery query);

    /**
    * 根据id查询
    */
    CustomerAddressDTO querySingle(Long id);
}