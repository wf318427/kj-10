package cn.tedu.test;


import cn.tedu.entity.Emp;
import cn.tedu.entity.Teacher;
import cn.tedu.service.Phone;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.util.SerializationUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.*;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Created by Administrator on 17.10.28.
 */
public class PhoneTest {
    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String,Object> map=new HashMap<>();
        map.put("name","caocao");
        map.put("age",25);
        map.put("idtype","身份证");
        map.put("idno","1111111111");
        map.put("sex","man");
        //System.out.println(map);
        Emp p=new Emp();
        Field[] fields=p.getClass().getDeclaredFields();
//        for(Field field:fields){
//            System.out.println(field.getName());
//            System.out.println(field.getType());
//        }
        Method[] methods=p.getClass().getMethods();
//        for(Method m:methods){
//            System.out.println(m.getName());
//        }
            for(String s:map.keySet()) {

                for (Field field : fields) {
                    if(s.toLowerCase().equals(field.getName().toLowerCase())){
                        //System.out.println(field.getName());
                        // 获取类的方法，及参数的leix
                        Method method=p.getClass().getMethod("set"+ (StringUtils.capitalize(field.getName())),field.getType());
                        method.invoke(p,map.get(s));// 执行 反射获取类的方法

                    }
                }
            }
        System.out.println(p);

    }
    @Test
    public void test2(){

        getData();
    }

    public DataSource getDataSources(){
        BasicDataSource ds=new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("318427");
        ds.setMaxWait(1000);
        return ds;
    }
    /**
     *
     */
    @Test
    public void test0() throws SQLException, IOException {

        Connection connection=null;
        connection=getDataSources().getConnection();
        System.in.read();

    }
    @Test
    public void getData() {
        Connection connection=null;

        Map<String,Object>map=new HashMap<>();
        List list=new ArrayList();
        Field[] fields=Emp.class.getDeclaredFields();
        Class clz=Emp.class;
        try {
            connection=getDataSources().getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from "+Emp.class.getSimpleName()+"");
            while(resultSet.next()){
                 Object p=clz.newInstance();
                for(Field field:fields) {
                    try {
                        Object o = resultSet.getObject(field.getName());
                        Method method=p.getClass().getMethod("set"+ (StringUtils.capitalize(field.getName())),field.getType());
                        method.invoke(p,o);

                    }catch (Exception e){

                    }
                }
                System.out.println(p);
                list.add(p);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        map.put(clz.getName(),list);
        ObjectOutput objectOutput=null;
        try {
            objectOutput=new ObjectOutputStream(new FileOutputStream(new File("src/test/resources/1.txt")));
            objectOutput.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(map);
    }

    @Test
    public void test3(){
        ObjectInputStream objectInputStream=null;

        try {
            objectInputStream=new ObjectInputStream(new FileInputStream("src/test/resources/1.txt"));
            Map<String,Object> p= (Map<String, Object>) objectInputStream.readObject();
            Emp e= (Emp) ((List)p.get(Emp.class.getName())).get(0);
            System.out.println(e);
        }  catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    @Test
    public void test4(){
        File file=new File("src/test/resources/1.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test5() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      Animal animal=new Cat();
        animal.ff();
        Animal animal1= (Animal) Class.forName(Cat.class.getName()).newInstance();
        animal1.ff();
        Animal animal2=Cat.class.newInstance();
        animal2.ff();
        List list=new ArrayList<>();
        Teacher teacher=new Teacher();
        teacher.setName("caocao");
        teacher.setAge(new Long("45"));
        teacher.setId(new Long("1"));
        list.add(teacher);
        Teacher teacher1= (Teacher) list.get(0);
        System.out.println(teacher1);

    }
    @Test
    public void test6() throws IllegalAccessException {
        Teacher teacher=new Teacher();
        teacher.setName("caocao");
        teacher.setAge(new Long("45"));
        teacher.setId(new Long("1"));
        Field[] fields=teacher.getClass().getDeclaredFields();
        AccessibleObject.setAccessible(fields,true);
        for(Field f:fields){
            System.out.println(f.getName());
            System.out.println(f.get(teacher).toString());
        }
    }
    @Test
    public void testSession(){
        DataSource ds=getDataSources();
        Connection connection=null;
        try {
            connection=ds.getConnection();
            Statement statement=connection.createStatement();
            statement.execute("");
            ResultSet rs=statement.executeQuery("SELECT  sysdate()");

            while(rs.next()){
                System.out.println(rs.getObject(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
class Cat extends Animal{
        public void ff(){
            System.out.println("catcat");
        }
}
class Animal{
    public void ff(){
        System.out.println("AnimalAnimalAnimal");
    }
}