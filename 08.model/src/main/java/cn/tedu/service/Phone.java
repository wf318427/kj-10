package cn.tedu.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 17.10.22.
 */
 @Service
public class Phone {
  public List<String> list=new ArrayList<String>();

 public List<String> getList() {
  return list;
 }

 public void setList(List<String> list) {
  this.list = list;
 }
}
