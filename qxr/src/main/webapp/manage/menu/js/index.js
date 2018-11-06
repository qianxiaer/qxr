/**
 * 菜单管理
 */

layui.use(['table','layer'], function(){
	var table = layui.table;
	var layer = layui.layer;
	
	table.render({
		elem: '#info'
		,url:'page'
		,toolbar:'true'
		,where:{mgr:0}
		,cols: [[
			{type:'checkbox'}
			,{field:'id', title: 'ID'}
			,{field:'name', title: '菜单名称'}
			,{field:'mgrname', title: '父级菜单'}
			,{field:'url', title: '菜单URL'}
			,{field:'createtime', title: '创建时间'}
			,{field:'username', title: '操作人员'}
			,{fixed:'right', title: '操作', toolbar:'#operation', minWidth: 180}
		]]
		,page: {
			limit:100,
			limits:[100,200,500,999]
		}
	});
	table.on('tool(info)', function(obj){
	    if(obj.event == "info"){
	    	layer.msg("info")
	    }else if(obj.event == "edit"){
	    	update(obj);
	    }else if(obj.event == "del"){
	    	obj.del();
	    }else if(obj.event == "ins"){
	    	layer.msg("insert")
	    }
	});
	
});
function update(obj){
	var data = obj.data;
	layer.open({
		type: 2
		,content: 'update.html?id='+data.id
		,area:['500px','400px']
	})
}