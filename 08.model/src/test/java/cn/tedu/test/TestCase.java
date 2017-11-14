package cn.tedu.test;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Administrator on 17.11.5.
 */
public class TestCase {
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("caocao");
        list.add("liubei");
        list.add("sunquan");
        System.out.println(list);
        list.set(1, "caozhang");
        System.out.println(list);

        ListIterator iterator=list.listIterator();
        while(iterator.hasNext()){
            String s= (String) iterator.next();
            System.out.println(s);
        }
        while(iterator.hasPrevious()){
            String s= (String) iterator.previous();
            if(s.equals("caocao")){
                iterator.remove();
            }
            System.out.println(s);

        }
        System.out.println(list);
    }
    @Test
    public void test1() {
        Lccont lccont=new Lccont();
        lccont.setName("乌磅");
        lccont.setAge("35");
        System.out.println(lccont);
        Lccont lccont1= (Lccont) lccont.clone();
        System.out.println(lccont1);
        lccont1.setAge("aa");
        System.out.println(lccont.getAge());
        System.out.println(lccont.equals(lccont1));

    }
}
class LcAppnt {
    public LcAppnt() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
class Lccont implements Cloneable,Serializable{
    private static final long serialVersionUID = 3810734077027698659L;
    String name;
    String age;
    public Object clone(){
               Object o=null;
                 try {
                         o=super.clone();
                     } catch (CloneNotSupportedException e) {
                         e.printStackTrace();
                     }
                 return o;
             }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Lccont{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}