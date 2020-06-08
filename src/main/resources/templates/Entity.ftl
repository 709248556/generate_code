import com.autumn.domain.entities.AbstractDefaultEntity;
import com.autumn.domain.entities.auditing.SoftDelete;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**  
* @Description:
* @author yanlianglong
* @date ${.now?date}
*/
@ToString(callSuper = true)
@Getter
@Setter
@Table(name = "${tableName}")
public class ${tableNameFormat} extends AbstractDefaultEntity implements SpEntity,SoftDelete{

	private static final long serialVersionUID = ${serialVersionUID1}L ;
<#list baseResultMapVoList as baseResultMapVo >
	<#if baseResultMapVo.property =="id">
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Override
	public Long getId() {
		return super.getId();
	}

	/**
	* id
	*/
    private ${baseResultMapVo.DTOType} ${baseResultMapVo.property};

	<#else>
	/**
	* ${baseResultMapVo.columnComment}
	*/
	private ${baseResultMapVo.DTOType} ${baseResultMapVo.property};

	</#if>
</#list>
	/**
     * 是否删除
     */
    private boolean delete;
}
