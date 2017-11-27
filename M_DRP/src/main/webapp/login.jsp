<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>login.html</title>
	 <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	 <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			/* $('#pl').dialog({
				iconCls:'images/spacer.gif',
				width:400,
				height:150,
				title: '登陆',
				closable: false
			}); */
			
			$("#login_btn").click(function(){
				var flag = false;
				var username = $("#userName").val();
				alert(username);
				if(!username.length > 0){
					flag = true;
					$("#userIdSpan").html("<font color='red'>用户代码不能为空</font>");
				}
				var pwd = $("#pwd").val();
				alert(pwd);
				if(!pwd.length > 0){
					flag = true;
					$("#passwordSpan").html("<font color='red'>密码不能为空</font>");
				}
				if (!flag) {
					$("#loginForm").submit();
				}
			});
		});
		
	function loadimage(){
		document.getElementById("randImage").src="images/image.jsp?"+Math.random();
	}
		
	</script>
  </head>
  
  <body>
  	<div id="pan" style="width: 100%;height: 100%;margin: 0 auto;">
	    <div id="pl">
	    	<form action="login.do" id="loginForm" method="post">
	    	<table style="margin: auto auto;">
	    		<tr>
					<td align="left">
						<FONT face="verdana, arial, helvetica, sans-serif"
							size="-1">用户名:&nbsp;</FONT>
					</td>
					<td align="left">
						<INPUT type="text" name="username" id="userName"  size="20" maxlength="20">
						<span id="userIdSpan"></span>
					</td>
				</tr>
				<tr>
					<td align="left">
						<FONT face="verdana, arial, helvetica, sans-serif"
							size="-1">密&nbsp&nbsp&nbsp码:</FONT>
					</td>
					<td align="left">
						<INPUT name="password" id="pwd" type="password" size="21"
							maxlength="20"><span id="passwordSpan"></span>
					</td>
				</tr>
				<tr>
					<td align="left">
						<FONT face="verdana, arial, helvetica, sans-serif"
							size="-1">验证码：</FONT>
					</td>
					<td align="left">
						<input type="text" value="${imageCode }" name="imageCode" class="txtCode" id="imageCode" size="10" onkeydown= "if(event.keyCode==13)form1.submit()"/>&nbsp;
						&nbsp;
						<img onclick="javascript:loadimage();" title="换一张试试" name="randImage" id="randImage" src="images/image.jsp" width="60" height="20" border="1" align="absmiddle">
					</td>
				</tr>
				<tr>
					<td align=right colSpan="2">
					<table cellSpacing="0" cellPadding="0" border="0">
						<tbody>
							<tr>
								<td>
									<input type="submit" value="提交" />
									<!-- <a id="login_btn" class="easyui-linkbutton" style="background-image:images/login_button.gif;width:71px; border:0px;">Login in</a> -->
								</td>
							</tr>
						</tbody>
					</table>
				</td>
				</tr>
	    	</table>
	    	</form>
	    </div>
  	</div>
  </body>
</html>
