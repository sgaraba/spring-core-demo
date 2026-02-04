package md.utm2026.p3.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "utm2026")
public record AppProperties(
        String name,
        String descrition,
        Notification notification
) {

    public record Notification(Boolean enabled, String url) {

    }
}
