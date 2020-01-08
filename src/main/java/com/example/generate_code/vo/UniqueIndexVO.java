package com.example.generate_code.vo;

/**
 * @author yanlianglong
 * @Title: uniqueIndexVO.java
 * @Package com.example.generate_code.vo
 * @Description:
 * @date 2019/5/29 12:22
 */
public class UniqueIndexVO {
    private String dataColumnName;
    private String dataColumnNameFormat;
    private String dataColumnNameFormatUpperCase;

    public String getDataColumnNameFormatUpperCase() {
        return dataColumnNameFormatUpperCase;
    }

    public void setDataColumnNameFormatUpperCase(String dataColumnNameFormatUpperCase) {
        this.dataColumnNameFormatUpperCase = dataColumnNameFormatUpperCase;
    }

    public String getDataColumnName() {
        return dataColumnName;
    }

    public void setDataColumnName(String dataColumnName) {
        this.dataColumnName = dataColumnName;
    }

    public String getDataColumnNameFormat() {
        return dataColumnNameFormat;
    }

    public void setDataColumnNameFormat(String dataColumnNameFormat) {
        this.dataColumnNameFormat = dataColumnNameFormat;
    }
}
