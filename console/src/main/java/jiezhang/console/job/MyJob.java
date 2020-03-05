package jiezhang.console.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJob {

    @Scheduled(fixedDelay = 1000)
    public void run() {
        System.out.println("打印定时任务");
    }
}
