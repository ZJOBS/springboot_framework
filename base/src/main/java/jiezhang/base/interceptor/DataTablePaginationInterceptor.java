package jiezhang.base.interceptor;

import jiezhang.base.constant.DataBase;
import jiezhang.base.entity.DataTablePage;
import jiezhang.base.utils.PropertiesUtil;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 分页插件
 *
 * @author ZhangJie
 * @description
 * @date 11:35 上午 2020/3/26
 * @return
 */
@Component
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
public class DataTablePaginationInterceptor implements Interceptor {

    @Value(value = "${database-type}")
    private String DATABASETYPE;

//    static {
//        DATABASETYPE = PropertiesUtil.loadProperties("properties/jdbc.properties").get("database_dataBaseType");
//    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation
                .getTarget();
        StatementHandler delegate = (StatementHandler) DataTablePaginationInterceptor.ReflectUtil.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        Object obj = boundSql.getParameterObject();
        if (obj instanceof DataTablePage) {
            DataTablePage page = (DataTablePage) obj;
            MappedStatement mappedStatement = (MappedStatement) DataTablePaginationInterceptor.ReflectUtil.getFieldValue(delegate, "mappedStatement");
            Connection connection = (Connection) invocation.getArgs()[0];
            String sql = boundSql.getSql();
            this.setTotalRecord(page, mappedStatement, connection);

//            if (!sql.toLowerCase().contains("where")) {
//                //不包含where时，自动生成where部分
//                sql += constructWhere(page.getParams());
//            }

            //分页
            String pageSql = this.getPageSql(page, sql);
            DataTablePaginationInterceptor.ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        //   this.dataBaseType = properties.getProperty("databaseType");
        System.out.println("数据库类型为" + DATABASETYPE);
    }

    @SuppressWarnings("rawtypes")
    private String getPageSql(DataTablePage page, String sql) {
        StringBuffer sqlBuffer = new StringBuffer(sql);
        //需要优化，将此数据库类型放到常量中，因经常使用
        if (DataBase.MYSQL.checkName(DATABASETYPE)) {
            return getMysqlPageSql(page, sqlBuffer);
        } else if (DataBase.ORALCE.checkName((DATABASETYPE))) {
            System.out.println("暂时不支持 oracle");
            //return getOraclePageSql(page, sqlBuffer);
            return "";
        }
        return sqlBuffer.toString();
    }

    @SuppressWarnings("rawtypes")
    private String getMysqlPageSql(DataTablePage page, StringBuffer sqlBuffer) {
        int offset = page.getIDisplayStart();
        sqlBuffer.append(" limit ").append(offset).append(",")
                .append(page.getIDisplayLength());
        return sqlBuffer.toString();
    }


    @SuppressWarnings("rawtypes")
    private void setTotalRecord(DataTablePage page, MappedStatement mappedStatement, Connection connection) {
        BoundSql boundSql = mappedStatement.getBoundSql(page);
        String sql = boundSql.getSql();
        String countSql = this.getCountSql(sql);
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, page);
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql);
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(countSql);
            parameterHandler.setParameters(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int totalRecord = rs.getInt(1);
                page.setITotalRecords(totalRecord);
                page.setITotalDisplayRecords(totalRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCountSql(String sql) {
        int index = sql.indexOf("from") == -1 ? sql.indexOf("FROM") : -1;
        return "select count(*) " + sql.substring(index);
    }

    private static class ReflectUtil {
        public static Object getFieldValue(Object obj, String fieldName) {
            Object result = null;
            Field field = DataTablePaginationInterceptor.ReflectUtil.getField(obj, fieldName);
            if (field != null) {
                field.setAccessible(true);
                try {
                    result = field.get(obj);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }

        private static Field getField(Object obj, String fieldName) {
            Field field = null;
            for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz
                    .getSuperclass()) {
                try {
                    field = clazz.getDeclaredField(fieldName);
                    break;
                } catch (NoSuchFieldException e) {
                    //
                }
            }
            return field;
        }

        public static void setFieldValue(Object obj, String fieldName, String fieldValue) {
            Field field = DataTablePaginationInterceptor.ReflectUtil.getField(obj, fieldName);
            if (field != null) {
                try {
                    field.setAccessible(true);
                    field.set(obj, fieldValue);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public String constructWhere(Map<String, Object> pmp) {
        String query = "";
        if (!pmp.isEmpty()) {
            int i = 0;
            for (Map.Entry<String, Object> entry : pmp.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    i++;
                    if (i == 1) {
                        query = " WHERE ";
                        query += " " + key + " " + "LIKE" + " " + "'%" + value + "%'";
                    }
                }
            }
        }
        return query;
    }
}
