package com.it.shop.service;

import com.it.shop.dao.CarDao;
import com.it.shop.dao.GoodsDao;
import com.it.shop.entity.Car;
import com.it.shop.entity.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WanYaJun
 * @date 2022/12/6 12:31
 */
@Service
public class CarService {
    @Resource
    private CarDao carDao;
    public List<Car> CarGoods(Car goods){
        return carDao.quryByParam(goods);
    }
    
    
    public List<Car> CarGoods1(Car goods){
        return carDao.quryByParamid(goods);
    }
    

    public Integer deleteCar(Integer id){
        return carDao.deleteById(id);
    }

    public Integer addCar(Car goods){
        return carDao.insert(goods);
    }

    public Car selectById(Integer id){
        return carDao.queryById(id);
    }

    public Integer updateCar(Car goods){
        return carDao.update(goods);
    }
}
