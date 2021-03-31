layui.use(['form','admin', 'HttpRequest'], function () {
   
    var form = layui.form;
    var admin = layui.admin;
    var HttpRequest = layui.HttpRequest;
    //获取信息详情填充表单
    var request = new HttpRequest(Feng.ctxPath + "/activity/addType?area=" + Feng.getUrlParam("area","utf8") + '&type=' + Feng.getUrlParam("type"), 'get');
    var result = request.start();
    document.getElementById("numberSpan").innerText = decodeURIComponent(result.data.number);//活动编号
    document.getElementById("typeNumberSpan").innerText = decodeURIComponent(result.data.typeNumber);//类型编号
    document.getElementById("areaName").innerText = decodeURIComponent(result.data.area);//活动名称
    document.getElementById("areaName1").innerText = decodeURIComponent(result.data.area);//活动名称
    form.val('activityForm', result.data);
    
    
   //表单提交事件
   form.on('submit(btnSubmit)', function (data) {
	    var request = new HttpRequest(Feng.ctxPath + "/activity/add", 'post', function (data) {
	    	admin.closeThisDialog();
	        Feng.success("添加成功！");
	        admin.putTempData('formOk', true);
	    }, function (data) {
	        admin.closeThisDialog();
	        Feng.error("添加失败！" + data.message);
	    });
	    request.set(data.field);
	    request.start(true);
	});
});