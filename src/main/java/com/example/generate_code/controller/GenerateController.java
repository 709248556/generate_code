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
//    private static final String PARENT_URL = "card";   //todo
    private static final String TABLE_NAME = "bz_report_log"; //todo
    private static final  int TABLE_PREFIX_LENGTH = 2;

    public static void main(String[] args) {


        Map<String, Object> dataMap = new HashMap<String, Object>();
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer entityOut = null;
        Writer repositoryOut = null;
        try {

            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(ResourceUtils.getFile(TEMPLATE_PATH));
            // step3 创建数据模型

            // step4 加载模版文件
            Template entityTemplate = configuration.getTemplate("Entity.ftl");
            Template repositoryTemplate = configuration.getTemplate("Repository.ftl");

            //获取数据模型
            List<BaseResultMapVo> baseResultMapVoList = DatabaseUtil.getBaseResultMap(TABLE_NAME);
            List<UniqueIndexVO> uniqueIndexVOList = DatabaseUtil.getUniqueIndex(TABLE_NAME);
            dataMap.put("baseResultMapVoList",baseResultMapVoList);
            dataMap.put("uniqueIndexVOList",uniqueIndexVOList);
            dataMap.put("tableNameFormat",FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("tableNameFormatOnCase",FormatUtil._split(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("baseColumnList",DatabaseUtil.getColumnNames(TABLE_NAME));
            dataMap.put("serialVersionUID1",(String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())));
            dataMap.put("serialVersionUID2",String.valueOf(Math.abs(UUID.randomUUID().getMostSignificantBits())));
            dataMap.put("tableName",TABLE_NAME);
            dataMap.put("tableShortName",FormatUtil.getShortName(TABLE_NAME).equals("as")  ? "as1" : FormatUtil.getShortName(TABLE_NAME) );
            dataMap.put("URL",FormatUtil._splitOnCase(TABLE_NAME.substring(TABLE_PREFIX_LENGTH)));
            dataMap.put("fristColumnName",FormatUtil.columnNames(DatabaseUtil.getColumnNames(TABLE_NAME)).get(0));//第一个字段名areaId

            // step5 生成数据
            File entityFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+".java");
            File repositoryFile = new File(TARGET_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+".Repositoryjava");

            entityOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(entityFile)));
            repositoryOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(repositoryFile)));

            // step6 输出文件
            entityTemplate.process(dataMap, entityOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Entity文件创建成功 !");
            repositoryTemplate.process(dataMap, repositoryOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^Repository文件创建成功 !");
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
