package cn.tedu.test;

import org.apache.catalina.startup.Tomcat;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrator on 17.10.22.
 */
public class TestCase1 {
    @Test
    public void test(){
        BasicDataSource ds=new BasicDataSource();

        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test");
        ds.setUsername("root");
        ds.setPassword("318427");
        Connection connection=null;
        try {
            connection=ds.getConnection();
            connection.setAutoCommit(false);
            String sqlb="select name from emp  ";
            String sql="insert into emp values(2,'sunquan',25)";
            Statement s=connection.createStatement();
            int i=s.executeUpdate(sql);
            System.out.println(i);
            ResultSet rs=s.executeQuery(sqlb);
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println("inset success");
            }
            if(i==1){
                connection.commit();
            }

//




        } catch (SQLException e) {

        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
