
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = ${tableNameFormat}Controller.PARENT_URL)
public class ${tableNameFormat}Controller extends BaseController {

	protected final static String PARENT_URL = "/${URL}/${tableNameFormatOnCase}";

	private Logger logger = LoggerFactory.getLogger(${tableNameFormat}Controller.class);

	@Autowired
	private ${tableNameFormat}Service ${tableNameFormatOnCase}Service;
	/**
	 * @Title: indexView
	 * @Description: 首页视图
	 * @param model 模型
	 * @param request 请求头
	 * @param query 查询对象
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String indexView(Model model, HttpServletRequest request, ${tableNameFormat}Query query) {
		QueryResult<${tableNameFormat}DTO> result = ${tableNameFormatOnCase}Service.queryList(query);
        <#list searchVos as searchVo >
        <#if searchVo.type == "select">
        model.addAttribute("${searchVo.items}", ${searchVo.items}.values());
        </#if></#list>
        model.addAttribute("source", result);
        model.addAttribute("query", query);
        model.addAttribute("menuRight", menuRight(PARENT_URL));
        model.addAttribute("searchParams", searchParams(query));
        return PARENT_URL + "/index";
    }

    /**
    * @Description: 新增页面
    * @param model 模型
    * @return
    */
    @RequestMapping(value = "/addView", method = RequestMethod.GET)
    public String addView(Model model) {
        return PARENT_URL + "/add";
    }

    /**
    * @Title: addSub
    * @Description: 新增提交
    * @param advert 新增实体
    * @return
    */
    @RequestMapping(value = "/addSub", method = RequestMethod.POST)
    @ResponseBody
    public String subSubmit(${tableNameFormat}DTO ${tableNameFormatOnCase}DTO,HttpServletRequest request) {
        ReturnJsonVO json = new ReturnJsonVO();
        try {
            Result result = ${tableNameFormatOnCase}Service.insert(${tableNameFormatOnCase}DTO);

            if (result.isSuccess()){
                json.setMessage(ViewMsgConstant.ADD_SUCCEED);
            } else {
                json.setStatus(ViewMsgConstant.DEFEATED_CODE);
                json.setMessage(ViewMsgConstant.ADD_DEFEATED);
            }
        } catch (Exception e) {
            json.setStatus(ViewMsgConstant.DEFEATED_CODE);
            json.setMessage(ViewMsgConstant.ADD_DEFEATED);
            logger.warn("${tableNameFormat}Controller " + ViewMsgConstant.ADD_DEFEATED);
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return JSONArray.fromObject(json).toString();
    }

    /**
    * @Description: 编辑界面视图
    * @param request 请求头
    * @param id 实体id
    * @param model 模型
    * @return
    */
    @RequestMapping(value = "/editView")
    public String editView(HttpServletRequest request, Long id, Model model) {
        SingleResult<${tableNameFormat}DTO> singleResult = ${tableNameFormatOnCase}Service.getSingleById(id);
        model.addAttribute("${tableNameFormatOnCase}", singleResult.getResult());
        return PARENT_URL + "/edit";
    }

    /**
    * @Description: 编辑提交
    * @param ${tableNameFormatOnCase}DTO
    * @return
    */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public String edit(${tableNameFormat}DTO ${tableNameFormatOnCase}DTO) {
        ReturnJsonVO json = new ReturnJsonVO();
        try {
            result = advertService.update(advert);
            if (result.isSuccess()) {
                json.setMessage(ViewMsgConstant.EDIT_SUCCEED);
                json.setStatus(ViewMsgConstant.SUCCEED_CODE);
            } else {
                json.setStatus(ViewMsgConstant.DEFEATED_CODE);
                json.setMessage(ViewMsgConstant.EDIT_DEFEATED);
            }
        } catch (Exception e) {
        json.setStatus(ViewMsgConstant.DEFEATED_CODE);
        json.setMessage(ViewMsgConstant.EDIT_DEFEATED);
        logger.warn("errorcode " + ViewMsgConstant.EDIT_DEFEATED);
        logger.error(e.getMessage());
        }
        return JSONArray.fromObject(json).toString();
    }
}