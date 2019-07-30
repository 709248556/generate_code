package com.example.generate_code.controller;

import com.example.generate_code.util.DatabaseUtil;
import com.example.generate_code.util.FormatUtil;
import com.example.generate_code.vo.BaseResultMapVo;
import com.example.generate_code.vo.UniqueIndexVO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanlianglong
 * @Title: testController.java
 * @Package com.example.generate_code.controller
 * @Description:
 * @date 2019/6/11 15:59
 */
public class testController {

    private static final String TEMPLATE_PATH = "classpath:templates";
    private static final String CLASS_PATH = "src/main/java/com/example/generate_code/controller";
    private static final String TABLE_NAME = "bz_advert";
    private final static int TABLE_PREFIX_LENGTH = 3;

    public static void main(String[] args){
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        File xmlFile = new File(CLASS_PATH + "\\" + FormatUtil._splitAll(TABLE_NAME.substring(TABLE_PREFIX_LENGTH))+"Mapper.xml");
        try(Writer xmlOut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFile)))){
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(ResourceUtils.getFile(TEMPLATE_PATH));
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
            // step4 加载模版文件
            Template xmlTemplate = configuration.getTemplate("Mapper.ftl");
            xmlTemplate.process(dataMap, xmlOut);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^xml文件创建成功 !");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
