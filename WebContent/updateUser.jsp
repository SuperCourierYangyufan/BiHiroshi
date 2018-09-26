<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="images/favicon.png" type="image/png">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Baloo+Bhaijaan" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Didact+Gothic" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/bootstrap-responsive.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/font-awesome.css" type="text/css" media="screen">
    
    
    <!-- JS -->
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="js/superfish.js"></script>
    <script type="text/javascript" src="js/jquery.ui.totop.js"></script>
    <script type="text/javascript" src="js/jquery.caroufredsel.js"></script>
    <script type="text/javascript" src="js/jquery.touchSwipe.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script>
        // CAROUFSEDSEL SLIDER 1 
        $(document).ready(function () {
            $('#caroufredsel_slider1').carouFredSel({
                auto: {
                    timeoutDuration: 9000
                }
                , responsive: true
                , direction: "left"
                , width: '100%'
                , scroll: {
                    items: 1
                    , duration: 1000
                    , easing: "easeOutExpo"
                    , fx: "fade"
                }
                , items: {
                    width: '1000'
                    , height: 'variable'
                    , visible: {
                        min: 1
                        , max: 1
                    }
                }
                , mousewheel: false
                , swipe: {
                    onMouse: true
                    , onTouch: true
                }
                , pagination: ".pagination1"
            });
            // CAROUFSEDSEL SLIDER 2
            $('#slider2 .carousel.main ul').carouFredSel({
                auto: {
                    timeoutDuration: 8000
                }
                , responsive: true
                , prev: '.prev3'
                , next: '.next3'
                , width: '100%'
                , scroll: {
                    items: 1
                    , duration: 1000
                    , easing: "easeOutExpo"
                }
                , items: {
                    width: '400'
                    , height: 'variable', //	optionally resize item-height			  
                    visible: {
                        min: 1
                        , max: 3
                    }
                }
                , mousewheel: false
                , swipe: {
                    onMouse: true
                    , onTouch: true
                }
            });
            $(window).bind("resize", updateSizes_vat).bind("load", updateSizes_vat);

            function updateSizes_vat() {
                $('#caroufredsel_slider1').trigger("updateSizes");
                $('#slider3 .carousel.main ul').trigger("updateSizes");
            }
            updateSizes_vat();
        });
        $(window).load(function () {});
        // TESTIMONIALS
        $(document).ready(function () {
            $('#testimonials').carouFredSel({
                auto: {
                    timeoutDuration: 8000
                }
                , responsive: true
                , prev: '.prev_testimonials'
                , next: '.next_testimonials'
                , width: '100%'
                , scroll: {
                    items: 1
                    , duration: 1000
                    , easing: "easeOutExpo"
                }
                , items: {
                    width: '1000'
                    , height: 'variable'
                    , visible: {
                        min: 1
                        , max: 1
                    }
                }
                , mousewheel: false
                , swipe: {
                    onMouse: true
                    , onTouch: true
                }
            });
            $(window).bind("resize", updateSizes_vat).bind("load", updateSizes_vat);

            function updateSizes_vat() {
                $('#testimonials').trigger("updateSizes");
            }
            updateSizes_vat();
        });
        $(window).load(function () {});
    </script>
</head>

<body class="main">
		<!-- 引入头 -->
   		<jsp:include page="/head.jsp"></jsp:include>
   	
   	
        <div class="pages_wrapper">
            <div class="container">
                <div class="row">
                    <div class="span8">
                        <div class="pages">
                            <!-- START ABOUT US -->
                            <div>
                            	<h3 style="margin-left: 230px">修改用户</h3>
                            </div>
                           <!--
								 <p>Wuqsum dolor sit amet conse ctetur adipisicing elit, sed do eiusmod tempor incididunt ut labore dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip exea commodo consequat consectetuer adipiscing elitarcu. </p>
                            <p>Aenean semper aliquet libero. Qupsum dolor sit amet conse ctetur adipisicing elit, sed do eius tempor incididunt ut laboreet dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exer citation ullamco laboris nisiut aliquip exea commodo consequat consectetuer adipiscing elit. Nuncmurat suscipit convallis non, cursus sed, dignissim etest.</p>
                           -->
                            <!-- END ABOUT US -->
                            <div class="divider1"></div>
                            <!-- START OUR TEACHER -->
                                <!--
								添加信息
                            -->
                       		<div style="margin-right:100px;">
						   		<form action="${pageContext.request.contextPath}/UserAction_updateUsername" method="post" enctype="multipart/form-data">
						   			<table>
										<tr>
											<td ><h4>昵称:</h4></td>
											<td style="margin-left: 60px"> <input type="text" name="user_name" class="form-control" id="exampleInputEmail1" placeholder="昵称" style="height: 25px" value="<s:property value='#session.user.user_name' />"></td>
										</tr>
										<tr>
											<td ><h4>电话:</h4></td>
											<td style="margin-left: 60px"> <input type="text" name="user_phone" class="form-control" id="exampleInputEmail1" placeholder="电话" style="height: 25px" value="<s:property value='#session.user.user_phone' />"></td>
										</tr>
										<tr>
											<td ><h4>邮箱:</h4></td>
											<td style="margin-left: 60px"> <input type="text" name="user_email" class="form-control" id="exampleInputEmail1" placeholder="邮箱" style="height: 25px" value="<s:property value='#session.user.user_email' />"></td>
										</tr>
										<tr>
											<td ><h4>签名:</h4></td>
											<td style="margin-left: 60px"> <input type="text" name="user_signature" class="form-control" id="exampleInputEmail1" placeholder="签名" style="height: 25px;width: 350px" value="<s:property value='#session.user.user_signature' />"></td>
										</tr>
										<tr>
											<td ><h4>头像:</h4></td>
											<td style="margin-left: 60px"> <input type="file" name="portrait"></td>
										</tr>
										<tr >
											<td><input type="hidden" name="user_id" value="<s:property value="#session.user.user_id" />" /></td>	
											<td ><button type="submit" class="btn btn-info">提交修改</button></td>
										</tr>
									</table>
								</form>
						   	</div>
                       
                            
                            
                            
                           
                       
                      <!-- 引入尾巴 -->
                      <jsp:include page="/footer.jsp"></jsp:include>      
                            
                            
</body>>
</html>