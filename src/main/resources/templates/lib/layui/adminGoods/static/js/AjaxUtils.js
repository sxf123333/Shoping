function AjaxUtils(){};
//创建一个ajaxUtil对象
var ajaxUtils =new AjaxUtils();

/**
 * ajax  Get请求
 * @returns
 */
//类型.prototype.方法
//给AjaxUtils添加一个ajaxGet方法
AjaxUtils.prototype.ajaxGet=function(url,param){
	var obj="";
	
	$.ajax({
	   	 url:url,//路径
	   	 type:'get',//请求方式
	   	 dateType:'json',//数据类型
	   	 async:false,//不是异步
	   	 cache:false,//不是缓存
	     data:param,//发送的数据
	   	 success:function(data){//成功返回值
	   		obj=data;
			console.log(data);
	   	 }
	    	});

	return obj	;
      		
	
}
/**
 * ajax  Post请求
 * url
 * params
 * @returns  {String} json
 */
//prototype 获取
AjaxUtils.prototype.ajaxPost=function(url,param){
var obj="";
	
	$.ajax({
	   	 url:url,//路径
	   	 type:'post',//请求方式
	   	 dataType:'json',//数据类型
	   	 async:false,//不是异步
	   	 cache:false,//不是缓存
	     data:JSON.stringify(param) ,//发送的数据
		contentType:'application/json',//json格式就是字符串
	   	 success:function(data){//成功返回值
	   		obj=data;

	   	 }
	    	});

	return obj	;
      		
}











