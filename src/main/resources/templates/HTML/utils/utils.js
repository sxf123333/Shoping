$(function (){

})
function serilizeUrl(url,param) {
    let urlObj = {}
    if (/\?/.test(url)) {
        let urlStr = url.substring(url.indexOf('?') + 1)
        let urlArr = urlStr.split('&')
        let len = urlArr.length

        for (let i = 0; i < len; i++) {
            let urlItem = urlArr[i]
            let item = urlItem.split('=')
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
        location.href="http://localhost:8080/APP_war_exploded/";
    }
    if(info==1){
        $(".side-menu>li:eq(1)").remove();
    }else{
        $(".side-menu>li:eq(0)").remove();
        $(".side-menu>li:eq(1)").remove();
    }
}