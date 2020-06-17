import com.autumn.domain.repositories.DefaultEntityRepository;
import com.autumn.mybatis.mapper.annotation.MapperViewSelect;
import org.springframework.stereotype.Repository;

/**  
* @author yanlianglong
* @date ${.now?date}
*/
@Repository
@MapperViewSelect("SELECT ${tableShortName}.*,<#list leftVO.name as name >${leftTableShortName}.${name} as ${leftTableNameFormatSub}_${name} </#list>FROM ${tableName} ${tableShortName} LEFT JOIN ${leftTableName} ${leftTableShortName}  ON ${leftTableShortName}.id = ${tableShortName}.${leftVO.leftJoinON} ")
public interface ${tableNameFormat}${leftTableNameFormat}QueryRepository extends DefaultEntityRepository<${tableNameFormat}${leftTableNameFormat}Query>{

}
