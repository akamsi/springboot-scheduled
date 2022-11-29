package com.springboot.scheduled.springbootscheduled.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@EnableAsync
@EnableScheduling
public class FixedRateParallel {

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        return threadPoolTaskScheduler;
    }

    @Async
    @Scheduled(fixedRate = 2000)
    public void scheduleFixedRateAsync() throws InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("[Fixed Rate Parallel] - Task is started at " + dtf.format(LocalDateTime.now()));
        Thread.sleep(10000);
    }
}
