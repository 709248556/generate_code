

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import com.zfull.commons.basic.constant.ServiceNameConst;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: ${tableNameFormat}Service.java
 * @Description:
 * @author yanlianglong
 * @date ${.now?date}
 */
@FeignClient(value = ServiceNameConst.SPP_WEBBUSINESS, fallbackFactory=${tableNameFormat}ServiceFallback.class)
public interface ${tableNameFormat}Service {

    /**
     * 新增
     */
    @PostMapping(value = "${URL}/insert${tableNameFormatOnCase}")
    String insert(@RequestBody ${tableNameFormat}DTO record);

    /**
     * 删除
     */
    @DeleteMapping(value = "${URL}/delete${tableNameFormat}DTO/{${tableNameFormatOnCase}Id}")
    String delete(@PathVariable("${tableNameFormatOnCase}Id") Integer ${tableNameFormatOnCase}Id);

    /**
     * 编辑
     */
    @PutMapping(value = "${URL}/update${tableNameFormat}DTO")
    String update(@RequestBody ${tableNameFormat}DTO record);

    /**
     * 查询
     */
    @PostMapping(value = "${URL}/queryList")
    String queryList(@RequestBody ${tableNameFormat}Query query);

    /**
    * 单个查询
    */
    @GetMapping(value = "${URL}/querySingle/{${tableNameFormatOnCase}Id}")
    String querySingle(@PathVariable Integer ${tableNameFormatOnCase}Id);
}

