package md.utm2026.p3.dynamic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class DynamicBeanRegistrar implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String beanName = "dynamicGreetingService";
        if (!registry.containsBeanDefinition(beanName)) {
            var bd = BeanDefinitionBuilder
                    .genericBeanDefinition(DynamicGreetingService.class)
                    .setLazyInit(false)
                    .getBeanDefinition();

            registry.registerBeanDefinition(beanName, bd);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // aici poți ajusta proprietăți la nivel de BeanFactory (opțional)
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}