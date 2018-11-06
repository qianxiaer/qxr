/**
 * 公共方法
 */
function getUrlParam(){
	var data = {};
	var url = window.location.href;
	var content = url.substr(url.indexOf("?")+1,url.length);
	var arr = content.split("&");
	for(i in arr){
		var m = arr[i].split("=")
		data[m[0]] = m[1];
	}
	return data;
}