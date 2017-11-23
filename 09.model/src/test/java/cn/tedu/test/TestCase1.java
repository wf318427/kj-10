package cn.tedu.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 17.11.20.
 */
public class TestCase1 {
    @Test
    public void test(){
        List<String>list=new ArrayList<>();// 默认底层创建 容量为 10 的数组
        list.add("ssss");
        list.add("aaaa");
        String[] strings=list.toArray(new String[list.size()]);// 集合转数组
        for(String s:strings){
            System.out.println(s);
        }
    }
    @Test
    public void test1(){
        int[] i1={1,3,5};
        int[] i2={2,4,6};
        i1= Arrays.copyOf(i1,i1.length+i2.length);// Arrays.copayOf() 数组扩容
        System.out.println(i1.length);
        System.out.println(i1[3]);
        System.arraycopy(i2,0,i1,3,i2.length); // 复制指定数组到目的数组
        System.out.println(i1.length);
        System.out.println(i1[3]);



    }
}
