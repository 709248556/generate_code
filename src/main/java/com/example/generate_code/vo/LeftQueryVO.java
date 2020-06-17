package com.example.generate_code.vo;

/**
 * @description:
 * @author: yanlianglong
 * @create: 2020-06-17 16:42
 **/
public class LeftQueryVO {
    private String column;//aread_id
    private String jdbcType;//int
    private String DTOType;//integer
    private String property;//areadId
    private String columnComment;//注释
    private String columnNameUpperCase;//AreadId

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getDTOType() {
        return DTOType;
    }

    public void setDTOType(String DTOType) {
        this.DTOType = DTOType;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnNameUpperCase() {
        return columnNameUpperCase;
    }

    public void setColumnNameUpperCase(String columnNameUpperCase) {
        this.columnNameUpperCase = columnNameUpperCase;
    }
}
