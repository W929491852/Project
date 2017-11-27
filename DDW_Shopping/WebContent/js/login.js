// JavaScript Document

/*邮箱获取焦点*/
function emailFocus(){
	var email=document.getElementById("email");
	email.className="login_content_input login_content_input_Focus";
	}
	
/*邮箱失去焦点*/	
function emailBlur(){
	var email=document.getElementById("email");
		email.className="login_content_input";
		}
		
/*密码获取焦点*/
function pwdFocus(){
	var pwd=document.getElementById("pwd");
	pwd.className="login_content_input login_content_input_Focus";
	}
	
/*密码失去焦点*/	
function pwdBlur(){
	var pwd=document.getElementById("pwd");
		pwd.className="login_content_input";
		}
/*检查登录，邮箱和密码必须输入*/
function checkLogin(){
	var email=document.getElementById("email").value;
	var pwd=document.getElementById("pwd").value;
	if(email==""){
		alert("请输入邮箱");
		return false;
		}
	if(pwd==""){
		alert("请输入密码");
		return false;
		}
	return true;
	}
	
/*跳转到注册页面*/
function jump(){
	window.location.href="register.jsp";
	}