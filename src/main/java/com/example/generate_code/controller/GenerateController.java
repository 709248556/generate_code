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
import java.lang.reflect.Array;
import java.util.*;
import java.util.Date;

import freemarker.template.Configuration;
import freemarker.template.Template;


@RestController
public class GenerateController {

    private static final String TEMPLATE_PATH = "classpath:templates";
    private static final String TARGET_PATH = "src/main/java/com/example/generate_code/target";
    private static final String TABLE_NAME = "sp_volunteer_unit";
    private static final HashMap<String,Boolean> INPUTS = new HashMap<>();
    private static final List<String> SELECTDTOS =  Arrays.asList("content_type","status","news_category_id","title");
    private static final  int TABLE_PREFIX_LENGTH = 3;

    static {
        INPUTS.put("title",Boolean.TRUE);
        INPUTS.put("content_type",Boolean.TRUE);
        INPUTS.put("intro",Boolean.TRUE);
        INPUTS.put("file_id",Boolean.TRUE);
        INPUTS.put("author",Boolean.TRUE);
        INPUTS.put("is_original",Boolean.TRUE);
        INPUTS.put("detail",Boolean.FALSE);
    }

    public static void main(String[] args) {
        DataUtil.mkDir(TARGET_PATH);
        DataUtil.mkDir(TARGET_PATH+"/"+FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));

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
            dataMap.put("tableShortName",FormatUtil.getShortName(TABLE_NAME).equals("as")  ? "as1" : FormatUtil.getShortName(TABLE_NAME) );
            dataMap.put("URL",FormatUtil._splitOnCase(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("fristColumnName",FormatUtil.columnNames(DatabaseUtil.getColumnNames(TABLE_NAME)).get(0));//第一个字段名areaId

            // step5 生成数据
            File entityFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+".java");
            File repositoryFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Repository.java");
            File controllerFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Controller.java");
            File serviceFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Service.java");
            File serviceImplFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"ServiceImpl.java");
            File inputFile = new File(TARGET_PATH +"\\"+FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Input.java");
            File outputFile = new File(TARGET_PATH +"\\"+FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Output.java");
            File selectDtoFile = new File(TARGET_PATH +"\\"+FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+ "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"SelectDto.java");

            entityOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFile)));
            repositoryOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(repositoryFile)));
            controllerOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(controllerFile)));
            inputOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(inputFile)));
            outputOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
            selectDtoOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(selectDtoFile)));
            serviceOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceFile)));
            serviceImplOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(serviceImplFile)));

            // step6 输出文件
            entityTemplate.process(dataMap, entityOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Entity文件创建成功 !");
            repositoryTemplate.process(dataMap, repositoryOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Repository文件创建成功 !");
            controllerTemplate.process(dataMap, controllerOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Controller文件创建成功 !");
            inputTemplate.process(dataMap, inputOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Input文件创建成功 !");
            outputTemplate.process(dataMap, outputOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Output文件创建成功 !");
            selectDTOTemplate.process(dataMap, selectDtoOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^SelectDto文件创建成功 !");
            serviceTemplate.process(dataMap, serviceOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^ServiceOut文件创建成功 !");
            serviceImplTemplate.process(dataMap, serviceImplOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^ServiceImplOut文件创建成功 !");
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
