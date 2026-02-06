package md.utm2026.p3.service.dto;

import java.time.Instant;

public record UserCreatEvent(String username, Instant createdDate) {
}
