package md.utm2026.p3.service;

import jakarta.annotation.PostConstruct;
import md.utm2026.p3.domain.Task;

import java.util.List;

public class TaskService {

    public TaskService() {
    }

    @PostConstruct
    void init() {
        System.err.println("Init post construct TaskService 1" + this);
    }

    public void printTaskList(List<Task> taskList) {
        System.err.println("TaskService 1");
        taskList.forEach(System.err::println);
    }

    public void hello() {
        System.out.println("hello");
    }

}
