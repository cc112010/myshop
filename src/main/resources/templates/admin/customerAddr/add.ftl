<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户地址表添加--${site.name}</title>
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
        <label class="layui-form-label">customer_login表的自增ID</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="customerId" lay-verify="required" placeholder="请输入customer_login表的自增ID">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮编</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="zip" lay-verify="required" placeholder="请输入邮编">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地区表中省份的ID</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="province" lay-verify="required" placeholder="请输入地区表中省份的ID">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地区表中城市的ID</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="city" lay-verify="required" placeholder="请输入地区表中城市的ID">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地区表中的区ID</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="district" lay-verify="required" placeholder="请输入地区表中的区ID">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">具体的地址门牌号</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="address" lay-verify="required" placeholder="请输入具体的地址门牌号">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">是否默认</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="isDefault" lay-verify="required" placeholder="请输入是否默认">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addCustomerAddr">立即提交</button>
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


        form.on("submit(addCustomerAddr)",function(data){

            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${base}/admin/customerAddr/add",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("用户地址表添加成功！",{time:1000},function(){
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