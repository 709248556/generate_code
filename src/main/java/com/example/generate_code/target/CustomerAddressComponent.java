
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.zfull.commons.enums.ResponseEnum;
import com.zfull.commons.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
/**
 * @ClassName: CustomerAddressServiceImpl.java
 * @Description:
 * @author yanlianglong
 * @date 2019-11-27
 */
@Component
public class CustomerAddressComponent {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerAddressDao customerAddressDao;

	public Result insert(CustomerAddressDTO example) {
		Result result = new Result();
        try {
            customerAddressDao.insert(example);
    		result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

	public Result deleteByExample(CustomerAddressExample example) {
		Result result = new Result();
        try {
            customerAddressDao.deleteByExample(example);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}


	public Result update(CustomerAddressExample example) {
		Result result = new Result();
        try {
            customerAddressDao.updateByExampleSelective(example);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

    public QueryResult<CustomerAddressDTO> queryList(CustomerAddressExample example) {
        QueryResult<CustomerAddressDTO> result = new QueryResult<CustomerAddressDTO>(false, ResponseEnum.CODE_9999.getCode(), "查询失败", null);
            List<CustomerAddressDTO> list = null;
            try {
                list = customerAddressDao.selectByExample(example);
                result.setSuccess(true);
                result.setResults(list);
                result.setErrorCode(ResponseEnum.CODE_0000.getCode());
                } catch (Exception e) {
                    logger.info("CustomerAddressComponent.queryList error: {}", e.toString());
                }
        return result;
    }
}

