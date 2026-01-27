package md.utm2026.p3;

import md.utm2026.p3.domain.Task;
import md.utm2026.p3.service.TaskService;
import md.utm2026.p3.service.TaskService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class P3Application implements CommandLineRunner {

    private final TaskService taskService;
    private final TaskService2 taskService2;

    public P3Application(
            TaskService taskService,
            TaskService2 taskService2
    ) {
        this.taskService = taskService;
        this.taskService2 = taskService2;
    }

    static void main(String[] args) {
        SpringApplication.run(P3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.err.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        List<Task> tasks = List.of(
                new Task("t1", "descripton1"),
                new Task("t2", "descripton2")
        );
        taskService.printTaskList(tasks);

        List<Task> tasks2 = List.of(
                new Task("t3", "descripton3"),
                new Task("t4", "descripton4")
        );
        taskService2.printTaskList(tasks2);

        List<Task> tasks3 = List.of(
                new Task("t5", "descripton5"),
                new Task("t6", "descripton6")
        );
        taskService2.getTaskService().printTaskList(tasks3);
    }

    @Autowired
    public void printTaskList(TaskService service) {
        service.hello();
    }
}
