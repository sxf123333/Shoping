package com.it.shop.controller;

import com.it.shop.entity.Goods;
import com.it.shop.service.GoodsService;
import com.it.shop.utils.ResultTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WanYaJun
 * @date 2022/12/6 12:24
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
     @Resource
    private GoodsService goodsService;
    //增
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    
    public ResultTable add(@RequestBody Goods goods){
        ResultTable resultTable = null;
        Integer info = goodsService.addGoods(goods);
        if (info==1){
            resultTable = new ResultTable("200","添加成功!",info);
        }else {
            resultTable = new ResultTable("100","添加失败!",info);
        }
        return resultTable;
    }

    //删
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    
    public ResultTable delete(@RequestBody  Goods goods){
        ResultTable resultTable = null;
        Integer info=null;
        //如果当前有id数组就是批量删除，如果没有就是单个删除
        if(goods.getIds()!=null){
            for (int i=0;i<goods.getIds().length;i++){
                info =  goodsService.deleteGoods(goods.getIds()[i]);
            }
        }else {
            info = goodsService.deleteGoods(goods.getId());
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
    
    public ResultTable update(@RequestBody Goods Goods){
        ResultTable resultTable = null;
        Integer info = goodsService.updateGoods(Goods);
        if (info==1){
            resultTable = new ResultTable("200","修改成功!",info);
        }else {
            resultTable = new ResultTable("100","修改失败!",info);
        }
        return resultTable;
    }


    //查
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    
    public ResultTable select(@RequestBody Goods goods){

        ResultTable resultTable=null;

        List<Goods> list = goodsService.getGoods(goods);
        if (list!=null){
            resultTable=new ResultTable("200","查询成功",list);
        }else {
            resultTable=new ResultTable("100","查询失败",list);

        }
        return resultTable;
    }
    @RequestMapping(value = "/selectById",method = RequestMethod.POST)
    
    //查
    public ResultTable selectById(@RequestBody  Goods goods){

        ResultTable resultTable=null;

        Goods id=goodsService.selectById(goods.getId());
        if (id!=null){
            resultTable=new ResultTable("200","查询成功",id);
        }else {
            resultTable=new ResultTable("100","查询失败",id);

        }
        return resultTable;
    }
}
