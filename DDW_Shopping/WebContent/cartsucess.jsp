<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/layout.css" type="text/css" />
<title>添加购物车成功</title>
<style type="text/css">
a{
	font-size:20px;
}


</style>
</head>
<body>
	<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>
					</div>
	<div style="border:1px solid red; width:100%;height:100%; background:#A7C0DC;text-align:center">
	<p>添加购物车成功</p>
	<a href="getcart">查看购物车</a><br/>
	<a href="getgoods?page=1&count=12">继续购物</a><br/>
	</div>
	<!--网站版权部分开始-->
	<div id="footer">
		<%@ include file="footer.html"%>
	</div>
</body>
</html>