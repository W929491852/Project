<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="refresh" content="5; url='index.jsp'">
<title>当当网注册成功激活</title>
<link rel="stylesheet" href="css/layout.css" type="text/css" />

<script type="text/javascript" src="js/my.js">
	
</script>
</head>

<body class="main">
	<div id="header">
		<div id="register_header">
			<div class="register_header_left">
				<img src="images/logo.gif" alt="logo">
			</div>
			<div class="register_header_right">
				<a href="index.jsp" class="blue">首页</a> | <a href="showbook"
					class="blue">商品展示页</a> | <a href="cart.jsp" class="blue">购物车</a> |
				<a href="login.jsp" class="blue">登录</a>
			</div>
		</div>
	</div>
	<div id="divcontent">
		<table width="850px" border="0" cellspacing="0">
			<tr>
				<td style="padding: 30px; text-align: center"><table
						width="60%" border="0" cellspacing="0" style="margin-top: 70px">
						<tr>
							<td style="width: 98"><img
								src="images/IconTexto_WebDev_009.jpg" width="128" height="128" />
							</td>
							<td style="padding-top: 30px"><font
								style="font-weight: bold; color: #FF0000">注册成功,别忘记激活帐户啊<a
									href="http://www.hao123.com/mail">现在激活</a></font><br /> <br /> <a
								href="sendEmail">没有收到验证码，重新发送</a></td>
						</tr>
					</table>
					<h1>&nbsp;</h1></td>
			</tr>
		</table>
	</div>
	<!--网站版权部分开始-->
	<div id="footer">
		<%@ include file="footer.html"%>
	</div>
</body>
</html>
