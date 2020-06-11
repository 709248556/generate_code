import com.autumn.application.service.EditApplicationService;
import com.autumn.mybatis.mapper.PageResult;

/**
 * @Description:${tableRemark}管理服务
 * @author yanlianglong
 * @date ${.now?date}
 */
public interface ${tableNameFormat}Service extends
        EditApplicationService<Long, ${tableNameFormat}Input, ${tableNameFormat}Input, ${tableNameFormat}Output, ${tableNameFormat}Output>{

    /**
     * 删除
     *
     * @param input
     * @return
     */
    ${tableNameFormat}Output deleteById(BaseIdDto input);

    /**
     * 分页查找列表
     *
     * @param input
     * @return
     */
    PageResult<${tableNameFormat}Output> queryListPage(${tableNameFormat}SelectDto input);
}

