package com.example.generate_code.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormatUtil {

    private final static int TABLE_PREFIX_LENGTH = 3;

    //格式化表明，避免出现mysql的关键字
    public static List<String> keyword(List<String> original) {
        List<String> format = new ArrayList<>();
        original.forEach(org -> {
            format.add("`" + org + "`");
        });
        return format;
    }
    //bz_card_inf_abandoned  -> cardInfAbandoned
    public static String tableName(String original) {
        return  _split(original.substring(TABLE_PREFIX_LENGTH));
    }

    //area ->Area
    public static String upperCase(String original) {
        if(StringUtils.isEmpty(original)) return original;
        return Character.toUpperCase(original.charAt(0)) + original.substring(1);
    }
    //Farea_id -> areaId
    public static List<String> columnNames(List<String> original) {
        List<String> format = new ArrayList<>();
        String str = "";
        original.forEach(item -> {
            format.add(_split(item.substring(1)));
        });
        return format;
    }
    //Farea_id -> AreaId
    public static List<String> columnNamesUpperCase(List<String> original) {
        List<String> format = new ArrayList<>();
        String str = "";
        original.forEach(item -> {
            format.add(_splitAll(item.substring(1)));
        });
        return format;
    }

    //转换数据类型
    public static List<String> columnTypes(List<String> original) {
        List<String> format = new ArrayList<>();
        original.forEach(item -> {
            if (item.equalsIgnoreCase("VARCHAR")) {
                format.add("String");
            } else if (item.equalsIgnoreCase("CHAR")) {
                format.add("String");
            } else if (item.equalsIgnoreCase("BIGINT")) {
                format.add("Long");
            } else if (item.equalsIgnoreCase("DATETIME")) {
                format.add("Date");
            } else if (item.equalsIgnoreCase("INT")) {
                format.add("Integer");
            }else if (item.equalsIgnoreCase("TEXT")) {
                format.add("String");
            }else if (item.equalsIgnoreCase("decimal")) {
                format.add("BigDecimal");
            }else {
                format.add("UNDEFINE");
            }
        });
        return format;
    }

    //转换数据类型
    public static List<String> columnTypesData(List<String> original) {
        List<String> format = new ArrayList<>();
        original.forEach(item -> {
            if (item.equalsIgnoreCase("VARCHAR")) {
                format.add("VARCHAR");
            } else if (item.equalsIgnoreCase("CHAR")) {
                format.add("CHAR");
            } else if (item.equalsIgnoreCase("BIGINT")) {
                format.add("BIGINT");
            } else if (item.equalsIgnoreCase("DATETIME")) {
                format.add("DATE");
            } else if (item.equalsIgnoreCase("INT")) {
                format.add("INTEGER");
            }else {
                format.add("UNDEFINE");
            }
        });
        return format;
    }

    //按"_"进行分割，并把_后的第一个字母写成大写
    public static String _split(String original) {
        String[] s = original.split("_");
        String format = s[0];
        for(int i = 1;i < s.length;i++){
            format = format+upperCase(s[i]);        }
        return format;
    }

    //按"_"进行分割，并把_后的第一个字母和首字母写成大写
    public static String _splitAll(String original) {
        String[] s = original.split("_");
        String format = upperCase(s[0]);
        for(int i = 1;i < s.length;i++){
            format = format+upperCase(s[i]);        }
        return format;
    }

    //按"_"进行分割，并把_后的第一个字母拼成缩写
    public static String getShortName(String original){
        String[] s = original.split("_");
        String format = "";
        for(int i = 1;i < s.length;i++){
            format = format+s[i].charAt(0);        }
        return format;
    }
}
