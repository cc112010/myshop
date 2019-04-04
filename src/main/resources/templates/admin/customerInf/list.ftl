<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息表--${site.name}</title>
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
  <legend>用户信息表检索</legend>
  <div class="layui-field-box">
    <form class="layui-form" id="searchForm">
    <div class="layui-inline" style="margin-left: 15px">
            <label>用户真实姓名:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_customerName" placeholder="请输入用户真实姓名" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>证件类型：1 身份证，2 军官证，3 护照:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_identityCardType" placeholder="请输入证件类型：1 身份证，2 军官证，3 护照" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>证件号码:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_identityCardNo" placeholder="请输入证件号码" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>手机号:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_mobilePhone" placeholder="请输入手机号" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>邮箱:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_customerEmail" placeholder="请输入邮箱" class="layui-input search_input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>性别:</label>
                <div class="layui-input-inline">
                <select name="s_gender">
                    <option value="" selected="">请选择性别</option>
                    <@my type="customer_inf_gender">
                    <#list result as r>
                    <option value="${r.value}" >${r.label}</option>
                    </#list>
                    </@my>
                </select>
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>注册时间:</label>
                <div class="layui-input-inline">
                    <input type="text" name="s_beginRegisterTime" id="beginRegisterTime" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
                <span>-</span>
                <div class="layui-input-inline">
                    <input type="text" name="s_endRegisterTime" id="endRegisterTime" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>会员生日:</label>
                <div class="layui-input-inline">
                    <input type="text" name="s_beginBirthday" id="beginBirthday" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
                <span>-</span>
                <div class="layui-input-inline">
                    <input type="text" name="s_endBirthday" id="endBirthday" lay-verify="date"  autocomplete="off" class="layui-input">
                </div>
    </div>
    <div class="layui-inline" style="margin-left: 15px">
            <label>会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石:</label>
                <div class="layui-input-inline">
                <input type="text" value="" name="s_customerLevel" placeholder="请输入会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石" class="layui-input search_input">
                </div>
    </div>
        <div class="layui-inline">
            <a class="layui-btn" lay-submit="" lay-filter="searchForm">查询</a>
        </div>
        <div class="layui-inline" >
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
        <div class="layui-inline">
            <a class="layui-btn layui-btn-normal" data-type="addCustomerInf">添加用户信息表</a>
        </div>
    </form>
  </div>
</fieldset>
<div class="layui-form users_list">
    <table class="layui-table" id="test" lay-filter="demo"></table>
    <script type="text/html" id="gender">
        <@my type="customer_inf_gender">
        <#list result as r>
        {{#  if(d.gender == ${r.value}){ }}
        <span>${r.label}</span>
        {{#  } }}
        </#list>
        </@my>
    </script>
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

        var beginRegisterTime= laydate.render({//渲染开始时间选择
            elem: '#beginRegisterTime', //通过id绑定html中插入的start
            type: 'date',
            max:"2099-12-31",//设置一个默认最大值
            done: function (value, dates) {
                endRegisterTime.config.min ={
                    year:dates.year,
                    month:dates.month-1, //关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                };
            }
        });
        var endRegisterTime= laydate.render({//渲染结束时间选择
            elem: '#endRegisterTime',//通过id绑定html中插入的end
            type: 'date',
            min:"1970-1-1",//设置min默认最小值
            done: function (value, dates) {
                beginRegisterTime.config.max={
                    year:dates.year,
                    month:dates.month-1,//关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                }
            }
        });
        var beginBirthday= laydate.render({//渲染开始时间选择
            elem: '#beginBirthday', //通过id绑定html中插入的start
            type: 'date',
            max:"2099-12-31",//设置一个默认最大值
            done: function (value, dates) {
                endBirthday.config.min ={
                    year:dates.year,
                    month:dates.month-1, //关键
                    date: dates.date,
                    hours: 0,
                    minutes: 0,
                    seconds : 0
                };
            }
        });
        var endBirthday= laydate.render({//渲染结束时间选择
            elem: '#endBirthday',//通过id绑定html中插入的end
            type: 'date',
            min:"1970-1-1",//设置min默认最小值
            done: function (value, dates) {
                beginBirthday.config.max={
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
                    title : "编辑用户信息表",
                    type : 2,
                    content : "${base}/admin/customerInf/edit?id="+data.id,
                    success : function(layero, index){
                        setTimeout(function(){
                            layer.tips('点击此处返回用户信息表列表', '.layui-layer-setwin .layui-layer-close', {
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
                layer.confirm("你确定要删除该用户信息表么？",{btn:['是的,我确定','我再想想']},
                        function(){
                            $.post("${base}/admin/customerInf/delete",{"id":data.id},function (res){
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
            url:'${base}/admin/customerInf/list',
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
                {field:'customerId', title: 'customer_login表的自增ID'},
                {field:'customerName', title: '用户真实姓名'},
                {field:'identityCardType', title: '证件类型：1 身份证，2 军官证，3 护照'},
                {field:'identityCardNo', title: '证件号码'},
                {field:'mobilePhone', title: '手机号'},
                {field:'customerEmail', title: '邮箱'},
                {field:'gender', title: '性别',templet:'#gender'},
                {field:'userPoint', title: '用户积分'},
                {field:'registerTime',  title: '注册时间',templet:'<div>{{ layui.laytpl.toDateString(d.registerTime,"yyyy-MM-dd") }}</div>',unresize: true},
                {field:'birthday',  title: '会员生日',templet:'<div>{{ layui.laytpl.toDateString(d.birthday,"yyyy-MM-dd") }}</div>',unresize: true},
                {field:'customerLevel', title: '会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石'},
                {field:'userMoney', title: '用户余额'},
                {field:'delFlag',    title: '用户信息表状态',width:'12%',templet:'#userStatus'},
                {field:'createDate',  title: '创建时间',width:'15%',templet:'<div>{{ layui.laytpl.toDateString(d.createDate) }}</div>',unresize: true}, //单元格内容水平居中
                {fixed: 'right', title:'操作',  width: '15%', align: 'center',toolbar: '#barDemo'}
            ]]
        };
        table.render(t);

        var active={
            addCustomerInf : function(){
                var addIndex = layer.open({
                    title : "添加用户信息表",
                    type : 2,
                    content : "${base}/admin/customerInf/add",
                    success : function(layero, addIndex){
                        setTimeout(function(){
                            layer.tips('点击此处返回用户信息表列表', '.layui-layer-setwin .layui-layer-close', {
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