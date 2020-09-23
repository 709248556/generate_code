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
        ${tableNameFormat}${leftTableNameFormat}Query, ${tableNameFormat}${leftTableNameFormat}QueryRepository,
        ${tableNameFormat}Input, ${tableNameFormat}Input,
        ${tableNameFormat}Output, ${tableNameFormat}Output>
        implements ${tableNameFormat}Service {

    @Override
    public String getModuleName() {
        return "${tableRemark}管理";
    }

    /**
     * @Description: 默认排序
     * @Param: [query]
     */
    @Override
    protected void queryByOrder(EntityQueryWrapper<${tableNameFormat}${tableNameFormat}Query> query) {
        query.lambda().orderByDescending(${tableNameFormat}${tableNameFormat}Query::getCreatedAt);
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
     * @param input
     * @return
     */
    @Override
    @Transactional(rollbackFor = SpException.class)
    public ${tableNameFormat}Output deleteById(BaseIdDto input) {
        ${tableNameFormat} ${tableNameFormatOnCase} = this.getEntity(input.getId());
        ${tableNameFormatOnCase}.setDelete(BussEnum.IsDelEnum.删除.getCode());
        ${tableNameFormat}Output ${tableNameFormatOnCase}Output = AutoMapUtils.map(${tableNameFormatOnCase}, ${tableNameFormat}Output.class);
        this.update(${tableNameFormatOnCase}Output);
        return ${tableNameFormatOnCase}Output;
    }

    /***
     * @Description: 分页查询列表
     * @param input
     * @return
     */
    @Override
    @Transactional(rollbackFor = SpException.class)
    public PageResult<${tableNameFormat}Output> queryListPage(${tableNameFormat}SelectDto input) {
        PageQueryBuilder<${tableNameFormat}${leftTableNameFormat}Query> query = new PageQueryBuilder<>(this.getQueryEntityClass());
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

    /***
     * @Description: 查询所有
     * @param input
     * @return
     */
    @Override
    @Transactional(rollbackFor = SpException.class)
    public List<${tableNameFormat}Output> queryAll(${tableNameFormat}SelectDto input) {
        EntityQueryWrapper<${tableNameFormat}${leftTableNameFormat}Query> wrapper = new EntityQueryWrapper<>(this.getQueryEntityClass());
        //TODO 搜索条件
        List<${tableNameFormat}${leftTableNameFormat}Query> ${tableNameFormatOnCase}List = this.getQueryRepository().selectForList(wrapper);
        return AutoMapUtils.mapForList(${tableNameFormatOnCase}List, ${tableNameFormat}Output.class);
    }
}

