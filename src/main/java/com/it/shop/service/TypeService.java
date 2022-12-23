package com.it.shop.service;

import com.it.shop.dao.TypeDao;
import com.it.shop.entity.Type;
import com.it.shop.entity.Type;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WanYaJun
 * @date 2022/12/8 14:54
 */
@Service
public class TypeService {
    @Resource
    private TypeDao typeDao;

    public List<Type> getType(Type type){
        return typeDao.quryByParam(type);
    }

    public Integer deleteType(Integer id){
        return typeDao.deleteById(id);
    }

    public Integer addType(Type type){
        return typeDao.insert(type);
    }

    public Type selectById(Integer id){
        return typeDao.queryById(id);
    }

    public Integer updateType(Type type){
        return typeDao.update(type);
    }
}
