package cn.tedu.controller;

import cn.tedu.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 17.10.15.
 */
@RestController
public class Logincontroller {
    @Autowired
    WeatherService weatherService;
    @RequestMapping("hello")
    public String hello(){
        weatherService.printMessage();
        return "hello";
    }
}
