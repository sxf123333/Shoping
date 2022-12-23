package com.it.shop.controller;

import com.it.shop.entity.Goods;
import com.it.shop.entity.Order;
import com.it.shop.service.OrderService;
import com.it.shop.utils.ResultTable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    //购买添加订单
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultTable add(@RequestBody Order order){

        ResultTable resultTable=null;
        Integer info=orderService.add(order);
        if (info!=0){
            resultTable=new ResultTable("200","添加成功",info);
        }else {
            resultTable=new ResultTable("100","添加失败",info);

        }
        return resultTable;
    }
    //查
    @RequestMapping(value = "/select",method = RequestMethod.POST)

    public ResultTable select(@RequestBody Order order){

        ResultTable resultTable=null;

        List<Order> list = orderService.getOrder(order);
        if (list!=null){
            resultTable=new ResultTable("200","查询成功",list);
        }else {
            resultTable=new ResultTable("100","查询失败",list);

        }
        return resultTable;
    }
    
}
