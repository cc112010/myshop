<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>供应商信息表添加--${site.name}</title>
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
        <label class="layui-form-label">供应商编码</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="supplierCode" lay-verify="required" placeholder="请输入供应商编码">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">供应商名称</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="supplierName" lay-verify="required" placeholder="请输入供应商名称">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">供应商类型：1.自营，2.平台</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="supplierType" lay-verify="required" placeholder="请输入供应商类型：1.自营，2.平台">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">供应商联系人</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="linkMan" lay-verify="required" placeholder="请输入供应商联系人">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">联系电话</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="phoneNumber" lay-verify="required" placeholder="请输入联系电话">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">供应商开户银行名称</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="bankName" lay-verify="required" placeholder="请输入供应商开户银行名称">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">银行账号</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="bankAccount" lay-verify="required" placeholder="请输入银行账号">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">供应商地址</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="address" lay-verify="required" placeholder="请输入供应商地址">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态：0禁止，1启用</label>
        <div class="layui-input-block">

            <input  type="text"  class="layui-input" name="supplierStatus" lay-verify="required" placeholder="请输入状态：0禁止，1启用">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addSupplierInfo">立即提交</button>
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


        form.on("submit(addSupplierInfo)",function(data){

            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            $.post("${base}/admin/supplierInfo/add",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("供应商信息表添加成功！",{time:1000},function(){
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