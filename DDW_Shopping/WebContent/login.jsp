<%@page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>当当网登录页面</title>
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript">
	$(function() {
		$('#verifycode').click(function() {
			$("#verifycode").attr('src', 'CreateCodeServlet?' + Math.random());
		});

		$('#autoLogin').click(function() {
			if (this.checked)
				$('#autoLoginHint').html('公用电脑上请勿勾选此项').css('color', 'red');
			else
				$('#autoLoginHint').html('');
		});
		$("#vcode").change(function() {
			$.get("checkcode", "code=" + this.value, function(data) {
				if (data == 0) {//验证码成功
					$("#c_m").css("color", "green");
					$("#c_m").html("OK");
					$("#btn").removeAttr("disabled");
				} else {
					$("#btn").attr("disabled", true);
					$("#c_m").css("color", "red");
					$("#c_m").html("验证码不正确")
					$("#verifycode").attr('src', 'code?' + Math.random());
				}
			});

		});
	});
</script>
</head>
<body>
	<div id="header">
		<div class="login_header_left">
			<img src="images/logo.gif" alt="logo">
		</div>
		<div class="login_header_mid">
			<img src="images/login_header.gif" alt="header">
		</div>
		<div class="login_header_right">
			<a href="index.jsp" class="blue">首页</a> | <a
				href="getgoods?page=1&count=12" class="blue">商品展示页</a> | <a
				href="getcart" class="blue">购物车</a> | <a href="register.jsp"
				class="blue">注册</a>
		</div>
	</div>

	<div id="main2">
		<div class="login_main_left">
			<div>
				<img src="images/login_main_01.jpg" alt="中间图片"> <img
					src="images/login_main_02.jpg" alt="中间图片"> <img
					src="images/login_main_03.jpg" alt="中间图片">
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
			<div class="login_content_top">请登录当当网</div>
			<div class="login_content_line"></div>
			<form action="login" method="post">
				<dl class="login_content">
					<dt></dt>
					<dd style="color: red;" id="d_msg">${hint}</dd>
				</dl>
				<dl class="login_content">
					<dt>用户名：</dt>
					<dd>
						<input id="username" name="email" type="text"
							class="login_content_input" value="" />
					</dd>
				</dl>
				<dl class="login_content">
					<dt>密码：</dt>
					<dd>
						<input id="pwd" name="password" type="password"
							class="login_content_input" />
					</dd>
				</dl>
				<!--下面是验证码啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊  -->
				<dl class="login_content">
					<dt>验证码：</dt>
					<dd>
						<input id="vcode" type="text" class="login_content_input"  name="code1"/><label
							id="c_m"></label>
					</dd>
				</dl>
				<dl class="login_content">
					<dt></dt>
					<dd>
						<img id="verifycode" alt="验证码" name="ccode" src="CreateCodeServlet"/>
					</dd>
				</dl>
				<dl class="login_content">
					<dt>
						<input type="checkbox" name="auto" value="1" id="autoLogin" />
					</dt>
					<dd>两周以内自动登录</dd>
				</dl>
				<dl class="login_content">
					<dt></dt>
					<dd>
						<span id="autoLoginHint"></span>
					</dd>
				</dl>
				<dl class="login_content">
					<dt></dt>
					<dd>
						<input disabled id="btn" value=" " type="submit"
							class="login_btn_out"
							onmouseover="this.className='login_btn_over'"
							onmouseout="this.className='login_btn_out'" />
					</dd>
				</dl>
			</form>
			<div class="login_content_end_bg">
				<div class="login_content_end_bg_top">
					<label class="login_content_bold">还不是当当网用户？</label>快捷方便的免费注册，让你立刻尽享当当网提供的条项优惠服务......
				</div>
				<div class="login_content_end_bg_end">
					<input class="login_register_out" value=" " type="button"
						onmouseover="this.className='login_register_over'"
						onmouseout="this.className='login_register_out'" onClick="jump()" />
				</div>
			</div>
		</div>
		<div class="login_main_right">
			<img src="images/login_main_04.jpg" alt="右侧图片" />
		</div>
	</div>
	<!--网站版权部分开始-->
	<div id="footer">
		<%@ include file="footer.html"%>
	</div>
</body>
</html>
