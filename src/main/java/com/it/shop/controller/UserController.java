package com.it.shop.controller;

import com.it.shop.entity.User;
import com.it.shop.service.UserService;
import com.it.shop.utils.ResultTable;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-12-05 14:37:59
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //查
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public ResultTable select(@RequestBody User user){

        ResultTable resultTable=null;

        List<User> list =userService.queryByPage(user);
        if (list.size()>0){
            resultTable=new ResultTable("200","查询成功",list);
        }else {
            resultTable=new ResultTable("100","查询失败",list);

        }
        return resultTable;
    }
    //查一条数据
    @RequestMapping(value = "/selectID",method = RequestMethod.POST)
    public ResultTable selectID(@RequestBody User user){

        ResultTable resultTable=null;

        User user1=userService.queryByPageId(user);
        System.out.println(user.toString());
        if (user1!=null){
            resultTable=new ResultTable("200","查询成功",user1);
        }else {
            resultTable=new ResultTable("100","查询失败",user1);

        }
        return resultTable;
    }
    //注册
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResultTable insert(@RequestBody User user){

        ResultTable resultTable=null;
        Integer info=userService.insert(user);
        if (info!=0){
            resultTable=new ResultTable("200","添加成功",info);
        }else {
            resultTable=new ResultTable("100","添加失败",info);

        }
        return resultTable;
    }

    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultTable update(@RequestBody User user){

        ResultTable resultTable=null;
        Integer info=userService.update(user);
        if (info!=0){
            resultTable=new ResultTable("200","添加成功",info);
        }else {
            resultTable=new ResultTable("100","添加失败",info);

        }
        return resultTable;
    }
    //删除
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResultTable delete(@RequestBody User user){

        ResultTable resultTable=null;
        Integer info=userService.delete(user);
        if (info!=0){
            resultTable=new ResultTable("200","删除成功",info);
        }else {
            resultTable=new ResultTable("100","删除失败",info);

        }
        return resultTable;
    }
}

