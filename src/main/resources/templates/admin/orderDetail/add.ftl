<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>订单详情表添加--${site.name}</title>
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
        <label class="layui-form-label">订单表ID</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="orderId" lay-verify="required" placeholder="请输入订单表ID">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">订单商品ID</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="productId" lay-verify="required" placeholder="请输入订单商品ID">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品名称</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="productName" lay-verify="required" placeholder="请输入商品名称">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">购买商品数量</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="productCnt" lay-verify="required" placeholder="请输入购买商品数量">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">购买商品单价</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="productPrice" lay-verify="required" placeholder="请输入购买商品单价">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">平均成本价格</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="averageCost" lay-verify="required" placeholder="请输入平均成本价格">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品重量</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="weight"  placeholder="请输入商品重量">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">优惠分摊金额</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="feeMoney" lay-verify="required" placeholder="请输入优惠分摊金额">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">仓库ID</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="wId" lay-verify="required" placeholder="请输入仓库ID">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addOrderDetail">立即提交</button>
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


        form.on("submit(addOrderDetail)",function(data){

            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${base}/admin/orderDetail/add",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("订单详情表添加成功！",{time:1000},function(){
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