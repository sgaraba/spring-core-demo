package condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnWindowsCondition implements Condition {

    public static final String WINDOWS = "windows";
    public static final String LINUX = "linux";
    public static final String OS_NAME = "os.name";

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String os = System.getProperty(OS_NAME);
        return os != null && os.toLowerCase().contains(LINUX);
    }
}
