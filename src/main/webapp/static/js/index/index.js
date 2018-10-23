function getMenuGroups(){
    $.ajax({
        url:"/sys/menu/getMenuGroups.json",
        success:function(res){
            console.log(res);
            if(res.status){
                var datas = res.data;
                var active = "layui-this";
                for (var i=0;i<datas.length;i++){
                    var data = datas[i];

                    if(i!=0&&active.length!=0){
                        active = "";
                    }
                    //图标
                    var icon = data["icon"];
                    //判断图标是否已icon开头
                    var fdStart = icon.indexOf("icon");
                    if(fdStart == 0){
                        $("#menuGroupsPC")
                            .append('<li class="layui-nav-item '+active+'" data-menu="'+data["id"]+'">\n' +
                                '<a href="javascript:;">' +
                                    '<i class="seraph iconfont '+icon+'" data-icon="'+icon+'"></i><cite>'+data["title"]+'</cite>' +
                                '</a>\n' +
                                '</li>');
                        $("#menuGroupsMobile")
                            .append('<dd class="'+active+'" data-menu="'+data["id"]+'">' +
                                        '<a href="javascript:;"><i class="seraph iconfont '+icon+'"  data-icon="'+icon+'"></i><cite>'+data["title"]+'</cite></a>' +
                                    '</dd>');
                    }else{
                        $("#menuGroupsPC")
                            .append('<li class="layui-nav-item '+active+'" data-menu="'+data["id"]+'">\n' +
                                '<a href="javascript:;">' +
                                    '<i class="layui-icon" data-icon="'+icon+'">'+icon+'</i><cite>'+data["title"]+'</cite>' +
                                '</a>\n' +
                                '</li>');
                        $("#menuGroupsMobile")
                            .append('<dd class="'+active+'" data-menu="'+data["id"]+'">' +
                                        '<a href="javascript:;"><i class="layui-icon " data-icon="'+icon+'">'+icon+'</i><cite>'+data["title"]+'</cite></a>' +
                                    '</dd>');
                    }

                }
            }
        }
    })
}