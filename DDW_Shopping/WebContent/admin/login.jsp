<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>欢迎光临本后台</title>

<link href="${pageContext.request.contextPath}/css/global.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function() {
	$('#verifycode').click(function() {
		$("#verifycode").attr('src', '${pageContext.request.contextPath}/CreateCodeServlet?' + Math.random());
	});
	$("#vcode").change(function() {
			$.get("${pageContext.request.contextPath}/checkcode", "code=" + this.value, function(data) {
				if (data == 0) {//验证码成功
					$("#c_m").css("color", "green");
					$("#c_m").html("OK");
					$("#btn").removeAttr("disabled");
				} else {
					$("#c_m").css("color", "red");
					$("#c_m").html("验证码不正确")
					$("#btn").attr("disabled", true);
					$("#verifycode").attr('src', '${pageContext.request.contextPath}/code?' + Math.random());
				}
			});
	});
});
</script>
</head>
<body>
	<div id="header">
		<div class="login_header_left">
			<img src="${pageContext.request.contextPath}/images/logo.gif" alt="logo">
		</div>
		<div class="login_header_mid">
			<img src="${pageContext.request.contextPath}/images/login_header.gif" alt="header">
		</div>
	</div>
	<div id="main2">
		<div class="login_main_left">
			<div>
				<img src="${pageContext.request.contextPath}/images/login_main_01.jpg" alt="中间图片"> <img
					src="${pageContext.request.contextPath}/images/login_main_02.jpg" alt="中间图片"> <img
					src="${pageContext.request.contextPath}/images/login_main_03.jpg" alt="中间图片">
			</div>
			<div class="login_main_end">
				<dl class="login_green">
					<dt>更多选择、更低价格</dt>
					<dd>100万种商品包含图书、数码、美妆、运动健康等，价格低于地面店20%以上</dd>
				</dl>

				<div class="login_main_dotted"></div>
				<dl class="login_green">
					<dt>全场免运费、货到付款</dt>
					<dd>免费送货上门、360个城市货到付款。另有网上支付、邮局汇款等多种支付方式</dd>
				</dl>

				<div class="login_main_dotted"></div>
				<dl class="login_green">
					<dt>真实、优质的商品评论</dt>
					<dd>千万用户真实、优质的商品评论，给您多角度、全方位的购物参考</dd>
				</dl>
			</div>
		</div>
		<div class="login_main_mid">
			<div class="login_content_top">请登录后台</div>
			<form action="${pageContext.request.contextPath}/loginadmin" method="post">
				<dl class="login_content">
					<dt></dt>
					<dd style="color:red;" id="d_msg"></dd>
				</dl>
				<dl class="login_content">
					<dt>用户名：</dt>
					<dd>
						<input id="username" name="name" type="text"
							class="login_content_input" value="" />
					</dd>
				</dl>
				<dl class="login_content">
					<dt>密码：</dt>
					<dd>
						<input id="pwd" name="psw" type="password"
							class="login_content_input" />
					</dd>
				</dl>
				<dl class="login_content">
					<dt>验证码：</dt>
					<dd>
						<input id="vcode" name="vcode" type="text" class="login_content_input" /> 
						<label id="c_m"></label>
					</dd>
				</dl>
				<dl>
				<dt></dt>
				<dd>
				<img id="verifycode" src="${pageContext.request.contextPath}/CreateCodeServlet" alt="验证码" />
				</dd>
				</dl>
				<dl class="login_content">
					<dt></dt>
					<dd>
						<input id="btn" disabled value="登录" type="submit" class="login_btn_out" />
					</dd>
				</dl>
			</form>
		</div>
		<div class="login_main_right">
			<img src="${pageContext.request.contextPath}/images/login_main_04.jpg" alt="右侧图片" />
		</div>
	</div>
</body>
</html>