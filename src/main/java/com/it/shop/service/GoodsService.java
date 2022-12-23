package com.it.shop.service;

import com.it.shop.dao.GoodsDao;
import com.it.shop.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WanYaJun
 * @date 2022/12/6 12:31
 */
@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;
    public List<Goods> getGoods(Goods goods){
        return goodsDao.quryByParam(goods);
    }

    public Integer deleteGoods(Integer id){
        return goodsDao.deleteById(id);
    }

    public Integer addGoods(Goods goods){
        return goodsDao.insert(goods);
    }

    public Goods selectById(Integer id){
        return goodsDao.queryById(id);
    }

    public Integer updateGoods(Goods goods){
        return goodsDao.update(goods);
    }
}
