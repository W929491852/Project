<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/DatePicker.js"></script>
<style type="text/css">
.tv_time{
width:80px;
}
.btn_1{
border:1px solid red;
}
</style>
</head>
<body>
	<br>
		<table cellSpacing="1" width="100%" align="center" bgColor="#f5fafe" >
				<tr>
				
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>查询条件</strong></td>
				</tr>
				<tr>
					<td>
					<form action="${pageContext.request.contextPath}/getorderwhere">
						<table width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" class="ta_01">
									订单时间区间：</td>
								<td class="ta_01" bgColor="#ffffff">
									<input type="text" name="stime" onclick="setday(this)" class="bg" style="width:80px" />-
									<input type="text" name="etime" onclick="setday(this)" class="bg" style="width:80px" />
								</td>
								<td align="right" bgColor="#ffffff" colspan="2" class="ta_01">
									<input type="submit"
										value="查询" class="btn_1"/>
										 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									type="reset" value="重置" class="btn_1"/></td>
							</tr>
						</table>
						</form>
					</td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3"><strong>订单列表</strong></td>
				</tr>
				<tr>
					<td class="ta_01" align="right"></td>
				</tr>
				<tr>
					<td class="ta_01" align="center" bgColor="#f5fafe">
						<table  cellpadding="1" rules="all" bordercolor="gray" 
							style="border:1px solid gray; width: 100%; word-break: break-all;border-collapse: collapse; background: #f5fafe; word-wrap: break-word">
							<tr style="font-weight: bold; font-size: 12pt; height: 25px; background: #afd1f3">
								<td align="center" width="20%">订单编号</td>
								<td align="center" width="20%">订单时间</td>
								<td width="11%" align="center">总价</td>
								<td width="10%" align="center">订单状态</td>
								<td width="7%" align="center">修改</td>
							</tr>
							<c:forEach items="${orders }" var="order">
							<tr onmouseover="this.style.backgroundColor = '#FCC1CC'"
								onmouseout="this.style.backgroundColor = 'white'">
								<td style="cursor: hand; height: 22px" align="center"
									width="20%">${order.id}</td>
								<td style="cursor: hand; height: 22px" align="center"
									width="10%">${order.time }</td>
								<td style="cursor: hand; height: 22px" align="center">
									${order.money }元</td>
								<td width="10%" align="center">${order.status}</td>
								<td align="center" style="height: 22px">
										<a href="${pageContext.request.contextPath}/updateorder?id=${order.id}">发货</a>
								</td>
							</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
		</table>
</body>
</HTML>

