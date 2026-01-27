package md.utm2026.p3.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskServiceBeanPostPreprocessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean.getClass().getSimpleName().equalsIgnoreCase("taskService2")) {
            System.err.println("Bean '" + bean.getClass().getName() + "' created : ");
        }
        return bean;
    }
}
