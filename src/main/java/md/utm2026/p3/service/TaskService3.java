package md.utm2026.p3.service;

import md.utm2026.p3.domain.Task;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TaskService3 {

    private TaskService2 taskService2;

    public TaskService3(TaskService2 taskService2) {
        this.taskService2 = taskService2;
    }

    public void printTaskList(List<Task> taskList) {
        System.out.println("TaskService 3");
        taskList.forEach(System.err::println);
    }
}
