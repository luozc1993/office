/** EasyWeb iframe v3.1.2 date:2019-06-02 License By http://easyweb.vip */

// 以下代码是配置layui扩展模块的目录，每个页面都需要引入
layui.config({
    version: true,
    base: getProjectUrl() + 'assets/module/'
}).extend({
    formSelects: 'formSelects/formSelects-v4',
    treetable: 'treetable-lay/treetable',
    dropdown: 'dropdown/dropdown',
    notice: 'notice/notice',
    step: 'step-lay/step',
    dtree: 'dtree/dtree',
    citypicker: 'city-picker/city-picker',
    tableSelect: 'tableSelect/tableSelect',
    cropper: 'cropper/cropper',
    zTree: 'zTree/zTree'
}).use(['layer', 'admin'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var admin = layui.admin;

    // 移除loading动画
    setTimeout(function () {
        admin.removeLoading();
    }, window == top ? 600 : 100);
	//设置ajax所有错误回调方法
	$.ajaxSettings.error = function(res){
		if(res.status==403){
			window.location.href = "/login.html"
		}
	};
	
	
	token = admin.getTempData("token");
	if(!admin.getTempData("token")&&window.location.href.replace(getProjectUrl(),"")!="login.html"){
		top.window.location.href = getProjectUrl()+"login.html"
	}else if(admin.getTempData("token")&&window.location.href.replace(getProjectUrl(),"")=="login.html"){
		top.window.location.href = getProjectUrl()+"index.html"
	}
});
/////////////////////////////////////////////////////////////
////////////////////////全局变量开始/////////////////////////////
/////////////////////////////////////////////////////////////
var serverUrl = "http://127.0.0.1:20000";
var token = "";
/////////////////////////////////////////////////////////////
////////////////////////全局变量结束/////////////////////////////
/////////////////////////////////////////////////////////////
/**
 * 
 * ajax请求
 * @param {Object} url
 * @param {Object} data
 * @param {Object} type
 * @param {Object} success
 */
function sysAjax(url,data,type,success){
	layer.load(2);
	var $ = layui.jquery;
	data['token'] = token;
	if(!(url.indexOf("http://")>-1||url.indexOf("https://")>-1)){
		url = serverUrl + url;
	}
	$.ajax({
		url:url,
		data:data,
		dataType:'json',//服务器返回json格式数据
		type:type,
		success:success,
		complete:function(){
			layer.closeAll('loading');
		}
	});
}


// 获取当前项目的根路径，通过获取layui.js全路径截取assets之前的地址
function getProjectUrl() {
    var layuiDir = layui.cache.dir;
    if (!layuiDir) {
        var js = document.scripts, last = js.length - 1, src;
        for (var i = last; i > 0; i--) {
            if (js[i].readyState === 'interactive') {
                src = js[i].src;
                break;
            }
        }
        var jsPath = src || js[last].src;
        layuiDir = jsPath.substring(0, jsPath.lastIndexOf('/') + 1);
    }
    return layuiDir.substring(0, layuiDir.indexOf('assets'));
}

/**
 * 替换字符串中 [key] 数据
 * 
 * @param {Object} html	待替换的内容
 * @param {Object} data	替换的数据{‘key’:value}
 */
function testHtmlReplaceContent(html,data){
	var reg = new RegExp("\\[([^\\[\\]]*?)\\]", 'igm'); //i g m是指分别用于指定区分大小写的匹配、全局匹配和多行匹配。
    return html.replace(reg, function (node, key) { return data[key]; });
}