<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生选课注册页面</title>
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/register.js"></script>
</head>

<body>
<div id="header">
  <div id="register_header">
    <div class="register_header_left">
   	 <img src="images/logo.gif" alt="logo">
   	</div>
    <div class="register_header_right">
   	 <a href="index.jsp" class="blue">首页</a> | 
   	 <a href="showbook" class="blue">商品展示页</a>  | 
   	 <a href="cart.jsp" class="blue">购物车</a> |  
   	 <a href="login.jsp" class="blue">登录</a>
    </div>
  </div>
</div>
<div id="main">
  <div class="register_content">
    <div class="register_top_bg"></div> 
    <div class="register_mid_bg">
      <ul>
        <li class="register_mid_left">填写注册信息</li>
        <li class="register_mid_mid">2. 邮箱验证</li>
        <li class="register_mid_right">3. 完成注册</li>
    </ul>
    </div>
    <div class="register_top_bg_mid">
    <div class="register_top_bg_two_left"></div>
    <div class="register_top_bg_two_right"></div>
    <div class="register_title_bg"><img src="images/register_pic_02.gif" alt="欢迎注册"><br>您所提供的资料不会做其他用途，敬请安心填写。</div>
    </div>
    <div class="register_dotted_bg"></div>
    <div class="register_message">
    <form action="register" method="post" id="myform" onSubmit="return checkRegister()">
      <dl class="register_row">
      	<dt>&nbsp;</dt>
      	<dd style="color:red;">${hint}</dd>
      </dl>
      <dl class="register_row">
        <dt>邮箱：</dt>
        <dd><input id="email" name="email" type="email" class="register_input" onFocus="emailFocus()" onBlur="emailBlur()"></dd>
        <dd><div id="email_prompt"></div></dd>
      </dl>
      <dl class="register_row">
         <dt>昵称：</dt>
         <dd><input id="username" name="username" type="text" class="register_input"></dd>
         <dd><div id="userName_prompt"></div></dd>
      </dl>
      
     <dl class="register_row">
         <dt>设定密码：</dt>
         <dd><input id="pwd" type="password" name="password" class="register_input" onFocus="pwdFocus()" onBlur="pwdBlur()"></dd>
         <dd><div id="pwd_prompt"></div></dd>
     </dl> 
     <dl class="register_row"> 
         <dt>再输入一次密码：</dt>
         <dd><input id="repwd" type="password" class="register_input" onFocus="repwdFocus()" onBlur="repwdBlur()"></dd>
        <dd><div id="repwd_prompt"></div></dd>
     </dl>
     <dl class="register_row">
        <dt>性别：</dt>
        <dd><input name="sex" id="man" type="radio" value="男" checked>男</dd>
       	<dd><input name="sex" id="woman" type="radio" value="女">女</dd>
     </dl>
     
      <div class="registerBtn"><input id="registerBtn" type="image" src="images/register_btn_out.gif" onMouseOver="btn_over()" onMouseOut="btn_out()"></div>
   </form>
    </div>
    
    
  </div>
  </div>
<!--网站版权部分开始-->
	<div id="footer">
		<%@ include file="footer.html"%>
	</div>
</body>
</html>
