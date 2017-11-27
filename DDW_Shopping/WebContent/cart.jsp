<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>当当网购物车</title>
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<style type="text/css">
.btn_1 {
	width: 20%;
	background: #DBDBDB;
}

td {
	text-align: center;
}

.show_tb {
	width: 100%;
	border: 1px solid red;
	background: #FCFDEF;
	font-size: 20px;
}
</style>

<script type="text/javascript">
	var url = "updatecartnum";
	//加
	//参数说明：1、商品id,2、单价,3、标签序号
	function addP(pid, p, no) {
		var curr = parseInt($("#tv_count" + no).val());

		$.ajax({
			url : "updatecartnum?type=1&pid=" + pid + "&num=" + (curr + 1)
					+ "&price=" + p,
			method : "get",
			success : function(data) {
				if (data == 0) {//修改数量成功
					alert("亲，服务器繁忙，稍后再来");
				} else if (data > 0) {
					$("#tv_count" + no).val(data);
					$("#td_pic" + no).html(
							addPoint(parseFloat(data) * Number(p) / 100.0)
									+ "元");
					$("#ft_sum").html(
							addPoint(parseFloat($("#ft_sum").html())
									+ Number(p) / 100.0));
				} else {
					location.href = "login.jsp";
				}
			},
			error : function() {
				alert("服务器异常");
			}
		});
		//}
	}
	//减或者删除
	function deleteP(pid, p, no) {
		var type = 2;
		var num = parseInt($("#tv_count" + no).val());
		if (num <= 1) {
			if (confirm("你确认要删除吗")) {
				num = 0;
				type = 3;
			} else {
				return;
			}
		} else {
			num--;
		}
		$.ajax({
			url : "updatecartnum?type=" + type + "&pid=" + pid + "&num=" + num
					+ "&price=" + p,
			method : "get",
			success : function(data) {
				if (data == 0) {//修改失败
					//location.href="getcart";
					alert("亲，服务器繁忙，稍后再来");
				} else if (data > 0) {//修该成功,返回当前的商品数量
					if (type == 2) {
						$("#tv_count" + no).val(data);
						$("#td_pic" + no).html(
								addPoint(parseFloat(data) * Number(p) / 100.0)
										+ "元");
						$("#ft_sum").html(
								addPoint(parseFloat($("#ft_sum").html())
										- Number(p) / 100.0));
					} else {//删除
						location.href = "getcart";
					}
				} else {
					location.href = "login.jsp";
				}
			},
			error : function() {
				alert("服务器异常");
			}
		});

	}
	function addPoint(obj) {
		return obj + ".0";
		/* var s=obj+"";
		if(s.lastindexof(".")==-1){
			
		} */
	}
	//清空购物车
	function clearCart() {
		if (confirm("你确认要清空购物车吗")) {
			location.href = "clearcart";
		}
	}
</script>
</head>
<body class="main">
	<div id="header">
		<jsp:include page="header.jsp" />
		<h1>${lname }</h1>
	</div>
	<div id="main">
		<table width="100%" border="0">
			<tr>
				<td>
					<div
						style="text-align: right; margin: 5px 10px 5px 0px; background: #FCFDEF">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;购物车
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<table class="show_tb" width="100%" border="0" cellspacing="0">
						<tr>
							<th width="10%">序号</th>
							<th width="30%">名称</th>
							<th width="10%">价格</th>
							<th width="20%">数量</th>
							<th width="10%">小计</th>
						</tr>
						<tr>
							<td colspan="5"><hr style="border: 1px solid blue" /></td>
						</tr>
						<c:set value="0" var="sum"></c:set>
						<c:forEach items="${carts }" var="ci" varStatus="vs">
							<tr>
								<td>${vs.count}</td>
								<td width="30%">${ci.pname }</td>
								<td width="10%">${ci.price/100.0 }元</td>
								<td width="20%"><input type="button" value='-'
									class="btn_1"
									onclick="deleteP('${ci.pid}','${ci.price}','${vs.count}')" />
									<input type="text" id="tv_count${vs.count }" value="${ci.num}"
									style="width: 40%; text-align: center" disabled /> <input
									type="button" value='+' class="btn_1"
									onclick="addP('${ci.pid}','${ci.price}','${vs.count}')" /></td>
								<td width="10%" id="td_pic${vs.count }">${ci.money/100.0}元</td>

							</tr>
							<c:set var="sum" value="${sum+ci.money }"></c:set>
						</c:forEach>
						<tr style="background: #E1FFE1">
							<td colspan="3" style="text-align: left; padding-left: 20px"><a
								href="javascript:clearCart();">清空购物车</a></td>
							<td colspan="2" align="right"><font
								style="color: #FF6600; font-weight: bold; margin-right: -60px">合计：&nbsp;&nbsp;<font
									id="ft_sum">${sum/100.0 }</font>元
							</font></td>
						</tr>
						<tr>
							<td colspan="5" align="right">
								<div style="text-align: right; margin-top: 10px">
									<a href="getorderview"><img
										src="images/shopping_balance.gif" /></a>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<!--网站版权部分开始-->
	<div id="footer">
		<%@ include file="footer.html"%>
	</div>
</body>
</html>
