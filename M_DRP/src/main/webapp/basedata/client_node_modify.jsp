<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet" href="../css/drp.css" />
<script src="../js/client_validate.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>分销商区域修改</title>
<script type="text/javascript">
	function modifyRegion() {
		if (trim(document.getElementById("name").value).length == 0) {
			alert("区域名称不能为空！");
			document.getElementById("name").focus();
			return;
		}
		with(document.forms[0]) {
			action="client_node_modify.jsp";
			method="post";
			submit();
		}
	}
	
	function goBack() {
		window.self.location = "client_node_crud.jsp?id=1";
	}
</script>
</head>

<body class="body1">
	<form>
		<input type="hidden" name="command" value="MODIFY"> <input
			type="hidden" name="id" value="">
		<table width="95%" border="0" cellspacing="0" cellpadding="0"
			height="8">
			<tr>
				<td width="522" class="p1" height="2" nowrap="nowrap"><img
					src="../images/mark_arrow_03.gif" width="14" height="14" /> &nbsp;
					<b>分销商管理&gt;&gt;修改区域</b></td>
			</tr>
		</table>
		<hr width="97%" align="center" size="0" />
		<p></p>
		<p></p>
		<table width="95%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="213">
					<div align="right">
						<font color="#FF0000">*</font>区域名称：
					</div>
				</td>
				<td width="410"><label> <input name="name" type="text"
						class="text1" id="name" value="" />
				</label></td>
			</tr>
		</table>
		<label> <br/>
		</label>
		<hr />
		<p align="center">
			<input name="btnModify" class="button1" type="button" id="btnModify"
				value="修改" onClick="modifyRegion()" /> &nbsp;&nbsp;&nbsp;&nbsp; <input
				name="btnModify" class="button1" type="button" id="btnModify"
				value="返回" onClick="goBack()" />
		</p>
	</form>
</body>
</html>
