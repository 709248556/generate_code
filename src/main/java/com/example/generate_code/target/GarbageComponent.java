
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
 * @ClassName: GarbageServiceImpl.java
 * @Description:
 * @author yanlianglong
 * @date 2019-12-2
 */
@Component
public class GarbageComponent {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GarbageDao garbageDao;

	public Result insert(GarbageDTO example) {
		Result result = new Result();
        try {
            garbageDao.insert(example);
    		result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

	public Result deleteByExample(GarbageExample example) {
		Result result = new Result();
        try {
            garbageDao.deleteByExample(example);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}


	public Result update(GarbageExample example) {
		Result result = new Result();
        try {
            garbageDao.updateByExampleSelective(example);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

    public QueryResult<GarbageDTO> queryList(GarbageExample example) {
        QueryResult<GarbageDTO> result = new QueryResult<GarbageDTO>(false, ResponseEnum.CODE_9999.getCode(), "查询失败", null);
            List<GarbageDTO> list = null;
            try {
                list = garbageDao.selectByExample(example);
                result.setSuccess(true);
                result.setResults(list);
                result.setErrorCode(ResponseEnum.CODE_0000.getCode());
                } catch (Exception e) {
                    logger.info("GarbageComponent.queryList error: {}", e.toString());
                }
        return result;
    }
}

