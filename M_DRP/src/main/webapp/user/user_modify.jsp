<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改用户</title>
		<link rel="stylesheet" href="../css/drp.css">
		<script src="../js/client_validate.js"></script>
		<script type="text/javascript">
	function goBack() {
		window.self.location ="user_maint.jsp"
	}
	
	function modifyUser() {
		//用户名称不能为空
		var userNameField = document.getElementById("userName");
		if (trim(userNameField.value).length == 0) {
			alert("用户名称不能为空！");
			userNameField.focus();
			return;
		}
		
		//密码至少6位！
		var passwordField = document.getElementById("password");
		if (trim(passwordField.value).length < 6) {
			alert("密码至少6位！");
			passwordField.focus();
			return;
		} 

		//采用正则表达式判断电话号码必须为数值（作业）
		var contactTelField = document.getElementById("contactTel");
		if (trim(contactTelField.value).length != 0) {
			var re = new RegExp(/\d/);
			if (!re.test(contactTelField.value)) {
					alert("电话号码必须是数字！");
					contactTelField.focus();
					return;
			}
		}
		
		//如果email了进行判断，判断规则是只要包含@即可(作业)
		var emailField = document.getElementById("email");
		if (trim(emailField.value) != "") {
			if (emailField.value.search("@") == -1) {
				alert("email格式不正确！");
				emailField.focus();
				return;
			}
		}

		with(document.getElementById("userForm")) {
			alert(1);
			action="updateUser?flag=2";
			method="post";
			submit();
		}
	}
	
	function init() {
		document.getElementById("userName").focus();
	}
	
</script>

	</head>

	<body class="body1" onLoad="init()">
		<form action="updateUser" method="get">
		<!-- <form name="userForm" id="userForm"> -->
			<input type="hidden" name="flag" value="2">
			<div align="center">
				<table width="95%" border="0" cellspacing="2" cellpadding="2">
					<tr>
						<td>&nbsp;
							
						</td>
					</tr>
				</table>
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="25">
					<tr>
						<td width="522" class="p1" height="25" nowrap>
							<img src="../images/mark_arrow_03.gif" width="14" height="14">
							&nbsp;
							<b>系统管理&gt;&gt;用户维护&gt;&gt;修改</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								序号:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="userid" type="text" class="text1" id="userId"
								size="10" maxlength="10" readonly="true" value="${user.userid }">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>用户名称:&nbsp;
							</div>
						</td>
						<td>
							<input name="username" type="text" class="text1" id="userName"
								size="20" maxlength="20" value="${user.username }">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>密码:&nbsp;
							</div>
						</td>
						<td>
							<label>
								<input name="password" type="password" class="text1"
									size="20" maxlength="20" value="${user.password }">
							</label>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								联系电话:&nbsp;
							</div>
						</td>
						<td>
							<input name="contacttel" type="text" class="text1"
								id="contactTel" size="20" maxlength="20" value="${user.contacttel }">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								email:&nbsp;
							</div>
						</td>
						<td>
							<input name="email" tsype="text" class="text1" id="email"
								size="20" maxlength="20" value="${user.email }">
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<!-- <input class="button1" type="button"
						id="btnModify" value="修改" onClick="modifyUser()"> -->
						<input type="submit" value="修改"/>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button1" type="button" id="btnBack"
						value="返回" onClick="goBack()" />
				</div>
			</div>
		</form>
	</body>
</html>
