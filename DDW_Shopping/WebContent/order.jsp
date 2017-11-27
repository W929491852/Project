<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//item">
<html>
<head>
<title>当当网订单预览</title>
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btn_add").click(function(){
		document.getElementById("f1").submit();
	}); 
	
});
</script>
<style type="text/css">
input[type="submit"] {
	font-size: 20px;
	border: 1px solid red;
}
#p_h{
border: 2px solid red;
background:#E4F3FF;
}
#tb_m{
background:#FCFDEF;

}
#tr_sh{
background:#C7EDCC;
}
</style>
</head>
<body>
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>
	<div id="main">
		<form action="orderadd" id="f1" method="post">
			<table id="tb_m" width="100%" border="0" cellspacing="0">
				<tr>
					<td><p id="p_h">您好：<font color="red">${user.username }</font>，欢迎来到结算中心</p></td>
				</tr>
				<tr>
					<td><table  width="100%" cellspacing="1" class="carttable">
							<tr>
								<td width="10%">序号</td>
								<td width="30%">商品名称</td>
								<td width="10%">价格</td>
								<td width="10%">数量</td>
								<td width="10%">小计</td>
							</tr>
						</table> 
					</td>
				</tr>
				<tr><td>
						<c:set var="he" value="0"></c:set> 
						<c:forEach
							items="${list }" var="item" varStatus="vs">
							<table width="100%" border="0" cellspacing="0">
								<tr>
									<td width="10%">${vs.count }</td>
									<td width="30%">${item.pname }</td>
									<td width="10%">${item.price/100.0 }元</td>
									<td width="10%">
									${item.num }
										</td>
									<td width="10%">${item.money/100.0 }元</td>
									<c:set var="sum" value="${sum+item.money}"></c:set>
								</tr>
							</table>
							
						</c:forEach>
					</td>
				</tr>
				<tr id="tr_sh"><td>收货地址：
				<select id="sl" name="aid" style="width:80%" >
					<c:forEach items="${as }" var="a" varStatus="vs">
						<option value="${a.id}">${a.detail }</option>
					</c:forEach>
					</select>
					<c:if test="${as==null }">
						<a href="address.jsp">添加收货地址</a>
					</c:if>
					</td></tr>
				<tr>
					<td style="text-align: right; padding-right: 40px;">
					<font
									style="color: #FF0000">合计：&nbsp;&nbsp;${sum/100.0 }元</font> 
									<input type="hidden" name="money" value="${sum }" />
									
					</td>				
				</tr>	
				<tr>
				<td style="text-align: right; padding-right: 20px;">
				
				<img src="images/shopping_balance.gif"  id="btn_add"/>
				</td>
				</tr>
			</table>
		</form>
	</div>
	<!--网站版权部分开始-->
	<div id="footer">
		<%@ include file="footer.html"%>
	</div>
</body>
</html>
