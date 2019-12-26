
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
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = LiquidationHisController.PARENT_URL)
public class LiquidationHisController extends BaseController {

	protected final static String PARENT_URL = "/liquidation/his";

	private Logger logger = LoggerFactory.getLogger(LiquidationHisController.class);

	@Autowired
	private LiquidationHisService liquidationHisService;
	/**
	 * @Title: indexView
	 * @Description: 首页视图
	 * @param model 模型
	 * @param request 请求头
	 * @param query 查询对象
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String indexView(Model model, HttpServletRequest request, LiquidationHisQuery query) {
		QueryResult<LiquidationHisDTO> result = liquidationHisService.queryList(query);
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
    * @param liquidationHisDTO 新增实体
    * @return
    */
    @RequestMapping(value = "/addSub", method = RequestMethod.POST)
    @ResponseBody
    public String subSubmit(LiquidationHisDTO liquidationHisDTO,HttpServletRequest request) {
        ReturnJsonVO json = new ReturnJsonVO();
        try {
            Result result = liquidationHisService.insert(liquidationHisDTO);

            if (result.isSuccess()){
                json.setMessage(ViewMsgConstant.ADD_SUCCEED);
            } else {
                json.setStatus(ViewMsgConstant.DEFEATED_CODE);
                json.setMessage(ViewMsgConstant.ADD_DEFEATED);
            }
        } catch (Exception e) {
            json.setStatus(ViewMsgConstant.DEFEATED_CODE);
            json.setMessage(ViewMsgConstant.ADD_DEFEATED);
            logger.warn("LiquidationHisController " + ViewMsgConstant.ADD_DEFEATED);
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return JSONArray.fromObject(json).toString();
    }

    /**
    * @Description: 编辑界面视图
    * @param request 请求头
    * @param query 查询对象
    * @param model 模型
    * @return
    */
    @RequestMapping(value = "/editView")
    public String editView(HttpServletRequest request,LiquidationHisQuery query, Model model) {
        SingleResult<LiquidationHisDTO> singleResult = liquidationHisService.querySingle(query);
        model.addAttribute("liquidationHis", singleResult.getResult());
        return PARENT_URL + "/edit";
    }

    /**
    * @Description: 编辑提交
    * @param liquidationHisDTO
    * @return
    */
    @RequestMapping(value = "/editSub")
    @ResponseBody
    public String edit(LiquidationHisDTO liquidationHisDTO) {
        ReturnJsonVO json = new ReturnJsonVO();
        try {


            Result result = liquidationHisService.update(liquidationHisDTO);
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

    /**
    * @Description: 冻结提交
    * @param liquidationHisDTO
    * @return
    */
    @RequestMapping(value = "/freezeLiquidationHis")
    @ResponseBody
    public String freeze(LiquidationHisDTO liquidationHisDTO) {
        ReturnJsonVO json = new ReturnJsonVO();
        try {


            Result result = liquidationHisService.update(liquidationHisDTO);
            if (result.isSuccess()) {
                json.setMessage(ViewMsgConstant.CHANGE_SUCCEED);
                json.setStatus(ViewMsgConstant.SUCCEED_CODE);
            } else {
                json.setStatus(ViewMsgConstant.DEFEATED_CODE);
                json.setMessage(ViewMsgConstant.CHANGE_DEFEATED);
            }
        } catch (Exception e) {
            json.setStatus(ViewMsgConstant.DEFEATED_CODE);
            json.setMessage(ViewMsgConstant.CHANGE_DEFEATED);
            logger.warn("errorcode " + ViewMsgConstant.CHANGE_DEFEATED);
            logger.error(e.getMessage());
        }
        return JSONArray.fromObject(json).toString();
    }

    /**
    * @Description: 解冻提交
    * @param liquidationHisDTO
    * @return
    */
    @RequestMapping(value = "/thawLiquidationHis")
    @ResponseBody
    public String thaw(LiquidationHisDTO liquidationHisDTO) {
        ReturnJsonVO json = new ReturnJsonVO();
        try {

            Result result = liquidationHisService.update(liquidationHisDTO);
            if (result.isSuccess()) {
                json.setMessage(ViewMsgConstant.CHANGE_SUCCEED);
                json.setStatus(ViewMsgConstant.SUCCEED_CODE);
            } else {
                json.setStatus(ViewMsgConstant.DEFEATED_CODE);
                json.setMessage(ViewMsgConstant.CHANGE_DEFEATED);
            }
        } catch (Exception e) {
            json.setStatus(ViewMsgConstant.DEFEATED_CODE);
            json.setMessage(ViewMsgConstant.CHANGE_DEFEATED);
            logger.warn("errorcode " + ViewMsgConstant.CHANGE_DEFEATED);
            logger.error(e.getMessage());
        }
        return JSONArray.fromObject(json).toString();
    }

    /**
    * @Description: 删除
    * @param request 请求头
    * @param id 实体id
    * @param model 模型
    * @return
    */
    @ResponseBody
    @PostMapping(value = "/deleteLiquidationHis")
    public String deleteNotice(HttpServletRequest request, Long id, Model model) {
        ReturnJsonVO json = new ReturnJsonVO();
        try {
            Result result = liquidationHisService.deleteById(id);
            if (result.isSuccess()) {
                json.setMessage(ViewMsgConstant.DELETE_SUCCEED);
                json.setStatus(ViewMsgConstant.SUCCEED_CODE);
            } else {
                json.setStatus(ViewMsgConstant.DEFEATED_CODE);
                json.setMessage(ViewMsgConstant.DELETE_DEFEATED);
            }
        } catch (Exception e) {
            json.setStatus(ViewMsgConstant.DEFEATED_CODE);
            json.setMessage(ViewMsgConstant.DELETE_DEFEATED);
            logger.warn("errorcode " + ViewMsgConstant.DELETE_DEFEATED);
            logger.error(e.getMessage());
        }
        return JSONArray.fromObject(json).toString();
    }

    /**
    * @Description: 详情页面
    * @param request 请求头
    * @param query 查询对象
    * @param model 模型
    * @return
    */
    @RequestMapping(value = "/detailView")
    public String detailView(HttpServletRequest request, LiquidationHisQuery query, Model model) {
        SingleResult<LiquidationHisDTO> singleResult = liquidationHisService.querySingle(query);
        model.addAttribute("liquidationHis",singleResult.getResult() );
        return PARENT_URL + "/detail";
    }
}