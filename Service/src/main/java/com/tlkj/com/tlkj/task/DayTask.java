package com.tlkj.com.tlkj.task;

public class DayTask implements Runnable {
    @Override
    public void run() {
        System.out.println("执行了任务");
    }
}
