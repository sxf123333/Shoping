package com.it.shop.controller;


import com.it.shop.entity.Type;
import com.it.shop.service.TypeService;
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
@RequestMapping("/type")
public class TypeController {
    @Resource
    private TypeService typeService;
    //增
    @RequestMapping(value = "/add",method = RequestMethod.POST)

    public ResultTable add(@RequestBody Type type){
        ResultTable resultTable = null;
        Integer info = typeService.addType(type);
        if (info==1){
            resultTable = new ResultTable("200","添加成功!",info);
        }else {
            resultTable = new ResultTable("100","添加失败!",info);
        }
        return resultTable;
    }

    //删
    @RequestMapping(value = "/delete",method = RequestMethod.POST)

    public ResultTable delete(@RequestBody  Type type){
        ResultTable resultTable = null;
        Integer info=null;
        //如果当前有id数组就是批量删除，如果没有就是单个删除
        if(type.getIds()!=null){
            for (int i=0;i<type.getIds().length;i++){
                info =  typeService.deleteType(type.getIds()[i]);
            }
        }else {
            info = typeService.deleteType(type.getId());
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

    public ResultTable update(@RequestBody Type type){
        ResultTable resultTable = null;
        Integer info = typeService.updateType(type);
        if (info==1){
            resultTable = new ResultTable("200","修改成功!",info);
        }else {
            resultTable = new ResultTable("100","修改失败!",info);
        }
        return resultTable;
    }


    //查
    @RequestMapping(value = "/select",method = RequestMethod.POST)

    public ResultTable select(@RequestBody Type type){

        ResultTable resultTable=null;

        List<Type> list = typeService.getType(type);
        if (list!=null){
            resultTable=new ResultTable("200","查询成功",list);
        }else {
            resultTable=new ResultTable("100","查询失败",list);

        }
        return resultTable;
    }
    @RequestMapping(value = "/selectById",method = RequestMethod.POST)

    //查
    public ResultTable selectById(@RequestBody  Type type){

        ResultTable resultTable=null;

        Type id=typeService.selectById(type.getId());
        if (id!=null){
            resultTable=new ResultTable("200","查询成功",id);
        }else {
            resultTable=new ResultTable("100","查询失败",id);

        }
        return resultTable;
    }
}
