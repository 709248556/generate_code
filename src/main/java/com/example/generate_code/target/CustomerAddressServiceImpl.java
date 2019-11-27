

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.zfull.commons.enums.ResponseEnum;

/**
 * @ClassName: CustomerAddressServiceImpl.java
 * @Description:
 * @author yanlianglong
 * @date 2019-11-27
 */
@Service("customerAddressService")
public class CustomerAddressServiceImpl extends GenericService implements CustomerAddressService{

    @Autowired
    private CustomerAddressDao customerAddressDao;

	@Override
	public Result insert(CustomerAddressDTO record) {
		Result result = new Result();
        try {
            customerAddressDao.insert(record);
    		result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

    @Override
	public Result deleteById(Long id) {
		Result result = new Result();
        try {
            customerAddressDao.deleteById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}


	@Override
	public Result update(CustomerAddressDTO record) {
		Result result = new Result();
        try {
            customerAddressDao.update(record);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

    @Override
    public QueryResult<CustomerAddressDTO> queryList(CustomerAddressQuery query) {
        QueryResult<CustomerAddressDTO> result = new QueryResult<CustomerAddressDTO>(false, ResponseEnum.API_ERROR_CODE_9999.getRespCode(), "查询失败", null);
            List<CustomerAddressDTO> list = null;
            try {
                if (query.getFlag()) {
                    PageHelper.startPage(query.getPageNum(), query.getPageSize());
                }
                list = customerAddressDao.queryList(query);
                result.setSuccess(true);
                result.setResults(list);
                result.setErrorCode(ResponseEnum.API_ERROR_CODE_0000.getRespCode());
                } catch (Exception e) {
                    logger.info("CustomerAddressServiceImpl.queryList error: {}", e.toString());
                }
        return result;
    }

    @Override
    public SingleResult<CustomerAddressDTO> querySingle(Long id) {
        SingleResult<CustomerAddressDTO> result = new SingleResult<>();
            try {
                CustomerAddressDTO customerAddressDTO = customerAddressDao.querySingle(id);
                result.setSuccess(true);
                result.setResult(customerAddressDTO);
                result.setErrorCode(ResponseEnum.API_ERROR_CODE_0000.getRespCode());
            } catch (Exception e) {
                logger.info("CustomerAddressServiceImpl.getSingleById error: {}", e.toString());
            }
        return result;
    }
}

