<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户</title>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	loadUser();
});

function loadUser(){
	$.ajax({
		url:"${pageContext.request.contextPath}/getuserall",
		method:"get",
		success:function(data){
			showMsg(data);
		},
		error:function(xpp, ts, et){
			alert("失败"+xpp.status+":"+ts+":"+et);
		}
	});
}
//显示用户信息
function showMsg(data){
	
	var list=JSON.parse(data);
	 $("#tb_list").html("");
	 $("#tb_list").html("<tr class='tr_head'><th>编号</th><th>邮箱</th><th>名称</th><th>性别</th><th>类别</th><th>操作</th></tr>");
	 
	 for(var u in list){
		 $("#tb_list").append("<tr onmouseover='overColor(this)' onmouseout='outColor(this)'");
		 $("#tb_list").append("<td>"+list[u].id+"</td>");
		 $("#tb_list").append("<td>"+list[u].email+"</td>");
		 $("#tb_list").append("<td>"+list[u].username+"</td>");
		 $("#tb_list").append("<td>"+list[u].gender+"</td>");
		 $("#tb_list").append("<td>"+(list[u].role==0?"管理员":"会员")+"</td>");
		 $("#tb_list").append("<td><a href='javascript:delUser("+list[u].id+")'>删除</a></td>");
		 $("#tb_list").append("</tr>");
	}
}
function delUser(id){
	if(confirm("确定也要删除该用户吗？")){
		$.ajax({
			url:"${pageContext.request.contextPath}/deleteuser?id="+id,
			method:"get",
			success:function(data){
				loadUser();
			},
			error:function(xpp, ts, et){
				alert("失败"+xpp.status+":"+ts+":"+et);
			}
		}); 
	}
}

function outColor(obj) {
	obj.setAttribute("style","backgroundColor:white");
}
function overColor(obj) {
	obj.setAttribute("style","backgroundColor:#FCC1CC");
}
</script>
<style type="text/css">
#tb_list td{
text-align:center;
}
.tr_head{
font-size:20px;
background:#AFD1F3;
}
.btn_1{
border:1px solid red;
width:50px;
}
</style>
</head>
<body>
<form>
	<table width="100%">
		<tr>
			
			<td align="right" bgColor="#ffffff" colspan="2" class="ta_01"><input
				type="button" value="刷新" class="btn_1" onclick="loadUser()"/></td>
		</tr>
		
	</table>
</form>
	<table id="tb_list" cellspacing="0" cellpadding="10px" bordercolor="gray"  border="1" style="width:100%;">
	<tr class="tr_head">
	<th>编号</th>
	<th>邮箱</th>
	<th>名称</th>
	<th>性别</th>
	<th>类别</th>
	<th>激活状态</th>
	<th>操作</th>
	</tr>												
</table>
<p id="p1"></p>
</body>
</html>