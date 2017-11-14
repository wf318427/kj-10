package cn.tedu.test;

import cn.tedu.entity.Student;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 17.11.8.
 */
public class TestCase1 {
    @Test
    public void test(){
        BasicDataSource  ds=new BasicDataSource();
        ds.setUrl("jdbc:oracle:thin:@//localhost:1521/zhangfei");
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUsername("sys as sysdba");
        ds.setPassword("zhangfei");
        Connection connection=null;
        Student s=new Student();
        try {
             connection=ds.getConnection();
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("SELECT * FROM student ");

            while (rs.next()){
                s.getId(Integer.parseInt(rs.getString("id")));
                s.setName(rs.getString("name"));
                s.setAge(Integer.parseInt(rs.getString("age")));
                s.setBirth(rs.getDate("birth"));
                System.out.println(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        Student student= (Student) s.clone();
        student.setAge(100);
        System.out.println(s);
    }
    @Test
    public void test2(){

    }
}
