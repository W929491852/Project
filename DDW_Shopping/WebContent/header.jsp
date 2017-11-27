<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>当当网站导航部分</title>
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/template.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.suggest {
		border: 1px solid black;
		background-color: #DEFB49;
		position:relative;
		top:0; 
		left:15px;
		width:200px;
	}
</style>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	
	$(function() {
		$("#btnSearch").click(function() {
			var name = $('#header_search').val();
			location.href = 'getgoods?name=' + encodeURI(name);
		});
		
		$("#header_search").keyup (function() {
			var name = this.value;
			if(name.length > 0) {
				$.get("getgoodsname","name="+encodeURI(name),function(data){
					if(data.length>0){
						var d=JSON.parse(data);
						var tempDiv = $('#suggestion');
						var li = $('#mySpecArea');
						if(tempDiv) {
							tempDiv.remove();
						}
						var myDiv = document.createElement("div");
				    	myDiv.setAttribute('id', 'suggestion');
				    	for(var i = 0; i < d.length; i++) {
				    		var temp = document.createElement("div");
				    		temp.innerHTML = d[i];
				    		temp.onclick = function() {
				    			$('#header_search').val(this.innerHTML);
				    			myDiv.remove();
				    		};
				    		myDiv.append(temp);
				    	}
				    	myDiv.className = "suggest";
				    	li.append(myDiv);
					}
				});	
			}
		});
	});
	
</script>
</head>

<body>
<!--顶部开始-->
<div class="header_top">
   <div class="header_top_left">欢迎光临当当网 
   <c:if test="${empty(user)}">
   <a href="login.jsp" target="_parent" style="color:red; margin-right:20px" >亲，请登录</a> |
   <a href="register.jsp" style="color:blue;" target="_parent">免费注册</a>
   </c:if> 
   <c:if test="${not empty(user)}">
   <a href="#">欢迎：${user.username}</a>&nbsp;<a href="loginout" style="color:blue;">注销</a>
   </c:if>
   </div>
   <div class="header_top_right">
   <ul>
   	  <c:if test="${not empty(user.username)}">
      <li><a href="#" target="_self">帮助</a></li>
      </c:if>
      <li>|</li>
      <li onmouseover="myddang_show('dd_menu_top_down')" 
      onmouseout="myddang_hidden('dd_menu_top_down')">
      <a href="#" target="_self">我的当当</a> 
      <img src="images/dd_arrow_down.gif" alt="arrow" />
      <div id="dd_menu_top_down">
        <a href="#" target="_self">我的订单</a><br />
           <a href="#" target="_self">账户余额</a><br />
          <a href="#" target="_self">购物礼券</a><br />
           <a href="#" target="_self">我的会员积分</a><br />
       </div>
       </li>
      <li>|</li>
      <li><a href="getaddress" target="_self">收货地址</a></li>
      <li>|</li>
      <li><a href="getorder" target="_self">我的订单</a></li>
      <li>|</li>
      <li><a href="getcart" target="_parent">购物车</a></li>
      <li><img src="images/dd_header_shop.gif" alt="shopping"/></li>
   </ul>
   </div>
</div>
<!--导航开始-->
<div class="header_middle">
<div class="logo">
<img src="images/dd_logo.gif" alt="logo"/></div>
<div class="menu_left">
  <dl>
   <dd class="menu_left_first"></dd>
   </dl>
   <ul id="menu_left_bold">
   <li><a href="index.jsp" target="_parent" class="bold">首页</a></li>
   <li>|</li>
   <li><a href="getgoods?page=1&count=10" target="_parent" class="bold">图书</a></li>
   <li>|</li>
   <li><a href="#" target="_self" class="bold">音乐</a></li>
   <li>|</li>
   <li><a href="#" target="_self" class="bold">影视</a></li>
   <li>|</li>
   <li><a href="#" target="_self" class="bold">运动</a></li>
   <li>|</li>
   <li><a href="#" target="_self" class="bold">服饰</a></li>
   <li>|</li>
   <li><a href="#" target="_self" class="bold">家居</a></li>
   <li>|</li>
   <li><a href="#" target="_self" class="bold">美妆</a></li>
   <li>|</li>
   <li><a href="#" target="_self" class="bold">母婴</a></li>
   <li>|</li>
   <li><a href="#" target="_self" class="bold">食品</a></li>
   <li>|</li>
   <li><a href="#" target="_self" class="bold">数码家电</a></li>
   </ul>
   <dl>
   <dd class="menu_left_end"></dd>
 </dl>
</div>
<div class="menu_right" id="menu_dull_red">
 <ul>
   <li class="menu_right_1"><a href="#" target="_self">商店街</a></li>
   <li class="menu_right_2"><a href="#" target="_self">促销</a></li>
   <li class="menu_right_3"><a href="#" target="_self">当当
   <img src="images/dd_header_top.png" alt="榜" /></a>
   </li>
   <li class="menu_right_2"><a href="#" target="_self">社区</a></li>
   <li class="menu_right_3"><a href="#" target="_self">在线读书</a></li>
 </ul>
</div>
<div class="menu">
<div class="menu_first"></div>
<div id="menu_white">
     <a href="#" target="_self" class="menu_mid_white">小说</a>|
     <a href="#" target="_self" class="menu_mid_white">青春</a>|
     <a href="#" target="_self" class="menu_mid_white">历史</a>|
     <a href="#" target="_self" class="menu_mid_white">保健</a>|
     <a href="#" target="_self" class="menu_mid_white">少儿</a>|
     <a href="#" target="_self" class="menu_mid_white">旅游</a>|
     <a href="#" target="_self" class="menu_mid_white">期刊</a>|
     <a href="#" target="_self" class="menu_mid_white">图书畅销榜</a>|
     <a href="#" target="_self" class="menu_mid_white">新书热卖榜</a>|
     <a href="#" target="_self" class="menu_mid_white">特价书</a>|
     <a href="#" target="_self" class="menu_mid_white">图书促销</a>|
     <a href="#" target="_self" class="menu_mid_white">所有图书分类</a>
     </div>
	 
<div class="menu_end"></div>
</div>
</div>
<!--搜索开始-->
<div class="header_search">
 <div class="header_serach_left"></div>
 <div class="header_serach_mid">
 <ul id="header_serach_mid_menu">
   <li id="mySpecArea">
   <input id="header_search" type="text" class="header_input_search" /></li>
   <li><input type="button" value="图书搜索" id="btnSearch" /></li>
   <li><img src="images/dd_arrow_right.gif" alt="arrow"/>
   <a href="#" target="_self">高级搜索</a></li>
   <li>|</li>
   <li><img src="images/dd_header_search_top.jpg" alt="搜索风云榜"/></li>
   <li><a href="#" target="_self">雅思</a></li>
   <li>|</li>
   <li><a href="#" target="_self">建造师</a></li>
   <li>|</li>
   <li><a href="#" target="_self">中里巴人</a></li>
   <li>|</li>
   <li><a href="#" target="_self">注会</a></li>
   <li>|</li>
   <li><a href="#" target="_self">新概念英语</a></li>
   <li>|</li>
   <li><a href="#" target="_self">更多&gt;&gt;</a></li>
  </ul>
 </div>
 <div class="header_serach_right"></div>
</div>
</body>
</html>
