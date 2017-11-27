<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>收货地址管理</title>
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.get("getcounty", "type=1", function(data) {
			var p = JSON.parse(data);
			for (v in p) {
				$("#s_p").append("<option>" + p[v] + "</option>")
			}
		});
		$("#s_p").change(function() {
			var p = $("#s_p").val();
			if (p != "0") {
				$.get("getcounty","type=2&param=" + encodeURI(p), function(data)  {
					var c = JSON.parse(data);
					$("#s_c").html("");
					$("#s_c").append("<option value='0'>请选择市</option>");
					$("#s_x").html("");
					$("#s_x").append("<option value='0'>请选择县</option>");
					for (v in c) {
						$("#s_c").append("<option>" + c[v] + "</option>")
					}
				});
			}
		});
		$("#s_c").change(function() {
			var c = $("#s_c").val();
			if (c != "0") {
				$.get("getcounty", "type=3&param=" + encodeURI(c), function(data) {
					var x = JSON.parse(data);
					$("#s_x").html("");
					$("#s_x").append("<option value='0'>请选择县</option>");
					for (v in x) {
						$("#s_x").append("<option>" + x[v] + "</option>")
					}
				});
			}
		});
		$("#s_x").change(
				function() {
					$("#p_a").val(
							$("#s_p").val() + "省" + $("#s_c").val() + "市"
									+ $("#s_x").val() + "县");

				});
		$("#btn_add").click(
				function() {
					$.post("addaddress", "pred=" + encodeURI($("#p_a").val())
							+ "&detail=" + encodeURI($("#ta_d").val())
							+ "&name=" + encodeURI($("#tv_n").val())
							+ "&phone=" + encodeURI($("#tv_p").val()),
							function(data) {
								switch (data) {
								case "0"://成功
									location.href = "getaddress";
									break;
								case "1"://添加失败
									alert("添加地址失败");
									//location.href="getaddress";
									break;
								case "2"://没有登陆
									alert("亲,请您登陆");
									location.href = "login.jsp";
									break;
								}

							});

				});
	});
</script>
</head>
<body>
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>
	<div id="main">
		<table width="100%" style="background: #FCFDEF;" border="1"
			bordercolor="#2583C5">
			<tr>
				<th>序号</th>
				<th>地址</th>
				<th>收货人</th>
				<th>手机号</th>
			</tr>
			<c:forEach items="${list }" var="address">
				<tr>
					<td align="center">${address.id }</td>
					<td align="center">${address.detail }</td>
					<td align="center">${address.name }</td>
					<td align="center">${address.phone }</td>
				</tr>
			</c:forEach>
		</table>
		<table width="100%" border="1" bordercolor="#CC0000">
			<tr>
				<td width="90%">收件人：<input type="text" id="tv_n" /> 手机号：<input
					type="text" id="tv_p" />
				</td>
			</tr>
			<tr>
				<td>选择地址： <select id="s_p">
						<option value="0">请选择省份</option>
				</select> <select id="s_c">
						<option value="0">请选择市</option>
				</select> <select id="s_x">
						<option value="0">请选择县</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>详细地址：<textarea rows="4" cols="30" id="ta_d"></textarea></td>
			</tr>
			<tr>
				<td align="right"><input type="button" value="添加地址"
					id="btn_add" /></td>
			</tr>
		</table>
		<input type="hidden" name="prefixa" id="p_a" />
	</div>
	<!--网站版权部分开始-->
	<div id="footer">
		<%@ include file="footer.html"%>
	</div>
</body>
</html>