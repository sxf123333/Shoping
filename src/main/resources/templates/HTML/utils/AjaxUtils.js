function AjaxUtil(){};
//创建一个ajaxUtil对象
var ajaxUtil=new AjaxUtil();
/**
 * ajax GET请求
 * return josn
 */
AjaxUtil.prototype.ajaxGet=function(url,params){
    var obj="";
    $.ajax({
        url:url,//路径
        type:'get',//请求方式
        dataType:'json',//数据类型
        async:false,//不是异步
        cache:false,//不是缓存
        data:params,//发送的数据
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        success:function(data){//成功返回值
            obj=data;
        }
    });
    return obj;
}
/**
 * ajax POST请求
 * @param url
 * @param params
 * @returns {String} josn
 */
AjaxUtil.prototype.ajaxPost=function(url,params){
    var obj="";
    $.ajax({
        url:url,//路径
        type:'post',//请求方式
        dataType:'json',//数据类型
        async:false,//不是异步
        cache:false,//不是缓存
        data:JSON.stringify(params),//发送的数据
        contentType : 'application/json',//json格式就是字符串
        success:function(data){//成功返回值
            obj=data;
        }
    });

    return obj;
}