layui.use(['table', 'form', 'func', 'HttpRequest', 'util'], function () {
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var func = layui.func;
    var HttpRequest = layui.HttpRequest;
    var util = layui.util;

    // 职位表管理
    var ActivityCumulateTimes = {
        tableId: "activityCumulateTimesTable"
    };

    // 初始化表格的列
    ActivityCumulateTimes.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键id'},
            {field: 'year', sort: true, title: '活动年限'},
            {field: 'numbers', sort: true, title: '累计次数'},
            {
                field: 'createTime', sort: true, title: '创建时间', templet: function (d) {
                    return util.toDateString(d.createTime);
                }
            },
            {
                field: 'updateTime', sort: true, title: '更新时间', templet: function (d) {
                    return d.updateTime == null ? '' : util.toDateString(d.updateTime);
                }
            },
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };


    // 弹出添加对话框
    ActivityCumulateTimes.openAddDlg = function () {
        func.open({
            title: '添加活动累计次数',
            content: Feng.ctxPath + '/view/activityCumulateTimes/addView',
            tableId: ActivityCumulateTimes.tableId
        });
    };

    // 点击编辑
    ActivityCumulateTimes.openEditDlg = function (data) {
        func.open({
            title: '修改活动累计次数',
            content: Feng.ctxPath + '/view/activityCumulateTimes/editView?id=' + data.id,
            tableId: ActivityCumulateTimes.tableId
        });
    };

    // 点击删除
    ActivityCumulateTimes.delete = function (data) {
        var operation = function () {
            var httpRequest = new HttpRequest(Feng.ctxPath + "/activityCumulateTimes/delete", 'post', function (data) {
                Feng.success("删除成功!");
                table.reload(ActivityCumulateTimes.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.message + "!");
            });
            httpRequest.set(data);
            httpRequest.start(true);
        };
        Feng.confirm("是否删除?", operation);
    };


    // 渲染表格
    var tableResult = table.render({
        elem: '#' + ActivityCumulateTimes.tableId,
        url: Feng.ctxPath + '/activityCumulateTimes/page',
        page: true,
        request: {pageName: 'pageNo', limitName: 'pageSize'}, //自定义分页参数
        height: "full-158",
        cellMinWidth: 100,
        cols: ActivityCumulateTimes.initColumn(),
        parseData: Feng.parseData
    });


    // 添加按钮点击事件
    $('#btnAdd').click(function () {
    	ActivityCumulateTimes.openAddDlg();
    });
    
    // 工具条点击事件
    table.on('tool(' + ActivityCumulateTimes.tableId + ')', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'edit') {
        	ActivityCumulateTimes.openEditDlg(data);
        } else if (event === 'delete') {
        	ActivityCumulateTimes.delete(data);
        }
    });

});
