package com.tlkj.framework;

import com.tlkj.CommonUtils.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtil {
    public static JActiveTable getActiveTable(Object obj, String cTableName) {
        JActiveTable aTable = new JActiveTable();
        if (obj.getClass().isAnnotationPresent(Table.class)) {
            Table vTableConfig = obj.getClass().getAnnotation(Table.class);
            String cDBTableName = vTableConfig.TableName();
            aTable.setTableName(cDBTableName);
        }
        StringBuffer sql = new StringBuffer();
        Field[] field = obj.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++) {     //遍历所有属性
            String cFieldName = field[j].getName();    //获取属性的名字
            Object objFieldValue = null;
            cFieldName = cFieldName.substring(0, 1).toUpperCase() + cFieldName.substring(1); //将属性的首字符大写，方便构造get，set方法
            Method m = null;
            try {
                m = obj.getClass().getMethod("get" + cFieldName);
                objFieldValue = m.invoke(obj);    //调用getter方法获取属性值
                if (m.getClass().isAnnotationPresent(Column.class)) {
                    Column vColumnConfig = obj.getClass().getAnnotation(Column.class);
                    String cFieldDesc = vColumnConfig.FieldDesc();
                    if (vColumnConfig.DBType() == DBType.ftInteger) {
                        aTable.AddField(cFieldName, cFieldDesc, DBType.ftInteger);
                    } else if (vColumnConfig.DBType() == DBType.ftDouble) {
                        aTable.AddField(cFieldName, cFieldDesc, DBType.ftDouble);
                    } else if (vColumnConfig.DBType() == DBType.ftFloat) {
                        aTable.AddField(cFieldName, cFieldDesc, DBType.ftFloat);
                    } else if (vColumnConfig.DBType() == DBType.ftBoolean) {
                        aTable.AddField(cFieldName, cFieldDesc, DBType.ftBoolean);
                    } else {
                        aTable.AddField(cFieldName, cFieldDesc, DBType.ftString);
                    }
                }

                if (objFieldValue != null) {
                    String cFieldValue = StringEx.getStr(objFieldValue);
                    aTable.setFieldValue(cFieldName, cFieldValue);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return aTable;
    }

    public static String getInsertSQL(Object obj, String cTableName) {
        StringBuffer sql = new StringBuffer();
        Map<String, Object> vObjInf = BeanUtil.Obj2Map(obj);
        sql.append("INSERT INTO " + cTableName + "(");
        boolean isEmpty = true;
        for (String cFieldName : vObjInf.keySet()) {
            if (isEmpty) {
                sql.append(cFieldName);
                isEmpty = false;
            } else {
                sql.append("," + cFieldName);
                isEmpty = false;
            }
        }
        sql.append(")");
        isEmpty = true;
        sql.append(" VALUES (");
        for (String cFieldName : vObjInf.keySet()) {
            Object cFieldValue = vObjInf.get(cFieldName);
            if (isEmpty) {
                if (cFieldValue == null) {
                    sql.append("null");
                } else {
                    sql.append("'" + cFieldValue.toString() + "'");
                }
                isEmpty = false;
            } else {
                if (cFieldValue == null) {
                    sql.append(",null");
                } else {
                    sql.append(",'" + cFieldValue.toString() + "'");
                }
                isEmpty = false;
            }
        }
        sql.append(")");
        return sql.toString();
    }

    public static String getUpdateSQL(Object obj, String cTableName, String cWhereParm) {
        StringBuffer sql = new StringBuffer();
        Map<String, Object> vObjInf = BeanUtil.Obj2Map(obj);
        sql.append(" UPDATE " + cTableName + " ");
        sql.append(" SET ");
        boolean isEmpty = true;
        for (String cFieldName : vObjInf.keySet()) {
            Object cFieldValue = vObjInf.get(cFieldName);
            if (isEmpty) {
                if (cFieldValue == null) {
                    sql.append(cFieldName + "=null");
                } else {
                    sql.append(cFieldName + "='" + cFieldValue.toString() + "'");
                }
                isEmpty = false;
            } else {
                if (cFieldValue == null) {
                    sql.append("," + cFieldName + "=null");
                } else {
                    sql.append("," + cFieldName + "='" + cFieldValue.toString() + "'");
                }
                isEmpty = false;
            }
        }
        sql.append(" WHERE " + cWhereParm);
        return sql.toString();
    }

    public static Map<String, Object> Obj2Map(Object obj) {
        Map<String, Object> objInfo = new HashMap<String, Object>();
        Field[] field = obj.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++) {     //遍历所有属性
            String cFieldName = field[j].getName();    //获取属性的名字
            Object objFieldValue = null;
            cFieldName = cFieldName.substring(0, 1).toUpperCase() + cFieldName.substring(1); //将属性的首字符大写，方便构造get，set方法
            String cFieldType = field[j].getGenericType().toString();    //获取属性的类型

            Method m = null;
            try {
                m = obj.getClass().getMethod("get" + cFieldName);
                if (m.isAnnotationPresent(Column.class)) {

                }
                objFieldValue = m.invoke(obj);    //调用getter方法获取属性值
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            objInfo.put(cFieldName, objFieldValue);
        }
        return objInfo;
    }

    public static Object Map2Obj(Map<String, Object> vMap, Object objInfo) {
        for (String cFieldName : vMap.keySet()) {
            Object objFieldValue = vMap.get(cFieldName);
            if (objFieldValue == null) {
                continue;
            }
            Field[] FieldList = objInfo.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
            for (int j = 0; j < FieldList.length; j++) {     //遍历所有属性
                String cMethodName = FieldList[j].getName();    //获取属性的名字
                if (cFieldName.equalsIgnoreCase(cMethodName)) {
                    cMethodName = cMethodName.substring(0, 1).toUpperCase() + cMethodName.substring(1); //将属性的首字符大写，方便构造get，set方法
                    Method m = null;
                    try {
                        m = objInfo.getClass().getMethod("set" + cMethodName, objFieldValue.getClass());
                        m.invoke(objInfo, objFieldValue);    //调用getter方法获取属性值
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        return objInfo;
    }

    public static String Insert(Object obj) {
        List<String> FieldList = new ArrayList<String>();
        List<Object> ValueList = new ArrayList<Object>();

        Field[] field = obj.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++) {     //遍历所有属性
            String cFieldName = field[j].getName();    //获取属性的名字
            Object objFieldValue = null;
            cFieldName = cFieldName.substring(0, 1).toUpperCase() + cFieldName.substring(1); //将属性的首字符大写，方便构造get，set方法
            String cFieldType = field[j].getGenericType().toString();    //获取属性的类型

            Method m = null;
            try {
                m = obj.getClass().getMethod("get" + cFieldName);
                objFieldValue = m.invoke(obj);    //调用getter方法获取属性值
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            ValueList.add(objFieldValue);
        }
        String cClassName = obj.getClass().toString();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO " + cClassName);
        sql.append(" ( ");
        for (int i = 0; i < FieldList.size(); i++) {
            String cFieldName = FieldList.get(i);
            if (i == 0)
                sql.append(cFieldName);
            else
                sql.append("," + cFieldName);
        }
        sql.append(" )");
        sql.append(" VALUES ( ");

        for (int i = 0; i < ValueList.size(); i++) {
            Object objValue = ValueList.get(i);
            String cFieldValue = (objValue == null) ? "null" : "'" + objValue.toString() + "'";
            if (i == 0)
                sql.append(cFieldValue);
            else
                sql.append("," + cFieldValue);
        }
        sql.append(" )");
        return sql.toString();
    }
}
