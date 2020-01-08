

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
            ${tableNameFormatOnCase}Dao.insertSelective(record);
    		result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}

    @Override
	public Result delete(Long id) {
		Result result = new Result();
        try {
            ${tableNameFormat}Example example = new ${tableNameFormat}Example();
            ${tableNameFormat}Example.Criteria criteria = example.createCriteria();
			criteria.and${fristColumnNameUpperCase}EqualTo(id);
            ${tableNameFormatOnCase}Dao.deleteByExample(example);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e.getMessage());
        }
        return result;
	}


	@Override
	public Result update(${tableNameFormat}DTO ${tableNameFormatOnCase}) {
		Result result = new Result();
        try {
            ${tableNameFormat}Example example = new ${tableNameFormat}Example();
            ${tableNameFormat}Example.Criteria criteria = example.createCriteria();
            criteria.and${fristColumnNameUpperCase}EqualTo(${tableNameFormatOnCase}.get${fristColumnNameUpperCase}());
            ${tableNameFormatOnCase}Dao.updateByExampleSelective(${tableNameFormatOnCase},example);
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
            ${tableNameFormat}Example example = new ${tableNameFormat}Example();
            ${tableNameFormat}Example.Criteria criteria = example.createCriteria();

            list = ${tableNameFormatOnCase}Dao.selectByExample(example);
            result.setSuccess(true);
            result.setResults(list);
            result.setErrorCode(ResponseEnum.CODE_0000.getCode());
        } catch (Exception e) {
            logger.info("${tableNameFormat}ServiceImpl.queryList error: {}", e);
        }
        return result;
    }

    @Override
    public SingleResult<${tableNameFormat}DTO> querySingle(${tableNameFormat}Query query) {
        SingleResult<${tableNameFormat}DTO> result = new SingleResult<>();
        try {
            ${tableNameFormat}Example example = new ${tableNameFormat}Example();
            ${tableNameFormat}Example.Criteria criteria = example.createCriteria();
            criteria.and${fristColumnNameUpperCase}EqualTo(query.get${fristColumnNameUpperCase}());

            List<${tableNameFormat}DTO> list = ${tableNameFormatOnCase}Dao.selectByExample(example);
            if (list != null && list.size() == 1){
                result.setSuccess(true);
                result.setResult(list.get(0));
                result.setErrorCode(ResponseEnum.CODE_0000.getCode());
            }else {
                result.setSuccess(false);
                result.setErrorCode(ResponseEnum.CODE_9999.getCode());
            }

        } catch (Exception e) {
            logger.info("${tableNameFormat}ServiceImpl.getSingle error: {}", e);
        }
        return result;
    }
}

