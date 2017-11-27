// JSON数据
var jsonData = [ {
	"text" : "用户管理",
	"id" : "r1",
	"icon" : "../images/user.PNG",
	"children" : [ {
		"id" : "r1_1",
		"text" : "会员管理",
		"data":"listu.jsp"
	}]
},{
	"text" : "订单管理",
	"id" : "r2",
	"icon" : "../images/or.GIF",
	"children" : [ {
		"id" : "r2_1",
		"text" : "查看订单",
		"data":"orderlist.jsp"
	}]
}, {
	"text" : "商品管理",
	"id" : "r3",
	"icon" : "../images/p.GIF",
	"children" : [ {
		"id" : "r3_1",
		"text" : "新增商品",
		"data":"addP.jsp"
	}, {
		"id" : "r3_2",
		"text" : "查看商品",
		"data":"listP.jsp"
	} ]
} ];
//创建菜单
function createLeft(id) {
	$('#'+id).jstree({
		"core" : {
			'data' : jsonData,
			"check_callback" : true
		},
		"plugins" : [ "wholerow", "contextmenu" ]
	}).bind("activate_node.jstree", function(obj, e) {
		// 处理代码
		// 获取当前节点
		var cn = e.node;
		if (cn.id.length > 2) {
			$(".dv_content").attr("src",cn.data);
		}
	});
}
