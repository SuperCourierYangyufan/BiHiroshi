<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="mountainbg">
        <div class="mountaincover">
            <div class="mountain">
                <div class="mountain-top">
                    <div class="mountain-cap-1"></div>
                    <div class="mountain-cap-2"></div>
                    <div class="mountain-cap-3"></div>
                </div>
            </div>
            <div class="mountain-two">
                <div class="mountain-top">
                    <div class="mountain-cap-1"></div>
                    <div class="mountain-cap-2"></div>
                    <div class="mountain-cap-3"></div>
                </div>
            </div>
            <div class="mountain-three">
                <div class="mountain-top">
                    <div class="mountain-cap-1"></div>
                    <div class="mountain-cap-2"></div>
                    <div class="mountain-cap-3"></div>
                </div>
            </div>
            <div class="cloud"></div>
            <div class="hot-air-balloon"><img src="images/bicycle.png" alt=""></div>
        </div>
    </div>
    <!-- END MOUNTAIN EFFECT -->
    <div id="inner">
        <div id="content">
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <div class="box1">
                            <header>
                                <!-- START LOGO -->
                                <div class="logo_wrapper">
                                    <a href="about.html" class="logo"><img src="images/logo.png" alt="Kinder Garten Logo"></a>
                                </div>
                                <!-- END LOGO -->
                            </header>
                            <!-- START NAVIGATION MENU -->
                            <nav>
                                <div class="menu_wrapper">
                                    <div class="navbar navbar_">
                                        <div class="navbar-inner navbar-inner_">
                                            <a class="btn btn-navbar btn-navbar_" data-toggle="collapse" data-target=".nav-collapse_"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a>
                                            <div class="nav-collapse nav-collapse_ collapse">
                                                <ul class="nav sf-menu clearfix">
                                                    <li class="active"><a href="${pageContext.request.contextPath}/HomeAction_homeList">主页<span class="over1"></span></a></li>
                                                        <li><a href="regist.jsp">注册<span class="over1"></span></a></li>
                                                        <li><a href="login.jsp">登入<span class="over1"></span></a></li>
                                                        <li><a href="${pageContext.request.contextPath}/Message_messagelist">留言板<span class="over1"></span></a></li>
                                                        <li><a href="${pageContext.request.contextPath}/DynamicAction_toDynamic">我的动态<span class="over1"></span></a></li>
                                                        <li><a href="${pageContext.request.contextPath}/UserAction_tologin">我的信息<span class="over1"></span></a></li>
                                                        <li><a href="about.html">网站管理<span class="over1"></span></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </nav>
                            <!-- END NAVIGATION MENU -->
                        </div>
                    </div>
                    <div class="span8 offset1">
                        <!-- START CAROUFREDSEL SLIDER -->
                        <div class="box2">
                            <div class="caroufredsel_slider1_wrapper">
                                <a class="prev1" href="about.html#"></a>
                                <a class="next1" href="about.html#"></a>
                                <ul id="caroufredsel_slider1" class="clearfix">
                                    <li>
                                        <div class="caroufredsel_slide1"> <img  src="images/home/index01.jpg" alt="Slider2" class="img">
                                            <div class="txt1">Spring</div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="caroufredsel_slide1"> <img  src="images/home/index02.jpg" alt="Slider2" class="img">
                                            <div class="txt1">Struts2</div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="caroufredsel_slide1"> <img  src="images/home/index03.jpg" alt="Slider3" class="img">
                                        	 <div class="txt1">Hibernate</div>	
                                        </div>
                                    </li>
                                </ul>
                                <div class="pagination1" id="caroufredsel_pag1"></div>
                            </div>
                        </div>
                        <!-- END CAROUFREDSEL SLIDER -->
                    </div>
                </div>
            </div>
        </div>