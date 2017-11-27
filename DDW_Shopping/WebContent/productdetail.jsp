<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>当当网商品展示页面</title>
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	$(function() {
		$('#btnOK').on('click', function() {
			var page = $('#txtPage').val();
			location.href = 'getgoods?page=' + page + '&count=12' ;
		});
	});

</script>
</head>

<body>
	<!-- 隐式表单域 / 隐藏域 -->
	<div id="header">
		<%@ include file="header.jsp"%>
	</div>
	<!--中间部分开始-->
	<div id="main">
		<div class="dd_index_top_adver">
			<img src="images/dd_index_top_adver.jpg" alt="通栏广告图片" />
		</div>
		<div class="current_place">
			您现在的位置：<a href="index.jsp">当当图书</a> &gt;&gt; 小说 &gt;&gt; 财经
		</div>
		<!--左侧菜单开始-->
		
		<div id="product_left">
			<div id="product_catList">
				<div class="product_catList_top">浏览同级分类</div>
				<div id="product_catList_class">
					<!--使用javaScript显示图书分类-->
				</div>
			</div>
			<div class="product_catList_end">
				<img src="images/product_01.gif" alt="shopping"> <img
					src="images/product_02.gif" alt="shopping">
			</div>
		</div>
		<!--右侧内容开始-->
		<div id="product_storyList">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td width="30%">
						<div class="divgoodscover">
							<p>
							<!--  -->
								<img src="../upload/${goods.picture}" alt="暂无图片" width="213" height="269"
									border="0" />
							</p>
						</div>
						<div style="text-align: center; margin-top: 25px">
							<a href="addcart?id=${goods.id}&price=${goods.price}">
								<img src="images/product_buy_01.gif" border="0" />
							</a>
						</div>
					</td>
					<td style="padding: 20px 5px 5px 5px">
						书名：<font color="red">${goods.name }</font>
						<hr />售价：<font color="red">${goods.price }</font>
						<hr />类别：${goods.typeid }
						<hr />评分：${goods.star }
						<hr />上架时间：${goods.pubdate }
						<hr />
						<p>
							<b>内容简介：</b>
						</p>${goods.intro}</td>
				</tr>
			</table>
		</div>
		<!--右侧内容结束-->
		<script src="js/product.js" type="text/javascript"></script>
	</div>
	<!--网站版权部分开始-->
	<div id="footer">
		<%@ include file="footer.html"%>
	</div>
</body>
</html>
