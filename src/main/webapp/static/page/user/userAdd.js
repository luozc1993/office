layui.use(['form','layer'],function(){
    var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery;

    form.on("submit(addUser)",function(data){
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        // 实际使用时的提交信息
        $.post("/sys/user/addUser",{
            id : data.field.userId,  //登录名
            userName : $(".userName").val(),  //登录名
            telPhone : $(".telePhone").val(),  //手机号
            userSex : data.field.sex,  //性别
            userStatus : data.field.userStatus,    //用户状态
            userDesc : $(".userDesc").val()    //用户简介
        },function(res){
            if(res.status){
                setTimeout(function(){
                    top.layer.close(index);
                    top.layer.msg("用户添加成功！");
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                },2000);
            }else{
                setTimeout(function(){
                    top.layer.close(index);
                    top.layer.msg(res.msg);
                    layer.closeAll("iframe");
                },2000);
            }
        });

        return false;
    });

    $(".cleanPage").click(function(){
        var index=parent.layer.getFrameIndex(window.name);//获取当前弹出层的层级
        parent.layer.close(index);//关闭弹出层
    });

    //格式化时间
    function filterTime(val){
        if(val < 10){
            return "0" + val;
        }else{
            return val;
        }
    }
    //定时发布
    var time = new Date();
    var submitTime = time.getFullYear()+'-'+filterTime(time.getMonth()+1)+'-'+filterTime(time.getDate())+' '+filterTime(time.getHours())+':'+filterTime(time.getMinutes())+':'+filterTime(time.getSeconds());

})