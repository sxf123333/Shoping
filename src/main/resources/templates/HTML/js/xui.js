;
(function($) {
    var xui = {};

    //联动类型插件
    xui.cate = function(dom,obj) {
        if(typeof dom != 'string'){return;}
        //加载模板
        $(dom).append(template());
        function template(){
            var html = "<div class='xui-cate'>"+
                       "       <div class='xui-cate-input' onselectstart='return false;'>"+
                       "     "+obj.title+""+
                       "       </div>"+
                       "       <div class='xui-cate-list'>"+
                       "            <ul class='xui-cate-lists'>";
            for(var v in obj.data){
                html +="                <li value='"+obj.data[v]['id']+"' onselectstart='return false;'>"+obj.data[v]['name']+"</li>";
            }
                html +="            </ul>"+
                       "       </div>"+
                       "</div>";
            return html;
        }

        $(dom).find(".xui-cate-input").click(function(){
            $(this).parents(".xui-cate").find(".xui-cate-list").fadeToggle(10);
        });

        $(dom).on("click",".xui-cate-lists li",function(){
            var pid = $(this).attr('value');
            request_cate(this,pid,obj.url);
        });
        //获取点击的id，请求对应子分类
        function request_cate(_this,pid,url){
            var arr = [];
            var parentDom = $(_this).parent();
            if($(_this).hasClass("current")){return;}
            parentDom.nextAll(":not(.btn-box)").remove();
            parentDom.parent().siblings(".xui-cate-input").addClass("bright");
            $(dom).attr("value",pid);
            $(_this).addClass("current").siblings().removeClass("current");
            $(_this).parents(".xui-cate-list").find(".current").each(function(){
                arr.push($(this).html());
                parentDom.parent().siblings(".xui-cate-input").html(arr.join(""))
            });
            $.post(url,{
                pid:pid
            },function(data){
                if(data.status){
                    if(data.cate.length!=0){
                        show_sun_cate(parentDom,data.cate,url);
                        return;
                    }
                    $(dom).find(".xui-cate-input").trigger("click");
                }
            },'json');
        }

        //显示子分类
        function show_sun_cate(doms,arr){
            var html = "";
            html = "<ul class='xui-cate-lists'>";
            for(var v in arr){
                html +="<li value='"+arr[v]['id']+"' onselectstart='return false;'>"+arr[v]['name']+"</li>";
            }
            html += "<ul/>";
            doms.after(html).siblings().show();
        }

    }

    /*select下拉类型分类*/
    xui.select = function(dom,obj){
        if(typeof dom != 'string'){return;}
        //加载模板
        $(dom).append(template());
        function template(){
            var template = "<div class='xui-select-cate' onselectstart='return false;'>"+
                "               <span class='xui-select-input' onselectstart='return false;'>顶级分类</span>"+
                "               <ul class='xui-select-list'>"+
                "                   <li class='xui-select-first-li'>顶级分类</li>";
            for(var v in obj.data){
                template += "        <li value='"+obj.data[v]['id']+"' onselectstart='return false;'>"+
                            "            <span>"+obj.data[v]['name']+"</span>"+
                            "        </li>";
            }
                template +="    </ul>";
                           "</div>";
            return template;
        }

        //显示/隐藏城市列表
        $(dom).find(".xui-select-input").click(function(){
            $(this).siblings().fadeToggle(10);
        });

        //点击顶级分类
        $(dom).find(".xui-select-first-li").click(function(){
            $(dom).attr("value","");
        });

        //点击城市
        $(dom).on("click",".xui-select-list li",function(){
            var pid = $(this).attr("value");
            post_pid(this,pid,obj.url);
        });

        //发送pid请求对应子城市数据,并做相应改变
        function post_pid(_this,pid,url){
            var html = "";
            var input = $(dom).find(".xui-select-input");
            $(dom).attr("value",pid);
            if($(_this).hasClass("xui-select-first-li")){
                $(dom).attr("value",0);
                $(_this).siblings().removeClass("current").parent().hide().find("ul").remove();
                input.html($(_this).html());
                return;
            }
            if($(_this).hasClass("current")){
                $(_this).removeClass("current").next("ul").remove();
                var len = $(dom).find(".current").length;
                if(len==1){
                    var pid = $(dom).find(".current").attr("value");
                    $(dom).attr("value",pid);
                }
                $(dom).find(".current").each(function(){
                    html += $(this).children("span").html();
                });
                input.html(html);
                if($(".xui-select-input").html()==""){
                    $(dom).attr("value","");
                    input.html("顶级分类");
                }
                return;
            }
            $(_this).addClass("current").siblings(".current").removeClass("current").next("ul").remove();
            $(dom).find(".current").each(function(){
                html += $(this).children("span").html();
            });
            input.html(html);
            $.post(url,{
                pid:pid
            },function(data){
                if(data.status){
                    if(data.cate.length!=0){
                        sun_city(_this,data['cate'],url);
                    }else{
                        show_city();
                    }
                    return;
                }
            },'json');
        }

        //显示对应城市名称列表
        function sun_city(_this,arr,url){
            var html = "<ul class='xui-select-lists'>";
            $.each(arr,function(i,val){
                html += "        <li value='"+val.id+"' onselectstart='return false;'>"+
                        "            |---<span>"+val.name+"</span>"+
                        "        </li>";
            });
                html += "<ul/>";
            $(_this).after(html).show();
            var len = $(dom).find(".xui-select-lists").length;
            var arr = new Array();
            var i=0;
            for(var i=1;i<=len;i++){
                arr[i-1]="lev"+i;
            }
            $(dom).find(".xui-select-lists").each(function(i){
                $(this).addClass(arr[i]).children().css("textIndent",15*(i+1)+"px");
            });
        }

        //显示点击的城市名称
        function show_city(){
            $(dom).find(".xui-select-list").hide();
        }

    }

    /*发送验证码*/
    xui.verifyCode = function(dom,obj){
        if(typeof dom != 'string'){return;}
        var template = "<div class='phone-verify-code'>"+
                        "   <span class='send-verify-code'>发送验证码</span>"+
                        "   <span class='old-send' onselectstart='return false;'>已发送(<i class='time'>obj.time</i>s)</span>"+
                        "</div>";
        $(dom).append(template);
        var flag = true;
        $(dom).click(function(){
            if(flag){
                var mobile = $(obj.mobile).val();
                var img_verify_code = $(obj.img_verify_code).val();
                $.post(obj.url,{
                    mobile:mobile,
                    img_verify_code:img_verify_code
                },function(data){
                    if(!data.status){
                        alert(data.msg);
                        $(obj.refresh).click();
                        return;
                    }
                    flag = false;
                    var t = obj.time;
                    $(dom).find(".time").html(t);
                    var timer = null;
                    timer = setInterval(time,1000);
                    $(dom).find(".send-verify-code").hide().next().show();
                    function time(){
                        t--;
                        if(t == 0){
                            clearInterval(timer);
                            $(dom).find(".send-verify-code").html("重新发送").show().next().hide();
                            flag = true;
                            return;
                        }
                        $(dom).find(".time").html(t);
                    }
                });
            }
        });
    }

    /*删除动作*/
    xui.del_action = function(obj){
        var ids = [];
        if(obj.id){
            ids.push(obj.id);
        }else{
            $(".selected").each(function(){
                ids.push($(this).find("."+obj.class).html());
            });
        }
        if(ids.length==0){
            layer.msg('请选择要删除的信息');
            return;
        }
        layer.open({
            type: 1,
            area:'300px',
            title:"删除",
            shadeClose:true,
            content: "<h5 style='text-align: center;line-height: 80px;'>确定删除吗？</h5>",
            btn:['确定','取消'],
            yes:function(index){
                layer.close(index);
                $.post(obj.url,{
                    id:ids
                },function(data){
                    if(!data.status){
                        layer.msg(data.msg);
                        return;
                    }
                    location.reload();
                },'json');
            }
        });

    }

    /*批量上下架*/
    xui.on_off = function(obj){
        if(obj.class){
            obj.id = [];
            $(".selected").each(function(){
                obj.id.push($(this).find("."+obj.class).html());
            });
            if(obj.id.length==0){
                layer.msg('请选择要删除的信息!');
                return;
            }
        }
        var page = $("li.active").children().html();
        $.post(obj.url,{
            ids:obj.id,
            on_off:obj.on_off
        },function(data){
            if(!data.status){
                layer.msg(data.msg);
                return;
            }
            location.reload();
        },'json');
    }

    window['xui'] = xui;
})(jQuery);