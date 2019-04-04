<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>商品信息表编辑--${site.name}</title>
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
    <input value="${productInfo.id}" name="id" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">商品编码</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.productCore}" name="productCore" lay-verify="required" placeholder="请输入商品编码">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品名称</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.productName}" name="productName" lay-verify="required" placeholder="请输入商品名称">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">国条码</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.barCode}" name="barCode" lay-verify="required" placeholder="请输入国条码">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">品牌表的ID</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.brandId}" name="brandId" lay-verify="required" placeholder="请输入品牌表的ID">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">一级分类ID</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.oneCategoryId}" name="oneCategoryId" lay-verify="required" placeholder="请输入一级分类ID">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">二级分类ID</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.twoCategoryId}" name="twoCategoryId" lay-verify="required" placeholder="请输入二级分类ID">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">三级分类ID</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.threeCategoryId}" name="threeCategoryId" lay-verify="required" placeholder="请输入三级分类ID">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品的供应商ID</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.supplierId}" name="supplierId" lay-verify="required" placeholder="请输入商品的供应商ID">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品销售价格</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.price}" name="price" lay-verify="required" placeholder="请输入商品销售价格">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品加权平均成本</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.averageCost}" name="averageCost" lay-verify="required" placeholder="请输入商品加权平均成本">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上下架状态：0下架1上架</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.publishStatus}" name="publishStatus" lay-verify="required" placeholder="请输入上下架状态：0下架1上架">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">审核状态：0未审核，1已审核</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.auditStatus}" name="auditStatus" lay-verify="required" placeholder="请输入审核状态：0未审核，1已审核">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品重量</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.weight}" name="weight"  placeholder="请输入商品重量">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品长度</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.length}" name="length"  placeholder="请输入商品长度">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品高度</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.height}" name="height"  placeholder="请输入商品高度">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品宽度</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.width}" name="width"  placeholder="请输入商品宽度">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">颜色分类</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.colorType}" name="colorType"  placeholder="请输入颜色分类">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">生产日期</label>
        <div class="layui-input-block">
                <input type="text" name="productionDate" id="productionDate" <#if (productInfo.productionDate)??>value="${productInfo.productionDate?string('yyyy-MM-dd')}"</#if>  lay-verify="date" placeholder="请选择生产日期" autocomplete="off" class="layui-input">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品有效期</label>
        <div class="layui-input-block">
                <input  type="text" class="layui-input" value = "${productInfo.shelfLife}" name="shelfLife"  placeholder="请输入商品有效期">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品描述</label>
        <div class="layui-input-block">
                <textarea name="descript"   placeholder="请输入商品描述" class="layui-textarea">${productInfo.descript}</textarea>

        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="addProductInfo">立即提交</button>
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
                            elem: '#productionDate'
<#if (productInfo.productionDate)??>
                            ,value: '${productInfo.productionDate?string("yyyy-MM-dd")}'
</#if>
                          });


        form.on("submit(addProductInfo)",function(data){
                               if(null === data.field.productionDate || "" ===data.field.productionDate){
                                delete data.field["productionDate"];
                            }else{
                                data.field.productionDate = new Date(data.field.productionDate);
                            }
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            //给角色赋值
            $.post("${base}/admin/productInfo/edit",data.field,function(res){
                layer.close(loadIndex);
                if(res.success){
                    parent.layer.msg("商品信息表编辑成功！",{time:1000},function(){
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