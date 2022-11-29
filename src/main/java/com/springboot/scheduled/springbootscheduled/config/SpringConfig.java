package com.springboot.scheduled.springbootscheduled.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableScheduling
public class SpringConfig {

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() throws InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("[Fixed Delay] - " + System.currentTimeMillis() / 1000);
        System.out.println("[Fixed Delay] - Time now is " + dtf.format(now));
        Thread.sleep(3000);
    }
}
