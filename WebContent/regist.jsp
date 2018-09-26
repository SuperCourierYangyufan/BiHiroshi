<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<style type="text/css">
.error{
	color:red
}
</style>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="css/component.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">

	function submitform(){
		$("#registfrom").submit();
	}
</script>



<script type="text/javascript">
//自定义校验规则
$.validator.addMethod(
	//规则的名称
	"checkUsername",
	//校验的函数
	function(value,element,params){
		//定义一个标志
		var flag = false;
		
		//value:输入的内容
		//element:被校验的元素对象
		//params：规则对应的参数值
		//目的：对输入的username进行ajax校验
		$.ajax({
			"async":false,
			"url":"${pageContext.request.contextPath}/UserAction_checkUsername",
			"data":{"user_Username":value},
			"type":"POST",
			"dataType":"json",
			"success":function(data){
				flag = data.isExist;
			}
		});
		
		
		//返回false代表该校验器不通过
		return flag;
	}
	
);
</script>
<script type="text/javascript">
$(function(){
	$("#registfrom").validate({
		rules:{
			"user_Username":{"required":true,"checkUsername":true},
			"user_password":{"required":true},
			"repassword":{"equalTo":"#user_password","required":true},
			"user_phone":{"rangelength":[6,14],"required":true},
			"user_email":{"email":true,"required":true}
		},
		messages:{
			"user_Username":{"required":"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 账号不能为空","checkUsername":"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 账号已存在"},
			"user_password":{"required":"<br/><br/> 密码不能为空"},
			"repassword":{"equalTo":"<br/><br/> 两次密码不相同",
						  "required":"<br/><br/> 密码不能为空"	},
			"user_phone":{"rangelength":"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 电话位数不对",
				"required":"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 电话不能为空"	},
			"user_email":{"email":"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 邮件格式不对",
						  "required":"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 邮件不能为空"}
			
		}
	});
});
</script>

<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>注册</h3>
						<form action="${pageContext.request.contextPath}/UserAction_add"  method="post" id="registfrom">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="user_Username" id="user_Username" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input id="user_password" name="user_password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="repassword" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请确认密码">
							</div>
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="user_phone" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入电话">
							</div>
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="user_email" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入邮箱">
							</div>
							<div class="mb2"><a class="act-but submit" href="#" onclick="submitform()" style="color: #FFFFFF">注册</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/TweenLite.min.js"></script>
		<script src="js/EasePack.min.js"></script>
		<script src="js/rAF.js"></script>
		<script src="js/demo-1.js"></script>
	</body>
</html>