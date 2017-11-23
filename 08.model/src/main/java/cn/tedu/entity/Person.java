package cn.tedu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 17.11.18.
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 2949869850477266954L;
    private int id;
    private String name;
    private int age;
    private Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
