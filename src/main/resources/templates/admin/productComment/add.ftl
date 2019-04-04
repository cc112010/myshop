<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品评论表添加--${site.name}</title>
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
    <div class="layui-form-item">
        <label class="layui-form-label">商品ID</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="productId" lay-verify="required" placeholder="请输入商品ID">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">订单ID</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="orderId" lay-verify="required" placeholder="请输入订单ID">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户ID</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="customerId" lay-verify="required" placeholder="请输入用户ID">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">评论标题</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="title" lay-verify="required" placeholder="请输入评论标题">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">评论内容</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="content" lay-verify="required" placeholder="请输入评论内容">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">审核状态</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="auditStatus" lay-verify="required" placeholder="请输入审核状态">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">评论时间</label>
        <div class="layui-input-block">

            <input type="text" name="auditTime" id="auditTime"   lay-verify="date" placeholder="请选择评论时间" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addProductComment">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','laydate'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                laydate = layui.laydate,
                layer = layui.layer;

                          //初始赋值
                          laydate.render({
                            elem: '#auditTime'
                          });

        form.on("submit(addProductComment)",function(data){
                       data.field.auditTime = new Date(data.field.auditTime);

            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${base}/admin/productComment/add",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("商品评论表添加成功！",{time:1000},function(){
                        parent.layer.close(parent.addIndex);
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