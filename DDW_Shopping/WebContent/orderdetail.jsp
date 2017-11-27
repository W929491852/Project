<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情</title>
</head>
<body>
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>
	<div id="main">
	<table cellSpacing="1" cellPadding="5" width="100%" align="center"
		bgColor="#eeeeee" style="border:1px solid #8ba7e3">
		<tr>
			<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
				height="26"><strong>订单详细信息</strong></td>
		</tr>
		<tr>
			<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
				订单编号：</td>
			<td class="ta_01" bgColor="#ffffff">${od.order.id}</td>
			<td align="center" bgColor="#f5fafe" class="ta_01">订单时间：</td>
			<td class="ta_01" bgColor="#ffffff" >${od.order.time}</td>
		</tr>

		<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">收件人：</td>
			<td class="ta_01" bgColor="#ffffff">${od.address.name }</td>
			<td align="center" bgColor="#f5fafe" class="ta_01">联系电话：</td>
			<td class="ta_01" bgColor="#ffffff">${od.address.phone }</td>
		</tr>
		<tr>
			<td align="center" bgColor="#f5fafe" class="ta_01">送货地址：</td>
			<td class="ta_01" bgColor="#ffffff">${od.address.detail}</td>
			<td align="center" bgColor="#f5fafe" class="ta_01">总价：</td>
			<td class="ta_01" bgColor="#ffffff">${od.order.money/100.0 }元</td>
		</tr>
	
		<tr>
			<td class="ta_01" align="center" bgColor="#f5fafe">商品列表</td>
			<td class="ta_01" bgColor="#ffffff" colSpan="3">
				<table cellspacing="0" cellpadding="1" rules="all"
					bordercolor="gray" border="1" id="DataGrid1"
					style="border:1px solid gray; width: 100%; word-break: break-all; border-collapse: collapse; background: #f5fafe; word-wrap: break-word">
					<tr
						style="font-weight: bold; font-size: 12pt; height: 25px; background: #afd1f3">
						<td align="center" width="7%">序号</td>
						<td width="8%" align="center">商品封面</td>
						<td align="center" width="10%">商品名称</td>
						<td align="center" width="10%">商品类型</td>
						<td width="7%" align="center">商品评分</td>
						<td align="center" width="10%">商品日期</td>
						<td align="center" width="10%">商品单价</td>
						<td width="7%" align="center">购买数量</td>
						<td width="7%" align="center">小计</td>
					</tr>
					<c:forEach items="${od.list}" var="item" varStatus="vs">
						<tr
							style="font-weight: bold; font-size: 12pt; height: 25px; background: #eeeeee">
							<td align="center" width="7%">${vs.count }</td>
							<td align="center"><img
								src="../upload/${item.goods.picture}"
								width="50" height="50"></td>
							<td align="center" >${item.goods.name }</td>
							<td align="center" >${item.goods.typeName }</td>
							<td align="center" >${item.goods.star }</td>
							<td align="center" >${item.goods.pubdate }</td>
							<td align="center" >${item.goods.price/100.0 }元</td>
							<td align="center">${item.num }</td>
							<td align="center">${item.money/100.0 }元</td>
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
</HTML>