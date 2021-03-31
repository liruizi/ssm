layui.use(['form','admin', 'HttpRequest'], function () {
   
    var form = layui.form;
    var admin = layui.admin;
    var HttpRequest = layui.HttpRequest;
    //获取信息详情填充表单
    var request = new HttpRequest(Feng.ctxPath + "/activity/addType?area=" + Feng.getUrlParam("area","utf8") + '&type=' + Feng.getUrlParam("type"), 'get');
    var result = request.start();
    if(result.code == 400){
    	admin.closeThisDialog();
    	Feng.error("添加失败！请检查行政单位、活动方式必选！！！");
    }
    if(result.code == 1004){
    	admin.closeThisDialog();
    	Feng.error("添加失败！请检查->活动累计次数 是否配置正确！！！");
    }
    if(result.code == 1003){
    	admin.closeThisDialog();
    	Feng.error("添加失败！请检查->活动编号 相关内容是否配置正确！！！");
    }
    if(result.code == 1002){
    	admin.closeThisDialog();
    	Feng.error("添加失败！请检查->活动主题 相关内容是否配置正确！！！！！！");
    }
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