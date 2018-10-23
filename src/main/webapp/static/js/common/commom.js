/**
 * 时间戳转换成字符串
 * @param timestamp  13位时间戳
 * @param format 日期格式 默认yyyy-MM-dd HH:mm:ss
 * @returns
 */
function timestampToTime(timestamp,format) {
    var date = new Date(timestamp * 1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    yyyy = date.getFullYear();//年
    yy = date.getYear(); //获取当前年份(2位)
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1);//月
    D = (date.getDate() < 10 ? '0'+(date.getDate()) : date.getDate());//日
    h = (date.getHours() < 10 ? '0'+(date.getHours()) : date.getHours());//时
    m = (date.getMinutes() < 10 ? '0'+(date.getMinutes()) : date.getMinutes());//分
    s = (date.getSeconds() < 10 ? '0'+(date.getSeconds()) : date.getSeconds());//秒
    //若为空默认"yyyy-MM-dd HH:mm:ss"
    if(isNull(format)==""){
    	format = "yyyy-MM-dd HH:mm:ss";
    }
    format = format.replace("yyyy",yyyy);//替换年
    format = format.replace("yy",yy);//替换年
    format = format.replace("MM",M);//替换月
    format = format.replace("dd",D);//替换日
    format = format.replace("HH",h);//替换时
    format = format.replace("mm",m);//替换分
    format = format.replace("ss",s);//替换秒
    return format;
}
/**
 * 日期转换成时间戳
 * @returns
 */
function timeTotimestamp(time){
	var date = new Date(time);
    // 有三种方式获取
    var time = date.getTime();
    return time;
}
/**
 * 
 * @param format 日期格式 默认yyyy-MM-dd HH:mm:ss
 * @returns
 */
function GetDate(format){
	timestampToTime(new Date().getTime(),format)
}
/**
 * 获取时间戳
 * @returns
 */
function GetTimestamp(){
	var date = new Date();
	return date.getTime();
}
/**
 * 判断是否为空
 * @param data
 * @returns
 */
function isNull(data){ 
	var gettype=Object.prototype.toString;
	if(gettype.call(data)=="[object Object]"){
		return (isEmptyObject(data)) ? "" : data;
	}	
	return (data == "" || data == undefined ||data == 'undefined'|| data == null) ? "" : data; 
}