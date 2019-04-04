<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>订单主表--${site.name}</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <meta name="description" content="${site.description}"/>
    <meta name="keywords" content="${site.keywords}"/>
    <meta name="author" content="${site.author}"/>
    <link rel="icon" href="${site.logo}">
    <link rel="stylesheet" href="${base}/static/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
    <link rel="stylesheet" href="${base}/static/css/user.css" media="all" />
</head>
<body class="childrenBody">
<fieldset class="layui-elem-field">
  <legend>订单主表检索</legend>
  <div class="layui-field-box">
    <form class="layui-form" id="searchForm">
    <div class="layui-inline" style="margin-left: 15px">
            <label>订单编号 yyyymmddnnnnnnnn:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_orderSn" placeholder="请输入订单编号 yyyymmddnnnnnnnn" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>收货人姓名:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_shippingUser" placeholder="请输入收货人姓名" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>省:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_province" placeholder="请输入省" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>市:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_city" placeholder="请输入市" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>区:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_district" placeholder="请输入区" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>支付方式:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_paymentMethod" placeholder="请输入支付方式" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>快递公司名称:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_shippingCompName" placeholder="请输入快递公司名称" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>快递单号:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_shippingSn" placeholder="请输入快递单号" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>下单时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="s_beginCreateTime" id="beginCreateTime" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
                <span>-</span>
                <div class="layui-input-inline">
                    <input type="text" name="s_endCreateTime" id="endCreateTime" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>发货时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="s_beginShippingTime" id="beginShippingTime" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
                <span>-</span>
                <div class="layui-input-inline">
                    <input type="text" name="s_endShippingTime" id="endShippingTime" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>支付时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="s_beginPayTime" id="beginPayTime" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
                <span>-</span>
                <div class="layui-input-inline">
                    <input type="text" name="s_endPayTime" id="endPayTime" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>收货时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="s_beginReceiveTime" id="beginReceiveTime" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
                <span>-</span>
                <div class="layui-input-inline">
                    <input type="text" name="s_endReceiveTime" id="endReceiveTime" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>订单状态:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_orderStatus" placeholder="请输入订单状态" class="layui-input search_input">
                </div>
    </div>
        <div class="layui-inline">
            <a class="layui-btn" lay-submit="" lay-filter="searchForm">查询</a>
        </div>
        <div class="layui-inline" >
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
        <div class="layui-inline">
            <a class="layui-btn layui-btn-normal" data-type="addOrderMaster">添加订单主表</a>
        </div>
    </form>
  </div>
