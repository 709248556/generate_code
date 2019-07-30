package com.example.generate_code.controller;

import com.example.generate_code.util.DataUtil;
import com.example.generate_code.util.DatabaseUtil;
import com.example.generate_code.util.FormatUtil;
import com.example.generate_code.vo.BaseResultMapVo;
import com.example.generate_code.vo.SearchVo;
import com.example.generate_code.vo.UniqueIndexVO;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RestController;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

import freemarker.template.Configuration;
import freemarker.template.Template;


@RestController
public class GenerateController {

    private static final String TEMPLATE_PATH = "classpath:templates";
    private static final String TARGET_PATH = "src/main/java/com/example/generate_code/target";
    private static final String URL = "settlement";   //todo
    private static final String TABLE_NAME = "bz_special_rate"; //todo
    private static final  int TABLE_PREFIX_LENGTH = 3;
    private static final String[] SEARCH_NAME = new String[]{"channelId","settleDate","chnlMchNo","settleState"};  //todo
    private static final String[] SEARCH_PLACEHOLDER = new String[]{"请选择渠道","结算日期","渠道商户号","请选择渠道资金转结状态"};  //todo
    private static final String SELECT = "select";
    private static final String INPUT = "input";
    private static final String[] SEARCH_TYPE = new String[]{SELECT,INPUT,INPUT,SELECT};  //todo
    private static final String[] SEARCH_SELECT_VALUE = new String[]{"channelId","value"}; //todo
    private static final String[] SEARCH_SELECT_DESC = new String[]{"channelName","desc"}; //todo
    private static final String[] SEARCH_SELECT_ITEMS = new String[]{"channels","chnlMchSettleStateEnums"};//todo

    public static void main(String[] args) {


        Map<String, Object> dataMap = new HashMap<String, Object>();
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer xmlOut = null;
        Writer DTOOut = null;
        Writer queryOut = null;
        Writer DAOOut = null;
        Writer serviceOut = null;
        Writer serviceImplOut = null;
        Writer controllerlOut = null;
        Writer jspOut = null;
        try {

            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(ResourceUtils.getFile(TEMPLATE_PATH));
            // step3 创建数据模型

            // step4 加载模版文件
            Template xmlTemplate = configuration.getTemplate("Mapper.ftl");
            Template DTOTemplate = configuration.getTemplate("DTO.ftl");
            Template queryTemplate = configuration.getTemplate("Query.ftl");
            Template DAOTemplate = configuration.getTemplate("DAO.ftl");
            Template serviceTemplate = configuration.getTemplate("Service.ftl");
            Template serviceImplTemplate = configuration.getTemplate("ServiceImpl.ftl");
            Template controllerlTemplate = configuration.getTemplate("Controller.ftl");
            Template jspTemplate = configuration.getTemplate("jsp.ftl");

            //获取数据模型
            List<BaseResultMapVo> baseResultMapVoList = DatabaseUtil.getBaseResultMap(TABLE_NAME);
            List<UniqueIndexVO> uniqueIndexVOList = DatabaseUtil.getUniqueIndex(TABLE_NAME);
            dataMap.put("baseResultMapVoList",baseResultMapVoList);
            dataMap.put("uniqueIndexVOList",uniqueIndexVOList);
            dataMap.put("tableNameFormat",FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("tableNameFormatOnCase",FormatUtil._split(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("baseColumnList",DatabaseUtil.getColumnNames(TABLE_NAME));
            dataMap.put("serialVersionUID1",(Math.random() * 9 + 1) * 1000000000000000l);
            dataMap.put("serialVersionUID2",(Math.random() * 9 + 1) * 1000000000000000l);
            dataMap.put("tableName",TABLE_NAME);
            dataMap.put("tableShortName",FormatUtil.getShortName(TABLE_NAME));
            dataMap.put("URL",URL);
            //jsp数据
            getJspDateMap(dataMap);

            // step5 生成数据
            File xmlFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"-Mapper.xml");//TODO
            File DTOFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"DTO.java");
            File queryFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Query.java");
            File DAOFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Dao.java");
            File serviceFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Service.java");
            File serviceImplFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"ServiceImpl.java");
            File ControllerlFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Controller.java");
            File jspFile = new File(TARGET_PATH + "\\" + "index.jsp");

            xmlOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFile)));
            DTOOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DTOFile)));
            queryOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(queryFile)));
            DAOOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DAOFile)));
            serviceOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile)));
            serviceImplOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceImplFile)));
            controllerlOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ControllerlFile)));
            jspOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jspFile)));

            // step6 输出文件
            xmlTemplate.process(dataMap, xmlOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^xml文件创建成功 !");
            DTOTemplate.process(dataMap, DTOOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^DTO文件创建成功 !");
            queryTemplate.process(dataMap, queryOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Query文件创建成功 !");
            DAOTemplate.process(dataMap, DAOOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^DAO文件创建成功 !");
            serviceTemplate.process(dataMap, serviceOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^service文件创建成功 !");
            serviceImplTemplate.process(dataMap, serviceImplOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^serviceImpl文件创建成功 !");
            controllerlTemplate.process(dataMap, controllerlOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^controller文件创建成功 !");
            jspTemplate.process(dataMap, jspOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^jsp文件创建成功 !");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != xmlOut) {
                    xmlOut.flush();
                }
                if (null != DTOOut) {
                    DTOOut.flush();
                }
                if (null != queryOut) {
                    queryOut.flush();
                }
                if (null != DAOOut) {
                    queryOut.flush();
                }
                if (null != serviceOut) {
                    queryOut.flush();
                }
                if (null != serviceImplOut) {
                    queryOut.flush();
                }
                if (null != controllerlOut) {
                    queryOut.flush();
                }
                if (null != jspOut) {
                    queryOut.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void getJspDateMap(Map<String, Object> dataMap){
        List<SearchVo> searchVos = new ArrayList<>();
        for(int i = 0,j = 0;i<SEARCH_NAME.length;i++){
            SearchVo searchVo = new SearchVo();
            searchVo.setName(SEARCH_NAME[i]);
            searchVo.setPlaceholder(SEARCH_PLACEHOLDER[i]);
            searchVo.setType(SEARCH_TYPE[i]);
            if(SELECT.equals(SEARCH_TYPE[i])){
                searchVo.setValue(SEARCH_SELECT_VALUE[j]);
                searchVo.setDesc(SEARCH_SELECT_DESC[j]);
                searchVo.setItems(SEARCH_SELECT_ITEMS[j]);
                j++;
            }
            searchVos.add(searchVo);
        }
        dataMap.put("searchVos",searchVos);
    }
}
