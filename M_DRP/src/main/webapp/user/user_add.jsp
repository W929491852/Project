<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link rel="stylesheet" href="../css/drp.css">
<script src="../js/client_validate.js"></script>
<script src="../js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function goBack() {
		window.self.location="user_maint.jsp"
	}
	
	function addUser() {
		var userIdField = document.getElementById("userId");
		//用户代码不能为空
		if (trim(userIdField.value) == "") {
			alert("用户代码不能为空！");
			userIdField.focus();
			return;
		}
		
		//使用正则表达式判断第1个字符必须是字母
		var re = new RegExp(/^[a-zA-Z]/);
		if (!re.test(trim(userIdField.value))) {
			alert("用户代码首字符必须为字母！");
			userIdField.focus();
			return;
		}

		//必须输入数字和字母，字符个数是4~6位
		re.compile(/^[a-zA-Z0-9]{4,6}$/);
		if (!re.test(trim(userIdField.value))) {
			alert("必须输入数字和字母，字符个数是4~6位！");
			userIdField.focus();
			return;
		}
		
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

		//采用正则表达式判断电话号码必须为数值
		var contactTelField = document.getElementById("contactTel");
		if (trim(contactTelField.value).length != 0) {
			re.compile(/\d/);
			if (!re.test(contactTelField.value)) {
					alert("电话号码必须是数字！");
					contactTelField.focus();
					return;
			}
		}
		
		//如果email了进行判断，判断规则是只要包含@即可
		var emailField = document.getElementById("email");
		if (trim(emailField.value) != "") {
			if (emailField.value.search("@") == -1) {
				alert("email格式不正确！");
				emailField.focus();
				return;
			}
		}
	
		//等同与上面的写法
		with(document.getElementById("userForm")) {
			method="post";
			action="user_add.jsp?command=add";
			submit();
		}
		
	}
	
	
	function userIdOnKeyPress() {
		if (!(event.keyCode >=48 && event.keyCode <=57) && !(event.keyCode >=97 && event.keyCode <=122)) {
			event.keyCode = 0;
		}  
	}
	
	
	function validate(field) {
		if (trim(field.value).length != 0) {
			var url = "user_validate.jsp";
			$.get(url,"userId=" + trim(field.value) + "&timestamp=" + new Date().getTime(),
					function(data) {
					if (data==1) { 
						document.getElementById("userIdSpan").innerHTML = "<font color='red'>" + xmlHttp.responseText + "</font>";
					}else {
						alert("请求失败，错误码=" + xmlHttp.status);
					}
				});
		}else {
			document.getElementById("userIdSpan").innerHTML = "";
		}
	}
	</script>
</head>

<body class="body1" >
	<form action="addUser" method="get">
<!-- 	<form name="userForm" target="_self" id="userForm"> -->
		<div align="center">
			<table width="95%" border="0" cellspacing="2" cellpadding="2">
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table width="95%" border="0" cellspacing="10px" cellpadding="10"
				height="25">
				<tr>
					<td width="522" class="p1" height="25" nowrap><img
						src="../images/mark_arrow_03.gif" width="14" height="14">
						&nbsp; <b>系统管理&gt;&gt;用户维护&gt;&gt;添加</b></td>
				</tr>
			</table>
			<hr width="80%" align="center" >
			<table width="80%" cellspacing="10px" align="center" cellpadding="10">
				<tr>
					<td>
						<div align="right">
							<font color="#FF0000">*</font>用户名称:&nbsp;
						</div>
					</td>
					<td><input name="username" type="text" class="text1" size="20" maxlength="20" ></td>
				</tr>
				<tr>
					<td>
						<div align="right">
							<font color="#FF0000">*</font>密码:&nbsp;
						</div>
					</td>
					<td><input name="password" type="password" class="text1" size="20" maxlength="20">
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">联系电话:&nbsp;</div>
					</td>
					<td><input name="contacttel" type="text" class="text1"
						id="contactTel" size="20" maxlength="20" value="">
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">email:&nbsp;</div>
					</td>
					<td><input name="email" type="text" class="text1" 
						size="20" maxlength="20" ></td>
				</tr>
				<tr>
				<td colspan="2"><hr width="97%" align="center" /></td>
				</tr>
				
				<tr>
				<td colspan="2" align="center">
				<input type="submit" value="新增用户"/> &nbsp;&nbsp; <input
					 type="button" value="返回" onClick="goBack()" />
				</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
