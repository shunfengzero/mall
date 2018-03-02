package com.test.controller;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ActController {

    ProcessInstance processInstance;
    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;
    @RequestMapping("start")
    public String start(Model model) {
        //启动流程实例
        processInstance = runtimeService.startProcessInstanceByKey("qj");
        System.out.println(processInstance.getId());
        model.addAttribute("pid",processInstance.getId());
        return "fill";
    }


    //填写请假信息
    @RequestMapping("fill2")
    @ResponseBody
    public String fill(@RequestParam Map<String, Object> data) {


        List<Task> tasks = taskService.createTaskQuery().processInstanceId(data.get("pid").toString()).list();
        Task task = tasks.get(0);
        data.remove("pid");
        taskService.setVariables(task.getId(),data);
        //结束填写假单信息的任务
        taskService.complete(task.getId());
        return "结束填写假单信息的任务";
    }

    //显示待批任务
    @RequestMapping("toAudit")
    public String toAudit(Model model) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("李四").list();
        model.addAttribute("tasks",tasks);
        return "audit";

    }

    //查看申请的数据
    @RequestMapping("audit2/{taskid}")
    public String audit2(@PathVariable String taskid, Model model) {
        model.addAllAttributes(taskService.getVariables(taskid));
        return "fill";
    }

    //审批
    @RequestMapping("doaudit")
    public String audit() {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("李四").list();
        //获取李四要执行的任务
        Task task = tasks.get(0);
        taskService.getVariable(task.getId(),"reason");
        taskService.setVariable(task.getId(),"yijian","同意");
        taskService.complete(task.getId());
        return "审批完成";
    }

}
