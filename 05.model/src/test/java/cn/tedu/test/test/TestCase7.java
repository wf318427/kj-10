package cn.tedu.test.test;

import cn.tedu.entity.Country;
import cn.tedu.entity.Emp;
import cn.tedu.entity.Person;
import cn.tedu.entity.Province;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 17.11.18.
 */
public class TestCase7 {
    @Test
    public void test() throws FileNotFoundException, UnsupportedEncodingException {
        Country country=new Country();
        country.setName("中国");
        List<Province> provinceList=new ArrayList<>();
        Province p1=new Province();
        p1.setProvCity("呼和浩特市");
        p1.setName("内蒙古");
        Province p2=new Province();
        p2.setName("山西省");
        p2.setProvCity("太原市");
        provinceList.add(p1);
        provinceList.add(p2);
        country.setProvinceList(provinceList);
        XStream xStream=new XStream();
        xStream.alias("country",Country.class);// 指定类的别名
        xStream.alias("province",Province.class);//
        xStream.aliasField("provinces",Country.class,"provinceList");
        String xml=xStream.toXML(country);
        System.out.println(xml);
        PrintWriter printWriter=new PrintWriter("src/main/resources/country.xml","utf-8");
        xStream.toXML(country,printWriter);
        Country country1= (Country) xStream.fromXML(xml);
        //System.out.println(country1);

        Country country2= (Country) xStream.fromXML(new FileInputStream("src/main/resources/country.xml"));
        System.out.println(country2);

    }
    @Test
    public void test1(){
        Emp emp=new  Emp();
        emp.setId(1);
        emp.setName("caocao");
        emp.setAge(20);
        Person person=new Person();
        person.setEmp_name("liubei");
        person.setEmp_id(1);
        List list=new ArrayList();
        list.add("a");
        list.add(emp);
        list.add(person);
        Country country=new Country();
        country.setProvinceList(list);
        XStream stream=new XStream();
        stream.alias("country",Country.class);
        stream.alias("emp",Emp.class);
        stream.alias("person",Person.class);
        stream.aliasField("id",Person.class,"emp_id");
        stream.aliasField("name",Person.class,"emp_name");
        String s =stream.toXML(country);
        System.out.println(s);

    }
}
