package com.example.generate_code.controller;

import com.example.generate_code.util.ConnectionUtil;
import com.example.generate_code.util.DatabaseUtil;
import com.example.generate_code.util.FormatUtil;
import com.example.generate_code.vo.BaseResultMapVo;
import com.example.generate_code.vo.UniqueIndexVO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class testController {

    @Autowired
    private ConnectionUtil connectionUtil;

    @RequestMapping("/generate")
    public String get(){

        return "";
    }
}
