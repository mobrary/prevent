package com.tlkj.Utils;

import org.activiti.engine.*;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.task.Task;

import java.util.List;

public class GZL {
    public static void main(String[] args) {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        // 连接数据库的配置
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration
                .setJdbcUrl("jdbc:mysql://192.168.1.9:3306/gw?useUnicode=true&characterEncoding=utf8");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("123456");

        /**
         * public static final String DB_SCHEMA_UPDATE_FALSE = "false";不能自动创建表，需要表存在
         * public static final String DB_SCHEMA_UPDATE_CREATE_DROP =
         * "create-drop";先删除表再创建表 public static final String DB_SCHEMA_UPDATE_TRUE =
         * "true";如果表不存在，自动创建表
         */
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);
        // 工作流的核心对象，ProcessEnginee对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        System.out.println("processEngine:" + processEngine);

        RepositoryService repositoryService = processEngine.getRepositoryService();
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addClasspathResource("fw.bpmn");//bpmn文件的名称
        builder.deploy();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.startProcessInstanceByKey("fw");//流程的名称，也可以使用ByID来启动流程

        TaskService taskService = processEngine.getTaskService();
        //根据assignee(代理人)查询任务
        String assignee = "荆利杰";
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(assignee).list();

        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            Task task = tasks.get(i);

        }
        //首次运行的时候这个没有输出，因为第一次运行的时候扫描act_ru_task的表里面是空的，但第一次运行完成之后里面会添加一条记录，之后每次运行里面都会添加一条记录
        for (Task task : tasks) {
            System.out.println("taskId:" + task.getId() +
                    ",taskName:" + task.getName() +
                    ",assignee:" + task.getAssignee() +
                    ",createTime:" + task.getCreateTime());
        }

        taskService = processEngine.getTaskService();
        //根据上一步生成的taskId执行任务
        String taskId = "20008";
        taskService.complete(taskId);
    }

    public void queryTask() {

    }
}
