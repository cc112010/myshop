<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>订单主表编辑--${site.name}</title>
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
    <input value="${orderMaster.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">订单编号 yyyymmddnnnnnnnn</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.orderSn}" name="orderSn" lay-verify="required" placeholder="请输入订单编号 yyyymmddnnnnnnnn">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">下单人ID</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.customerId}" name="customerId" lay-verify="required" placeholder="请输入下单人ID">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">收货人姓名</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.shippingUser}" name="shippingUser" lay-verify="required" placeholder="请输入收货人姓名">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">省</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.province}" name="province" lay-verify="required" placeholder="请输入省">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">市</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.city}" name="city" lay-verify="required" placeholder="请输入市">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">区</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.district}" name="district" lay-verify="required" placeholder="请输入区">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地址</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.address}" name="address" lay-verify="required" placeholder="请输入地址">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">支付方式</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.paymentMethod}" name="paymentMethod" lay-verify="required" placeholder="请输入支付方式">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">订单金额</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.orderMoney}" name="orderMoney" lay-verify="required" placeholder="请输入订单金额">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">优惠金额</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.districtMoney}" name="districtMoney" lay-verify="required" placeholder="请输入优惠金额">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">运费金额</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.shippingMoney}" name="shippingMoney" lay-verify="required" placeholder="请输入运费金额">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">支付金额</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.paymentMoney}" name="paymentMoney" lay-verify="required" placeholder="请输入支付金额">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">快递公司名称</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.shippingCompName}" name="shippingCompName"  placeholder="请输入快递公司名称">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">快递单号</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.shippingSn}" name="shippingSn"  placeholder="请输入快递单号">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">下单时间</label>
        <div class="layui-input-block">
                <input type="text" name="createTime" id="createTime" <#if (orderMaster.createTime)??>value="${orderMaster.createTime?string('yyyy-MM-dd')}"</#if>  lay-verify="date|required" placeholder="请选择下单时间" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">发货时间</label>
        <div class="layui-input-block">
                <input type="text" name="shippingTime" id="shippingTime" <#if (orderMaster.shippingTime)??>value="${orderMaster.shippingTime?string('yyyy-MM-dd')}"</#if>  lay-verify="date" placeholder="请选择发货时间" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">支付时间</label>
        <div class="layui-input-block">
                <input type="text" name="payTime" id="payTime" <#if (orderMaster.payTime)??>value="${orderMaster.payTime?string('yyyy-MM-dd')}"</#if>  lay-verify="date" placeholder="请选择支付时间" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">收货时间</label>
        <div class="layui-input-block">
                <input type="text" name="receiveTime" id="receiveTime" <#if (orderMaster.receiveTime)??>value="${orderMaster.receiveTime?string('yyyy-MM-dd')}"</#if>  lay-verify="date" placeholder="请选择收货时间" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">订单状态</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.orderStatus}" name="orderStatus" lay-verify="required" placeholder="请输入订单状态">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">订单积分</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.orderPoint}" name="orderPoint" lay-verify="required" placeholder="请输入订单积分">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">发票抬头</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${orderMaster.invoiceTime}" name="invoiceTime"  placeholder="请输入发票抬头">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addOrderMaster">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/static/layui/layui.js"></script>
<script>
    layui.use(['form','jquery','layer','laydate'],function(){
        var form      = layui.form,
                $     = layui.jquery,
                layer = layui.layer;

                          //初始赋值

                          laydate.render({
                            elem: '#createTime'
<#if (orderMaster.createTime)??>
                            ,value: '${orderMaster.createTime?string("yyyy-MM-dd")}'
</#if>
                          });

                          //初始赋值

                          laydate.render({
                            elem: '#shippingTime'
<#if (orderMaster.shippingTime)??>
                            ,value: '${orderMaster.shippingTime?string("yyyy-MM-dd")}'
</#if>
                          });

                          //初始赋值

                          laydate.render({
                            elem: '#payTime'
<#if (orderMaster.payTime)??>
                            ,value: '${orderMaster.payTime?string("yyyy-MM-dd")}'
</#if>
                          });

                          //初始赋值

                          laydate.render({
                            elem: '#receiveTime'
<#if (orderMaster.receiveTime)??>
                            ,value: '${orderMaster.receiveTime?string("yyyy-MM-dd")}'
</#if>
                          });


        form.on("submit(addOrderMaster)",function(data){
                               data.field.createTime = new Date(data.field.createTime);
                               if(null === data.field.shippingTime || "" ===data.field.shippingTime){
                                delete data.field["shippingTime"];
                            }else{
                                data.field.shippingTime = new Date(data.field.shippingTime);
                            }
                               if(null === data.field.payTime || "" ===data.field.payTime){
                                delete data.field["payTime"];
                            }else{
                                data.field.payTime = new Date(data.field.payTime);
                            }
                               if(null === data.field.receiveTime || "" ===data.field.receiveTime){
                                delete data.field["receiveTime"];
                            }else{
                                data.field.receiveTime = new Date(data.field.receiveTime);
                            }
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/admin/orderMaster/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("订单主表编辑成功！",{time:1000},function(){
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