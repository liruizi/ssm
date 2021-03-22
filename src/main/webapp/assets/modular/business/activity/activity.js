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
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '主键id'},
            {field: 'times', sort: true, title: '活动日期',width: 140},
            {field: 'hour', sort: true, title: '活动时间',width: 105},
            {field: 'duration', sort: true, title: '活动时长',width: 105},
            {field: 'area', title: '行政单位',width: 90},
            {field: 'address', title: '活动地点'},
            {field: 'object',  title: '活动对象'},
            {field: 'type', title: '活动类型'},
            {field: 'people',  title: '对接单位负责人',width: 150},
            {field: 'contact',  title: '对接单位联系'},
            {field: 'theNumber',  title: '参加人数'},
            {field: 'leader',  title: '活动负责人'},
            {field: 'vehicleSecurity',  title: '车辆保障'},
            {field: 'driver',title: '活动司机'},
            
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
            title: '修改职位',
            content: Feng.ctxPath + '/view/position/editView?positionId=' + data.positionId,
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

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Position.search();
    });

    // 工具条点击事件
    table.on('tool(' + Position.tableId + ')', function (obj) {
        var data = obj.data;
        var event = obj.event;
        if (event === 'edit') {
            Position.openEditDlg(data);
        } else if (event === 'delete') {
            Position.delete(data);
        }
    });
});
