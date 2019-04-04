<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>品牌信息表编辑--${site.name}</title>
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
    <input value="${brandInfo.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">品牌名称</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${brandInfo.brandName}" name="brandName" lay-verify="required" placeholder="请输入品牌名称">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系电话</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${brandInfo.telephone}" name="telephone" lay-verify="required" placeholder="请输入联系电话">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">品牌网络</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${brandInfo.brandWeb}" name="brandWeb"  placeholder="请输入品牌网络">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">品牌logo URL</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${brandInfo.brandLogo}" name="brandLogo"  placeholder="请输入品牌logo URL">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">品牌描述</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${brandInfo.brandDesc}" name="brandDesc"  placeholder="请输入品牌描述">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">品牌状态</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${brandInfo.brandStatus}" name="brandStatus" lay-verify="required" placeholder="请输入品牌状态">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">排序</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${brandInfo.brandOrder}" name="brandOrder" lay-verify="required" placeholder="请输入排序">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addBrandInfo">立即提交</button>
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


        form.on("submit(addBrandInfo)",function(data){
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/admin/brandInfo/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("品牌信息表编辑成功！",{time:1000},function(){
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