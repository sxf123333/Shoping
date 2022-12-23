$(function (){

})
function serilizeUrl(url,param) {
    var urlObj = {}
    if (/\?/.test(url)) {
        var urlStr = url.substring(url.indexOf('?') + 1)
        var urlArr = urlStr.split('&')
        var len = urlArr.length

        for (var i = 0; i < len; i++) {
            var urlItem = urlArr[i]
            var item = urlItem.split('=')
            urlObj[item[0]] = item[1]
        }

        return urlObj[param]
    }
}
//权限方法
function power(){
    /*var info= serilizeUrl(location.href.toString(),'usertype');*/
    var info=sessionStorage.getItem("user");
    if(info==null){
    }
    if(info==1){
        $(".side-menu>li:eq(1)").remove();
    }else{
        $(".side-menu>li:eq(0)").remove();
        $(".side-menu>li:eq(1)").remove();
    }
}
