import com.autumn.application.service.EditApplicationService;
import com.autumn.mybatis.mapper.PageResult;

/**
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
public interface ${tableNameFormat}Service extends
        TreeAppService<Long, ${tableNameFormat}Input, ${tableNameFormat}Input, ${tableNameFormat}Output, ${tableNameFormat}Output>{

    /**
     * 删除
     *
     * @param input
     * @return
     */
    ${tableNameFormat}Output deleteById(BaseIdDto input);

    /**
    * 查询
    *
    * @param input
    * @return
    */
    List<${tableNameFormat}Output> queryAll(${tableNameFormat}SelectDto input);
}

