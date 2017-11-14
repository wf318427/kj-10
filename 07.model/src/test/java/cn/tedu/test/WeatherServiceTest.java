package cn.tedu.test;

import cn.tedu.service.Phone;
import cn.tedu.service.WeatherService;
import cn.tedu.test.TestSpringBoot;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 17.10.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WeatherServiceTest extends TestSpringBoot {
    @Autowired
    WeatherService weatherService;
    @Autowired
    Phone phone;
    @Value("${name}")
    String name;
    @Test
    public void printMessage() throws Exception {
        weatherService.printMessage();
        System.out.println(name);
    }
    public void test(){
        System.out.println("ssssssssssssssssssssssssssssss");
    }

}