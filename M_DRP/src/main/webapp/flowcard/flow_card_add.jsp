<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>添加流向单维护</title>
		<link rel="stylesheet" href="../css/drp.css">
		<link href="../css/JSCalendar.css" rel=stylesheet type=text/css>
		<script src="../js/jquery-3.2.1.min.js"></script>
		<script src="../js/JSCalendar.js"></script>
		<script src="../js/client_validate.js"></script>
		<script language="javascript">
		
    var rowIndex = 0;
    function selectClient(){
		var open=window.open("selectClientSelect", "选择分销商", "width=700, height=400, scrollbars=no");
		console.log(1);
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
    function selectAimClient(index) {
		window.open("selectTemi?index=" + index, "请选择需方客户", "width=700, height=400, scrollbars=no");
		
	
    }   
     
    function selectItem(index) {
    	console.log(index);
		var open=window.open("selectItemSelect?indexItemNo="+index+"&clientId="+$("#clientId4").val(), "请选择物料", "width=700, height=400, scrollbars=no");
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
		    }  	}, 100);   
    } 
     
    function addOneLineOnClick() {
		var row= document.getElementById("tblFlowCardDetail").insertRow(document.getElementById("tblFlowCardDetail").rows.length);
		var col = row.insertCell(0);
		col.innerHTML = "<input type=\"hidden\" name=\"aimInnerId\"><input readonly=\"true\" maxLength=6 size=6 id=aimId"+rowIndex+" name=aimId><input type=button  value =...   name=btnSelectAimClient index=\""+ rowIndex +"\" onclick=\"selectAimClient("+rowIndex+")\">";
		col = row.insertCell(1);
		col.innerHTML = "<input id=aimName"+rowIndex+" name=aimName size=25 maxlength=25 readonly=\"true\">";
		col = row.insertCell(2);
		col.innerHTML = "<input readonly=\"true\" maxLength=6 size=6 id=itemNo"+rowIndex+" name=itemNo><input type=button  value =...   name=btnSelectItem index=\""+ rowIndex +"\" onclick=\"selectItem("+rowIndex+")\">";
		col = row.insertCell(3);
		col.innerHTML = "<input id=itemName"+rowIndex+" name=itemName size=25 maxlength=25 readonly=\"true\">";		
		col = row.insertCell(4);
		col.innerHTML = "<input id=spec"+rowIndex+" name=spec size=10 maxlength=10 readonly=\"true\">";
		col = row.insertCell(5);
		col.innerHTML = "<input id=pattern"+rowIndex+" name=pattern size=10 maxlength=10 readonly=\"true\">";
		col = row.insertCell(6);
		col.innerHTML = "<input id=unit"+rowIndex+" name=unit size=4 maxlength=4 readonly=\"true\">";
		col = row.insertCell(7);
		col.innerHTML = "<input id=qty"+rowIndex+" name=qty size=6 maxlength=6>";
		col = row.insertCell(8);
		col.innerHTML = "<input type='button' value='删除' id=btnDeleteLine name=btnDeleteLine onclick=\"return DeleteRow('row" + rowIndex + "')\">";
		row.setAttribute("id", "row" + rowIndex);
		rowIndex++;
	}
	
	function DeleteRow(rowTag){
 	    var i =  document.getElementById("tblFlowCardDetail").rows(rowTag).rowIndex;
 		var j;
		for(j=i;j<=rowIndex;j++) {	
			document.getElementById("tblFlowCardDetail").rows(j).cells(0).all("btnSelectAimClient").index--;
			document.getElementById("tblFlowCardDetail").rows(j).cells(2).all("btnSelectItem").index--;	
		}
       	document.getElementById("tblFlowCardDetail").deleteRow(i);
		rowIndex--;
	}

	function goBack() {
		window.self.location="flow_card_maint.html"
	}	

</script>
	</head>

	<body class="body1">
		<div align="center">
			<form name="flowCardAddForm" method="post" action="flowCardDetailAdd">
				<input type="hidden" name="command" value="">
				<input type="hidden" name="clientInnerId" id="clientInnerId">
				<table width="95%" border="0" cellspacing="2" cellpadding="2">
					<tr>
						<td>&nbsp;
							
						</td>
					</tr>
				</table>
				<table width="95%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="522" class="p1" height="2" nowrap>
							<img src="images/mark_arrow_03.gif" width="14" height="14">
							&nbsp;<b>流向单维护&gt;&gt;添加</b>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0">
					<tr id="row0">
						<td width="15%" height="29">
							<div align="right">
								<font color="#FF0000">*</font>供方分销商代码:&nbsp;
							</div>
						</td>
						<td width="16%">
							<input name="clientId" type="text" class="text1" id="clientId4"
								size="10" maxlength="10" readonly="true">
							<input name="btnSelectClient" type="button" id="btnSelectClient"
								value="..." class="button1"
								onClick="selectClient();">
						</td>
						<td width="16%">
							<div align="right">
								供方分销商名称:&nbsp;
							</div>
						</td>
						<td width="29%">
							<input name="clientName" type="text" class="text1"
								id="clientName" size="40" maxlength="40" readonly="true">
						</td>
						<td width="7%">&nbsp;
							
						</td>
						<td width="17%">
							<label></label>
						</td>
					</tr>
				</table>
				<hr width="97%" align="center" size=0>
				<table width="95%" border="0" cellpadding="0" cellspacing="0"
					name="tblFlowCardDetail" id="tblFlowCardDetail">
					<tr>
						<td nowrap>
							<div align="left">
								<font color="#FF0000">*</font>需方客户代码
							</div>
						</td>
						<td nowrap>
							<div align="left">
								需方客户名称
							</div>
						</td>
						<td nowrap>
							<div align="left">
								<font color="#FF0000">*</font>物料代码
							</div>
						</td>
						<td nowrap>
							<div align="left">
								物料名称
							</div>
						</td>
						<td nowrap>
							规格
						</td>
						<td nowrap>
							型号
						</td>
						<td nowrap>
							计量单位
						</td>
						<td nowrap>
							<font color="#FF0000">*</font>操作数量
						</td>
						<td nowrap>
							<div align="left">
								删除
							</div>
						</td>
					</tr>
				</table>
				<p>
					<input name="btnAddLine" type="button" id="btnAddLine"
						onClick="return addOneLineOnClick()" value="加入一行">
					<input name="btnSave" type="submit" id="btnSave" value="保存">
					<input name="btnBack" type="button" id="btnBack" onClick="goBack()"
						value="返回">
				</p>
				<p>&nbsp;
					
				</p>
				<p>&nbsp;
					
				</p>
			</form>
			<p>&nbsp;
				
			</p>
		</div>
	</body>
</html>
