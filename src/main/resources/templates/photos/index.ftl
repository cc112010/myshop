<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <#include "${base}/photos/common/header.ftl">
    <!-- 本页样式表 -->
    <link href="${base}/static/blog/css/home.css?t=${.now?long}" rel="stylesheet" />
</head>
<body>
<div class="layui-carousel" id="carousel">
    <div carousel-item>
    <@ar channelId="19">
        <#if (result?size>0)>
            <#list result as items>
                <div><img src="${items.showPic}"></div>
            </#list>
        </#if>
    </@ar>
    </div>
</div>
<div>
    <p>hello world</p>
</div>
</body>
</html>