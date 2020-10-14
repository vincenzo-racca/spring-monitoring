package com.vincenzoracca.springmonitoring.client.custom;

import com.vincenzoracca.springmonitoring.client.repos.UserRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserHealthChecker implements HealthIndicator {

    private final UserRepository userRepository;

    public UserHealthChecker(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Health health() {
        Map<String,Long> inits = new HashMap<>();
        long count = userRepository.count();
        if(count > 0) {
            inits.put("userInit",count);
            return Health.up().withDetails(inits).build();
        }
        else {
            return Health.down().withDetail("userInit", "FAILED").
                    build();
        }
    }
}
