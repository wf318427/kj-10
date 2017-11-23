package cn.tedu.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 17.11.21.
 */
public class TestCase2 {
    @Test
    public void test(){
        SubClass[] subArray = {new SubClass(), new SubClass()};
        System.out.println(subArray.getClass());

        // class [Lcollection.SubClass;
        BaseClass[] baseArray = subArray;
        System.out.println(baseArray.getClass());
        baseArray = java.util.Arrays.copyOf(baseArray, subArray.length, BaseClass[].class);

        /**
         * 假如我们有1个Object[]数组，并不代表着我们可以将Object对象存进去，这取决于数组中元素实际的类型。
         */
        baseArray[0]=new BaseClass();  //ArrayStoreException


    }
    @Test
    public void test1(){
        int[] i1={1,3,5,7};
//        String[] s= Arrays.copyOf(i1,i1.length,String[].class);
        List<String> list=new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        Object[] objects=list.toArray();
        System.out.println(objects.getClass()==Object[].class);
        objects[0]=new Object();

    }
}
class BaseClass{

}
class SubClass extends BaseClass{
    public<U> U[] ff(U[] u,Class<? extends U> t){// 泛型方法
        return u;
    }

}