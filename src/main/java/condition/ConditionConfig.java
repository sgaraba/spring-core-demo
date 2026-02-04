package condition;


import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(OnWindowsCondition.class)
    public NativeFileWatcher nativeFileWatcher() {
        return new NativeFileWatcher();
    }

    @Bean
    @ConditionalOnClass(name = "org.springframework.data.redis.core.RedisTemplate")
    public CacheClient redisCacheClient() {
        return new RedisCacheClient();
    }

    @Bean
    @ConditionalOnProperty(
            prefix = "utm2026.notification",
            name = "enabled",
            havingValue = "true",
            matchIfMissing = false
    )
    public NotificationSender notificationSender() {
        return new EmailNotificationSender();
    }
}