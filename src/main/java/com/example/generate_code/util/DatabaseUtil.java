package com.example.generate_code.util;

import com.example.generate_code.vo.BaseResultMapVo;
import com.example.generate_code.vo.UniqueIndexVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseUtil.class);

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //todo
//    private static final String URL = "jdbc:mysql://192.168.0.50:3306/zjsm-sp?characterEncoding=UTF-8&useSSL=false&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=GMT%2b8&&useInformationSchema=true";
//    private static final String USERNAME = "test";
//    private static final String PASSWORD = "123456";
private static final String URL = "jdbc:mysql://116.199.15.19:3306/ai_transcoder?characterEncoding=UTF-8&useSSL=false&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=GMT%2b8&&useInformationSchema=true";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test@zjzl!23";

    private static final String SQL = "SELECT * FROM ";// 数据库操作

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver", e);
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("get connection failure", e);
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
            }
        }
    }

    /**
     * 获取数据库下的所有表名
     */
    public static List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            //获取数据库的元数据
            DatabaseMetaData db = conn.getMetaData();
            //从元数据中获取到所有的表名
            rs = db.getTables(null, null, "%", new String[]{"TABLE"});
            while (rs.next()) {
                tableNames.add(rs.getString(3));
            }
        } catch (SQLException e) {
            LOGGER.error("getTableNames failure", e);
        } finally {
            try {
                rs.close();
                closeConnection(conn);
            } catch (SQLException e) {
                LOGGER.error("close ResultSet failure", e);
            }
        }
        return tableNames;
    }

    /**
     * 获取表的注释
     */
    public static String getTableRemark(String tableName) {
        Connection conn = getConnection();
        String remark = "";
        ResultSet rs = null;
        try {
            //获取数据库的元数据
            DatabaseMetaData db = conn.getMetaData();
            //从元数据中获取到所有的表名
            rs = db.getTables(null, null, tableName, new String[]{"TABLE"});
            while (rs.next()) {
                remark = rs.getString("REMARKS");
            }
        } catch (SQLException e) {
            LOGGER.error("getTableRemark failure", e);
        } finally {
            try {
                rs.close();
                closeConnection(conn);
            } catch (SQLException e) {
                LOGGER.error("close ResultSet failure", e);
            }
        }
        return remark;
    }

    /**
     * 获取表中所有字段名称
     *
     * @param tableName 表名
     * @return
     */
    public static List<String> getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnNames.add(rsmd.getColumnName(i + 1));
            }
        } catch (SQLException e) {
            LOGGER.error("getColumnNames failure", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnNames close pstem and connection failure", e);
                }
            }
        }
        return columnNames;
    }

    /**
     * 获取表中所有字段类型
     *
     * @param tableName
     * @return
     */
    public static List<String> getColumnTypes(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnTypes.add(rsmd.getColumnTypeName(i + 1));
            }
        } catch (SQLException e) {
            LOGGER.error("getColumnTypes failure", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnTypes close pstem and connection failure", e);
                }
            }
        }
        return columnTypes;
    }

    /**
     * 获取表中字段的所有注释
     *
     * @param tableName
     * @return
     */
    public static List<String> getColumnComments(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        List<String> columnComments = new ArrayList<>();//列名注释集合
        ResultSet rs = null;
        try {
            pStemt = conn.prepareStatement(tableSql);
            rs = pStemt.executeQuery("show full columns from " + tableName);
            while (rs.next()) {
                columnComments.add(rs.getString("Comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnComments close ResultSet and connection failure", e);
                }
            }
        }
        return columnComments;
    }

    /**
     * 获取表中索引信息
     *
     * @param tableName
     * @return
     */
    public static List<String> getIndexInfo(String tableName) {
        List<String> IndexInfo = new ArrayList<>();
        String namestr, strn, indexstr;
        int index;
        //与数据库的连接
        Connection conn = getConnection();
        DatabaseMetaData dbmd = null;
        ResultSet rs = null;
        try {
            dbmd = conn.getMetaData();
            //获取索引信息
            rs = dbmd.getIndexInfo(null, null, tableName, Boolean.TRUE, Boolean.TRUE);
            //输出索引信息
            while (rs.next()) {
                //获取索引名
                namestr = rs.getString("INDEX_NAME");
                //获取索引类型
                index = rs.getInt("TYPE");
                //获取索引列名
                strn = rs.getString("COLUMN_NAME");
                IndexInfo.add(strn);
//                System.out.println("索引名:" + namestr + ",索引类型:" + index + ",索引列名:" + strn);
            }
        } catch (SQLException e) {
            LOGGER.error("getIndexInfo failure", e);
        } finally {
            closeConnection(conn);
        }
        return IndexInfo;
    }

    public static void main(String[] args) {
//        List<String> tableNames = getTableNames();
//        System.out.println("tableNames:" + tableNames);
//        for (String tableName : tableNames) {
//            System.out.println("tableName:" + tableName);
//            System.out.println("remark:" + getTableRemark(tableName));
//            System.out.println("ColumnNames:" + getColumnNames(tableName));
//            System.out.println("ColumnTypes:" + getColumnTypes(tableName));
//            System.out.println("ColumnComments:" + getColumnComments(tableName));
//            System.out.println("IndexInfo:" + getIndexInfo(tableName));
//        }
    }

    public static List<Map<String, String>> getMapList() {
        List<Map<String, String>> list = new ArrayList<>();
        List<String> tableNames = getTableNames();
        for (String tableName : tableNames) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("originalTableName", tableName);
            map.put("tableName", FormatUtil.tableName(tableName));
            List<String> columnNames = FormatUtil.columnNames(getColumnNames(tableName));
            List<String> columnTypes = FormatUtil.columnTypes(getColumnTypes(tableName));
            for (int i = 0; i < columnNames.size(); i++) {
                map.put(columnNames.get(i), columnTypes.get(i));
            }
            list.add(map);
        }
        return list;
    }

    public static List<BaseResultMapVo> getBaseResultMap(String tableName) {
        List<BaseResultMapVo> baseResultMapVoList = new ArrayList<>();
        List<String> originalColumnNames = getColumnNames(tableName);//获取原字段名
        List<String> columnNames = FormatUtil.columnNames(getColumnNames(tableName));//DTO格式字段名
        List<String> columnNamesUpperCase = FormatUtil.columnNamesUpperCase(getColumnNames(tableName));//DTO格式字段名
        List<String> columnDTOTypes = FormatUtil.columnTypes(getColumnTypes(tableName));//DTO格式类型名
        List<String> columnTypes = FormatUtil.columnTypesData(getColumnTypes(tableName));//数据库格式类型名
        List<String> ColumnComments = getColumnComments(tableName);//注释
        for (int i = 0; i < columnNames.size(); i++) {
            BaseResultMapVo baseResultMapVo = new BaseResultMapVo();
            baseResultMapVo.setColumn(originalColumnNames.get(i));
            baseResultMapVo.setJdbcType(columnTypes.get(i));
            baseResultMapVo.setProperty(columnNames.get(i));
            baseResultMapVo.setDTOType(columnDTOTypes.get(i));
            baseResultMapVo.setColumnComment(ColumnComments.get(i));
            baseResultMapVo.setColumnNameUpperCase(columnNamesUpperCase.get(i));
            baseResultMapVoList.add(baseResultMapVo);
        }
        return baseResultMapVoList;
    }

    public static List<UniqueIndexVO> getUniqueIndex(String tableName) {
        List<UniqueIndexVO> uniqueIndexVoList = new ArrayList<>();
        List<String> dataColumnNameList = getIndexInfo(tableName);
        List<String> dataColumnNameFormatList = FormatUtil.columnNames(getIndexInfo(tableName));
        for (int i = 0; i < dataColumnNameList.size(); i++) {
            UniqueIndexVO uniqueIndexVO = new UniqueIndexVO();
            uniqueIndexVO.setDataColumnName(dataColumnNameList.get(i));
            uniqueIndexVO.setDataColumnNameFormat(dataColumnNameFormatList.get(i));
            uniqueIndexVoList.add(uniqueIndexVO);
        }
        return uniqueIndexVoList;
    }
}