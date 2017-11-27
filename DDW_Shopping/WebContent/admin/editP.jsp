<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
/* $(function() {
	getType();
});
function getType() {
	$.get("${pageContext.request.contextPath}/getgoodstype",null,function(data){
		var t=JSON.parse(data);
		for(i in t){
			$("#typeid").append("<option values='"+t[i].id+"'>"+t[i].name+"</option>");
		}
	});
} */
</script>
<style type="text/css">
.a-upload {
	padding: 4px 10px;
	height: 20px;
	line-height: 20px;
	position: relative;
	cursor: pointer;
	color: #888;
	background: #fafafa;
	border: 1px solid #ddd;
	border-radius: 4px;
	overflow: hidden;
	display: inline-block;
	*display: inline;
	*zoom: 1
}

.a-upload  input {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
	filter: alpha(opacity = 0.4);
	cursor: pointer
}

.a-upload:hover {
	color: #444;
	background: #eee;
	border-color: #ccc;
	text-decoration: none
}
</style>
</head>
<body>
	<form action="${pageContext.request.contextPath }/updategoods"
		method="post">
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td align="center" bgColor="#afd1f3" colSpan="4" height="26"><strong><StrONG>编辑商品</StrONG>
				</strong></td>
			</tr>
			<tr>
				<td colSpan="4"><input type="hidden" value="${goods.id }"
					name="id"></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">商品名称：</td>
				<td bgColor="#ffffff"><input type="text" name="name" class="bg"
					value="${goods.name }" /></td>
				<td align="center" bgColor="#f5fafe">商品价格：</td>
				<td bgColor="#ffffff"><input type="text" name="price"
					class="bg" value="${goods.price }" /></td>
			</tr>
			<tr>

				<td align="center" bgColor="#f5fafe">商品类别：</td>
				<td bgColor="#ffffff"><input type="hidden" id="g_type"
					value="${goods.typeid }" /> <select name="typeid" id="typeid">
						<option value="">--选择商品类加--</option>
						<c:forEach items="${types }" var="t">
						
						<option value="${t.id }" ${goods.typeid==t.id?'selected':'' }>${t.name }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">商品图片：</td>
				<td bgColor="#ffffff"><a href="javascript:;" class="a-upload">选择图书的封面<input
						type="file" name="img_url" size="30" /></a></td>
				<td align="center" bgColor="#f5fafe">商品评分：</td>
				<td bgColor="#ffffff"><input name="gstra" value="${goods.star}" /></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe">商品描述：</td>
				<td bgColor="#ffffff" colSpan="3"><textarea name="description"
						cols="30" rows="3" style="width: 96%">${goods.intro }</textarea></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" colSpan="4"><input
					type="submit" class="button_ok" value="确定"> <input
					type="reset" value="重置" class="button_cancel"
					style="margin-left: 20px" /></td>
			</tr>
		</table>
	</form>
</body>
</HTML>