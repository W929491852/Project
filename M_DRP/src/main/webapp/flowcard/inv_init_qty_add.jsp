<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加分销商库存数量</title>
		<link rel="stylesheet" href="../css/drp.css">
		<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
		<script src="../js/client_validate.js"></script>
		<script type="text/javascript">		
			function selectItem(){
				var open=window.open('selectItemSelect', "选择物料", "width=700, height=400, scrollbars=no");
				var loop = setInterval(function() {     
				    if(open.closed) {    
				        clearInterval(loop);   
				        $.get("selectItemChecked?itemno="+$("#itemNo").val(),function(data){
							var selectItem=eval('(' + data + ')');
							$("#itemName").val(selectItem.itemname);
							$("#spec").val(selectItem.spec);
							$("#pattern").val(selectItem.itemname);
							$("#unit").val(selectItem.unit.name);
							$("#itemName").val(selectItem.itemname);
							$("#itemName").val(selectItem.itemname);
							$("#itemName").val(selectItem.itemname);
							
						}) 
				    }    
				}, 100);  
			}
			
			function selectClient(){
				var open=window.open("selectClientSelect", "选择分销商", "width=700, height=400, scrollbars=no");
				var loop = setInterval(function() {     
				    if(open.closed) {    
				        clearInterval(loop);   
				        $.get("selectClientChecked?clientid="+$("#clientId4").val(),function(data){
							var selectItem=eval('(' + data + ')');
							$("#clientName").val(selectItem.clientname);
						}) 
				    }    
				}, 100);  
			}
			
			
		</script>
	</head>

	<body class="body1">
		<form name="InvIniQtyForm" action="addInventory" id="InvIniQtyForm">
			<input type="hidden" name="flag" value="2"/>
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
							<b>库存管理&gt;&gt;库存数量初始化&gt;&gt;添加</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="22%" height="29">
							<div align="right">
								<font color="#FF0000">*</font>分销商代码:&nbsp;
							</div>
						</td>
						<td width="78%">
							<input name="client.clientid" type="text" class="text1" id="clientId4"
								size="10" maxlength="10" readonly="true">
							<input name="btnSelectClient" type="button" id="btnSelectClient"
								value="..." class="button1"
								onClick="selectClient()">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								分销商名称:&nbsp;
							</div>
						</td>
						<td>
							<input name="clientname" type="text" class="text1"
								id="clientName" size="10" maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>物料代码:&nbsp;
							</div>
						</td>
						<td>
							<input name="item.itemno" type="text" class="text1" id="itemNo"
								size="10" maxlength="10" readonly="true">
							<input name="btnSelectItem" type="button" id="btnSelectItem"
								value="..." class="button1"
								onClick="javascript:selectItem();">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								物料名称:&nbsp;
							</div>
						</td>
						<td>
							<input name="itemName" type="text" class="text1" id="itemName"
								size="10" maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								物料规格:&nbsp;
							</div>
						</td>
						<td>
							<input name="spec" type="text" class="text1" id="spec" size="10"
								maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								物料型号:&nbsp;
							</div>
						</td>
						<td>
							<input name="pattern" type="text" class="text1" id="pattern"
								size="10" maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								计量单位:&nbsp;
							</div>
						</td>
						<td>
							<input name="unit" type="text" class="text1" id="unit" size="10"
								maxlength="10" readonly="true">
						</td>
					</tr>
					<tr>
						<td height="26">
							<div align="right">
								<font color="#FF0000">*</font>初始数量:&nbsp;
							</div>
						</td>
						<td>
							<input name="initqty" type="text" class="text1" id="initQty"
								size="10" maxlength="10">
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
