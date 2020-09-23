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
public class ${tableNameFormat}AppServiceImpl extends AbstractSpEditApplicationService<
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

    /**
     * @Description: 默认排序
     * @Param: [query]
     */
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
        PageResult<${tableNameFormat}Output> redisResult = queryFromRedisByPage(input);
        if (redisResult != null) {
            return redisResult;
        }
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
        PageResult<${tableNameFormat}Output> result =query.toPageResult(getQueryRepository(), this.getOutputItemClass(), this::itemConvertHandle);
        return result;
    }

    /**
    * 创建过滤条件
    *
    * @param stream
    * @param input
    * @return
    */
    @Override
    protected Stream<${tableNameFormat}Output> stream(Stream<${tableNameFormat}Output> stream,Object input) {
        ${tableNameFormat}SelectDto selectDto = (${tableNameFormat}SelectDto) input;
        // 名称
        //if (StringUtils.isNotNullOrBlank(selectDto.getArea())) {
        //stream = stream.filter(item ->
        //item.getArea().contains(selectDto.getArea().trim()));
        //}
        // 类型
        //if (selectDto.getTypeId() != null && selectDto.getTypeId() != 0) {
        //stream = stream.filter(item ->
        //item.getTypeId().equals(selectDto.getTypeId()));
        }
        return stream;
    }

    /**
     * 查询所有
     * @param input
     * @return
     */
    @Override
    @Transactional(rollbackFor = SpException.class)
    public List<${tableNameFormat}Output> queryAll(${tableNameFormat}SelectDto input) {
        List<${tableNameFormat}Output> redisList = redisService.rangeListAll(RedisConstant.${REDIS_CONSTANT}_ALL);
        if (redisList != null && redisList.size() > 0) {
            return list;
        }
        EntityQueryWrapper<${tableNameFormat}> wrapper = new EntityQueryWrapper<>(this.getQueryEntityClass());
        List<${tableNameFormat}> list = this.getQueryRepository().selectForList(wrapper);
        List<${tableNameFormat}Output> result = AutoMapUtils.mapForList(list,${tableNameFormat}Output.class);
        //没有，则存进redis
        if (redisList == null || redisList.size() == 0) {
            redisService.rightPushAll(RedisConstant.${REDIS_CONSTANT}_ALL,result);
        }
        return result;
    }

    /**
    * 获取缓存前缀（列表）
    *
    * @return
    */
    @Override
    protected String redisConstantAll() {
        return RedisConstant.${REDIS_CONSTANT}_ALL;
    }
}

