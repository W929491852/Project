<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<link rel="csssheet" href="../css/drp.css" />
		<script src="../js/client_validate.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>分销商区域添加</title>
		<script type="text/javascript">
			function addRegion() {
				if (trim(document.getElementById("name").value).length == 0) {
					alert("区域名称不能为空！");
					document.getElementById("name").focus();
					return;
				}
				with(document.forms[0]) {
					action="client_node_add.jsp";
					method="post";
					submit();
				}
				
			}
			
			function goBack() {
				location = "client_node_crud.jsp?id=pid";
			}
		</script>
	</head>

	<body class="body1">
		<form>
		<input type="hidden" name="command" value="ADD">
		<input type="hidden" name="id" value="pid">
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				height="8">
				<tr>
					<td width="522" class="p1" height="2" nowrap="nowrap">
						<img src="../images/mark_arrow_03.gif" width="14" height="14" />
						&nbsp;
						<b>分销商管理&gt;&gt;添加区域</b>
					</td>
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
					<td width="410">
						<label>
							<input name="name" type="text" class="text1" id="name" />
						</label>
					</td>
				</tr>
			</table>
			<p></p>
			<label>
				<br />
			</label>
			<hr />
			<p align="center">
				<input name="btnAdd" class="button1" type="button" value="添加" onClick="addRegion()"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input name="btnBack" class="button1" type="button" value="返回"
					onclick="goBack()" />
			</p>
		</form>
	</body>
</html>
