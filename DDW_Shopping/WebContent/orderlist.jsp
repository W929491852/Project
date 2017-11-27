<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>订单列表</title>
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.tr_h td {
	background: #C7EDCC;
}
a{
	color:red;
}
</style>
</head>
<body class="main">
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>
	<div id="main">
		<table width="100%" >
			<tr>

				<td style="padding: 20px">
					<p>
						${user.username }&nbsp;&nbsp;有<font style="color: #FF0000">${orders.size() }</font>个订单
					</p>
					<table width="100%" border="1" bordercolor="#CC0000" >
						<tr class="tr_h" style="color:#2587C6;font-weight:bold;">
							<td class="tableopentd01">序号</td>
							<td class="tableopentd01">订单时间</td>
							<td class="tableopentd01">地址</td>
							<td class="tableopentd01">金额</td>
							<td class="tableopentd01">状态</td>
							<td class="tableopentd01">操作</td>
						</tr>


						<c:forEach items="${orders }" var="order" varStatus="vs">
							<tr onmouseover="this.style.backgroundColor = '#AFB7FF'"
								onmouseout="this.style.backgroundColor = 'white'">
								<td class="tableopentd02">${vs.count}</td>
								<td class="tableopentd02">${order.aid }</td>
								<td class="tableopentd02">${order.time }</td>
								<td class="tableopentd02">${order.money }</td>
								<td class="tableopentd02">${order.status}</td>
								<td class="tableopentd03">
								<a href="orderdetail?id=${order.id}">查看详细</a>&nbsp;&nbsp;
								</td>
							</tr>
						</c:forEach>
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
