layui.use(['form', 'HttpRequest'], function () {
    var form = layui.form;
    var HttpRequest = layui.HttpRequest;

    //获取信息详情填充表单
    var request = new HttpRequest(Feng.ctxPath + "/activityManager/detail?id=" + Feng.getUrlParam("id"), 'get');
    var result = request.start();
    form.val('activityForm', result.data);

});