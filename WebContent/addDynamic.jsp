<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                            	<h3 style="margin-left: 210px">添加动态</h3>
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
						   		<form action="${pageContext.request.contextPath}/DynamicAction_add" method="post" enctype="multipart/form-data">
						   				<input type="text" name="dynamic_title" class="form-control" id="exampleInputName2" placeholder="标题" style="margin-left: 110px;height: 25px;width: 350px">
						   				<textarea name="dynamic_InputText" class="form-control" rows="3" style="height: 550px; width: 600px;" ></textarea><br />
						   			<div style="margin-left:235px">
						   				<h5>选择动态图片</h5>
						   			</div>
						   			<div style="margin-left: 257px">
						   				<input type="file" name="photoFile">
						   			</div>
						   			<div style="margin-left: 260px;margin-top: 2px">
						   				<button type="submit" class="btn btn-info">提交</button>
						   			</div>
								</form>
						   	</div>
                       
                            
                            
                            
                           
                       
                      <!-- 引入尾巴 -->
                      <jsp:include page="/footer.jsp"></jsp:include>      
                            
                            
</body>>
</html>