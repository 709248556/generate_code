
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
 * @ClassName: ${tableNameFormat}ServiceImpl.java
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@Component
public class ${tableNameFormat}Component {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ${tableNameFormat}Dao ${tableNameFormatOnCase}Dao;

	public Result insert(${tableNameFormat}DTO example) {
		Result result = new Result();
        try {
            ${tableNameFormatOnCase}Dao.insert(example);
    		result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

	public Result deleteByExample(${tableNameFormat}Example example) {
		Result result = new Result();
        try {
            ${tableNameFormatOnCase}Dao.deleteByExample(example);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}


	public Result update(${tableNameFormat}Example example) {
		Result result = new Result();
        try {
            ${tableNameFormatOnCase}Dao.updateByExampleSelective(example);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

    public QueryResult<${tableNameFormat}DTO> queryList(${tableNameFormat}Example example) {
        QueryResult<${tableNameFormat}DTO> result = new QueryResult<${tableNameFormat}DTO>(false, ResponseEnum.CODE_9999.getCode(), "查询失败", null);
            List<${tableNameFormat}DTO> list = null;
            try {
                list = ${tableNameFormatOnCase}Dao.selectByExample(example);
                result.setSuccess(true);
                result.setResults(list);
                result.setErrorCode(ResponseEnum.CODE_0000.getCode());
                } catch (Exception e) {
                    logger.info("${tableNameFormat}Component.queryList error: {}", e.toString());
                }
        return result;
    }
}

