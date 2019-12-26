

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.zfull.commons.enums.ResponseEnum;

/**
 * @ClassName: LiquidationHisServiceImpl.java
 * @Description:
 * @author yanlianglong
 * @date 2019-12-26
 */
@Service("liquidationHisService")
public class LiquidationHisServiceImpl extends GenericService implements LiquidationHisService{

    @Autowired
    private LiquidationHisDao liquidationHisDao;

	@Override
	public Result insert(LiquidationHisDTO record) {
		Result result = new Result();
        try {
            liquidationHisDao.insert(record);
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
            liquidationHisDao.deleteById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}


	@Override
	public Result update(LiquidationHisDTO record) {
		Result result = new Result();
        try {
            liquidationHisDao.update(record);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

    @Override
    public QueryResult<LiquidationHisDTO> queryList(LiquidationHisQuery query) {
        QueryResult<LiquidationHisDTO> result = new QueryResult<LiquidationHisDTO>(false, ResponseEnum.CODE_9999.getCode(), "查询失败", null);
        List<LiquidationHisDTO> list = null;
        try {
            if (query.getFlag()) {
                PageHelper.startPage(query.getPageNum(), query.getPageSize());
            }
            list = liquidationHisDao.queryList(query);
            result.setSuccess(true);
            result.setResults(list);
            result.setErrorCode(ResponseEnum.CODE_0000.getCode());
        } catch (Exception e) {
            logger.info("LiquidationHisServiceImpl.queryList error: {}", e.toString());
        }
        return result;
    }

    @Override
    public SingleResult<LiquidationHisDTO> querySingle(LiquidationHisQuery query) {
        SingleResult<LiquidationHisDTO> result = new SingleResult<>();
        try {
            LiquidationHisDTO liquidationHisDTO = liquidationHisDao.querySingle(query);
            result.setSuccess(true);
            result.setResult(liquidationHisDTO);
            result.setErrorCode(ResponseEnum.CODE_0000.getCode());
        } catch (Exception e) {
            logger.info("LiquidationHisServiceImpl.getSingleById error: {}", e.toString());
        }
        return result;
    }
}

