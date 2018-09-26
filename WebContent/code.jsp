<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>Hello</title>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<style type="text/css">
.error{
	color:red
}
</style>
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
$(function(){
	$("#registfrom").validate({
		rules:{
			"code":{"required":true,"number":true}
		},
		messages:{
			"code":{"required":"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 激活码不能为空",
								"number":"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 激活码是数字哦"}
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
						<h3>若无激活码输入0000</h3>
						<h3>若需要为vip请联系管理员</h3>
						<form action="${pageContext.request.contextPath}/UserAction_code"  method="post" id="registfrom">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="code" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入激活码">
							</div>
							<h3><label><font color="red">${error}</font></label></h3>
							<div class="mb2"><a class="act-but submit" href="#" onclick="submitform()" style="color: #FFFFFF">激活</a></div>
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