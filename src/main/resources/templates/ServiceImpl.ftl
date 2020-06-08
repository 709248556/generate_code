import com.autumn.mybatis.mapper.PageResult;
import com.autumn.mybatis.wrapper.EntityQueryWrapper;
import com.autumn.util.AutoMapUtils;
import com.autumn.util.StringUtils;
import com.autumn.util.data.PageQueryBuilder;
import com.zjsm.sp.application.services.AbstractSpEditApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@Service
public class ${tableNameFormat}ServiceImpl extends AbstractSpEditApplicationService<
        ${tableNameFormat},
        ${tableNameFormat}Repository,
        ${tableNameFormat}, ${tableNameFormat}Repository,
        ${tableNameFormat}Input, ${tableNameFormat}Input,
        ${tableNameFormat}Output, ${tableNameFormat}Output>
        implements ${tableNameFormat}Service {

    @Override
    public String getModuleName() {
        return "${tableRemark}管理";
    }

    @Override
    protected void queryByOrder(EntityQueryWrapper<${tableNameFormat}> query) {
        query.lambda().orderByDescending(${tableNameFormat}::getCreatedAt);
    }

    /**
     * 添加之前的处理
     *
     * @param input
     * @param query
     * @return
     */
    @Override
    protected ${tableNameFormat} addBefore(${tableNameFormat}Input input, EntityQueryWrapper<${tableNameFormat}> query) {
        ${tableNameFormat} ${tableNameFormatOnCase} = super.addBefore(input, query);

        return ${tableNameFormatOnCase};
    }

    /**
    * @Description: 删除
    * @Author: yanlianglong
    * @Date: ${.now?date}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ${tableNameFormat}Output delete(BaseIdDto input) {
        ${tableNameFormat} ${tableNameFormatOnCase} = this.getEntity(input.getId());
        ${tableNameFormatOnCase}.setDelete(BussEnum.IsDelEnum.删除.getCode());
        this.getRepository().update(${tableNameFormatOnCase});
        return AutoMapUtils.map(${tableNameFormatOnCase}, ${tableNameFormat}Output.class);
    }

    /***
    * @Description: 分页查询列表
    * @Author: yanlianglong
    * @Date: @Date: ${.now?date}
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageResult<${tableNameFormat}Output> queryListForCusPage(${tableNameFormat}SelectDto input) {
        PageQueryBuilder<${tableNameFormat}> query = new PageQueryBuilder<>(this.getQueryEntityClass());
        this.generateQueryListColumn(query.getQuery());
        this.systemByCriteria(query.getQuery());
        this.queryByOrder(query.getQuery());
        query.page(input.getCurrentPage(), input.getPageSize());
        //名称
        if (StringUtils.isNotNullOrBlank(input.getName())) {
            query.getQuery().lambda().where().like(${tableNameFormat}::getName, input.getName().trim());
        }
        return query.toPageResult(getQueryRepository(), this.getOutputItemClass(), this::itemConvertHandle);
    }
}

