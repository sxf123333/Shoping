function AjaxUtils() {
};
//创建一个ajaxUtil对象
var ajaxUtils = new AjaxUtils();

AjaxUtils.prototype.ajaxPost= function (url,params) {
    var obj = "";
    $.ajax({
        url: url,
        contentType: "application/json;charset=utf-8",
        type: 'post',
        dataType: 'json',
        async: false,
        cache: false,
        data: JSON.stringify(params),
        success: function (data) {
            obj = data;
        }
    });
    return obj;
}









