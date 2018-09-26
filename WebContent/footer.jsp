<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

                            <!-- END OUR TEACHER -->
                            <div class="divider1"></div>
                            <!-- START OUR CLIENTS -->
                            <h3>联系方式</h3>
                            <ul class="thumbnails thumbnails1">
                                <li>
                                    <div class="thumbnail clearfix">
                                        <div class="client1">
                                            <a href="#">
                                                <div class="client1_inner">
                                                    <div class="c1">
                                                        <div class="txt2">杨宇帆
                                                            <p>学生</p>
                                                            <div class="divider2"></div>
                                                            <p><i class="icofont icofont-phone"></i> +18827421758
                                                                <br />852287099@qq.com</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </li>
                                
                            </ul>
                            <!-- END OUR TEACHER -->
                        </div>
                    </div>
                    <div class="span4">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- START TESTIMONIALS -->
                                <div class="testimonials">
                                    <div class="testimonials_title">留言</div>
                                    <div class="testimonials_wrapper">
                                        <a class="prev_testimonials" href="about.html#" style="display: block;"></a>
                                        <a class="next_testimonials" href="about.html#" style="display: block;"></a>
                                        <div class="caroufredsel_wrapper" style="display: block; text-align: start; float: none; position: relative; top: auto; right: auto; bottom: auto; left: auto; z-index: auto; width: 770px; height: 160px; margin: 0px; overflow: hidden; cursor: move;">
                                            <ul id="testimonials" class="clearfix" style="text-align: left; float: none; position: absolute; top: 0px; right: auto; bottom: auto; left: 0px; margin: 0px; width: 5390px; height: 160px; z-index: auto;">
                                               <!--  <li>
                                                    <div class="testimonial1">
                                                        <div class="txt1">Enutnim ad minim veniam, quisnos truder exercitation ullamco eitr tempor didunt.</div>
                                                        <div class="txt2">
                                                            <div class="txt2_inner">Micheal Smith
                                                                <br>Parent</div>
                                                        </div>
                                                    </div>
                                                </li> -->
                                                <s:iterator value="#session.messageList" var="message">
                                                	<li>
	                                                    <div class="testimonial1">
	                                                        <div class="txt1"><s:property value="#message.message_text"/> </div>
	                                                        <div class="txt2">
	                                                            <div class="txt2_inner">
	                                                            <s:if test="#message.user.user_name!=null">
	                                                            	<s:property value="#message.user.user_name"/>
	                                                            </s:if>
	                                                            <s:else>
	                                                            	<s:property value="#message.user.user_Username"/>
	                                                            </s:else>
	                                                            
	                                                            
	                                                            
	                                                                <br><s:property value="#message.message_time"/></div>
	                                                        </div>
	                                                    </div>
                                               		 </li>
                                                </s:iterator>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <!-- END TESTIMONIALS -->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <!-- START ANNOUNCEMENTS -->
                                <div class="announcements">
                                    <div class="announcements_title">用户</div>
                                    <!-- <div class="thumb1">
                                        <div class="thumbnail clearfix">
                                            <figure><img src="images/teacher/d.jpg" alt="Aliquam erat volutpat" class="news_img"></figure>
                                            <div class="caption">
                                                <h5><a href="#">Aliquam erat</a></h5>
                                                <p> Veniam, quis nostrud exercitation ullamco labor. </p>
                                            </div>
                                        </div>
                                    </div> -->
                                   	<s:iterator value="#session.userList" var="usertable">
                                   		<div class="thumb1">
	                                        <div class="thumbnail clearfix">
	                                            <figure><img src="${pageContext.request.contextPath}/portrait/<s:property value='#usertable.user_img'/>" alt="此用户暂无头像" class="news_img"></figure>
	                                            <div class="caption">
	                                                <h4><font color="pink"><s:property value="#usertable.user_name"/></font> </h4>
	                                                <p> <s:property value="#usertable.user_signature"/></p>
	                                            </div>
	                                        </div>
                                   		</div> 
                                   	
                                   	</s:iterator>
                                </div>
                                <!-- END ANNOUNCEMENTS -->
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <!-- START SCHOOL CLASSES -->
                                	<div class="school-classes">
                                    <div class="school-classes_title">最新动态</div>
                                   <!--  <div class="date2 clearfix">
                                        <div class="txt1 ">1</div>
                                        <div class="txt2">
                                            <p>Maecenas ac liquam erat.</p>
                                        </div>
                                    </div> -->
                                    
                                    <s:iterator value="#session.dynamiclist" var="dynamic"  status="myid" >
                                    <div class="date2 clearfix">
                                        <div class="txt1 "> <s:property value="#myid.index+1"/> </div>
                                        <div class="txt2">
                                            <p>  <a href="${pageContext.request.contextPath}/DynamicAction_showDynamic?dynamic_id=<s:property value="#dynamic.dynamic_id" />"><s:property value="#dynamic.dynamic_title"/> </a> </p>
                                        </div>
                                    </div> 
                                    </s:iterator>
                                    
                                </div>
                                <!-- END SCHOOL CLASSES -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- START FOOTER -->
        <footer>
            <div class="social_wrapper">
                <ul class="social clearfix">
                    <li><a href="about.html#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="about.html#"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="about.html#"><i class="fa fa-instagram"></i></a></li>
                    <li><a href="about.html#"><i class="fa fa-youtube"></i></a></li>
                    <li><a href="about.html#"><i class="fa fa-pinterest"></i></a></li>
                </ul>
            </div>
            <div class="copyright">YangYuFan © 2018</div>
        </footer>
        <!-- END FOOTER -->
    </div>