</fieldset>
<div class="layui-form users_list">
    <table class="layui-table" id="test" lay-filter="demo"></table>
    <script type="text/html" id="userStatus">
        <!-- 这里的 checked 的状态只是演示 -->
        {{#  if(d.delFlag == false){ }}
        <span class="layui-badge layui-bg-green">正常</span>
        {{#  } else { }}
        <span class="layui-badge layui-bg-gray">停用</span>
        {{#  } }}
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
</div>
<div id="page"></div>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script type="text/javascript" src="${base}/static/js/tools.js"></script>
<script>
    layui.use(['layer','form','table','laydate'], function() {
        var layer = layui.layer,
                $ = layui.jquery,
                form = layui.form,
                laydate = layui.laydate,
                table = layui.table;

        var beginCreateTime= laydate.render({//渲染开始时间选择
            elem: '#beginCreateTime', //通过id绑定html中插入的start
            type: 'date',
            max:"2099-12-31",//设置一个默认最大值
            done: function (value, dates) {
                endCreateTime.config.min ={
                    year:dates.year,
                    month:dates.month-1, //关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                };
            }
        });
        var endCreateTime= laydate.render({//渲染结束时间选择
            elem: '#endCreateTime',//通过id绑定html中插入的end
            type: 'date',
            min:"1970-1-1",//设置min默认最小值
            done: function (value, dates) {
                beginCreateTime.config.max={
                    year:dates.year,
                    month:dates.month-1,//关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                }
            }
        });
        var beginShippingTime= laydate.render({//渲染开始时间选择
            elem: '#beginShippingTime', //通过id绑定html中插入的start
            type: 'date',
            max:"2099-12-31",//设置一个默认最大值
            done: function (value, dates) {
                endShippingTime.config.min ={
                    year:dates.year,
                    month:dates.month-1, //关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                };
            }
        });
        var endShippingTime= laydate.render({//渲染结束时间选择
            elem: '#endShippingTime',//通过id绑定html中插入的end
            type: 'date',
            min:"1970-1-1",//设置min默认最小值
            done: function (value, dates) {
                beginShippingTime.config.max={
                    year:dates.year,
                    month:dates.month-1,//关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                }
            }
        });
        var beginPayTime= laydate.render({//渲染开始时间选择
            elem: '#beginPayTime', //通过id绑定html中插入的start
            type: 'date',
            max:"2099-12-31",//设置一个默认最大值
            done: function (value, dates) {
                endPayTime.config.min ={
                    year:dates.year,
                    month:dates.month-1, //关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                };
            }
        });
        var endPayTime= laydate.render({//渲染结束时间选择
            elem: '#endPayTime',//通过id绑定html中插入的end
            type: 'date',
            min:"1970-1-1",//设置min默认最小值
            done: function (value, dates) {
                beginPayTime.config.max={
                    year:dates.year,
                    month:dates.month-1,//关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                }
            }
        });
        var beginReceiveTime= laydate.render({//渲染开始时间选择
            elem: '#beginReceiveTime', //通过id绑定html中插入的start
            type: 'date',
            max:"2099-12-31",//设置一个默认最大值
            done: function (value, dates) {
                endReceiveTime.config.min ={
                    year:dates.year,
                    month:dates.month-1, //关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                };
            }
        });
        var endReceiveTime= laydate.render({//渲染结束时间选择
            elem: '#endReceiveTime',//通过id绑定html中插入的end
            type: 'date',
            min:"1970-1-1",//设置min默认最小值
            done: function (value, dates) {
                beginReceiveTime.config.max={
                    year:dates.year,
                    month:dates.month-1,//关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                }
            }
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'edit'){
                var editIndex = layer.open({
                    title : "编辑订单主表",
                    type : 2,
                    content : "${base}/admin/orderMaster/edit?id="+data.id,
                    success : function(layero, index){
                        setTimeout(function(){
                            layer.tips('点击此处返回订单主表列表', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500);
                    }
                });
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function(){
                    layer.full(editIndex);
                });
                layer.full(editIndex);
            }
            if(obj.event === "del"){
                layer.confirm("你确定要删除该订单主表么？",{btn:['是的,我确定','我再想想']},
                        function(){
                            $.post("${base}/admin/orderMaster/delete",{"id":data.id},function (res){
                                if(res.success){
                                    layer.msg("删除成功",{time: 1000},function(){
                                        location.reload();
                                    });
                                }else{
                                    layer.msg(res.message);
                                }

                            });
                        }
                )
            }
        });

        var t = {
            elem: '#test',
            url:'${base}/admin/orderMaster/list',
            method:'post',
            page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'], //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                groups: 2, //只显示 1 个连续页码
                first: "首页", //显示首页
                last: "尾页", //显示尾页
                limits:[3,10, 20, 30]
            },
            cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            cols: [[
                {type:'checkbox'},
                {field:'orderSn', title: '订单编号 yyyymmddnnnnnnnn'},
                {field:'customerId', title: '下单人ID'},
                {field:'shippingUser', title: '收货人姓名'},
                {field:'province', title: '省'},
                {field:'city', title: '市'},
                {field:'district', title: '区'},
                {field:'address', title: '地址'},
                {field:'paymentMethod', title: '支付方式'},
                {field:'orderMoney', title: '订单金额'},
                {field:'districtMoney', title: '优惠金额'},
                {field:'shippingMoney', title: '运费金额'},
                {field:'paymentMoney', title: '支付金额'},
                {field:'shippingCompName', title: '快递公司名称'},
                {field:'shippingSn', title: '快递单号'},
                {field:'createTime',  title: '下单时间',templet:'<div>{{ layui.laytpl.toDateString(d.createTime,"yyyy-MM-dd") }}</div>',unresize: true},
                {field:'shippingTime',  title: '发货时间',templet:'<div>{{ layui.laytpl.toDateString(d.shippingTime,"yyyy-MM-dd") }}</div>',unresize: true},
                {field:'payTime',  title: '支付时间',templet:'<div>{{ layui.laytpl.toDateString(d.payTime,"yyyy-MM-dd") }}</div>',unresize: true},
                {field:'receiveTime',  title: '收货时间',templet:'<div>{{ layui.laytpl.toDateString(d.receiveTime,"yyyy-MM-dd") }}</div>',unresize: true},
                {field:'orderStatus', title: '订单状态'},
                {field:'orderPoint', title: '订单积分'},
                {field:'invoiceTime', title: '发票抬头'},
                {field:'delFlag',    title: '订单主表状态',width:'12%',templet:'#userStatus'},
                {field:'createDate',  title: '创建时间',width:'15%',templet:'<div>{{ layui.laytpl.toDateString(d.createDate) }}</div>',unresize: true}, //单元格内容水平居中
                {fixed: 'right', title:'操作',  width: '15%', align: 'center',toolbar: '#barDemo'}
            ]]
        };
        table.render(t);

        var active={
            addOrderMaster : function(){
                var addIndex = layer.open({
                    title : "添加订单主表",
                    type : 2,
                    content : "${base}/admin/orderMaster/add",
                    success : function(layero, addIndex){
                        setTimeout(function(){
                            layer.tips('点击此处返回订单主表列表', '.layui-layer-setwin .layui-layer-close', {
                                tips: 3
                            });
                        },500);
                    }
                });
                //改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
                $(window).resize(function(){
                    layer.full(addIndex);
                });
                layer.full(addIndex);
            }
        };

        $('.layui-inline .layui-btn-normal').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        form.on("submit(searchForm)",function(data){
            t.where = data.field;
            table.reload('test', t);
            return false;
        });

    });
</script>
</body>
</html>