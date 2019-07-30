package com.example.generate_code.vo;

/**
 * @author yanlianglong
 * @Title: SearchVo.java
 * @Package com.example.generate_code.vo
 * @Description:
 * @date 2019/7/22 11:10
 */
public class SearchVo {
    private String name;
    private String placeholder;
    private String type;
    private String value;
    private String desc;
    private String items;

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
