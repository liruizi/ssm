layui.use(['table', 'form', 'func', 'HttpRequest', 'util'], function () {
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var func = layui.func;
    var HttpRequest = layui.HttpRequest;
    var util = layui.util;

    // 职位表管理
    var ActivityTotal = {
        tableId: "ActivityTotalTable"
    };

    // 初始化表格的列
    ActivityTotal.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键id'},
            {field: 'area', sort: true, title: '活动区域'},
            {field: 'year', sort: true, title: '活动年限'},
            {field: 'prefix', sort: true, title: '活动前缀'},
            {field: 'number', sort: true, title: '活动编号'},
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
    ActivityTotal.search = function () {
        var queryData = {};
        queryData['positionName'] = $("#positionName").val();
        //queryData['positionCode'] = $("#positionCode").val();
        table.reload(ActivityTotal.tableId, {
            where: queryData,
            page: {curr: 1}
        });
    };

    // 弹出添加对话框
    ActivityTotal.openAddDlg = function () {
        func.open({
            title: '添加活动编号',
            content: Feng.ctxPath + '/view/activityTotal/addView',
            tableId: ActivityTotal.tableId
        });
    };

    // 点击编辑
    ActivityTotal.openEditDlg = function (data) {
        func.open({
            title: '修改活动编号',
            content: Feng.ctxPath + '/view/activityTotal/editView?id=' + data.id,
            tableId: ActivityTotal.tableId
        });
    };

    // 点击删除
    ActivityTotal.delete = function (data) {
        var operation = function () {
            var httpRequest = new HttpRequest(Feng.ctxPath + "/activityTotal/delete", 'post', function (data) {
                Feng.success("删除成功!");
                table.reload(ActivityTotal.tableId);
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
        elem: '#' + ActivityTotal.tableId,
        url: Feng.ctxPath + '/activityTotal/page',
        page: true,
        request: {pageName: 'pageNo', limitName: 'pageSize'}, //自定义分页参数
        height: "full-158",
        cellMinWidth: 100,
        cols: ActivityTotal.initColumn(),
        parseData: Feng.parseData
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
    	ActivityTotal.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
    	ActivityTotal.openAddDlg();
    });
    
    // 工具条点击事件
    table.on('tool(' + ActivityTotal.tableId + ')', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'edit') {
        	ActivityTotal.openEditDlg(data);
        } else if (event === 'delete') {
        	ActivityTotal.delete(data);
        }
    });

});
