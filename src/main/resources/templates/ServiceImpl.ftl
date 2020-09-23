import com.autumn.mybatis.mapper.PageResult;
import com.autumn.mybatis.wrapper.EntityQueryWrapper;
import com.autumn.util.AutoMapUtils;
import com.autumn.util.StringUtils;
import com.autumn.util.data.PageQueryBuilder;
import com.zjsm.sp.application.services.AbstractSpEditApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.autumn.exception.SpException;

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


    @Autowired
    private RedisService redisService;

    @Override
    public String getModuleName() {
        return "${tableRemark}管理";
    }

    @Override
    protected void queryByOrder(EntityQueryWrapper<${tableNameFormat}> query) {
        query.lambda().orderByDescending(${tableNameFormat}::getId);
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
     * 添加之后的处理
     *
     */
    @Override
    protected ${tableNameFormat}Output addAfter(${tableNameFormat}Input input,${tableNameFormat} ${tableNameFormatOnCase},EntityQueryWrapper<${tableNameFormat}> query) {
        ${tableNameFormat}Output ${tableNameFormatOnCase}Output = super.addAfter(input,${tableNameFormatOnCase},query);
        redisService.delete(RedisConstant.${REDIS_CONSTANT}_ALL);
        return ${tableNameFormatOnCase}Output;
    }

    /**
     * 更新之前的操作
     */
    @Override
    protected void updateBefore(${tableNameFormat}Input input,${tableNameFormat} entity,EntityQueryWrapper<${tableNameFormat}> wrapper) {
        super.updateBefore(input,entity,wrapper);
    }

    /**
    * 更新之后的操作
    */
    @Override
    protected ${tableNameFormat}Output updateAfter(${tableNameFormat}Input input,${tableNameFormat} newEntity,${tableNameFormat} oldEntity,EntityQueryWrapper<${tableNameFormat}> wrapper) {
        redisService.delete(RedisConstant.${REDIS_CONSTANT}_ALL);
        return super.updateAfter(input,newEntity,oldEntity,wrapper);
    }

    /***
     * @Description: 分页查询列表
     * @param input
     * @return
     */
    @Override
    @Transactional(rollbackFor = SpException.class)
    public PageResult<${tableNameFormat}Output> queryListPage(${tableNameFormat}SelectDto input) {
        PageQueryBuilder<${tableNameFormat}> query = new PageQueryBuilder<>(this.getQueryEntityClass());
        this.generateQueryListColumn(query.getQuery());
        this.systemByCriteria(query.getQuery());
        this.queryByOrder(query.getQuery());
        query.page(input.getCurrentPage(), input.getPageSize());
<#list selectDTOs as selectDTO >
    <#list baseResultMapVoList as baseResultMapVo >
        <#if selectDTO == baseResultMapVo.column>
        <#if "String" == baseResultMapVo.DTOType>
        if (StringUtils.isNotNullOrBlank(input.get${baseResultMapVo.columnNameUpperCase}())) {
            query.getQuery().lambda().where().like(${tableNameFormat}::get${baseResultMapVo.columnNameUpperCase}, input.get${baseResultMapVo.columnNameUpperCase}().trim());
        }
        </#if>
        <#if "Long" == baseResultMapVo.DTOType||"Integer" == baseResultMapVo.DTOType>
        if (input.get${baseResultMapVo.columnNameUpperCase}()!= null) {
            query.getQuery().lambda().where().eq(${tableNameFormat}::get${baseResultMapVo.columnNameUpperCase}, input.get${baseResultMapVo.columnNameUpperCase}());
        }
        </#if>
        </#if>
    </#list>
</#list>
        return query.toPageResult(getQueryRepository(), this.getOutputItemClass(), this::itemConvertHandle);
    }
}

