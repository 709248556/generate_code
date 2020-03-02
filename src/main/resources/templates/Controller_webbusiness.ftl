
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
public class ${tableNameFormat}Controller extends BasicController {

	private Logger logger = LoggerFactory.getLogger(${tableNameFormat}Controller.class);

	@Autowired
	private ${tableNameFormat}Component ${tableNameFormatOnCase}Component;

    @GetMapping(value = "${URL}/insert${tableNameFormatOnCase}")
	@SentinelResource(value = "insert", fallback = "handleFallback", fallbackClass = SentinelException.class, blockHandler = "handleBlock", blockHandlerClass = SentinelException.class)
	@ApiOperation(value = "插入信息", response = MsgRoot.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "${tableNameFormat}DTO", value = "对象", paramType = "from", required = true, dataType = "${tableNameFormat}DTO") })
	public String insert(${tableNameFormat}DTO record) {
        MsgRoot msgRoot = new MsgRoot();
		MsgHead msgHead = new MsgHead();
		msgRoot.setHead(msgHead);
		Result result = ${tableNameFormatOnCase}Component.insert(record);
		msgRoot.setBody(result);
		return JSONObject.toJSONString(msgRoot);
    }

    @GetMapping(value = "${URL}/delete${tableNameFormat}DTO/{${tableNameFormatOnCase}Id}")
	@SentinelResource(value = "delete", fallback = "handleFallback", fallbackClass = SentinelException.class, blockHandler = "handleBlock", blockHandlerClass = SentinelException.class)
	@ApiOperation(value = "删除信息", response = MsgRoot.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "${tableNameFormatOnCase}Id", value = "编号", paramType = "from", required = true, dataType = "Integer") })
	public String delete(@PathVariable("${tableNameFormatOnCase}Id") Integer ${tableNameFormatOnCase}Id) {
        MsgRoot msgRoot = new MsgRoot();
		MsgHead msgHead = new MsgHead();
		msgRoot.setHead(msgHead);
		Result result = ${tableNameFormatOnCase}Component.delete(${tableNameFormatOnCase}Id);
		msgRoot.setBody(result);
		return JSONObject.toJSONString(msgRoot);
    }

    @PostMapping(value = "${URL}/update${tableNameFormat}DTO")
	@SentinelResource(value = "update", fallback = "handleFallback", fallbackClass = SentinelException.class, blockHandler = "handleBlock", blockHandlerClass = SentinelException.class)
	@ApiOperation(value = "修改信息", response = MsgRoot.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "${tableNameFormat}DTO", value = "对象", paramType = "from", required = true, dataType = "${tableNameFormat}DTO") })
	public String update(${tableNameFormat}DTO record) {
		MsgRoot msgRoot = new MsgRoot();
		MsgHead msgHead = new MsgHead();
		msgRoot.setHead(msgHead);
		Result result = ${tableNameFormatOnCase}Component.update(record);
		msgRoot.setBody(result);
		return JSONObject.toJSONString(msgRoot);
	}



    @PostMapping(value = "${URL}/queryList")
	@SentinelResource(value = "queryList", fallback = "handleFallback", fallbackClass = SentinelException.class, blockHandler = "handleBlock", blockHandlerClass = SentinelException.class)
	@ApiOperation(value = "获取信息列表", response = MsgRoot.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "${tableNameFormat}Query", value = "查询对象", paramType = "from", required = true, dataType = "${tableNameFormat}Query")})
	public String queryList(${tableNameFormat}Query query) {
		MsgRoot msgRoot = new MsgRoot();
		MsgHead msgHead = new MsgHead();
		msgRoot.setHead(msgHead);
		List<${tableNameFormat}DTO> list = ${tableNameFormatOnCase}Component.queryList(query);
        msgRoot.setBody(list);
        return JSONObject.toJSONString(msgRoot);
    }

    @GetMapping(value = "${URL}/querySingle/{${tableNameFormatOnCase}Id}")
    @SentinelResource(value = "querySingle", fallback = "handleFallback", fallbackClass = SentinelException.class, blockHandler = "handleBlock", blockHandlerClass = SentinelException.class)
    @ApiOperation(value = "获取信息", response = MsgRoot.class)
    @ApiImplicitParams({ @ApiImplicitParam(name = "${tableNameFormatOnCase}Id", value = "编号", paramType = "path", required = true, dataType = "Integer")})
    public String querySingle(@PathVariable Integer ${tableNameFormatOnCase}Id) {
    MsgRoot msgRoot = new MsgRoot();
    MsgHead msgHead = new MsgHead();
    msgRoot.setHead(msgHead);
    ${tableNameFormat}DTO ${tableNameFormat} = ${tableNameFormatOnCase}Component.querySingle(${tableNameFormatOnCase}Id);
    msgRoot.setBody(${tableNameFormat});
    return JSONObject.toJSONString(msgRoot);
    }
}