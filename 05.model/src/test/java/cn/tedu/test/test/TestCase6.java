package cn.tedu.test.test;

import cn.tedu.entity.Country;
import cn.tedu.entity.Emp;
import cn.tedu.entity.Person;
import cn.tedu.entity.Province;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.util.SerializationUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLEventWriter;
import java.io.StringWriter;
import java.util.ArrayList;
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
    @Test
    public void test3() throws JAXBException {
        Emp p=new Emp();
        p.setName("caocao");
        p.setAge(45);
        p.setId(1);
        Person person=new Person();
        person.setEmp_id(1);
        person.setEmp_name("caochong");
        Person person1=new Person();
        person1.setEmp_id(2);
        person1.setEmp_name("caozhang");
        List list=new ArrayList<>();
        list.add(person);
        list.add(person1);
        //list.add("a");
        //list.add("b");
        p.setTransdata(list);
        JAXBContext context=JAXBContext.newInstance(Emp.class);
        Marshaller marshaller=context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING,"utf-8");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        StringWriter stringWriter =new StringWriter();
        marshaller.marshal(p,stringWriter);
        System.out.println(stringWriter.toString());
    }
    @Test
    public void test4(){
        Country country=new Country();
        country.setName("中国");
        List<Province>provinceList=new ArrayList<>();
        Province p1=new Province();
        p1.setProvCity("呼和浩特市");
        p1.setName("内蒙古");
        Province p2=new Province();
        p2.setName("山西省");
        p2.setProvCity("太原市");
        provinceList.add(p1);
        provinceList.add(p2);
        country.setProvinceList(provinceList);
        try {
            JAXBContext context=JAXBContext.newInstance(Country.class);
            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING,"utf-8");
            StringWriter stringWriter=new StringWriter();
            marshaller.marshal(country,stringWriter);
            System.out.println(stringWriter.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
