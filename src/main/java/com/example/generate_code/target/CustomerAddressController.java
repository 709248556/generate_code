
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
@RequestMapping(value = CustomerAddressController.PARENT_URL)
public class CustomerAddressController extends BaseController {

	protected final static String PARENT_URL = "/customer/address";

	private Logger logger = LoggerFactory.getLogger(CustomerAddressController.class);

	@Autowired
	private CustomerAddressService customerAddressService;
	/**
	 * @Title: indexView
	 * @Description: 首页视图
	 * @param model 模型
	 * @param request 请求头
	 * @param query 查询对象
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String indexView(Model model, HttpServletRequest request, CustomerAddressQuery query) {
		QueryResult<CustomerAddressDTO> result = customerAddressService.queryList(query);
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
    public String subSubmit(CustomerAddressDTO customerAddressDTO,HttpServletRequest request) {
        ReturnJsonVO json = new ReturnJsonVO();
        try {
            Result result = customerAddressService.insert(customerAddressDTO);

            if (result.isSuccess()){
                json.setMessage(ViewMsgConstant.ADD_SUCCEED);
            } else {
                json.setStatus(ViewMsgConstant.DEFEATED_CODE);
                json.setMessage(ViewMsgConstant.ADD_DEFEATED);
            }
        } catch (Exception e) {
            json.setStatus(ViewMsgConstant.DEFEATED_CODE);
            json.setMessage(ViewMsgConstant.ADD_DEFEATED);
            logger.warn("CustomerAddressController " + ViewMsgConstant.ADD_DEFEATED);
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
        SingleResult<CustomerAddressDTO> singleResult = customerAddressService.querySingle(id);
        model.addAttribute("customerAddress", singleResult.getResult());
        return PARENT_URL + "/edit";
    }

    /**
    * @Description: 编辑提交
    * @param customerAddressDTO
    * @return
    */
    @RequestMapping(value = "/editSub")
    @ResponseBody
    public String edit(CustomerAddressDTO customerAddressDTO) {
        ReturnJsonVO json = new ReturnJsonVO();
        try {
            Result result = customerAddressService.update(customerAddressDTO);
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
    * @Description: 删除
    * @param request 请求头
    * @param id 实体id
    * @param model 模型
    * @return
    */
    @ResponseBody
    @PostMapping(value = "/deleteCustomerAddress")
    public String deleteNotice(HttpServletRequest request, Long id, Model model) {
    ReturnJsonVO json = new ReturnJsonVO();
    try {
    Result result = customerAddressService.deleteById(id);
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
    * @param id 实体id
    * @param model 模型
    * @return
    */
    @RequestMapping(value = "/detailView")
    public String detailView(HttpServletRequest request, Long id, Model model) {
        SingleResult<CustomerAddressDTO> singleResult = customerAddressService.querySingle(id);
        model.addAttribute("systemNotice",singleResult.getResult() );
        return PARENT_URL + "/detail";
        }
}