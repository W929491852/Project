<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/drp.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>终端客户维护</title>
</head>
<script type="text/javascript">
	function addTemi() {
		window.self.location = "addTemi?flag=1";
	}

	function modifyTemi() {
		var selectFlags = document.getElementsByName("selectFlag");
		//计数器
		var count = 0;
		//记录选中的checkbox索引号
		var index = 0;
		for (var i = 0; i < selectFlags.length; i++) {
			if (selectFlags[i].checked) {
				//记录选中的checkbox
				count++;
				index = i;
			}
		}
		if (count == 0) {
			alert("请选择需要修改的数据！");
			return;
		}
		if (count > 1) {
			alert("一次只能修改一个终端客户！");
			return;
		}
		//alert(selectFlags[index].value);

		window.self.location = "updateTemi?flag=1&temiid="
				+ selectFlags[index].value;
	}

	function deleteTemi() {
		var selectFlags = document.getElementsByName("selectFlag");
		var flag = false;
		var ids = "";
		for (var i = 0; i < selectFlags.length; i++) {
			if (selectFlags[i].checked) {
				//已经有选中的checkbox
				flag = true;
				ids += selectFlags[i].value + ",";
			}
		}
		if (!flag) {
			alert("请选择需要删除的数据！");
			return;
		}
		//删除提示
		if (window.confirm("确认删除？")) {

			location.href = "deleteTemi?ids=" + ids;
			/* with(document.getElementById("userform")) {
				action="user_maint.jsp";
				method="post";
				submit();
			} */
		}
	}

	function checkAll() {
		var selectFlags = document.getElementsByName("selectFlag");
		for (var i = 0; i < selectFlags.length; i++) {
			selectFlags[i].checked = document.getElementById("ifAll").checked;
		}
	}

	function topPage() {
		window.location = "user_maint.jsp?pageNo="
	}

	function previousPage() {
		window.location = "user_maint.jsp?pageNo=getPreviousPageNo()%>"
	}

	function nextPage() {
		window.location = "user_maint.jsp?pageNo=getNextPageNo()%>"
	}

	function bottomPage() {
		window.location = "user_maint.jsp?pageNo=getButtomPageNo()%>";
	}
</script>
</head>

<body class="body1">
	<div align="center">
		<table width="95%" border="0" cellspacing="0" cellpadding="0"
			height="35">
			<tr>
				<td class="p1" height="18" nowrap>&nbsp;</td>
			</tr>
			<tr>
				<td width="522" class="p1" height="17" nowrap><img
					src="../images/mark_arrow_02.gif" width="14" height="14">
					&nbsp; <b>系统管理&gt;&gt;终端客户管理</b></td>
			</tr>
		</table>
		<hr width="100%" align="center" size=0>
	</div>
	<table width="95%" height="20" border="0" align="center"
		cellspacing="0" class="rd1" id="toolbar">
		<tr>
			<td width="49%" class="rd19"><font color="#FFFFFF">查询列表</font></td>
			<td width="27%" nowrap class="rd16">
				<div align="right"></div>
			</td>
		</tr>
	</table>
	<table width="95%" border="1" cellspacing="0" cellpadding="0"
		align="center" class="table1">
		<tr>
			<td width="55" class="rd6">选择</td>
			<td width="119" class="rd6">终端客户名称</td>
			<td width="152" class="rd6">终端客户类型</td>
			<td width="166" class="rd6">终端客户联系人</td>
			<td width="150" class="rd6">终端客户联系电话</td>
			<td width="153" class="rd6">终端客户地址</td>
			<td width="153" class="rd6">终端客户邮编</td>
		</tr>
		<c:forEach items="${temis }" var="item">
			<tr>
				<td class="rd8"><input type="checkbox" name="selectFlag"
					class="checkbox1" value="${item.temiid }"></td>
				<td class="rd8">${item.teminame}</td>
				<td class="rd8">${item.dataDict.name }</td>
				<td class="rd8">${item.contactor }</td>
				<td class="rd8">${item.contacttel }</td>
				<td class="rd8">${item.address }</td>
				<td class="rd8">${item.zipcode }</td>
				
			</tr>
		</c:forEach>
	</table>
	<table width="95%" height="30" border="0" align="center" class="rd1">
		<tr>
			<td nowrap class="rd19">
				<div align="right">
					<input class="button1" type="button" id="btnTopPage"
						value="|&lt;&lt; " title="首页" onClick="topPage()"> <input
						class="button1" type="button" id="btnPreviousPage" value=" &lt;"
						title="上页" onClick="previousPage()"> <input
						class="button1" type="button" id="btnNextPage" value="  &gt; "
						title="下页" onClick="nextPage()"> <input class="button1"
						type="button" id="btnBottomPage" value=" &gt;&gt;|" title="尾页"
						onClick="bottomPage()"> <input type="button"
						class="button1" id="btnAdd" value="添加" onClick="addTemi()">
					<input class="button1" type="button" id="btnDelete" value="删除"
						onClick="deleteTemi()"> <input class="button1"
						type="button" id="btnModify" value="修改" onClick="modifyTemi()">
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
