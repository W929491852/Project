<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当当网后台主页</title>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/jstree.min.js"></script>
<script type="text/javascript" src="../js/createMenu.js"></script>
<link href="../css/style.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	$(function() {
		createLeft("dv_menu");
	});
</script>
<style type="text/css">
html, body {
	margin: 0px;
	height: 100%;
	overflow-y: hidden;
}

#dv_menu {
	position: fixed;
	left: 5px;
	top: 8%;
	width: 18%;
	height: 100%;
	float: left;
	background: #F1F9F1;
}

.dv_content {
	width: 82%;
	height: 100%;
	float: right;
	background: #F2F2F2;
}

.dv_head {
	height: 8%;
	width: 100%;
	text-align: center;
	float: left;
	background: url("../images/admin.GIF");
	background-repeat: no-repeat;
	background-color: #ECECEC;
}
.jstree-node{
margin:10px;
}
</style>
</head>
<body>
<%-- 	<c:if test="${user==null }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if> 
 --%>	<div class="dv_head"></div>
	<!--菜单靠左  -->
	<div id="dv_menu"></div>
	<!--正文内容  -->
	<iframe class="dv_content"></iframe>
	
</body>
</html>