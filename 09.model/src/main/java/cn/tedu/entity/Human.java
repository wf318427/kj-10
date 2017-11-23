package cn.tedu.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 17.11.19.
 */
public class Human implements Cloneable,Serializable{
    /**
     * protected 本类与子类
     * private 本类
     * public 到处
     * 隐藏累的内部细节 写一些私有方法 再写一个公共方法调用这些私有方法
     */
    protected void ff(){
        System.out.println("sssssssssssssss");
    }
    private void prepareLCcontData(FieldCarriry fieldCarriry,LCcont lCcont){
        fieldCarriry.setContNo(lCcont.getContno());
    }
    private void prepareLCAppntData(FieldCarriry fieldCarriry,LCAppnt lcAppnt){
        fieldCarriry.setAppntNo(lcAppnt.getAppntNo());
    }
    public void dealData(FieldCarriry fieldCarriry,LCcont lCcont,LCAppnt lcAppnt) throws CloneNotSupportedException {
        Human human= (Human) super.clone();// object clone 意义
        prepareLCcontData(fieldCarriry,lCcont);
        prepareLCAppntData(fieldCarriry,lcAppnt);
        System.out.println(fieldCarriry);

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        FieldCarriry fieldCarriry=new FieldCarriry();
        LCcont lCcont=new LCcont("caocao");
        LCAppnt lcAppnt=new LCAppnt("caozhang");
        new Human().dealData(fieldCarriry,lCcont,lcAppnt);
    }


}
