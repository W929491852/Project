<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>分销商库存数量初始化确认</title>
		<link rel="stylesheet" href="../css/drp.css">
	</head>

	<body class="body1">
		<form name="invInitQryForm">
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
							<img src="../images/mark_arrow_02.gif" width="14" height="14">
							&nbsp;
							<b>库存管理&gt;&gt;库存数量初始化确认</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table height=8 width="95%">
					<tr>
						<td height=3></td>
					</tr>
				</table>
				<table width="95%" height="20" border="0" cellspacing="0"
					id="toolbar" class="rd1">
					<tr>
						<td class="rd19" width="434">
							<font color="#FFFFFF">查询列表</font>
						</td>
						<td nowrap class="rd16" width="489">
							<div align="right"></div>
						</td>
					</tr>
				</table>
				<table width="95%" border="1" cellspacing="0" cellpadding="0"
					align="center" class="table1">
					<tr>
						<td width="31" height="32" class="rd6">
							<input type="checkbox" name="ifAll" onClick="checkAll()">
						</td>
						<td width="86" class="rd6">
							分销商代码
						</td>
						<td width="194" class="rd6">
							分销商名称
						</td>
						<td width="93" class="rd6">
							物料代码
						</td>
						<td width="144" class="rd6">
							物料名称
						</td>
						<td width="119" class="rd6">
							规格
						</td>
						<td width="110" class="rd6">
							型号
						</td>
						<td width="79" class="rd6">
							计量单位
						</td>
						<td width="94" class="rd6">
							数量
						</td>
					</tr>
					<c:forEach items="${inventorys }" var="i">
						<tr>
						<td width="31" class="rd8">
							<input type="checkbox" name="selectFlag" class="checkbox1"
								value="checkbox">
						</td>
						<td width="86" class="rd8">
							${i.client.clientid }
						</td>
						<td width="194" class="rd8">
							${i.client.clientname }
						</td>
						<td width="93" class="rd8">
							${i.item.itemno }
						</td>
						<td width="144" class="rd8">
							${i.item.itemname }
						</td>
						<td width="119" class="rd8">
							${i.item.spec }
						</td>
						<td width="110" class="rd8">
							${i.item.pattern }
						</td>
						<td width="79" class="rd8">
							${i.item.unit.name }
						</td>
						<td width="94" class="rd8">
							${i.initqty }
						</td>
					</tr>
						
					</c:forEach>
				</table>
				<table width="95%" border="0" cellspacing="0" cellpadding="0"
					height="30" class="rd1">
					<tr>
						
						<td nowrap class="rd19" width="66%">
							<div align="right">
								<input name="btnTopPage" class="button1" type="button"
									id="btnTopPage" value="|&lt;&lt; " title="首页">
								<input name="btnPreviousPage" class="button1" type="button"
									id="btnPreviousPage" value=" &lt;  " title="上页">
								<input name="btnNextPage" class="button1" type="button"
									id="btnNextPage" value="  &gt; " title="下页">
								<input name="btnBottomPage" class="button1" type="button"
									id="btnBottomPage" value=" &gt;&gt;|" title="尾页">
								<input name="btnOk" class="button1" type="button" id="btnOk"
									value="确认"">
							</div>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</body>
</html>
