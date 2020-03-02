

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.zfull.commons.enums.ResponseEnum;

/**
 * @ClassName: ${tableNameFormat}Component.java
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@Component
public class ${tableNameFormat}Component extends BasicComponent{

    @Autowired
    private ${tableNameFormat}Dao ${tableNameFormatOnCase}Dao;
    @Autowired
    private ${tableNameFormat}HandleDao ${tableNameFormatOnCase}HandleDao;

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
	public Result delete(Integer id) {
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
    public QueryResult<${tableNameFormat}VO> queryList(${tableNameFormat}Query query) {
        QueryResult<${tableNameFormat}VO> result = new QueryResult<${tableNameFormat}VO>(false, ResponseEnum.CODE_9999.getCode(), "查询失败", null);
        List<${tableNameFormat}VO> list = null;
        try {
            if (query.getFlag()) {
                PageHelper.startPage(query.getPageNum(), query.getPageSize());
            }

            list = ${tableNameFormatOnCase}HandleDao.queryList(example);
            result.setSuccess(true);
            result.setResults(list);
            result.setErrorCode(ResponseEnum.CODE_0000.getCode());
        } catch (Exception e) {
            logger.info("${tableNameFormat}ServiceImpl.queryList error: {}", e);
        }
        return result;
    }

    @Override
    public SingleResult<${tableNameFormat}DTO> querySingle(Integer ${tableNameFormatOnCase}Id) {
        SingleResult<${tableNameFormat}DTO> result = new SingleResult<>();
        try {
            ${tableNameFormat}Example example = new ${tableNameFormat}Example();
            ${tableNameFormat}Example.Criteria criteria = example.createCriteria();
            criteria.and${fristColumnNameUpperCase}EqualTo(Integer ${tableNameFormatOnCase}Id);

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

