package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 17.11.19.
 */
@EnableEurekaServer
@SpringBootApplication

public class StartApp {
    /**
     * main 方法psvm
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class,args);
    }
}
