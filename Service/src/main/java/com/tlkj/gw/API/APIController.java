package com.tlkj.gw.API;

import com.alibaba.druid.pool.DruidDataSource;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.tlkj.CommonUtils.ActiveResult;
import com.tlkj.framework.TLKJController;
import com.tlkj.gw.rest.S_ORG_INFController;
import io.jboot.web.controller.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api")
public class APIController extends TLKJController {
    public void list() {
        List<Record> records = Db.find("select * from S_USER_INF");
        renderJson(records);
    }

    public void user_login() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = USER_API.APP_USER_LOGIN(request, response);
        renderJson(vret);
    }

    public void login() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = WEB_API.USER_LOGIN(request, response);
        renderJson(vret);
    }

    public void menu() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = WEB_API.getList(request, response);
        renderJson(vret);
    }

    public void modify_pass() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = USER_API.ModifyKeyWord(request, response);
        renderJson(vret);
    }

    public void feed_back() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = SYS_API.Feed_Back(request, response);
        renderJson(vret);
    }


    public void conf_list() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = CONF_API.QueryList(request, response);
        renderJson(vret);
    }

    public void read_flag() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = CONF_API.Read_Flag(request, response);
        renderJson(vret);
    }

    public void news_list() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = NEWS_API.QueryList(request, response);
        renderJson(vret);
    }

    //法律法规
    public void law_list() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = LAW_API.QueryList(request, response);
        renderJson(vret);
    }

    //电子档案
    public void archive_list() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = ARCHIVE_API.QueryList(request, response);
        renderJson(vret);
    }

    //通讯录
    public void phone_book_list() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = PHONE_BOOK_API.QueryList(request, response);
        renderJson(vret);
    }

    //通知公告
    public void notice_list() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = NOTICE_API.QueryList(request, response);
        renderJson(vret);
    }

    //科室
    public void gw_org() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = GW_API.orglist(request, response);
        renderJson(vret);
    }

    //人员
    public void gw_user() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = GW_API.userlist(request, response);
        renderJson(vret);
    }

    public void gw_list() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = GW_API.GW(request, response);
        renderJson(vret);
    }

    public void gw_pdf() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = GW_API.make_pdf(request, response);
        renderJson(vret);
    }

    public void gw_sign() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = GW_API.doSIGN(request, response);
        renderJson(vret);
    }

    public void gw_tg() {
        request = this.getRequest();
        response = this.getResponse();
        ActiveResult vret = GW_API.doTG(request, response);
        renderJson(vret);
    }
}