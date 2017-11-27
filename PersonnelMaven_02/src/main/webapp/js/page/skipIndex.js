function skip(){
	var v=$("#skipIndex").val();
	if(v==""){
		alert("请填写跳转的页数");
		return ;
	}
	if(!/^[0-9]{1,}$/.test(v)){
		alert("请填写数字");
		return ;
	}
	v=parseInt(v); 
	var totle=parseInt($("#totle").val());
	if(v>0&&v<=totle){
		location.href=$("#url").val()+"?pageIndex="+v;
	}
	
}