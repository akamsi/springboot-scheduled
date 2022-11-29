package com.springboot.scheduled.springbootscheduled.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableScheduling
public class FixedDelayConfig {

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() throws InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("[Fixed Delay] - Task starts now at " + dtf.format(LocalDateTime.now()));
        Thread.sleep(3000);
        System.out.println("[Fixed Delay] - Task is finished at "  + dtf.format(LocalDateTime.now()));
    }
}
