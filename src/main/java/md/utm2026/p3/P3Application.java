package md.utm2026.p3;

import condition.ConditionConfig;
import condition.NotificationSender;
import md.utm2026.p3.config.AppProperties;
import md.utm2026.p3.domain.Task;
import md.utm2026.p3.dynamic.DynamicGreetingService;
import md.utm2026.p3.service.ITestService;
import md.utm2026.p3.service.TaskService;
import md.utm2026.p3.service.TaskService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import registrar.EnableGreeting;
import registrar.GreetingService;

import java.util.List;

@Import({ConditionConfig.class})
@SpringBootApplication()
@EnableGreeting(prefix = "Salut")
public class P3Application implements CommandLineRunner {

    private final TaskService taskService;
    private final TaskService2 taskService2;
    private final AppProperties appProperties;
    private final ITestService iTestService;
    private final NotificationSender notificationSender;
    private final DynamicGreetingService dynamicGreetingService;
    private final GreetingService greetingService;

    @Value("${spring.application.name}")
    private String val1;

    public P3Application(
            TaskService taskService,
            TaskService2 taskService2,
            AppProperties appProperties,
            ITestService iTestService,
            NotificationSender notificationSender,
            DynamicGreetingService dynamicGreetingService,
            GreetingService greetingService
    ) {
        this.taskService = taskService;
        this.taskService2 = taskService2;
        this.appProperties = appProperties;
        this.iTestService = iTestService;
        this.notificationSender = notificationSender;
        this.dynamicGreetingService = dynamicGreetingService;
        this.greetingService = greetingService;
    }

    static void main(String[] args) {
        SpringApplication.run(P3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        String greetingJoe = greetingService.greet("Joe");

        System.err.println(greetingJoe);

        String abaraCadabra = greetingService.greet("Abara Cadabra");

        System.err.println(abaraCadabra);

        String john = dynamicGreetingService.greet("John");
        System.err.println(john);
        iTestService.test("adcsdcsd");
        System.err.println("val1 = " + val1);

        System.err.println("appProperties.name() = " + appProperties.name());
        System.err.println("appProperties.descrition() = " + appProperties.descrition());

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

    public NotificationSender getNotificationSender() {
        return notificationSender;
    }
}
