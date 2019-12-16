

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.zfull.commons.enums.ResponseEnum;

/**
 * @ClassName: ${tableNameFormat}ServiceImpl.java
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@Service("${tableNameFormatOnCase}Service")
public class ${tableNameFormat}ServiceImpl extends GenericService implements ${tableNameFormat}Service{

    @Autowired
    private ${tableNameFormat}Dao ${tableNameFormatOnCase}Dao;

	@Override
	public Result insert(${tableNameFormat}DTO record) {
		Result result = new Result();
        try {
            ${tableNameFormatOnCase}Dao.insert(record);
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
            ${tableNameFormatOnCase}Dao.deleteById(id);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}


	@Override
	public Result update(${tableNameFormat}DTO record) {
		Result result = new Result();
        try {
            ${tableNameFormatOnCase}Dao.update(record);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

    @Override
    public QueryResult<${tableNameFormat}DTO> queryList(${tableNameFormat}Query query) {
        QueryResult<${tableNameFormat}DTO> result = new QueryResult<${tableNameFormat}DTO>(false, ResponseEnum.CODE_9999.getCode(), "查询失败", null);
            List<${tableNameFormat}DTO> list = null;
            try {
                if (query.getFlag()) {
                    PageHelper.startPage(query.getPageNum(), query.getPageSize());
                }
                list = ${tableNameFormatOnCase}Dao.queryList(query);
                result.setSuccess(true);
                result.setResults(list);
                result.setErrorCode(ResponseEnum.CODE_0000.getCode());
                } catch (Exception e) {
                    logger.info("${tableNameFormat}ServiceImpl.queryList error: {}", e.toString());
                }
        return result;
    }

    @Override
    public SingleResult<${tableNameFormat}DTO> querySingle(${tableNameFormat}Query query) {
        SingleResult<${tableNameFormat}DTO> result = new SingleResult<>();
            try {
                ${tableNameFormat}DTO ${tableNameFormatOnCase}DTO = ${tableNameFormatOnCase}Dao.querySingle(query);
                result.setSuccess(true);
                result.setResult(${tableNameFormatOnCase}DTO);
                result.setErrorCode(ResponseEnum.CODE_0000.getCode());
            } catch (Exception e) {
                logger.info("${tableNameFormat}ServiceImpl.getSingleById error: {}", e.toString());
            }
        return result;
    }
}

