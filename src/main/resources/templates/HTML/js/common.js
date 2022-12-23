/*时间*/
(function(){
	function timer(){
		var oTime = document.getElementById('data-time');
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		var day = date.getDate();
		var hour = date.getHours();
		var min = date.getMinutes();
		var seconds = date.getSeconds();
		var time = 0;
		time = year+"-"+month+"-"+day+" "+tou(hour)+":"+tou(min)+":"+tou(seconds);
		oTime.innerHTML = time
	}
	timer();
	setInterval(timer,1000);
	function tou(time){
		if(time<10){
			return "0" + time;
		}
		else{
			return time;
		}
	}
})();

/*头部导航高亮*/
(function(){
	$('.nav .nav-list li').each(function(){
		var href=$(this).children('a').attr('href');
		if(href!="" && location.href.indexOf(href)!=-1){
			$(this).addClass("current").siblings().removeClass("current");
		}
	});
})();

/*会员中心left左侧导航高亮*/
(function(){
	$('.m-slide-nav ul li').each(function(){
		var href=$(this).children('a').attr('href');
		if(href!="" && location.href.indexOf(href)!=-1){
			$(this).addClass("ative").siblings().removeClass("ative");
		}
	});
})();

(function(){
	//会员中心消息
	var beforeHtml = $(".m-notice .list li:first-child").prop('outerHTML');
	$(".m-notice .list").append(beforeHtml);
	var num = $(".m-notice .list li").length;
	var i = 0;
	setInterval(function(){
		i++;
		var top = -i*35+"px";
		$(".m-notice .list").animate({top:top},1000,function(){
			var poTop = $(".m-notice .list").position().top;
			poTop = Math.floor(poTop);
			if(poTop <= -(num-1)*35){
				$(".m-notice .list").css({top:0});
				i = 0;
			}
		});
	},3000);
})();