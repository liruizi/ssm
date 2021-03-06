layui.use(['form', 'admin', 'HttpRequest'], function () {
    var $ = layui.jquery;
    var form = layui.form;
    var admin = layui.admin;
    var HttpRequest = layui.HttpRequest;


    $("#groupCode").val(Feng.getUrlParam("groupCode"));

    //表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var httpRequest = new HttpRequest(Feng.ctxPath + "/sysConfig/add", 'post', function (data) {
            admin.closeThisDialog();
            Feng.success("添加成功！");
            admin.putTempData('formOk', true);
        }, function (data) {
            admin.closeThisDialog();
            Feng.error("添加失败！" + data.message)
        });
        httpRequest.set(data.field);
        httpRequest.start(true);
    });
});
