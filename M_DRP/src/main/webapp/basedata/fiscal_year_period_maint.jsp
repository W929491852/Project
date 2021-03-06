<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会计核算维护</title>
<link rel="stylesheet" href="../css/drp.css">
<script type="text/javascript">
	function addFiscalYearPeriod() {
		window.self.location = "addAccounts?flag=1";
	}
	
	function modifyFiscalYearPeriod() {
		var flag = false;
		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
			if (document.getElementsByName("selectFlag")[i].checked) {
				flag = true;
				break;
			}		
		}
		if (!flag) {
			alert("请选择需要修改的核算期间！");
			return;
		}
		window.self.location = "updateAccounts?flag=1&id=" + document.getElementsByName("selectFlag")[i].value;
	}
	
	function topPage() {
		window.self.location = "fiscal_year_period_maint.jsp?pageNo=getTopPageNo()%>";
	}
	
	function previousPage() {
		window.self.location = "fiscal_year_period_maint.jsp?pageNo=getPreviousPageNo()%>";
	}	
	
	function nextPage() {
		window.self.location = "fiscal_year_period_maint.jsp?pageNo=getNextPageNo()%>";
	}
	
	function bottomPage() {
		window.self.location = "fiscal_year_period_maint.jsp?pageNo=getButtomPageNo()%>";
	}
</script>
</head>
<body class="body1">
	<form name="fiscalYearPeriodForm" id="fiscalYearPeriodForm">
		<div align="center">
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				height="35">
				<tr>
					<td class="p1" height="18" nowrap>&nbsp;</td>
				</tr>
				<tr>
					<td width="522" class="p1" height="17" nowrap><img
						src="../images/mark_arrow_02.gif" width="14" height="14">
						&nbsp; <b>会计核算&gt;&gt;维护</b></td>
				</tr>
			</table>
			<hr width="100%" align="center" size=0>
		</div>
		<table width="95%" height="20" border="0" align="center"
			cellspacing="0" class="rd1" id="toolbar">
			<tr>
				<td width="49%" class="rd19"><font color="#FFFFFF">查询列表</font>
				</td>
				<td width="27%" nowrap class="rd16">
					<div align="right"></div>
				</td>
			</tr>
		</table>
		<table width="95%" border="1" cellspacing="0" cellpadding="0"
			align="center" class="table1">
			<tr>
				<td width="79" class="rd6">选择</td>
				<td width="123" class="rd6">核算年</td>
				<td width="146" class="rd6">核算月</td>
				<td width="188" class="rd6">开始日期</td>
				<td width="204" class="rd6">结束日期</td>
				<td width="172" class="rd6">核算期状态</td>
			</tr>
			<c:forEach items="${accounts }" var="item">
				<tr>
					<td class="rd8"><input type="radio" name="selectFlag"
						id="selectFlag" value="${item.id }"></td>
					<td class="rd8">${item.fiscalyear }</td>
					<td class="rd8">${item.fiscalperiod }</td>
					<td class="rd8">${item.begindate }
					</td>
					<td class="rd8">${item.enddate }</td>
					<td class="rd8">${item.periodsts }</td>
				</tr>
			</c:forEach>

		</table>
		<table width="95%" height="30" border="0" align="center"
			cellpadding="0" cellspacing="0" class="rd1">
			<tr>
				
				<td nowrap class="rd19">
					<div align="right">
						<input name="btnTopPage" class="button1" type="button"
							id="btnTopPage" value="|&lt;&lt; " title="首页" onClick="topPage()">
						<input name="btnPreviousPage" class="button1" type="button"
							id="btnPreviousPage" value=" &lt;  " title="上页"
							onClick="previousPage()"> <input name="btnNextPage"
							class="button1" type="button" id="btnNextPage" value="  &gt; "
							title="下页" onClick="nextPage()"> <input
							name="btnBottomPage" class="button1" type="button"
							id="btnBottomPage" value=" &gt;&gt;|" title="尾页"
							onClick="bottomPage()"> <input name="btnAdd"
							type="button" class="button1" id="btnAdd" value="添加"
							onClick="addFiscalYearPeriod()"> <input name="btnModify"
							class="button1" type="button" id="btnModify" value="修改"
							onClick="modifyFiscalYearPeriod()">
					</div>
				</td>
			</tr>
		</table>
		<p>&nbsp;</p>
	</form>
</body>
</html>
