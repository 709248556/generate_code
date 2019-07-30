package com.example.generate_code.vo;

public class BaseResultMapVo {
    private String column;
    private String jdbcType;
    private String DTOType;
    private String property;
    private String columnComment;
    private String columnNameUpperCase;

    public String getColumnNameUpperCase() {
        return columnNameUpperCase;
    }

    public void setColumnNameUpperCase(String columnNameUpperCase) {
        this.columnNameUpperCase = columnNameUpperCase;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getDTOType() {
        return DTOType;
    }

    public void setDTOType(String DTOType) {
        this.DTOType = DTOType;
    }

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

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
