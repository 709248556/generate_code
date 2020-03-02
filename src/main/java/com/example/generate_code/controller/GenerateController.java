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
    private static final String TARGET_PATH_ADMIN = "src/main/java/com/example/generate_code/target/admin";
    private static final String TARGET_PATH_WEBBUSINESS = "src/main/java/com/example/generate_code/target/webbusiness";
//    private static final String PARENT_URL = "card";   //todo
    private static final String TABLE_NAME = "bz_unit"; //todo
    private static final  int TABLE_PREFIX_LENGTH = 3;
    private static final String[] SEARCH_NAME = new String[]{};  //todo 搜索框
    private static final String[] SEARCH_PLACEHOLDER = new String[]{};  //todo
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
        Writer Controller_adminOut = null;
        Writer Controller_webbusinessOut = null;
        Writer ComponentOut = null;
        Writer FallbackOut = null;
        Writer jspOut = null;
        Writer addOut = null;
        Writer editOut = null;
        Writer detailOut = null;
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
            Template controller_adminTemplate = configuration.getTemplate("Controller_admin.ftl");
            Template controller_webbusinessTemplate = configuration.getTemplate("Controller_webbusiness.ftl");
            Template FallbackTemplate = configuration.getTemplate("Fallback.ftl");
            Template jspTemplate = configuration.getTemplate("jsp.ftl");
            Template addTemplate = configuration.getTemplate("add.ftl");
            Template editTemplate = configuration.getTemplate("edit.ftl");
            Template detailTemplate = configuration.getTemplate("detail.ftl");
            Template ComponentTemplate = configuration.getTemplate("Component.ftl");

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
            dataMap.put("tableShortName",FormatUtil.getShortName(TABLE_NAME).equals("as")  ? "as1" : FormatUtil.getShortName(TABLE_NAME) );
            dataMap.put("URL",FormatUtil._splitOnCase(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
//            dataMap.put("URL",FormatUtil._split(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("fristColumnName",FormatUtil.columnNames(DatabaseUtil.getColumnNames(TABLE_NAME)).get(0));//第一个字段名areaId
            dataMap.put("fristColumnNameUpperCase",FormatUtil.columnNamesUpperCase(DatabaseUtil.getColumnNames(TABLE_NAME)).get(0));//第一个字段名AreaId
            //jsp数据
            getJspDateMap(dataMap);

            // step5 生成数据
            File xmlFile = new File(TARGET_PATH_WEBBUSINESS + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Handle-Mapper.xml");//TODO
            File DTOFile = new File(TARGET_PATH_WEBBUSINESS + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"VO.java");
            File queryFile = new File(TARGET_PATH_WEBBUSINESS + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Query.java");
            File DAOFile = new File(TARGET_PATH_WEBBUSINESS + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"HandleDao.java");
            File serviceFile = new File(TARGET_PATH_ADMIN + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Service.java");
            File controller_adminFile = new File(TARGET_PATH_ADMIN + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Controller.java");
            File Controller_webbusinessFile = new File(TARGET_PATH_WEBBUSINESS + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Controller.java");
            File FallbackFile = new File(TARGET_PATH_ADMIN + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"ServiceFallback.java");
            File jspFile = new File(TARGET_PATH_ADMIN + "\\" + "index.jsp");
            File addFile = new File(TARGET_PATH_ADMIN + "\\" + "add.jsp");
            File editFile = new File(TARGET_PATH_ADMIN + "\\" + "edit.jsp");
            File detailFile = new File(TARGET_PATH_ADMIN + "\\" + "detail.jsp");
            File ComponentFile = new File(TARGET_PATH_WEBBUSINESS + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Component.java");

            xmlOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFile)));
            DTOOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DTOFile)));
            queryOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(queryFile)));
            DAOOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(DAOFile)));
            serviceOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile)));
            Controller_webbusinessOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Controller_webbusinessFile)));
            Controller_adminOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(controller_adminFile)));
            FallbackOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FallbackFile)));
            jspOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jspFile)));
            addOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(addFile)));
            editOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(editFile)));
            detailOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(detailFile)));
            ComponentOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ComponentFile)));

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
            controller_adminTemplate.process(dataMap, Controller_adminOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^controller_admin文件创建成功 !");
            controller_webbusinessTemplate.process(dataMap, Controller_webbusinessOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^controller_webbusiness文件创建成功 !");
            FallbackTemplate.process(dataMap, FallbackOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Fallback文件创建成功 !");
            jspTemplate.process(dataMap, jspOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^jsp文件创建成功 !");
            addTemplate.process(dataMap, addOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^add文件创建成功 !");
            editTemplate.process(dataMap, editOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^edit文件创建成功 !");
            detailTemplate.process(dataMap, detailOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^detail文件创建成功 !");
            ComponentTemplate.process(dataMap,ComponentOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Component文件创建成功 !");
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
                    DAOOut.flush();
                }
                if (null != serviceOut) {
                    serviceOut.flush();
                }
                if (null != Controller_adminOut) {
                    Controller_adminOut.flush();
                }
                if (null != Controller_webbusinessOut) {
                    Controller_webbusinessOut.flush();
                }
                if (null != FallbackOut) {
                    FallbackOut.flush();
                }
                if (null != jspOut) {
                    jspOut.flush();
                }
                if (null != addOut) {
                    addOut.flush();
                }
                if (null != editOut) {
                    editOut.flush();
                }
                if (null != detailOut) {
                    detailOut.flush();
                }
                if (null != ComponentOut) {
                    ComponentOut.flush();
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
