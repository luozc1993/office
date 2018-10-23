<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <jsp:include page="../../common/common.jsp"/>
    <link rel="stylesheet" sr>
    <style >
        .userList .layui-input{height: 30px}
        .userList .layui-elem-quote{    margin-top: 10px;padding: 12px;margin-bottom: 0px}
        .layui-table-cell .layui-form-checkbox[lay-skin=primary]{    top: 6px;}
    </style>
</head>
<body>
<form class="layui-form userList" style="    height: 100%;">

    <table id="userList" lay-filter="userList"></table>

    <script type="text/html" id="toolbar">
        <form class="layui-form">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" class="layui-input searchVal" placeholder="请输入搜索的内容" />
                </div>
                <a class="layui-btn layui-btn-sm search_btn layui-btn-sm" data-type="reload">搜索</a>
            </div>
            <div class="layui-inline">
                <a class="layui-btn layui-btn-sm layui-btn-normal addNews_btn">添加用户</a>
            </div>
            <div class="layui-inline">
                <a class="layui-btn layui-btn-sm layui-btn-danger layui-btn-normal delAll_btn">批量删除</a>
            </div>
        </form>
    </script>
    <!--操作-->
    <script type="text/html" id="userListBar">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
    </script>
    <script type="text/javascript" src="/static/js/sys/user/userList.js"></script>
</form>
</body>
</html>
