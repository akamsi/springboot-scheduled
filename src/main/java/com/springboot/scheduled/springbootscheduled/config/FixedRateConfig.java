package com.springboot.scheduled.springbootscheduled.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableScheduling
public class FixedRateConfig {

    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("[Fixed Rate] - Task starts now at " + dtf.format(LocalDateTime.now()));
    }

}
