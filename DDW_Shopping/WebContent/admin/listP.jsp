<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
var page=1,count=15;
	function addProduct() {
		window.location.href = "${pageContext.request.contextPath}/admin/addP.jsp";
	}
     //询问用户是否真的要删除某本书
     function DelBook(name,id)
     {
     	if(confirm("你真的要删除"+name+"?")){
     		window.location="${pageContext.request.contextPath}/DeleteProductServlet?id="+id;
     	}
     }
   //查询商品列表
 	function searchGoods() {
 		//发起Ajax请求，获取分页数据
 		window.location="${pageContext.request.contextPath}/getgoodsadmin?p=" + page + "&c=" +
 				count+"&id="+$("#id").val()+"&typeid="+$("#typeid").val()+"&name="+$("#name").val()
 				+"&maxprice="+$("#maxprice").val()+"&minprice="+$("#minprice").val();
 		
 	}
   //分页函数
 	function changePage(type){
 		var tp=parseInt($("#lbt").html());
 		page=parseInt($("#lbc").html());
 		switch (type) {
 		case 1://首页
 			if(page>1){
 				page=1;
 				searchGoods();
 			}else{
 				alert("亲，已经在首页了");
 			}
 			break;
 		case 2://上一页
 			if(page>1){
 				page--;
 				searchGoods();
 			}else{
 				alert("亲，已经在首页了");
 			}
 			break;
 		case 3://下一页
 			if(page<tp){
 				page++;
 				searchGoods();
 			}else{
 				alert("亲，已经在末页了");
 			}
 			break;
 		case 4://末页
 			if(page<tp){
 				page=tp;
 				searchGoods();
 			}else{
 				alert("亲，已经在末页了");
 			}
 			break;
 		}
 	}
</script>
<style type="text/css">
body{
width:100%;
}
.btn{
margin-left:20px;
text-align:center;
border:1px solid #AFD1F3;

}
[type="button"] {
	border: 1px solid red;
	padding: 5px;
	margin-left: 20px;
}
</style>
</head>
<body >
	<br>
		<table cellSpacing="1" width="100%" align="center"
			bgColor="#f5fafe" >
				<tr>
					<td  align="center" bgColor="#afd1f3"><strong>查询条件</strong>
					</td>
				</tr>
				<tr>
					<td width="100%">
					<form action="${pageContext.request.contextPath}/getgoodsadmin?p=1&c=15" method="post">
						<table cellpadding="0" cellspacing="0" border="0" width="100%">
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" >
									商品编号</td>
								<td  bgColor="#ffffff"><input type="text"
									name="id" size="15" value="${param.id }" id="id" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" >
									类别：</td>
								<td  bgColor="#ffffff"><select name="typeid"
									id="typeid">
										<option value="" selected="selected">--选择商品类型--</option>	
										<c:forEach items="${types }" var="t">
										<c:if test="${!empty(param.typeid)}">
											<option value="${t.id }" ${param.typeid==(t.id+"")?"selected='selected'":"" }>${t.name }</option>
										</c:if>
										<c:if test="${empty(param.typeid)}">
											<option value="${t.id }" >${t.name }</option>
										</c:if>
										</c:forEach>	
								</select>
								</td>
							</tr>
							<tr>
								<td height="22" align="center" bgColor="#f5fafe" >
									商品名称：</td>
								<td  bgColor="#ffffff"><input type="text"
									name="name" size="15" value="${param.name }" id="name" class="bg" />
								</td>
								<td height="22" align="center" bgColor="#f5fafe" >
									价格区间(元)：</td>
								<td  bgColor="#ffffff"><input type="text"
									name="minprice" id="minprice"  value="${param.minprice }"  size="10" />- <input type="text"
									name="maxprice" id="maxprice"  value="${param.maxprice }" size="10" /></td>
							</tr>
							<tr>
								<td width="100" height="22" align="center" bgColor="#f5fafe"
									></td>
								<td  bgColor="#ffffff">
								</td>
								<td align="right" bgColor="#ffffff" ><br>
									<br></td>
								<td align="right" bgColor="#ffffff" >
									<input type="submit" value="查询" class="btn"/> 
									<input type="reset" name="reset" value="重置" class="btn"/>
								</td>
							</tr>
						</table>
					</form>
					</td>
				</tr>
				<tr>
					<td  align="center" bgColor="#afd1f3"><strong>商品列表</strong>
					</td>
				</tr>
				<tr>
				    <td  align="right">
						<input type="button" value="添加" class="btn" onclick="addProduct()"/>
					</td>
				</tr>
				<tr>
					<td  align="center" bgColor="#f5fafe">
					<table cellspacing="0" cellpadding="1" rules="all"
							bordercolor="gray" border="1" id="DataGrid1"
							style="border:1px solid gray ; width: 100%; word-break: break-all;border-collapse: collapse; background-color: #f5fafe; word-wrap: break-word">
							<tr
								style="font-weight: bold; font-size: 12pt; height: 25px; background-color: #afd1f3">
								
								<td align="center" width="24%">商品编号</td>
								<td align="center" width="18%">商品名称</td>
								<td align="center" width="9%">商品价格</td>
								<td align="center" width="9%">商品评分</td>
								<td width="8%" align="center">商品类别</td>
								<td width="8%" align="center">编辑</td>
								<td width="8%" align="center">删除</td>
							</tr>

							<c:forEach items="${pb.list }" var="shu">
								<tr onmouseover="this.style.backgroundColor = 'white'"
									onmouseout="this.style.backgroundColor = '#F5FAFE';">
									<td style="cursor: hand; height: 22px" align="center"
										width="23">${shu.id }</td>
									<td style="cursor: hand; height: 22px" align="center"
										width="18%">${shu.name }</td>
									<td style="cursor: hand; height: 22px" align="center"
										width="8%">${shu.price/100.0 }元</td>
									<td style="cursor: hand; height: 22px" align="center"
										width="8%">${shu.star }</td>
									<td style="cursor: hand; height: 22px" align="center">${shu.typeName }</td>
									<td align="center" style="height: 22px" width="7%">
									<a
										href="getgoodsbyid?id=${shu.id}">查看详情 </a>
									</td>
									<td align="center" style="height: 22px" width="7%"><a
										href="javascript:DelBook('${shu.name }','${shu.id }')">删除</a>
									</td>
								</tr>
						   </c:forEach>
						</table>
					</td>
				</tr>
		</table>
		<c:if test="${!empty(pb) }">
		<table cellSpacing="1" width="100%" align="center" bgColor="#f5fafe"
		style="margin-top: 20px">
		<tr>
			<td align="center"><input type="button" value="首页" onclick="changePage(1)"  class="btnpage">
				<input type="button" value="上一页" class="btnpage"  onclick="changePage(2)"> <span
				style="margin-left: 20px">当前<label id="lbc">${pb.currPage }</label>/共<label id="lbt">${pb.totalPage }</label>页
			</span> <input type="button" value="下一页"  onclick="changePage(3)"  class="btnpage"> <input
				type="button" value="末页"  class="btnpage"  onclick="changePage(4)"></td>
		</tr>
	</table>
	</c:if>
</body>
</html>

