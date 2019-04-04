<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>仓库信息表编辑--${site.name}</title>
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
    <style type="text/css">
        .layui-form-item .layui-inline{ width:33.333%; float:left; margin-right:0; }
        @media(max-width:1240px){
            .layui-form-item .layui-inline{ width:100%; float:none; }
        }
        .layui-form-item .role-box {
            position: relative;
        }
        .layui-form-item .role-box .jq-role-inline {
            height: 100%;
            overflow: auto;
        }

    </style>
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <input value="${warehouseInfo.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">仓库编码</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${warehouseInfo.warehouseSn}" name="warehouseSn" lay-verify="required" placeholder="请输入仓库编码">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">仓库名称</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${warehouseInfo.warehoustName}" name="warehoustName" lay-verify="required" placeholder="请输入仓库名称">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">仓库电话</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${warehouseInfo.warehousePhone}" name="warehousePhone" lay-verify="required" placeholder="请输入仓库电话">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">仓库联系人</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${warehouseInfo.contact}" name="contact" lay-verify="required" placeholder="请输入仓库联系人">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">省</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${warehouseInfo.province}" name="province" lay-verify="required" placeholder="请输入省">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">市</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${warehouseInfo.city}" name="city" lay-verify="required" placeholder="请输入市">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">区</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${warehouseInfo.distrct}" name="distrct" lay-verify="required" placeholder="请输入区">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">仓库地址</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${warehouseInfo.address}" name="address" lay-verify="required" placeholder="请输入仓库地址">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">仓库状态</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${warehouseInfo.warehouseStatus}" name="warehouseStatus" lay-verify="required" placeholder="请输入仓库状态">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addWarehouseInfo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                layer = layui.layer;


        form.on("submit(addWarehouseInfo)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/admin/warehouseInfo/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("仓库信息表编辑成功！",{time:1000},function(){
                        parent.layer.close(parent.editIndex);
                        //刷新父页面
                        parent.location.reload();
                    });
                }else{
                    layer.msg(res.message);
                }
            });
            return false;
        });

    });
</script>
</body>
</html>