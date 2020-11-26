import com.autumn.domain.entities.auditing.user.gmt.AbstractDefaultUserGmtFullAuditingEntity;
import com.autumn.domain.entities.auditing.SoftDelete;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;
import com.autumn.audited.annotation.LogMessage;

/**  
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@ToString(callSuper = true)
@Getter
@Setter
@Table(name = "${tableName}")
public class ${tableNameFormat} extends AbstractDefaultUserGmtFullAuditingEntity implements SpEntity,SoftDelete{

	private static final long serialVersionUID = ${serialVersionUID1}L ;
<#assign i = 1>
<#list baseResultMapVoList as baseResultMapVo >
	<#if baseResultMapVo.property =="id">
	@LogMessage(name = "id",order = ${i})<#assign i = i + 1>
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Override
	public Long getId() {
		return super.getId();
	}

	<#elseif baseResultMapVo.property == "isDelete">
	/**
     * 是否删除
     */
    private boolean delete;

	<#else>
	/**
	 * ${baseResultMapVo.columnComment}
	 */
	@LogMessage(name = "${baseResultMapVo.columnComment}",order = ${i})<#assign i = i + 1>
	private ${baseResultMapVo.DTOType} ${baseResultMapVo.property};

	</#if>
</#list>
}
