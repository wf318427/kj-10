package cn.tedu.test;

import org.junit.Test;
import org.omg.CORBA.DoubleHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.SerializationUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * Created by Administrator on 17.10.15.
 */
public class TestCase {
    @Test
    public void test() {
        System.out.println(Double.parseDouble(new Lcprem().getPrem()));
        System.out.println(Integer.parseInt(new Lcprem().getPrem()));
    }

    @Test
    public void test1() {
        MultiValueMap<String, Integer> map = new LinkedMultiValueMap<>();
        System.out.println(StringUtils.capitalize("abc"));
        String s = null;
        System.out.println(StringUtils.hasLength(s));
        System.out.println(StringUtils.hasText(s));
    }

    @Test
    public void test2() {
        Lcprem lcprem=new Lcprem();
        lcprem.setPrem("200");
        byte[] b= SerializationUtils.serialize(lcprem);
        System.out.println(new String(b));
        Lcprem lcprem1= (Lcprem) SerializationUtils.deserialize(b);
        System.out.println(lcprem1);

    }
    @Test
    public void test3() {
        String s="aaabbbbccbbddbb";
//        System.out.println(StringUtils.trimTrailingCharacter(s));
        for(int i=0;i<s.length();i++){
            System.out.println(s.charAt(i)+": "+StringUtils.countOccurrencesOf(s,String.valueOf(s.charAt(i))));
        }
        String[] strings ={"a","b","a","c","a"};
        String[] strings1=StringUtils.removeDuplicateStrings(strings);
        for(String str:strings1){
            System.out.println(str);
        }


    }
}
























class Lcprem implements Serializable{
    private String prem;

    public String getPrem() {
        if ("".equals(this.prem) || this.prem == null) {
            prem = "0";
        }
        return prem;
    }

    public void setPrem(String prem) {
        this.prem = prem;
    }

    @Override
    public String toString() {
        return "Lcprem{" +
                "prem='" + prem + '\'' +
                '}';
    }
}

class A {
    public void ss() {
        System.out.println(1 / 0);
    }
}