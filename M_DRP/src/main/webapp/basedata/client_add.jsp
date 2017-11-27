<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加分销商</title>
<link rel="stylesheet" href="../css/drp.css">
<script src="../js/client_validate.js"></script>
<script type="text/javascript">
	window.onload=function(){
		var msg = "";
		if (trim(document.getElementById("clientid").value) != "") {
			msg+="分销商代码已经存在,不能再添加！\n";
		}
		if (msg != "") {		
			alert(msg);
			location.href="client_crud.jsp";
			return false;		
		}
		return true;
	}
</script>
</head>

<body class="body1">
	<form name="form1" action="addClient" method="post"
		>
		<input type="hidden" id="clientid" value="${sessionScope.user.client.clientid }"> 
		<input type="hidden" name="flag" value="2"/>
		<div align="center">
			<table width="95%" border="0" cellspacing="2" cellpadding="2">
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				height="8">
				<tr>
					<td width="522" class="p1" height="2" nowrap><img
						src="images/mark_arrow_03.gif" width="14" height="14">
						&nbsp; <b>分销商管理&gt;&gt;添加分销商</b></td>
				</tr>
			</table>
			<hr width="97%" align="center" >
			<table width="95%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td >
						<div align="right">
							<font color="#FF0000">*</font>分销商名称:&nbsp;
						</div>
					</td>
					<td><input name="clientname" type="text" class="text1"
						id="clientName" ></td>
				</tr>
				<tr>
					<td >
						<div align="right">
							<font color="#FF0000">*</font>分销商类型:&nbsp;
						</div>
					</td>
					<td><select name="dataDict.id" class="select1"
						id="clientLevel">
							<option value="0">请选择级别</option>
							<c:forEach items="${dicts }" var="item">
								<option value=${item.id }>${item.name }</option>
							</c:forEach>


					</select></td>
				</tr>
				<tr>
					<td >
						<div align="right">银行帐号:&nbsp;</div>
					</td>
					<td><input name="bankacctno" type="text" class="text1"
						id="bankAcctNo" ></td>
				</tr>
				<tr>
					<td >
						<div align="right">联系电话:&nbsp;</div>
					</td>
					<td><input name="contacttel" type="text" class="text1"
						id="contactTel" ></td>
				</tr>
				<tr>
					<td >
						<div align="right">地址:&nbsp;</div>
					</td>
					<td><input name="address" type="text" class="text1"
						id="address" ></td>
				</tr>
				<tr>
					<td >
						<div align="right">邮编:&nbsp;</div>
					</td>
					<td><input name="zipcode" type="text" class="text1"
						id="zipCode" ></td>
				</tr>
			</table>
			<hr width="97%" align="center" size=0>
			<div align="center">
				<input name="btnAdd" class="button1" type="submit" id="btnAdd"
					value="添加"> &nbsp;&nbsp;&nbsp;&nbsp; <input name="btnBack"
					class="button1" type="button" id="btnBack" value="返回"
					onClick="" />
			</div>
		</div>
	</form>
</body>
</html>
