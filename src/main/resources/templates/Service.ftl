import com.autumn.application.service.EditApplicationService;
import com.autumn.mybatis.mapper.PageResult;

/**
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
public interface ${tableNameFormat}Service extends
        EditApplicationService<Long, ${tableNameFormat}Input, ${tableNameFormat}Input, ${tableNameFormat}Output, ${tableNameFormat}Output>{

    /**
     * 分页查找列表
     *
     * @param input
     * @return
     */
    PageResult<${tableNameFormat}Output> queryListPage(${tableNameFormat}SelectDto input);
}

