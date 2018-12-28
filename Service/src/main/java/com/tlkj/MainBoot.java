package com.tlkj;

import com.alibaba.druid.pool.DruidDataSource;
import com.jfinal.config.Plugins;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import io.jboot.Jboot;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;

@RequestMapping("/")
public class MainBoot extends JbootController {
    public static void main(String[] args) {
        Jboot.run(args);
    }

    public void configPlugin(Plugins me) {
        Cron4jPlugin cp = new Cron4jPlugin(PropKit.use("quarter.properties"), "cron4j");
        me.add(cp);
    }
}