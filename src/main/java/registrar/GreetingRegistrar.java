package registrar;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.Map;

public class GreetingRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 1) feature flag din config
        boolean enabled = env.getProperty("greeting.enabled", Boolean.class, true);
        if (!enabled) {
            return; // nu înregistrăm nimic
        }

        // 2) valoare din adnotare
        String prefixFromAnnotation = "Hello";
        Map<String, Object> attrs = importingClassMetadata.getAnnotationAttributes(EnableGreeting.class.getName());

        if (attrs != null && attrs.get("prefix") instanceof String p && StringUtils.hasText(p)) {
            prefixFromAnnotation = p;
        }

        // 3) valoare din application.yml (dacă există, are prioritate)
        String prefixFromConfig = env.getProperty("greeting.prefix");

        String finalPrefix = StringUtils.hasText(prefixFromConfig)
                ? prefixFromConfig
                : prefixFromAnnotation;

        // 4) înregistrare bean definition
        String beanName = "greetingService";
        if (!registry.containsBeanDefinition(beanName)) {
            var bd = BeanDefinitionBuilder
                    .genericBeanDefinition(GreetingService.class)
                    .addConstructorArgValue(finalPrefix)
                    .getBeanDefinition();

            registry.registerBeanDefinition(beanName, bd);
        }
    }
}
