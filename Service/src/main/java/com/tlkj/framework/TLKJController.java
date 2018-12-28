package com.tlkj.framework;

import com.tlkj.CommonUtils.AppConfig;
import com.tlkj.CommonUtils.StringEx;
import io.jboot.web.controller.JbootController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TLKJController extends JbootController {
    public HttpServletRequest request;
    public HttpServletResponse response;
    public String ITEM_KEY = "__dbkey";
    public int iPageNo = 1;
    public int iPageSize = 15;

    public void readQueryString() {
        String cLimit = StringEx.getSafeParm(request.getParameter("limit"));
        String cOffset = StringEx.getSafeParm(request.getParameter("offset"));

        if ((cLimit.length() > 0) && (cOffset.length() > 0)) {
            iPageSize = StringEx.getInt(cLimit, 15);
            int iOffset = StringEx.getInt(cOffset);
            iPageNo = (iOffset / iPageSize) + 1;
            if (iPageNo <= 0) {
                iPageNo = 1;
            }
        }
    }
}