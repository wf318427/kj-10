package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Administrator on 17.10.15.
 */
@SpringBootApplication
//@PropertySource(value = "classpath:application-test.properties",encoding = "gbk")
public class StartApp {
    public static void main(String[] args) {
        SpringApplication.run(StartApp.class,args);
    }
}
