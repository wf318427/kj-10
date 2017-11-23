package cn.tedu.test;

import cn.tedu.entity.Emp;
import cn.tedu.entity.LCcontPojo;
import cn.tedu.entity.Student;
import cn.tedu.entity.Teacher;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 17.11.18.
 */
public class TestCase2 {
    @Test
    public void test(){
        Emp p=new Emp();
        p.setIdNo("123");
        p.setName("caocao");
        p.setIdtype("军官证");
        p.setAge(45);
        p.setSex("male");
        List list=new ArrayList<>();

        list.add(new Student(1,"caocao",25,new Date()));
        list.add(new Student(2,"liubei",10,new Date()));
        p.setList(list);
        try {
            JAXBContext context=JAXBContext.newInstance(Emp.class);
            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING,"utf-8");
            StringWriter stringWriter=new StringWriter();
            marshaller.marshal(p,stringWriter);
            System.out.println(stringWriter.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        Map map=new HashMap();
        Emp p=new Emp();
        p.setIdNo("123");
        p.setName("caocao");
        p.setIdtype("军官证");
        p.setAge(45);
        p.setSex("male");
        List list=new ArrayList<>();
        list.add(new Student(1,"caocao",25,new Date()));
        list.add(new Student(2,"liubei",10,new Date()));
        map.put(Student.class.getName(),list);
        map.put(Emp.class.getName(),p);
        XStream xStream=new XStream();
        xStream.alias("emp",Emp.class);
        xStream.alias("student",Student.class);
        xStream.alias("students",List.class);
        Teacher teacher=new Teacher();
        teacher.setMap(map);
        String s=xStream.toXML(teacher);
        System.out.println(s);
        System.out.println(xStream.fromXML(s));
    }
    @Test
    public void test2(){
       int i=5;
        System.out.println(ff(i));
    }
    public int ff(int i){
        if(i==1){
            return i;
        }else {
            return ff(i-1)*i;
        }
    }

    /**
     * qname 待解决
     */
    @Test
    public void test3(){
        LCcontPojo lCcontPojo=new LCcontPojo();
        lCcontPojo.setContno("11111111111");
        lCcontPojo.setPolno("222222222");
        try {
            JAXBContext context=JAXBContext.newInstance(lCcontPojo.getClass());
            QName qName=new QName("LCcontPojo");
            JAXBElement<LCcontPojo>element=new JAXBElement<LCcontPojo>(qName, (Class<LCcontPojo>) lCcontPojo.getClass(),lCcontPojo);
            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING,"utf-8");
            StringWriter writer=new StringWriter();
            marshaller.marshal(element,writer);
            System.out.println(writer.toString());
            Unmarshaller unmarshaller=context.createUnmarshaller();
            unmarshaller.unmarshal((new StringReader(writer.toString())));

//            System.out.println(lCcontPojo1);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test4(){
        List list=new ArrayList();
        for(int i=0;i<10;i++){
            list.add("1");
        }




    }

}
