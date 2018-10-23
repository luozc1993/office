layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer == undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laytpl = layui.laytpl,
        table = layui.table;

    //用户列表
    var tableIns = table.render({
        elem: '#userList',
        url : '/sys/user/getUserList.json',
        cellMinWidth : 95,
        page : true,
        limits : [10,15,20,25],
        limit : 20,
        toolbar: '#toolbar',
        id : "userListTable",
        cols : [[
            {type: "checkbox", fixed:"left", width:42},
            {field: 'username', title: '用户名', minWidth:100, align:"center"},
            {field: 'telephone', title: '手机号', minWidth:120, align:"center"},
 /*           {field: 'mail', title: '用户邮箱', minWidth:200, align:'center',templet:function(d){
                return '<a class="layui-blue" href="mailto:'+d.mail+'">'+d.mail+'</a>';
            }},*/
            {field: 'status', title: '状态',minWidth:80, align:'center',templet:function(d){
                    if(d.status ==null||d.status=="0"){
                        return  '<a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="usable">已启用</a>'
                    }else{
                        return '<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="usable">已禁用</a>'
                    }
                    return s;
            }},
            {field: 'grade', title: '用户等级', minWidth:100,align:'center',templet:function(d){
                var grade = d["grade"];
                if(grade == "0"){
                    return "注册会员";
                }else if(grade == "1"){
                    return "中级会员";
                }else if(grade == "2"){
                    return "高级会员";
                }else if(grade == "3"){
                    return "钻石会员";
                }else if(grade == "4"){
                    return "超级会员";
                }
            }},
            {field: 'lastlogintime', title: '最后登录时间', align:'center',minWidth:150,templet:function(d){
                return timestampToTime(d.lastlogintime.time/1000,"yyyy-MM-dd HH:mm");
                }},
            {title: '操作', minWidth:120, templet:'#userListBar',fixed:"right",align:"center"}
        ]]
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //添加用户
    function addUser(edit){
        var index = layui.layer.open({
            title : "添加用户",
            type : 2,
            content : "/static/page/user/userAdd.html",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){
                    body.find("#userId").val(edit.id);
                    body.find(".userName").val(edit.username);  //登录名
                    body.find(".telePhone").val(edit.telephone);  //登录名
                    body.find(".userSex input[value="+edit.sex+"]").prop("checked","checked");  //性别
                    body.find(".userStatus").val(edit.status);    //用户状态
                    body.find(".userDesc").val(edit.remark);    //用户简介
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                        tips: 3
                    });
                },500)
            }
        });
        layui.layer.full(index);
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    $(".addNews_btn").click(function(){
        addUser();
    });

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            ids = "";
        if(data.length > 0) {
            for (var i in data) {
                ids +=data[i].id+",";
            }
            layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
                 $.get("/sys/user/delUsers",{
                     ids : ids.substring(0,ids.length-1)  //将需要删除的newsId作为参数传入
                 },function(data){
                tableIns.reload();
                layer.close(index);
                 })
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })

    //列表操作
    table.on('tool(userList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent == 'edit'){ //编辑
            addUser(data);
        }else if(layEvent == 'usable'){ //启用禁用
            console.log(data);
            var _this = $(this),
                usableText = "是否确定禁用此用户？",
                btnText = "已禁用";

            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？";
                btnText = "已启用";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                var status = 0;
                if(btnText=="已禁用"){
                    status = 1;
                }
                $.get("/sys/user/setUserStatus",{"status":status,"uid":data.id},function(){
                    if(btnText=="已禁用"){
                        _this.removeClass("layui-btn-warm");
                        _this.addClass("layui-btn-danger");
                    }else{
                        _this.addClass("layui-btn-warm");
                        _this.removeClass("layui-btn-danger");
                    }
                    _this.text(btnText);
                });


                layer.close(index);
            },function(index){
                layer.close(index);
            });
        }else if(layEvent == 'del'){ //删除
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                $.get("/sys/user/delUser",{
                    uid : data.id  //将需要删除的newsId作为参数传入
                },function(data){
                    tableIns.reload();
                    layer.close(index);
                })
            });
        }
    });

});
