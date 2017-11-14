package cn.tedu.test.test;

import cn.tedu.entity.Emp;
import org.junit.Test;
import org.junit.internal.Classes;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.validator.ValidateWith;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 17.11.9.
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({TestCase3.class,TestCase4.class})
public class TestCase5 {
    @Test
    public void test(){
        String man=null;
        try {
            Properties properties=new Properties();
            try {
                properties.load(Emp.class.getClassLoader().getResourceAsStream("application.properties"));
                 man=properties.getProperty("man");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Human human= (Human) Class.forName(man).newInstance();
            System.out.println(Man.class.getName());
            human.ff();
        } catch (InstantiationException e) {// 调用构造器异常
            e.printStackTrace();
        } catch (IllegalAccessException e) {// 构造器访问权限异常 illagal 非法的 access 入口
            e.printStackTrace();
        } catch (ClassNotFoundException e) {// 类加载异常
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){

    }
}
class Man extends Human{
    private String name;
    public void ff(){
        System.out.println("man");
    }

    public Man(String name) {
        this.name = name;
    }

    public Man() {
    }
}
class Human {
    public void ff(){
        System.out.println("Human");
    }
}
class Wanman extends Human{
    @Override
    public void ff() {
        System.out.println("Wanman");
    }
}
