<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/css.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.2.1.js"></script>
<script language="javascript" type="text/javascript">
	$(function() {
		/** 给左侧功能菜单绑定点击事件  */
		$("td[id^='navbg']").click(function() {
				/** 获取一级菜单的id */
				var navbgId = this.id;
				/** 获取对应的二级菜单id */
				var submenuId = navbgId.replace('navbg','submenu');
				/** 控制二级菜单显示或隐藏  */
				$("#" + submenuId).toggle();
				/** 控制关闭或者开启的图标*/
				$("#" + navbgId).toggleClass("left_nav_expand");
				/** 控制其他的一级菜单的二级菜单隐藏按钮都关闭  */
				$("tr[id^='submenu']").not("#" + submenuId).hide();
				/** 控制其他一级菜单的图片显示关闭  */
				$("td[id^='navbg']").not(this).removeClass().addClass("left_nav_closed");
			});
	});
</script>
</head>
<body>
	<div style="margin: 10px; background-color: #000000; text-align: left;height:100%">
		<table width="200" height="100%" class="left_nav_bg">
			<tr>
				<td id="navbg0" class="left_nav_closed"><div class="font1">用户管理</div></td>
			</tr>
			<tr id="submenu0">
				<td class="left_nav_bgshw" height="50">
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"><a
							href="user/user_add.jsp" target="main">用户添加</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"><a
							href="user/selectUser" target="main">用户维护</a></img>
					</p>
				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>

			<tr>
				<td id="navbg1" class="left_nav_closed"><div class="font1">分销商管理</div></td>
			</tr>
			<tr id="submenu1" style="display: none">
				<td class="left_nav_bgshw" height="50">
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="basedata/client_crud.jsp" target="main">分销商维护</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="basedata/addClient?flag=1" target="main">分销商添加</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="basedata/client_node_crud.jsp" target="main">分销商区域维护</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="basedata/client_node_add.jsp" target="main">分销商区域新增</a></img>
					</p>
					
					
				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>

			<tr>
				<td id="navbg2" class="left_nav_closed"><div class="font1">核算管理</div></td>
			</tr>
			<tr id="submenu2" style="display: none">
				<td class="left_nav_bgshw" height="50">
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="basedata/selectAccounts" target="main">会计核算维护</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="basedata/addAccounts?flag=1" target="main">会计核算添加</a></img>
					</p>

					

				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>

			<tr>
				<td id="navbg3" class="left_nav_closed"><div class="font1">物料管理</div></td>
			</tr>
			<tr id="submenu3" style="display: none">
				<td class="left_nav_bgshw" height="50">
				<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="basedata/selectItem" target="main">物料维护</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="basedata/addItem?flag=1" target="main">物料添加</a></img>
					</p>
				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>

			<tr>
				<td id="navbg4" class="left_nav_closed"><div class="font1">终端客户管理</div></td>
			</tr>
			<tr id="submenu4" style="display: none">
				<td class="left_nav_bgshw tdbtmline" height="50">
				<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="basedata/selectTemi?flag=2" target="main">终端客户维护</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="basedata/addTemi?flag=1" target="main">终端客户添加</a></img>
					</p>
				</td>
			</tr>

			<tr>
				<td height="2"></td>
			</tr>
			<tr>
				<td id="navbg5" class="left_nav_closed"><div class="font1">库存管理</div></td>
			</tr>
			<tr id="submenu5" style="display: none">
				<td class="left_nav_bgshw tdbtmline" height="50">
				<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="flowcard/checkvou_maint.jsp" target="main">库存维护</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="flowcard/checkvou_add.jsp" target="main">库存新增</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="flowcard/checkvou_audit.jsp" target="main">库存审核</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="flowcard/addInventory?flag=1" target="main">库存初始化</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="flowcard/selectInventory" target="main">库存数量确认</a></img>
					</p>
				</td>
			</tr>

			<tr>
				<td height="2"></td>
			</tr>
			<tr>
				<td id="navbg6" class="left_nav_closed"><div class="font1">流向管理</div></td>
			</tr>
			<tr id="submenu6" style="display: none">
				<td class="left_nav_bgshw tdbtmline" height="50">
				<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="flowcard/flowCardSelect" target="main">流向单维护</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="flowcard/flow_card_add.jsp" target="main">流向单新增</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="flowcard/flow_card_audit.jsp" target="main">流向单审核</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif"> <a
							href="flowcard/flow_card_rehear.jsp" target="main">流向单复审</a></img>
					</p>
					
				</td>
			</tr>
			<tr>
				<td height="2"></td>
			</tr>
			<tr>
				<td id="navbg7" class="left_nav_closed" onClick="showsubmenu(7)"><div
						class="font1">报表管理</div></td>
			</tr>
			<tr id="submenu7" style="display: none">
				<td class="left_nav_bgshw tdbtmline" height="50">
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif">
						<a href="statreport/client_detail_month_per.jsp"
							target="main">分销明细</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif">
						<a href="statreport/client_level_chart.jsp"
							target="main">分销商级别</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif">
						<a href="statreport/client_stock_report.jsp"
							target="main">库存报表</a></img>
					</p>
					<p class="left_nav_link">
						<img src="images/left_nav_arrow.gif">
						<a href="statreport/flow_card_audit_report.jsp"
							target="main">审核报告</a></img>
					</p>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>