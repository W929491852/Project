<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>盘点维护</title>
<link rel="stylesheet" href="../css/drp.css">
<link href="../css/JSCalendar.css" rel=stylesheet type=text/css>
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/JSCalendar.js"></script>
<script src="../js/client_validate.js"></script>
<script language="javascript">
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
	function selectItem(index) {
		if($("#clientId4").val()==""){
			alert("请先选择分销商");
			return ;
		}
		var open=window.open('selectItemSelect?indexItemNo='+index+"&clientId="+$("#clientId4").val(), '请选择物料',
				'width=700, height=400, scrollbars=no');
		var loop = setInterval(function() {     
		    if(open.closed) {    
		        clearInterval(loop);   
		        $.get("selectItemChecked?itemno="+$("#itemNo"+index).val(),function(data){
					var selectItem=eval('(' + data + ')');
					$("#itemName"+index).val(selectItem.itemname);
					$("#spec"+index).val(selectItem.spec);
					$("#pattern"+index).val(selectItem.itemname);
					$("#unit"+index).val(selectItem.unit.name);
					$("#itemName"+index).val(selectItem.itemname);
					$("#itemName"+index).val(selectItem.itemname);
					$("#itemName"+index).val(selectItem.itemname);
					
				}) 
		    }    
		}, 100); 
	}

	var rowIndex = 0;

	function addOneLineOnClick() {
		var row = tblFlowCardDetail.insertRow(tblFlowCardDetail.rows.length);
		var col = row.insertCell(0);
		col.innerHTML = "<input readonly=\"true\" maxLength=6 size=10 name=itemNo id=itemNo"+rowIndex+"><input type=button  value =...   name=btnSelectItem index=\""
				+ rowIndex + "\" onclick=\"selectItem("+rowIndex+")\">";
		col = row.insertCell(1);
		col.innerHTML = "<tr><input id=itemName"+rowIndex+" name=itemName size=12 maxlength=16 readonly=\"true\">";
		col = row.insertCell(2);
		col.innerHTML = "<INPUT readonly=\"true\" maxLength=6 size=10 name=spec id=spec"+rowIndex+">";
		col = row.insertCell(3);
		col.innerHTML = "<input id=pattern"+rowIndex+" name=pattern size=10 maxlength=10 readonly=\"true\">";
		col = row.insertCell(4);
		col.innerHTML = "<input id=unit"+rowIndex+" name=unit size=10 maxlength=10 readonly=\"true\">";
		col = row.insertCell(5);
		col.innerHTML = "<input id=qty"+rowIndex+" name=qty size=10 maxlength=10>";
		col = row.insertCell(6);
		col.innerHTML = "<input type='button' value='删除' id=btnDeleteLine name=btnDeleteLine onclick=\"return DeleteRow('row"
				+ rowIndex + "')\"></tr>";
		row.setAttribute("id", "row" + rowIndex);
		row.setAttribute("name", "row" + rowIndex);
		rowIndex++;
	}

	function DeleteRow(rowTag) {
		//var i=1;
		//var i= document.getElementById("tblFlowCardDetail");
		console.log(tblFlowCardDetail);
		//console.log(i);
		//var i = tblFlowCardDetail.rows(rowTag);
		/* var i=1;
		// alert(i);
		var j;
		for (j = i; j <= rowIndex; j++) {
			tblFlowCardDetail.rows[j].cells[0].all("btnSelectItem").index--;
		}  */
		tblFlowCardDetail.deleteRow(i);
	//	rowIndex--;
	}
</script>
</head>

<body class="body1">
	<div align="center">
		<form name="checkVoucherForm" action="updateInventory" id="checkVoucherForm">
			<table width="95%" border="0" cellspacing="2" cellpadding="2">
				<tr>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table width="95%" border="0" cellspacing="0" cellpadding="0"
				height="8">
				<tr>
					<td width="522" class="p1" height="2" nowrap><img
						src="../images/mark_arrow_03.gif" width="14" height="14">
						&nbsp; <b>库存管理&gt;&gt;盘点结果维护&gt;&gt;添加</b></td>
				</tr>
			</table>
			<hr width="97%" align="center" size=0>
			<table width="95%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="15%" height="29">
						<div align="right">
							<font color="#FF0000">*</font>分销商代码:&nbsp;
						</div>
					</td>
					<td width="20%"><input name="clientid" type="text"
						class="text1" id="clientId4" size="10" maxlength="10"
						readonly="true"> <input name="btnSelectClient"
						type="button" id="btnSelectClient" value="..." class="button1"
						onClick="selectClient()"></td>
					<td width="12%">
						<div align="right">分销商名称:&nbsp;</div>
					</td>
					<td width="53%"><input name="clientName" type="text"
						class="text1" id="clientName" size="10" maxlength="10"
						readonly="true"></td>
				</tr>
			</table>
			<hr width="97%" align="center" size=0>
			<table name="tblFlowCardDetail" id="tblFlowCardDetail" width="95%"
				border="0" cellspacing="0" cellpadding="0" height="9"
				bordercolor="#66CCFF">
				<tr bordercolor="#FFFFFF" bgcolor="#FFFFFF">
					<td>
						<div align="left">
							<font color="#FF0000">*</font>物料代码
						</div>
					</td>
					<td>
						<div align="left">物料名称</div>
					</td>
					<td>规格</td>
					<td>型号</td>
					<td>计量单位</td>
					<td><font color="#FF0000">*</font>差异数量</td>
					<td>
						<div align="left">删除</div>
					</td>
				</tr>
			</table>
			<p>
				<input name="btnAddLine" type="button" id="btnAddLine"
					onClick="return addOneLineOnClick()" value="加入一行"> <input
					name="btnSave" type="submit" id="btnSave" value="保存"> <input
					name="btnBack" type="button" id="btnBack" onClick="history.go(-1)"
					value="返回">
			</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</form>
		<p>&nbsp;</p>
	</div>
</body>
</html>
