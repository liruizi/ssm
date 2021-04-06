layui.use(['form', 'HttpRequest'], function () {
    var form = layui.form;
    var HttpRequest = layui.HttpRequest;

    //获取信息详情填充表单
    var request = new HttpRequest(Feng.ctxPath + "/activityManager/detail?id=" + Feng.getUrlParam("id"), 'get');
    var result = request.start();
    document.getElementById("numberSpan").innerText = decodeURIComponent(result.data.number);//活动编号
    document.getElementById("typeNumberSpan").innerText = decodeURIComponent(result.data.typeNumber);//类型编号
    document.getElementById("areaName").innerText = decodeURIComponent(result.data.area);//活动名称
    document.getElementById("areaName1").innerText = decodeURIComponent(result.data.area);//活动名称
    document.getElementById("hour").innerText = decodeURIComponent(result.data.times) + " "+decodeURIComponent(result.data.hour);//时间
    form.val('activityForm', result.data);
    
});