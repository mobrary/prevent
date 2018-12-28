package com.tlkj.CommonUtils;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class StringEx {

    public static String getStr(Object StrObj) {
        try {
            return getStr(StrObj.toString());
        } catch (Exception ex) {
            return "";
        }
    }

    public static boolean isEmpty(Object cValue) {
        if (cValue == null)
            return true;
        else {
            String cStr = String.valueOf(cValue);
            if (cStr.trim().length() == 0)
                return true;
            else
                return false;
        }
    }

    public static String getAllowValue(Object cValue) {
        try {
            if (cValue != null) {
                return cValue.toString().equals("1") ? "是" : "否";
            } else {
                return "是";
            }
        } catch (Exception ex) {
            return "否";
        }
    }

    public static String getDateStr(Date vDate, String cFormat) {
        if (vDate == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(cFormat);
        String cStr = "";
        try {
            cStr = sdf.format(vDate);
        } catch (Exception e) {
            ;
        }
        return cStr;
    }

    public static Date getDateValue(String cDate, String cFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(cFormat);
        Date vDate = null;
        try {
            vDate = sdf.parse(cDate);
        } catch (ParseException e) {
            ;
        }
        return vDate;
    }

    public static String getDBValue(String cValue) {
        if (cValue == null)
            return "";
        else
            return cValue.trim();
    }

    public static String getDateTime(String cValue) {
        cValue = cValue == null ? "" : cValue.toString();
        cValue = cValue.replace(".0", "");
        // cValue= cValue.replace(" 00:00:00","");
        return cValue;
    }

    public static String getPageValue(Object objValue) {
        String cValue = objValue == null ? "" : objValue.toString();
        if (cValue.length() > 0) {
            return cValue.toString();
        } else {
            return "";
        }
    }

    public static String getPageValue(Object objValue, int iLength) {
        String cValue = objValue == null ? "" : objValue.toString();
        if (cValue.length() > iLength) {
            return cValue.substring(0, iLength) + "...";
        } else {
            return cValue;
        }
    }

    public static String getStr(String cStr) {
        if (cStr == null)
            return "";
        try {
            return cStr.toString().trim();
        } catch (Exception ex) {
            return "";
        }
    }

    public static String getSafeParm(String cStr) {
        if (cStr == null)
            return "";
        try {
            String cVal = cStr;
            cVal = cVal.replace("-", "");
            cVal = cVal.replace(">", "");
            cVal = cVal.replace(";", "");
            return cVal;
        } catch (Exception ex) {
            return "";
        }
    }

    public static String getStr(String cStr, String StrDefvalue) {
        if (cStr == null)
            return StrDefvalue;
        else
            return getStr(cStr);
    }

    public static String getStr(String cStr, int iLength) {
        String StrValue = StringEx.getStr(cStr);
        if (StrValue.length() > iLength)
            return StrValue.substring(0, iLength) + "...";
        else
            return StrValue;
    }

    public static String getStr(ResultSet rs, int iRowID, String StrFieldName) {
        try {
            rs.absolute(iRowID);
            return rs.getString(StrFieldName).trim();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    @SuppressWarnings("rawtypes")
    public static String getStr(List rs, int iRowID, String StrFieldName) {
        try {
            Map row = (Map) rs.get(iRowID);
            return row.get(StrFieldName).toString().trim();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String getStr(Map<String, Object> rs, String StrFieldName) {
        try {
            return StringEx.getStr(rs.get(StrFieldName));
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static String getMapVal(Map<String, Object> rs, String StrFieldName) {
        try {
            return StringEx.getStr(rs.get(StrFieldName));
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static int getInt(Object iObj) {
        String StrObj = StringEx.getStr(iObj);
        return getInt(StrObj);
    }

    public static int getInt(String StrObj) {
        try {
            return Integer.parseInt(StrObj);
        } catch (Exception ex) {
            return 0;
        }
    }

    public static Long getLong(String cValue) {
        try {
            return Long.parseLong(cValue);
        } catch (Exception ex) {
            return 0L;
        }
    }

    public static int getInt(Object Obj, int iDefvalue) {
        if (Obj == null)
            return iDefvalue;
        else {
            String cStr = getStr(Obj);
            return StringEx.getInt(cStr, iDefvalue);
        }
    }

    public static int getInt(String StrObj, int iDefvalue) {
        if ((StrObj == null) || (StrObj.length() == 0))
            return iDefvalue;
        else
            return StringEx.getInt(StrObj);
    }

    public static int getInt(ResultSet rs, int iRowID, String cFieldName) {
        try {
            rs.absolute(iRowID);
            return rs.getInt(cFieldName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static int getInt(Map<String, Object> rs, String cFieldName) {
        try {
            return StringEx.getInt(rs.get(cFieldName));
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static float getFloat(Object iObj) {
        String StrObj = StringEx.getStr(iObj);
        return Float.parseFloat(StrObj);
    }

    public static float getFloat(String StrObj) {
        return Float.parseFloat(StrObj);
    }

    public static float getFloat(String StrObj, float fDefvalue) {
        if (StrObj == null)
            return fDefvalue;
        else
            return StringEx.getFloat(StrObj);
    }

    public static float getFloat(ResultSet rs, int iRowID, String cFieldName) {
        try {
            rs.absolute(iRowID);
            return rs.getFloat(cFieldName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static float getFloat(Map<String, Object> rs, String cFieldName) {
        try {
            return StringEx.getFloat(rs.get(cFieldName));
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public static List<String> split(String cStr, String delim) {
        List<String> splitList = null;
        StringTokenizer st = null;

        if (cStr == null)
            return splitList;

        if (delim != null)
            st = new StringTokenizer(cStr, delim);
        else
            st = new StringTokenizer(cStr);

        if (st != null && st.hasMoreTokens()) {
            splitList = new ArrayList<String>();

            while (st.hasMoreTokens())
                splitList.add(st.nextToken());
        }
        return splitList;
    }

    public static String replace(String mainString, String oldString, String newString) {
        if (mainString == null)
            return null;
        int i = mainString.lastIndexOf(oldString);
        if (i < 0)
            return mainString;
        StringBuffer mainSb = new StringBuffer(mainString);
        while (i >= 0) {
            mainSb.replace(i, i + oldString.length(), newString);
            i = mainString.lastIndexOf(oldString, i - 1);
        }
        return mainSb.toString();
    }

    public static String getLastNumericStr(String cStr) {
        StringBuffer sb = new StringBuffer();
        for (int i = cStr.length() - 1; i >= 0; i--) {
            char ch = cStr.charAt(i);
            if ((ch >= '0') && (ch <= '9')) {
                sb.insert(0, cStr.charAt(i));
            } else {
                break;
            }

        }
        return sb.toString();
    }

    public static String getDateVal(String cStr) {
        cStr = cStr.replace("/", "-").replace("年", "-").replace("月", "-").replace("日", " ").replace("  ", " ");
        StringBuffer sb = new StringBuffer();
        boolean isVal = false;
        for (int i = 0; i < cStr.length(); i++) {
            char ch = cStr.charAt(i);
            String cv = String.valueOf(ch);
            if ((ch >= '0') && (ch <= '9')) {
                isVal = true;
                sb.append(cStr.charAt(i));
            } else if (cv.equals("-")) {
                if (isVal) {
                    sb.append(cStr.charAt(i));
                }
            } else if (cv.equals(":")) {
                if (isVal) {
                    sb.append(cStr.charAt(i));
                }
            } else if (cv.equals(" ")) {
                if (isVal) {
                    sb.append(cStr.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    public static int getIntVal(String cStr) {
        StringBuffer sb = new StringBuffer();
        boolean isStarted = false;
        for (int i = 0; i < cStr.length(); i++) {
            char ch = cStr.charAt(i);
            if ((ch >= '0') && (ch <= '9')) {
                if (!isStarted) {
                    isStarted = true;
                }
                sb.append(cStr.charAt(i));
            } else {
                if (isStarted) {
                    break;
                }
            }
        }
        return getInt(sb.toString());
    }

    public static void main(String[] arg) {
        System.out.println(getDateVal("    2016-04-21 15:51:58"));
        System.out.println(getIntVal("    回复：100，点击:300"));
    }
}