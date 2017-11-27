<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会计核算添加</title>
<link rel="stylesheet" href="../css/drp.css">
<link href="../css/JSCalendar.css" rel="stylesheet" type=text/css>
<script src="../js/JSCalendar.js"></script>
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/client_validate.js"></script>
<script type="text/javascript">
			function init() {
				document.getElementById("fiscalYear").focus();
			}
		
			function addFiscalYearPeriod() {
				if (!isinteger(trim(document.getElementById("fiscalYear").value))) {
					alert("核算年必须为整数！");
					document.getElementById("fiscalYear").focus();
					return;
				}
				
				if (!isinteger(trim(document.getElementById("fiscalPeriod").value))) {
					alert("核算月必须为整数！");
					document.getElementById("fiscalPeriod").focus();
					return;
				}
				
				if (document.getElementById("responseMsg").innerHTML != "" ) {
					alert("核算年或核算月重复！");
					document.getElementById("fiscalYear").focus();
					return;
				}
				
				if (trim(document.getElementById("beginDate").value) > trim(document.getElementById("endDate").value)) {
					alert("开始日期必须小于等于结束日期！");
					document.getElementById("beginDate").focus();
					return;
				}
				
				with (document.getElementById("fiscalYearPeriodForm")) {
					method = "post";
					action = "addAccounts?flag=2";
					submit();
				}
			}
			
			function goBack() {
				window.location = "selectAccounts";
			}
			
			function fiscalPeriodOnkeyPress() {
				if (!(window.event.keyCode >=48 && window.event.keyCode<=57)) {
					window.event.keyCode = 0;		
				}
			}
			
			function fiscalYearOnkeypress() {
				if (!(window.event.keyCode >=48 && window.event.keyCode<=57)) {
					window.event.keyCode = 0;		
				}
			}
	//---------------------------Ajax begin----------------------------	
	
	function validate() {
		if (trim(document.getElementById("fiscalYear").value) != "" &&
		    trim(document.getElementById("fiscalPeriod").value) != "") {
			var fiscalYear = document.getElementById("fiscalYear");
			var fiscalPeriod = document.getElementById("fiscalPeriod");
			var url = "../servlet/FiscalYearPeriodValidateServlet?fiscalYear=" + fiscalYear.value + "&fiscalPeriod=" + fiscalPeriod.value + "&timestampt=" + new Date().getTime();
			$.get( url,null, function(data) {
				var responseMsgDiv = document.getElementById("responseMsg");
				if(data==1) {
					responseMsgDiv.innerHTML = "<font color='red'>" + xmlHttp.responseText + "</font>";
				}else {
					responseMsgDiv.innerHTML = "";
				}
			});
		}
	}
</script>
</head>
<body class="body1" onLoad="init()">
	<form name="fiscalYearPeriodForm" target="_self"
		id="fiscalYearPeriodForm">
		<div align="center">
			<table width="95%" border="0" cellspacing="2" cellpadding="2">
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				height="25">
				<tr>
					<td width="522" class="p1" height="25" nowrap><img
						src="../images/mark_arrow_03.gif" width="14" height="14">
						&nbsp; <b>会计核算维护&gt;&gt;添加</b></td>
				</tr>
			</table>
			<hr width="97%" align="center" size=0>
			<table width="95%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="22%" height="29">
						<div align="right">
							<font color="#FF0000">*</font>核算年:&nbsp;
						</div>
					</td>
					<td width="78%"><input name="fiscalyear" type="text"
						class="text1" id="fiscalYear" size="10" maxlength="4"
						onBlur="validate()" onKeyPress="fiscalYearOnkeypress()">
					</td>
				</tr>
				<tr>
					<td height="26">
						<div align="right">
							<font color="#FF0000">*</font>核算月:&nbsp;
						</div>
					</td>
					<td><input name="fiscalperiod" type="text" class="text1" id="fiscalPeriod" size="10" maxlength="2"
						onBlur="validate()" onKeyPress="fiscalPeriodOnkeyPress()">&nbsp<span
						id="responseMsg"></span></td>
				</tr>
				<tr>
					<td height="26">
						<div align="right">
							<font color="#FF0000">*</font>开始日期:&nbsp;
						</div>
					</td>
					<td><label> <input type="text" name="begindate"
							id="beginDate" size="10" maxlength="10" 
							>
					</label></td>
				</tr>
				<tr>
					<td height="26">
						<div align="right">
							<font color="#FF0000">*</font>结束日期:&nbsp;
						</div>
					</td>
					<td><input name="enddate" type="text" id="endDate"
						 size="10" maxlength="10" ></td>
				</tr>
				<tr>
					<td height="26">
						<div align="right">
							<font color="#FF0000">*</font>是否可用:&nbsp;
						</div>
					</td>
					<td><input name="periodsts" type="checkbox" class="checkbox1"
						id="periodSts" value="是"></td>
				</tr>
			</table>
			<hr width="97%" align="center" size=0>
			<div align="center">
				<input name="btnAdd" class="button1" type="button" id="btnAdd"
					onClick="addFiscalYearPeriod()" value="添加">
				&nbsp;&nbsp;&nbsp;&nbsp; <input name="btnBack" class="button1"
					type="button" id="btnBack" value="返回" onClick="goBack()">
			</div>
		</div>
	</form>
</body>
</html>
