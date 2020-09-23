package com.example.generate_code.controller;

import com.example.generate_code.util.DataUtil;
import com.example.generate_code.util.DatabaseUtil;
import com.example.generate_code.util.FormatUtil;
import com.example.generate_code.vo.BaseResultMapVo;
import com.example.generate_code.vo.LeftQueryVO;
import com.example.generate_code.vo.UniqueIndexVO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;


@RestController
public class GenerateController {

    private static final String TEMPLATE_PATH = "classpath:templates";
    private static final String TARGET_PATH = "src/main/java/com/example/generate_code/target";
    private static final String LEFT = "left";
    private static final String TREE = "tree";

    private static final String TABLE_NAME = "sp_showroom_type";
    private static final String LEFT_TABLE = "sp_sms_channel";
    private static final String LEFTJOINON = "channel_id";
    private static final String REDIS_CONSTANT = "KPGZ_DRAW_USER_WIN_ALL";

    private static final HashMap<String,Boolean> INPUTS = new HashMap<>();
    private static final List<LeftQueryVO> leftQueryVOS = new ArrayList<>();

    private static final List<String> SELECTDTOS =  new ArrayList<>();
    private static final  int TABLE_PREFIX_LENGTH = 3;

    static {
        //intput
        INPUTS.put("title",Boolean.TRUE);
        INPUTS.put("file_id",Boolean.TRUE);
        INPUTS.put("area",Boolean.TRUE);
        INPUTS.put("type_id",Boolean.TRUE);
        INPUTS.put("link",Boolean.TRUE);


//        INPUTS.put("type",Boolean.FALSE);
        INPUTS.put("condition_type",Boolean.FALSE);
        INPUTS.put("condition_num",Boolean.FALSE);
        //selectDTOs
        SELECTDTOS.add("status");

        //leftQueryVOS
        LeftQueryVO leftQueryVO = new LeftQueryVO();
        leftQueryVO.setDTOType("String");
        leftQueryVO.setJdbcType("nationCode");//表的字段名
        leftQueryVO.setColumnComment("手机地区码");//注释
        leftQueryVO.setColumn("nation_code");//aread_id
        leftQueryVO.setProperty(FormatUtil._split(leftQueryVO.getColumn()));//
        LeftQueryVO leftQueryVO2 = new LeftQueryVO();
        leftQueryVO2.setDTOType("Integer");
        leftQueryVO2.setJdbcType("app_id");//表的字段名
        leftQueryVO2.setColumnComment("AppID");//注释
        leftQueryVO2.setColumn("appId");//aread_id
        leftQueryVO2.setProperty(FormatUtil._split(leftQueryVO2.getColumn()));//

        leftQueryVOS.add(leftQueryVO);
        leftQueryVOS.add(leftQueryVO2);
    }

