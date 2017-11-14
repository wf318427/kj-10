package cn.tedu.utils;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public SpringContextUtils() {
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBeanById(String id) {
        if(applicationContext == null) {
            return null;
        } else {
            return applicationContext.getBean(id);
        }
    }

    public static <T> T getBeanByClass(Class<T> c) {
        if(applicationContext == null) {
            return null;
        } else {
            return applicationContext.getBean(c);
        }
    }

    public static Map getBeansByClass(Class c) {
        if(applicationContext == null) {
            return null;
        } else {
            return applicationContext.getBeansOfType(c);
        }
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext = applicationContext;
    }
}
