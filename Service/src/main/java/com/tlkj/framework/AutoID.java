package com.tlkj.framework;

import com.jfinal.kit.PropKit;
import com.tlkj.CommonUtils.AppConfig;
import com.tlkj.CommonUtils.StringEx;

public class AutoID {
    private String ID;
    private String UPDATE_TIME;
    private static int OrderID = 0;
    private static String DayTime;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(String UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public static synchronized AutoID getAutoID() {
        return getAutoID("");
    }

    public static synchronized AutoID getAutoID(String cKeyID) {
        AutoID vKeyID = new AutoID();

        PropKit.use("jboot.properties");
        String cDayTimeNum = DayTime = DateUtil.getDayTimeNum();
        if (StringEx.isEmpty(DayTime)) {
            DayTime = cDayTimeNum;
            OrderID = 1;
        } else {
            if (cDayTimeNum.equals(DayTime)) {
                OrderID++;
            }
        }
        String cHostID = PropKit.get(AppConfig.HOST_ID, "00");
        String cStr = DayTime + "" + String.format("%08d", OrderID) + cKeyID + cHostID;
        vKeyID.setID(cStr);
        vKeyID.setUPDATE_TIME(DayTime);

        return vKeyID;
    }
}
