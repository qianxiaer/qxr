/**
 * 后台首页
 */
window.onload = function init(){
	var data = getUrlParam();
	findMenu(data);
}
/**
 * 获取当前登录人员菜单
 * */
function findMenu(data){
	
}
/**
 * 菜单
 * */
layui.use('element', function() {
	var element = layui.element;
	var $ = layui.jquery;
	// 触发事件
	element.on('nav(menu)', function(elem) {
		var title = elem.context.innerText;
		var url = $(elem.context.outerHTML).attr("_href");
		var tid = $(elem.context.outerHTML).attr("id");
		var iframeList = $(".a-iframe");
		for (var i = 0; i < iframeList.length; i++) {
			if($(iframeList[i]).attr("src") == url){
				element.tabChange('main', i);
				return;
			}
		}
		if (url != "") {
			element.tabAdd('main', {
				title : title ,
				content : '<iframe frameborder="0" src="' + url + '" class="a-iframe"></iframe>',
				id : tid
			});
			element.tabChange('main', tid);
		}
	});
});
