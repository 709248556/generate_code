import com.autumn.mybatis.mapper.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/${tableNameFormatOnCase}")
@Api(tags = "${tableRemark}管理")
@RequiresUser
public class ${tableNameFormat}Controller {

	@Autowired
	private ${tableNameFormat}Service ${tableNameFormatOnCase}Service;

    @ApiOperation(value = "添加${tableRemark}信息")
    @ApiResponses(value = {@ApiResponse(code = 1000, message = "OK")})
    @PostMapping("/add")
    public ${tableNameFormat}Output add(@Valid @RequestBody ${tableNameFormat}Input ${tableNameFormatOnCase}Input){
        return ${tableNameFormatOnCase}Service.add(${tableNameFormatOnCase}Input);
    }

    @ApiOperation(value = "编辑${tableRemark}信息")
    @ApiResponses(value = {@ApiResponse(code = 1000, message = "OK")})
    @PostMapping("/update")
    public ${tableNameFormat}Output update(@Valid @RequestBody  ${tableNameFormat}Input ${tableNameFormatOnCase}Input){
        return ${tableNameFormatOnCase}Service.update(${tableNameFormatOnCase}Input);
    }
    @ApiOperation(value = "删除${tableRemark}信息")
    @ApiResponses(value = {@ApiResponse(code = 1000, message = "OK")})
    @PostMapping("/deleteById")
    public ${tableNameFormat}Output update(@Valid @RequestBody BaseIdDto input){
        return ${tableNameFormatOnCase}Service.delete(input);
    }

    @ApiOperation(value = "获取${tableRemark}信息详情")
    @ApiResponses(value = {@ApiResponse(code = 1000, message = "OK")})
    @GetMapping("/queryById")
    public ${tableNameFormat}Output queryById(@Valid BaseIdDto input) {
        return ${tableNameFormatOnCase}Service.queryById(input.getId());
    }

    @ApiOperation(value = "获取${tableRemark}信息列表")
    @ApiResponses(value = {@ApiResponse(code = 1000, message = "OK")})
    @GetMapping("/list")
    public PageResult<${tableNameFormat}Output> queryListForCusPage(@Valid ${tableNameFormat}SelectDto input) {
    return ${tableNameFormatOnCase}Service.queryListForCusPage(input);
    }
}