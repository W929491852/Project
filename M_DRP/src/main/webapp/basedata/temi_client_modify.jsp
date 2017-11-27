<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>终端客户修改</title>
		<link rel="stylesheet" href="../css/drp.css">
		<script src="../js/client_validate.js"></script>
	</head>

	<body class="body1">
		<form name="temiClientForm" action="updateTemi" id="temiClientForm">
			<input type="hidden" name="flag" value="2" />
			<div align="center">
				<table width="95%" border="0" cellspacing="2" cellpadding="2">
					<tr>
						<td>&nbsp;
							
						</td>
					</tr>
				</table>
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="8">
					<tr>
						<td width="522" class="p1" height="2" nowrap>
							<img src="../images/mark_arrow_03.gif" width="14" height="14">
							&nbsp;
							<b>终端客户管理&gt;&gt;终端客户修改</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								<font color="#FF0000">*</font>终端客户代码:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="temiid" type="text" class="text1" id="temiId"
								size="10" maxlength="10" value="${temi.temiid }">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>终端客户名称:&nbsp;
							</div>
						</td>
						<td>
							<input name="teminame" type="text" class="text1" id="temiName"
								size="10" maxlength="10" value="${temi.teminame }">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>终端客户类型:&nbsp;
							</div>
						</td>
						<td>
							<select name="dataDict.id" class="select1" id="temiType">
								<option value="0">
									请选择终端客户类型
								</option>
								<c:forEach items="${dicts }"  var="item">
									<c:choose>
										<c:when test="${item.id==temi.dataDict.id }"><option value="${item.id }" selected="selected">${item.name }</option></c:when>
										<c:otherwise><option value="${item.id }">${item.name }</option></c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								联系人:&nbsp;
							</div>
						</td>
						<td>
							<input name="contactor" type="text" class="text1" id="contactor"
								size="10" maxlength="10" value="${temi.contactor }">
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
								id="contactTel" size="10" maxlength="10" value="${temi.contacttel }">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								联系地址:&nbsp;
							</div>
						</td>
						<td>
							<input name="address" type="text" class="text1" id="address"
								size="10" maxlength="10" value="${temi.address }">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								邮编:&nbsp;
							</div>
						</td>
						<td>
							<input name="zipcode" type="text" class="text1" id="zipCode"
								size="10" maxlength="10" value="${temi.zipcode }">
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnAdd" class="button1" type="submit" id="btnAdd"
						value="添加">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="返回" onClick="history.go(-1)">
				</div>
			</div>
		</form>
	</body>
</html>
