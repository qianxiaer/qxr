/**
 * 登录
 */
$(function(){
	layui.use('layer',function(){
		var layer = layui.layer;
	});
});

var data = {
	username : "admin",
	password : "123456"
}

var form = new Vue({
	el : '#form',
	data : data,
	methods:{
		login: function(){
			if(!this.username){
				layer.msg("请输入用户名");
				return false;
			}
			if(!this.password){
				layer.msg("请输入密码")
				return false;
			}
			if(this.username && this.password){
				login();
			}
		}
	}
});
function login(){
	layer.msg(JSON.stringify(data),function(){
		window.location = "manage/index.html?username="+data.username;
	});
}