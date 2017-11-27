<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请选择分销商</title>
<link rel="stylesheet" href="../css/drp.css">
<script src="../js/client_validate.js"></script>
<script type="text/javascript">
	function selectOk() {
		var flag = false;
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			if (document.getElementsByName("selectFlag")[i].checked) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			alert("请选择需要的分销商！");
			return;
		} 
	 	parentWindowElement = window.opener.document
				.getElementById("clientId4");
		parentWindowElement.value = document.getElementsByName("selectFlag")[i].value;
		window.close();   
	}

	function topPage() {
		window.self.location = "client_select.jsp?pageNo=2";
	}

	function previousPage() {
		window.self.location = "client_select.jsp?pageNo=1";
	}

	function nextPage() {
		window.self.location = "client_select.jsp?pageNo=3";
	}

	function bottomPage() {
		window.self.location = "client_select.jsp?pageNo=4";
	}

	function queryClient() {
		with (document.getElementById("clientForm")) {
			method = "post";
			action = "client_select.jsp";
			submit();
		}
	}

	function doubleclick(clientInnerId, clientId, clientName) {

		//判断对象是否定义
		if (window.opener.document.getElementById("clientInnerId") != undefined) {
			window.opener.document.getElementById("clientInnerId").value = clientInnerId;
		}
		window.opener.document.getElementById("clientId").value = clientId;
		window.opener.document.getElementById("clientName").value = clientName;
		window.close();
	}
</script>
</head>

<body class="body1">
	<form name="clientForm">
		<div align="center">
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				height="34">
				<tr>
					<td width="522" class="p1" height="34" nowrap><img
						src="../images/search.gif" width="32" height="32">&nbsp;<b>请选择分销商</b></td>
				</tr>
			</table>
			<hr width="100%" align="center" size=0>
			<table width="95%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="17%" height="29">
						<div align="left">分销商代码/名称:</div>
					</td>
					<td width="57%"><input name="clientIdOrName" type="text"
						class="text1" id="clientIdOrName" value="" size="50"
						maxlength="50"></td>
					<td width="26%">
						<div align="left">
							<input name="btnQuery" type="button" class="button1"
								id="btnQuery" value="查询" onClick="queryClient()">
						</div>
					</td>
				</tr>
				<tr>
					<td height="16">
						<div align="right"></div>
					</td>
					<td>&nbsp;</td>
					<td><div align="right"></div></td>
				</tr>
			</table>

		</div>
	</form>
	<table width="95%" border="0" cellspacing="0" cellpadding="0"
		class="rd1" align="center">
		<tr>
			<td nowrap height="10" class="p2">分销商信息</td>
			<td nowrap height="10" class="p3">&nbsp;</td>
		</tr>
	</table>
	<table width="95%" border="1" cellspacing="0" cellpadding="0"
		align="center" class="table1">
		<tr>
			<td class="rd6">选择</td>
			<td class="rd6">分销商代码</td>
			<td class="rd6">分销商名称</td>
			<td class="rd6">分销商类型</td>
		</tr>
		<c:forEach items="${clients }" var="item">
			<tr>
				<td class="rd8"><input type="radio" name="selectFlag"
					value="${item.clientid }" onDblClick="doubleclick()"></td>
				<td class="rd8">${item.clientid }</td>
				<td class="rd8">${item.clientname }</td>
				<td class="rd8">${item.dataDict.name }</td>
			</tr>
		</c:forEach>
	</table>
	<table width="95%" height="30" border="0" align="center"
		cellpadding="0" cellspacing="0" class="rd1">
		<tr>
			<td nowrap class="rd19" height="2" width="36%">
				<div align="left">
					<font color="#FFFFFF">&nbsp;共&nbsp&nbsp页</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#FFFFFF">当前第</font>&nbsp<font color="#FF0000"></font>&nbsp<font
						color="#FFFFFF">页</font>
				</div>
			</td>
			<td nowrap class="rd19" width="64%">
				<div align="right">
					<input name="btnTopPage" class="button1" type="button"
						id="btnTopPage" value="|&lt;&lt; " title="首页" onClick="topPage()">
					<input name="btnPreviousPage" class="button1" type="button"
						id="btnPreviousPage" value=" &lt;  " title="上页"
						onClick="previousPage()"> <input name="btnNext"
						class="button1" type="button" id="btnNext" value="  &gt; "
						title="下页" onClick="nextPage()"> <input
						name="btnBottomPage" class="button1" type="button"
						id="btnBottomPage" value=" &gt;&gt;|" title="尾页"
						onClick="bottomPage()"> <input name="btnOk"
						class="button1" type="button" id="btnOk" value="确定"
						onClick="selectOk()"> <input name="btnClose"
						class="button1" type="button" id="btnClose" value="关闭"
						onClick="window.close()">
				</div>
			</td>
		</tr>
	</table>
</body>
</html>