

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.zfull.commons.enums.ResponseEnum;

/**
 * @ClassName: GarbageServiceImpl.java
 * @Description:
 * @author yanlianglong
 * @date 2019-12-2
 */
@Service("garbageService")
public class GarbageServiceImpl extends GenericService implements GarbageService{

    @Autowired
    private GarbageDao garbageDao;

	@Override
	public Result insert(GarbageDTO record) {
		Result result = new Result();
        try {
            garbageDao.insert(record);
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
            garbageDao.deleteById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}


	@Override
	public Result update(GarbageDTO record) {
		Result result = new Result();
        try {
            garbageDao.update(record);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

    @Override
    public QueryResult<GarbageDTO> queryList(GarbageQuery query) {
        QueryResult<GarbageDTO> result = new QueryResult<GarbageDTO>(false, ResponseEnum.API_ERROR_CODE_9999.getRespCode(), "查询失败", null);
            List<GarbageDTO> list = null;
            try {
                if (query.getFlag()) {
                    PageHelper.startPage(query.getPageNum(), query.getPageSize());
                }
                list = garbageDao.queryList(query);
                result.setSuccess(true);
                result.setResults(list);
                result.setErrorCode(ResponseEnum.API_ERROR_CODE_0000.getRespCode());
                } catch (Exception e) {
                    logger.info("GarbageServiceImpl.queryList error: {}", e.toString());
                }
        return result;
    }

    @Override
    public SingleResult<GarbageDTO> querySingle(Long id) {
        SingleResult<GarbageDTO> result = new SingleResult<>();
            try {
                GarbageDTO garbageDTO = garbageDao.querySingle(id);
                result.setSuccess(true);
                result.setResult(garbageDTO);
                result.setErrorCode(ResponseEnum.API_ERROR_CODE_0000.getRespCode());
            } catch (Exception e) {
                logger.info("GarbageServiceImpl.getSingleById error: {}", e.toString());
            }
        return result;
    }
}

