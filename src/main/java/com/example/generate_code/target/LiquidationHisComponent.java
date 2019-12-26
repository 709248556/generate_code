
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
 * @ClassName: LiquidationHisServiceImpl.java
 * @Description:
 * @author yanlianglong
 * @date 2019-12-26
 */
@Component
public class LiquidationHisComponent {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LiquidationHisDao liquidationHisDao;

	public Result insert(LiquidationHisDTO example) {
		Result result = new Result();
        try {
            liquidationHisDao.insert(example);
    		result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

	public Result deleteByExample(LiquidationHisExample example) {
		Result result = new Result();
        try {
            liquidationHisDao.deleteByExample(example);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}


	public Result update(LiquidationHisExample example) {
		Result result = new Result();
        try {
            liquidationHisDao.updateByExampleSelective(example);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

    public QueryResult<LiquidationHisDTO> queryList(LiquidationHisExample example) {
        QueryResult<LiquidationHisDTO> result = new QueryResult<LiquidationHisDTO>(false, ResponseEnum.CODE_9999.getCode(), "查询失败", null);
            List<LiquidationHisDTO> list = null;
            try {
                list = liquidationHisDao.selectByExample(example);
                result.setSuccess(true);
                result.setResults(list);
                result.setErrorCode(ResponseEnum.CODE_0000.getCode());
                } catch (Exception e) {
                    logger.info("LiquidationHisComponent.queryList error: {}", e.toString());
                }
        return result;
    }
}

