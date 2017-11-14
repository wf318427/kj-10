package cn.tedu.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 17.11.2.
 */
public class Emp implements Serializable{
    private static final long serialVersionUID = 7942140833883741981L;
    private String name;
    private Integer age;
    private String Idtype;
    private String IdNo;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdtype() {
        return Idtype;
    }

    public void setIdtype(String idtype) {
        Idtype = idtype;
    }

    public String getIdNo() {
        return IdNo;
    }

    public void setIdNo(String idNo) {
        IdNo = idNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Idtype='" + Idtype + '\'' +
                ", IdNo='" + IdNo + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
