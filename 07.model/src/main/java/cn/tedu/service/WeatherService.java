package cn.tedu.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 17.10.15.
 */
@Service
public class WeatherService {
    @Value("${name}")
    String name;
    public void printMessage(){
        System.out.println("WeatherService");
        System.out.println(name);
    }
}
