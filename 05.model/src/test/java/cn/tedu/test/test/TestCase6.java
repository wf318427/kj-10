package cn.tedu.test.test;

import cn.tedu.entity.Emp;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.util.SerializationUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 17.11.12.
 */
public class TestCase6  {
    @Test
    public void test(){
        System.out.println(System.getenv());
    }
    @Test
    public void test1(){
        Emp p=new Emp();
        p.setName("caocao");
        p.setAge(45);
        p.setId(1);
        byte[] b= SerializationUtils.serialize(p);
        System.out.println(new String(b));
        System.out.println(SerializationUtils.deserialize(b));


    }
}
