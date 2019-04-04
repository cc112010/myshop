<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息表编辑--${site.name}</title>
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
    <input value="${customerInf.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">customer_login表的自增ID</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${customerInf.customerId}" name="customerId" lay-verify="required" placeholder="请输入customer_login表的自增ID">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户真实姓名</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${customerInf.customerName}" name="customerName" lay-verify="required" placeholder="请输入用户真实姓名">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">证件类型：1 身份证，2 军官证，3 护照</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${customerInf.identityCardType}" name="identityCardType" lay-verify="required" placeholder="请输入证件类型：1 身份证，2 军官证，3 护照">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">证件号码</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${customerInf.identityCardNo}" name="identityCardNo"  placeholder="请输入证件号码">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${customerInf.mobilePhone}" name="mobilePhone"  placeholder="请输入手机号">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${customerInf.customerEmail}" name="customerEmail"  placeholder="请输入邮箱">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
                <select name="gender" >
                    <option value="" selected="">请选择性别</option>
                    <@my type="customer_inf_gender">
                    <#list result as r>
                    <option value="${r.value}"  <#if (customerInf.gender == r.value)> selected="" </#if>  >${r.label}</option>
                    </#list>
                    </@my>
                </select>

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户积分</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${customerInf.userPoint}" name="userPoint" lay-verify="required" placeholder="请输入用户积分">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">注册时间</label>
        <div class="layui-input-block">
                <input type="text" name="registerTime" id="registerTime" <#if (customerInf.registerTime)??>value="${customerInf.registerTime?string('yyyy-MM-dd')}"</#if>  lay-verify="date|required" placeholder="请选择注册时间" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">会员生日</label>
        <div class="layui-input-block">
                <input type="text" name="birthday" id="birthday" <#if (customerInf.birthday)??>value="${customerInf.birthday?string('yyyy-MM-dd')}"</#if>  lay-verify="date" placeholder="请选择会员生日" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${customerInf.customerLevel}" name="customerLevel" lay-verify="required" placeholder="请输入会员级别：1 普通会员，2 青铜，3白银，4黄金，5钻石">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户余额</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${customerInf.userMoney}" name="userMoney" lay-verify="required" placeholder="请输入用户余额">

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addCustomerInf">立即提交</button>
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
                            elem: '#registerTime'
<#if (customerInf.registerTime)??>
                            ,value: '${customerInf.registerTime?string("yyyy-MM-dd")}'
</#if>
                          });

                          //初始赋值

                          laydate.render({
                            elem: '#birthday'
<#if (customerInf.birthday)??>
                            ,value: '${customerInf.birthday?string("yyyy-MM-dd")}'
</#if>
                          });


        form.on("submit(addCustomerInf)",function(data){
                               data.field.registerTime = new Date(data.field.registerTime);
                               if(null === data.field.birthday || "" ===data.field.birthday){
                                delete data.field["birthday"];
                            }else{
                                data.field.birthday = new Date(data.field.birthday);
                            }
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/admin/customerInf/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("用户信息表编辑成功！",{time:1000},function(){
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