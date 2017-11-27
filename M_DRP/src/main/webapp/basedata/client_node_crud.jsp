<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<link rel="stylesheet" href="../css/drp.css" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>分销商区域维护</title>
		<script type="text/javascript">

	function addRegion() {
		window.self.location = "client_node_add.jsp?id=id";	
	}
	
	function modifyRegion() {
		window.self.location = "client_node_modify.jsp?id=id";
	}
	
	function deleteRegion() {
		if (window.confirm("确认删除？")) {
			with(document.forms[0]) {
				action="client_node_crud.jsp";
				method="post";
				submit();				
			}
		}
	}
	function addClient() {
		window.self.location = "client_add.jsp?id=id";
	}
	
</script>
	</head>

	<body class="body1">
		<form id="clientForm" name="clientForm" method="post" action="">
			
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				height="8">
				<tr>
					<td width="522" class="p1" height="2" nowrap="nowrap">
						<img src="../images/mark_arrow_02.gif" width="14" height="14" />
						&nbsp;
						<b>基础数据管理&gt;&gt;分销商维护</b>
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
							当前区域名称：
						</div>
					</td>
					<td width="410">
						<label>
							<input name="name" type="text" class="text1" id="name"
								readonly="true" value="${sessionScope.user.client.address }"/>
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
				<input name="btnAddRegion" type="button" class="button1"
					id="btnAddRegion" onClick="addRegion()" value="添加区域" />
				&nbsp;
				<input name="btnDeleteRegion" type="button" class="button1"
					id="btnDeleteRegion" value="删除区域" onClick="deleteRegion()" />
				&nbsp;
				<input name="btnModifyRegion" type="button" class="button1"
					id="btnModifyRegion" onClick="modifyRegion()" value="修改区域" />
				&nbsp;
				<input name="btnAddClient" type="button" class="button1"
					id="btnAddClient" onClick="addClient()" value="添加分销商" />
			</p>
		</form>
	</body>
</html>
