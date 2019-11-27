

import java.util.List;

/**
 * @ClassName: CustomerAddressService.java
 * @Description:
 * @author yanlianglong
 * @date 2019-11-27
 */
public interface CustomerAddressService {

    /**
     * 新增
     */
     Result insert(CustomerAddressDTO record);

    /**
     * 根据Id删除
     */
    Result deleteById(Long id);

    /**
     * 编辑
     */
    Result update(CustomerAddressDTO record);

    /**
     * 查询
     */
    QueryResult<CustomerAddressDTO> queryList(CustomerAddressQuery query);

    /**
    * 单个查询
    */
    SingleResult<CustomerAddressDTO> querySingle(Long id);
}

