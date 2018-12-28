package com.tlkj.CommonUtils;

import com.tlkj.framework.BeanUtil;
import io.jboot.aop.annotation.Bean;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RequestUtil {
    public static Object readFromRequest(HttpServletRequest request, Object obj) {
        Field[] field = obj.getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
        for (int j = 0; j < field.length; j++) {     //遍历所有属性
            String cFieldName = field[j].getName();    //获取属性的名字
            Object objFieldValue = request.getParameter(cFieldName);

            if (objFieldValue == null) {
                continue;
            }
            cFieldName = cFieldName.substring(0, 1).toUpperCase() + cFieldName.substring(1); //将属性的首字符大写，方便构造get，set方法
            String cFieldType = field[j].getGenericType().toString();    //获取属性的类型

            Method m = null;
            try {
                m = obj.getClass().getMethod("set" + cFieldName, objFieldValue.getClass());
                m.invoke(obj, objFieldValue);    //调用getter方法获取属性值
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
