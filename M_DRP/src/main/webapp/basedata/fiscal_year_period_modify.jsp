<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>会计核算修改</title>
		<link rel="stylesheet" href="../css/drp.css">
		<link href="../css/JSCalendar.css" rel=stylesheet type=text/css>
		<script src="../css/JSCalendar.js"></script>
		<script src="../css/client_validate.js"></script>
		<script type="text/javascript">
			
			function init() {
				document.getElementById("beginDate").focus();
			}
		
			function modifyFiscalYearPeriod(){
				if (trim(document.getElementById("beginDate").value) > trim(document.getElementById("endDate").value)) {
					alert("核算日期必须小于等于结束日期！");
					document.getElementById("beginDate").focus();
					return;
				}
				with (document.getElementById("fiscalYearPeriodForm")) {
					method = "post";
					action = "updateAccounts";
					submit();
				}
			}
			
			function goBack(){
				window.self.location = "selectAccounts";
			}
		</script>
	</head>

	<body class="body1" >
		<form name="fiscalYearPeriodForm" target="_self"
			id="fiscalYearPeriodForm" action = "updateAccounts";>
			<input type="hidden" name="flag" value="2"/>
			<input type="hidden" name="id" value="${account.id }"/>
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
							<b>会计核算&gt;&gt;会计核算维护&gt;&gt;修改</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								核算年:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="fiscalyear" type="text" class="text1" value="${account.fiscalyear }"
								id="fiscalYear" size="10" maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								核算月:&nbsp;
							</div>
						</td>
						<td>
							<input name="fiscalperiod" type="text" class="text1" value="${account.fiscalperiod }"
								id="fiscalPeriod" size="10" maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>开始日期:&nbsp;
							</div>
						</td>
						<td>
							<label>
								<input type="text" name="begindate" id="beginDate"  size="10" maxlength="10" value="<fmt:formatDate value='${account.begindate }' pattern='yyyy-MM-dd'></fmt:formatDate>"
									readonly="true" onClick="JSCalendar(this)">
							</label>
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>结束日期:&nbsp;
							</div>
						</td>
						<td>
							<input name="enddate" type="text" id="endDate" value="<fmt:formatDate value='${account.enddate }' pattern='yyyy-MM-dd'></fmt:formatDate>"
								onClick="JSCalendar(this)"  size="10"
								maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>是否可用:&nbsp;
							</div>
						</td>
						<td>
							<c:choose>
								<c:when test="${account.periodsts.equals('是') }"><input name="periodsts" type="checkbox" class="checkbox1" value="${account.periodsts }" checked="checked"/></c:when>
								<c:otherwise><input name="periodsts" type="checkbox" class="checkbox1" value="${account.periodsts }"/></c:otherwise>
							</c:choose>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<div align="center">
					<input name="btnModify" class="button1" type="submit"
						id="btnModify" value="修改">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input name="btnBack" class="button1" type="button" id="btnBack"
						value="返回" onClick="goBack()">
				</div>
			</div>
		</form>
	</body>
</html>
