package com.tlkj.framework;

import com.tlkj.CommonUtils.StringEx;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validity {

    public static boolean ValidateLength(String str, int len) {
        if (str.trim().length() <= len) {
            return true;
        }
        return false;
    }

    public static boolean IsNumeric(String StrValue) {
        try {
            Double.parseDouble(StrValue);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static Boolean isMobile(String cTelNo) {
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(cTelNo);
        return m.matches();
    }

    public static Boolean isEmail(String cTelNo) {
        Pattern pattern = Pattern
                .compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = pattern.matcher(cTelNo);
        return m.matches();
    }

    public static Boolean isIpAddr(String cIPaddr) {
        Pattern pattern = Pattern
                .compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
        Matcher m = pattern.matcher(cIPaddr); // 以验 ?27.400.600.2为例
        return m.matches();
    }

    public static boolean IsDate(String StrDay) {
        DateFormat myDTF = new SimpleDateFormat("yyyy-MM-dd");
        try {
            myDTF.parse(StrDay);
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            myDTF = null;
        }
    }

    public static boolean IsTime(String StrDay) {
        DateFormat myDTF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            myDTF.parse(StrDay);
            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            myDTF = null;
        }
    }

    public static boolean IsEmpty(String obj) {
        String StrValue = StringEx.getStr(obj);
        if (StrValue.length() > 0)
            return true;
        else
            return false;
    }

    public static boolean IsDateTime(String strFieldValue) {
        if (IsDate(strFieldValue))
            return true;
        else if (IsTime(strFieldValue))
            return true;
        else
            return false;
    }
}