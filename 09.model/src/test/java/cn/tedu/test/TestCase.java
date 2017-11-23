package cn.tedu.test;

import cn.tedu.entity.Human;
import cn.tedu.entity.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by Administrator on 17.11.19.
 */
public class TestCase {
    @Test
    public void test(){
        System.out.println(11);
        SortedSet<String>set=new TreeSet<>();// SortedSet 不允许null值
        set.add(null);
        Set<String>set1=new HashSet<>();
        set1.add(null);
        set1.add(null);
        System.out.println(set1);
    }
    @Test
    public void test1(){
        Human human=new Human();
       Person p=new Person();
        p.gg();

    }
}
