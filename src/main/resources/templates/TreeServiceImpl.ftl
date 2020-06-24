import com.autumn.mybatis.mapper.PageResult;
import com.autumn.mybatis.wrapper.EntityQueryWrapper;
import com.autumn.util.AutoMapUtils;
import com.autumn.util.StringUtils;
import com.autumn.util.data.PageQueryBuilder;
import com.zjsm.sp.application.services.AbstractSpEditApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.autumn.exception.AutumnException;

/**
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@Service
public class ${tableNameFormat}ServiceImpl extends AbstractTreeAppService<
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
    @Transactional(rollbackFor = AutumnException.class)
    public ${tableNameFormat}Output deleteById(BaseIdDto input) {
        ${tableNameFormat} ${tableNameFormatOnCase} = this.getEntity(input.getId());
        ${tableNameFormatOnCase}.setDelete(BussEnum.IsDelEnum.删除.getCode());
        ${tableNameFormat}Output ${tableNameFormatOnCase}Output = AutoMapUtils.map(${tableNameFormatOnCase}, ${tableNameFormat}Output.class);
        this.update(${tableNameFormatOnCase}Output);
        return ${tableNameFormatOnCase}Output;
    }

    /***
     * @Description: 查询
     * @param input
     * @return
     */
    @Override
    @Transactional(rollbackFor = AutumnException.class)
    public List<${tableNameFormat}Output> queryAll(${tableNameFormat}SelectDto input) {
        EntityQueryWrapper<${tableNameFormat}> wrapper = new EntityQueryWrapper<>(this.getQueryEntityClass());
        //TODO 搜索条件
        wrapper.lambda().where()
                .of().orderByDescending(${tableNameFormat}::getGmtCreate);
        List<${tableNameFormat}> list = this.getRepository().selectForList(wrapper);
        List<${tableNameFormat}Output> outList = AutoMapUtils.mapForList(list,${tableNameFormat}Output.class);
        Collection<${tableNameFormat}Output> tMenus = TreeUtil.toTree(outList, "id", "parentId", "children", ${tableNameFormat}Output.class);
        List<${tableNameFormat}Output> result = new ArrayList<${tableNameFormat}Output>(tMenus);
        return result;
    }
}

