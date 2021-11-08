package jiezhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableDiscoveryClient
@EnableElasticsearchRepositories(basePackages = "jiezhang.repository")
public class ConsoleApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConsoleApplication.class, args);
        System.out.println("启动完成");
    }


}
