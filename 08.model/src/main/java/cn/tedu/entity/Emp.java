package cn.tedu.entity;

import javax.xml.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 17.11.2.
 */
//@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Emp implements Serializable{
    private static final long serialVersionUID = 7942140833883741981L;
    private String name;
    private Integer age;
    private String Idtype;
    private String IdNo;
    private String sex;
    private List<Person> list;
    //@XmlElementWrapper(name="Person")// 集合属性的父节点
    //@XmlElement(name="student")        // 成员节点
    public List<Person> getList() {
        return list;
    } public void setList(List<Person> list) {
        this.list = list;
    } public String getName() {
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
