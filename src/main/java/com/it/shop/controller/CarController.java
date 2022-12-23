package com.it.shop.controller;


import com.it.shop.entity.Car;

import com.it.shop.utils.ResultTable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WanYaJun
 * @date 2022/12/8 14:58
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Resource
    private com.it.shop.service.CarService carService ;
    //增
    @RequestMapping(value = "/add",method = RequestMethod.POST)

    public ResultTable add(@RequestBody Car type){
        ResultTable resultTable = null;
        Integer info = carService.addCar(type);
        if (info==1){
            resultTable = new ResultTable("200","添加成功!",info);
        }else {
            resultTable = new ResultTable("100","添加失败!",info);
        }
        return resultTable;
    }

    //删
    @RequestMapping(value = "/delete",method = RequestMethod.POST)

    public ResultTable delete(@RequestBody  Car type){
        ResultTable resultTable = null;
        Integer info=null;
        //如果当前有id数组就是批量删除，如果没有就是单个删除
        if(type.getIds()!=null){
            for (int i=0;i<type.getIds().length;i++){
                info =  carService.deleteCar(type.getIds()[i]);
            }
        }else {
            info = carService.deleteCar(type.getId());
        }


        if (info==1){
            resultTable = new ResultTable("200","删除成功!",info);
        }else {
            resultTable = new ResultTable("100","删除失败!",info);
        }
        return resultTable;
    }

    //改
    @RequestMapping(value = "/update",method = RequestMethod.POST)

    public ResultTable update(@RequestBody Car type){
        ResultTable resultTable = null;
        Integer info = carService.updateCar(type);
        if (info==1){
            resultTable = new ResultTable("200","修改成功!",info);
        }else {
            resultTable = new ResultTable("100","修改失败!",info);
        }
        return resultTable;
    }


    //查
    @RequestMapping(value = "/select",method = RequestMethod.POST)

    public ResultTable select(@RequestBody Car type){
        System.out.println(type.getId());
        System.out.println(type.getUid());

        ResultTable resultTable=null;

        List<Car> list = carService.CarGoods(type);
        if (list!=null){
            resultTable=new ResultTable("200","查询成功",list);
        }else {
            resultTable=new ResultTable("100","查询失败",list);

        }
        return resultTable;
    }
    //查
    @RequestMapping(value = "/selectid",method = RequestMethod.POST)

    public ResultTable select11(@RequestBody Car type){
        System.out.println(type.getId());
        System.out.println(type.getUid());
        ResultTable resultTable=null;

        List<Car> list = carService.CarGoods1(type);
        if (list!=null){
            resultTable=new ResultTable("200","查询成功",list);
        }else {
            resultTable=new ResultTable("100","查询失败",list);

        }
        return resultTable;
    }
    
    
    @RequestMapping(value = "/selectById",method = RequestMethod.POST)

    //查
    public ResultTable selectById(@RequestBody  Car type){

        ResultTable resultTable=null;

        Car id=carService.selectById(type.getId());
        if (id!=null){
            resultTable=new ResultTable("200","查询成功",id);
        }else {
            resultTable=new ResultTable("100","查询失败",id);

        }
        return resultTable;
    }
}
