layui.use(['table', 'form', 'func', 'laydate', 'HttpRequest', 'util'], function () {
    var $ = layui.$;
    var table = layui.table;
    var form = layui.form;
    var func = layui.func;
    var HttpRequest = layui.HttpRequest;
    var util = layui.util;
    var laydate = layui.laydate;
    // 职位表管理
    var Position = {
        tableId: "activityTable"
    };

    // 初始化表格的列
    Position.initColumn = function () {
        return [[
            
            {field: 'id', hide: true, title: '主键id'},
            {field: 'times', title: '活动日期',width: 140},
            {field: 'hour',  title: '时间',width: 70},
            {field: 'number', title: '活动编号',width: 120},
            {field: 'typeNumber', title: '类型编号',width: 120},
            {field: 'area', title: '行政单位',width: 90},
            {field: 'address', title: '活动地点'},
            {field: 'type', title: '活动类型'},
            {field: 'people',  title: '对接单位负责人',width: 150},
            {field: 'theNumber',  title: '参加人数'},
            {field: 'activityResp',  title: '活动负责人'},
            {field: 'vehicleSecurity',  title: '车辆保障'},
            {field: 'driver',title: '活动司机'},
            {align: 'center', toolbar: '#tableBar', title: '操作',width: 160}
        ]];
    };

    // 点击查询按钮
    Position.search = function () {
        var queryData = {};
        queryData['beginTime'] = $("#beginDateTime").val();
        queryData['endTime'] = $("#endDateTime").val();
        queryData['times'] = $("#times").val();
        queryData['duration'] = $("#duration").val();
        queryData['area'] = $("#area").val();
        queryData['type'] = $("#type").val();
        queryData['leader'] = $("#leader").val();
        queryData['driver'] = $("#driver").val();
        table.reload(Position.tableId, {
            where: queryData,
            page: {curr: 1}
        });
    };

    // 点击编辑
    Position.openEditDlg = function (data) {
        func.open({
            title: '编辑我的活动',
            content: Feng.ctxPath + '/view/activity/editView?id=' + data.id,
            tableId: Position.tableId
        });
    };
    
   // 渲染时间选择框
    laydate.render({
        elem: '#beginDateTime'
    });

    //渲染时间选择框
    laydate.render({
        elem: '#endDateTime'
    });
    
    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Position.tableId,
        url: Feng.ctxPath + '/activity/page',
        page: true,
        request: {pageName: 'pageNo', limitName: 'pageSize'}, //自定义分页参数
        height: "full-158",
        cellMinWidth: 100,
        cols: Position.initColumn(),
        parseData: Feng.parseData
    });

    // 点击详情
    Position.openDetailDlg = function (data) {
        func.open({
            title: '我的活动详情',
            content: Feng.ctxPath + '/view/activity/detailView?id=' + data.id,
            tableId: Position.tableId
        });
    };
    
    // 导出excel按钮
    Position.exportExcel = function () {
        var checkRows = table.checkStatus(Position.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };
    // 点击删除
    Position.delete = function (data) {
        var operation = function () {
            var httpRequest = new HttpRequest(Feng.ctxPath + "/activity/delete", 'post', function (data) {
                Feng.success("删除成功!");
                table.reload(Position.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.message + "!");
            });
            httpRequest.set(data);
            httpRequest.start(true);
        };
        Feng.confirm("是否删除?", operation);
    };
    
    // 弹出添加对话框
    Position.openAddDlg = function (data) {
    	var area = $("input[name='radio1']:checked").val();
    	var type = $("input[name='radio2']:checked").val();
    	$("#w_warning").animate({top:"-400px"}, 200).hide(200);
    	$("#w_mengban").delay(100).fadeOut(200);
        func.open({
            title: '添加活动',
            content: Feng.ctxPath + '/view/activity/addView?area='+ area + '&type=' + type,
            tableId: Position.tableId
        });
       
    };

    
    
    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Position.search();
    });
    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        Position.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        Position.exportExcel();
    });
    // 工具条点击事件
    table.on('tool(' + Position.tableId + ')', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'edit') {
            Position.openEditDlg(data);
        } else if (event === 'delete') {
            Position.delete(data);
        } else if (event === 'detail') {
        		Position.openDetailDlg(data);
        }
    });
});
