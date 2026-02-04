package registrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(GreetingRegistrar.class)
public @interface EnableGreeting {
    String prefix() default "Hello";
}