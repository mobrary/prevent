package com.tlkj.CommonUtils;

import com.tlkj.framework.AutoID;
import com.tlkj.framework.DateUtil;

public class AppManager {
    public static String Explain(String cStr) {
        if (StringEx.isEmpty(cStr)) {
            return cStr;
        } else {
            String cDayNum = DateUtil.getDayNum();
            cStr = cStr.replace("{YYYY}", cDayNum.substring(1, 4));
            cStr = cStr.replace("{MM}", cDayNum.substring(5, 2));
            cStr = cStr.replace("{DD}", cDayNum.substring(7, 2));
            cStr = cStr.replace("{ID}", AutoID.getAutoID().getID());
            return cStr;
        }
    }

    public static String getOrgID(String cORG_ID) {
        if (StringEx.isEmpty(cORG_ID))
            return "";
        else {
            try {
                return cORG_ID.substring(0, 8);
            } catch (Exception ex) {
                return cORG_ID;
            }
        }
    }
}
