package md.utm2026.p3.service;

import md.utm2026.p3.domain.Task;
import md.utm2026.p3.service.dto.UserCreatEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class TaskService2 {

    public final Executor taskExecutor;
    private final TaskService taskService;
    private final ApplicationEventPublisher eventPublisher;

    public TaskService2(ThreadPoolTaskExecutor taskExecutor, TaskService taskService, ApplicationEventPublisher eventPublisher) {
        this.taskExecutor = taskExecutor;
        this.taskService = taskService;
        this.eventPublisher = eventPublisher;
    }

    @Async
    public void printTaskList(List<Task> taskList) {
        System.out.println("TaskService 2");
        System.err.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        taskList.forEach(System.err::println);

        System.out.println("Publish event ...");

        eventPublisher.publishEvent(new UserCreatEvent("john", Instant.now()));
    }

    public TaskService getTaskService() {
        return taskService;
    }
}
