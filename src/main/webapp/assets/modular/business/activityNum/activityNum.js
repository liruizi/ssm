layui.use(['table', 'form', 'func', 'HttpRequest', 'util'], function () {
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var func = layui.func;
    var HttpRequest = layui.HttpRequest;
    var util = layui.util;

    // 职位表管理
    var ActivityNum = {
        tableId: "activityNumTable"
    };

    // 初始化表格的列
    ActivityNum.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键id'},
            {field: 'year', sort: true, title: '活动年限'},
            {field: 'area', sort: true, title: '活动城区'},
            {field: 'type', sort: true, title: '活动形式'},
            {field: 'typeSerial', sort: true, title: '编号前缀'},
            {field: 'serial', sort: true, title: '编号后缀'},
            {field: 'host', sort: true, title: '活动主办'},
            {field: 'guide', sort: true, title: '活动协办'},
            {field: 'title', sort: true, title: '活动主题'},
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

    // 点击查询按钮
    ActivityNum.search = function () {
        var queryData = {};
        queryData['type'] = $("#type").val();
        queryData['area'] = $("#area").val();
        queryData['year'] = $("#year").val();
        table.reload(ActivityNum.tableId, {
            where: queryData,
            page: {curr: 1}
        });
    };

    // 弹出添加对话框
    ActivityNum.openAddDlg = function () {
        func.open({
            title: '添加活动相关内容',
            content: Feng.ctxPath + '/view/activityNum/addView',
            tableId: ActivityNum.tableId
        });
    };

    // 点击编辑
    ActivityNum.openEditDlg = function (data) {
        func.open({
            title: '修改活动相关内容',
            content: Feng.ctxPath + '/view/activityNum/editView?id=' + data.id,
            tableId: ActivityNum.tableId
        });
    };

    // 点击删除
    ActivityNum.delete = function (data) {
        var operation = function () {
            var httpRequest = new HttpRequest(Feng.ctxPath + "/activityNum/delete", 'post', function (data) {
                Feng.success("删除成功!");
                table.reload(ActivityNum.tableId);
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
        elem: '#' + ActivityNum.tableId,
        url: Feng.ctxPath + '/activityNum/page',
        page: true,
        request: {pageName: 'pageNo', limitName: 'pageSize'}, //自定义分页参数
        height: "full-158",
        cellMinWidth: 100,
        cols: ActivityNum.initColumn(),
        parseData: Feng.parseData
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
    	ActivityNum.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
    	ActivityNum.openAddDlg();
    });
    
    // 工具条点击事件
    table.on('tool(' + ActivityNum.tableId + ')', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'edit') {
        	ActivityNum.openEditDlg(data);
        } else if (event === 'delete') {
        	ActivityNum.delete(data);
        }
    });

});