    public static void main(String[] args) {
        DataUtil.mkDir(TARGET_PATH);
        DataUtil.mkDir(TARGET_PATH+"/"+FormatUtil._split(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
        DataUtil.mkDir(TARGET_PATH+"/"+LEFT);
        DataUtil.mkDir(TARGET_PATH+"/"+TREE);

        Map<String, Object> dataMap = new HashMap<String, Object>();
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer entityOut = null;
        Writer repositoryOut = null;
        Writer inputOut = null;
        Writer outputOut = null;
        Writer selectDtoOut = null;
        Writer controllerOut = null;
        Writer serviceOut = null;
        Writer serviceImplOut = null;
        Writer serviceImplAppOut = null;
        Writer serviceImplLeftOut = null;
        Writer leftQueryOUT = null;
        Writer queryRepositorytOut = null;
        Writer leftOutputOut = null;
        Writer treeOutputOut = null;
        Writer treeInputOut = null;
        Writer treeServiceOut = null;
        Writer treeServiceImplOut = null;
        try {

            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(ResourceUtils.getFile(TEMPLATE_PATH));
            // step3 创建数据模型

            // step4 加载模版文件
            Template entityTemplate = configuration.getTemplate("Entity.ftl");
            Template repositoryTemplate = configuration.getTemplate("Repository.ftl");
            Template controllerTemplate = configuration.getTemplate("Controller.ftl");
            Template inputTemplate = configuration.getTemplate("Input.ftl");
            Template outputTemplate = configuration.getTemplate("Output.ftl");
            Template selectDTOTemplate = configuration.getTemplate("SelectDTO.ftl");
            Template serviceTemplate = configuration.getTemplate("Service.ftl");
            Template serviceImplTemplate = configuration.getTemplate("ServiceImpl.ftl");
            Template serviceImplAppTemplate = configuration.getTemplate("ServiceImplApp.ftl");
            Template serviceImplLeftTemplate = configuration.getTemplate("ServiceImplLeft.ftl");
            Template leftQueryTemplate = configuration.getTemplate("LeftQuery.ftl");
            Template queryRepositoryTemplate = configuration.getTemplate("QueryRepository.ftl");
            Template leftOutputTemplate = configuration.getTemplate("LeftOutput.ftl");
            Template treeInputTemplate = configuration.getTemplate("TreeInput.ftl");
            Template treeOutputTemplate = configuration.getTemplate("TreeOutput.ftl");
            Template treeServiceTemplate = configuration.getTemplate("TreeService.ftl");
            Template treeServiceImplTemplate = configuration.getTemplate("TreeServiceImpl.ftl");

            //获取数据模型
            List<BaseResultMapVo> baseResultMapVoList = DatabaseUtil.getBaseResultMap(TABLE_NAME);
            List<UniqueIndexVO> uniqueIndexVOList = DatabaseUtil.getUniqueIndex(TABLE_NAME);
            dataMap.put("baseResultMapVoList",baseResultMapVoList);
            dataMap.put("uniqueIndexVOList",uniqueIndexVOList);
            dataMap.put("tableRemark",DatabaseUtil.getTableRemark(TABLE_NAME).substring(0,DatabaseUtil.getTableRemark(TABLE_NAME).length()-1));
            dataMap.put("tableNameFormat",FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("tableNameFormatOnCase",FormatUtil._split(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("baseColumnList",DatabaseUtil.getColumnNames(TABLE_NAME));
            dataMap.put("serialVersionUID1",(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits()))));
            dataMap.put("serialVersionUID2",String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())));
            dataMap.put("serialVersionUID3",String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())));
            dataMap.put("serialVersionUID4",String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())));
            dataMap.put("tableName",TABLE_NAME);
            dataMap.put("selectDTOs",SELECTDTOS);
            dataMap.put("inputs",INPUTS);
            dataMap.put("leftJoinOn",LEFTJOINON);
            dataMap.put("tableShortName",FormatUtil.getShortName(TABLE_NAME).equals("as")  ? "as1" : FormatUtil.getShortName(TABLE_NAME) );
            dataMap.put("URL",FormatUtil._splitOnCase(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("fristColumnName",FormatUtil.columnNames(DatabaseUtil.getColumnNames(TABLE_NAME)).get(0));//第一个字段名areaId
            //连表查询
            dataMap.put("leftTableName",LEFT_TABLE);
            dataMap.put("leftTableShortName",FormatUtil.getShortName(LEFT_TABLE).equals("as")  ? "as1" : FormatUtil.getShortName(LEFT_TABLE) );
            dataMap.put("leftTableNameFormat",FormatUtil._splitAll(LEFT_TABLE.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("leftTableNameFormatSub",LEFT_TABLE.substring(TABLE_PREFIX_LENGTH));
            dataMap.put("leftTableNameFormatOnCase",FormatUtil._split(LEFT_TABLE.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("leftQueryVOS",leftQueryVOS);

            dataMap.put("REDIS_CONSTANT",REDIS_CONSTANT);

            // step5 生成数据
            File entityFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+".java");
            File repositoryFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Repository.java");
            File controllerFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Controller.java");
            File serviceFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Service.java");
            File treeServiceFile = new File(TARGET_PATH + "\\"+TREE+"\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Service.java");
            File serviceImplFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"ServiceImpl.java");
            File serviceImplAppFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"AppServiceImpl.java");
            File treeServiceImplFile = new File(TARGET_PATH +"\\"+TREE+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"ServiceImpl.java");
            File serviceImplLeftFile = new File(TARGET_PATH +"\\"+LEFT+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"ServiceImpl.java");
            File leftQueryFile = new File(TARGET_PATH +"\\"+LEFT+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+FormatUtil._splitAll(LEFT_TABLE.substring(TABLE_PREFIX_LENGTH))+"Query.java");
            File leftOutPutFile = new File(TARGET_PATH +"\\"+LEFT+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+FormatUtil._splitAll(LEFT_TABLE.substring(TABLE_PREFIX_LENGTH))+"Output.java");
            File queryRepositoryFile = new File(TARGET_PATH +"\\"+LEFT+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+FormatUtil._splitAll(LEFT_TABLE.substring(TABLE_PREFIX_LENGTH))+"QueryRepository.java");
            File inputFile = new File(TARGET_PATH +"\\"+FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Input.java");
            File treeInputFile = new File(TARGET_PATH +"\\"+TREE+"\\"+ FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Input.java");
            File outputFile = new File(TARGET_PATH +"\\"+FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Output.java");
            File treeOutputFile = new File(TARGET_PATH +"\\"+TREE+"\\"+ FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Output.java");
            File selectDtoFile = new File(TARGET_PATH +"\\"+FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"SelectDto.java");

            entityOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFile)));
            repositoryOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(repositoryFile)));
            controllerOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(controllerFile)));
            inputOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(inputFile)));
            outputOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
            selectDtoOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(selectDtoFile)));
            serviceOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile)));
            serviceImplOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceImplFile)));
            serviceImplAppOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceImplAppFile)));
            serviceImplLeftOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceImplLeftFile)));
            leftQueryOUT = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(leftQueryFile)));
            queryRepositorytOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(queryRepositoryFile)));
            leftOutputOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(leftOutPutFile)));
            treeInputOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(treeInputFile)));
            treeOutputOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(treeOutputFile)));
            treeServiceOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(treeServiceFile)));
            treeServiceImplOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(treeServiceImplFile)));

            // step6 输出文件
            entityTemplate.process(dataMap, entityOut);
            repositoryTemplate.process(dataMap, repositoryOut);
            controllerTemplate.process(dataMap, controllerOut);
            inputTemplate.process(dataMap, inputOut);
            outputTemplate.process(dataMap, outputOut);
            selectDTOTemplate.process(dataMap, selectDtoOut);
            serviceTemplate.process(dataMap, serviceOut);
            serviceImplTemplate.process(dataMap, serviceImplOut);
            serviceImplAppTemplate.process(dataMap, serviceImplAppOut);
            serviceImplLeftTemplate.process(dataMap, serviceImplLeftOut);
            leftQueryTemplate.process(dataMap, leftQueryOUT);
            queryRepositoryTemplate.process(dataMap, queryRepositorytOut);
            leftOutputTemplate.process(dataMap, leftOutputOut);
            treeInputTemplate.process(dataMap, treeInputOut);
            treeOutputTemplate.process(dataMap, treeOutputOut);
            treeServiceTemplate.process(dataMap, treeServiceOut);
            treeServiceImplTemplate.process(dataMap, treeServiceImplOut);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != entityOut) {
                    entityOut.flush();
                }
                if (null != repositoryOut) {
                    repositoryOut.flush();
                }
                if (null != controllerOut) {
                    controllerOut.flush();
                }
                if (null != inputOut) {
                    inputOut.flush();
                }
                if (null != outputOut) {
                    outputOut.flush();
                }
                if (null != selectDtoOut) {
                    selectDtoOut.flush();
                }
                if (null != serviceOut) {
                    serviceOut.flush();
                }
                if (null != serviceImplOut) {
                    serviceImplOut.flush();
                }
                if (null != serviceImplLeftOut) {
                    serviceImplLeftOut.flush();
                }
                if (null != leftQueryOUT) {
                    leftQueryOUT.flush();
                }
                if (null != queryRepositorytOut) {
                    queryRepositorytOut.flush();
                }
                if (null != leftOutputOut) {
                    leftOutputOut.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
