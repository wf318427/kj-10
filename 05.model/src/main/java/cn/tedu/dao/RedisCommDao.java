package cn.tedu.dao;

import cn.tedu.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 17.10.11.
 */
@Component
public class RedisCommDao {
    @Autowired
    EmpDao dao;
    @Cacheable(value = "Emp",key = "'id'+#id")
    public Emp findEmpById(int id){
        Emp p=dao.findOne(id);
        return p;
    }
}
