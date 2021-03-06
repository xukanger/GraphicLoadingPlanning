<%@ page import="com.just.yt.project.services.ResParams.PercentCalculateData" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>媒体资源管理器</title>
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="<%=request.getContextPath()%>/css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<!-- end: CSS -->
	

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="<%=request.getContextPath()%>/css/ie.css" rel="stylesheet">
	<![endif]-->
	
	<!--[if IE 9]>
		<link id="ie9style" href="<%=request.getContextPath()%>/css/ie9.css" rel="stylesheet">
	<![endif]-->
		
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon.ico">
	<!-- end: Favicon -->
	
		
		
		
</head>

<body>
		<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="<%=request.getContextPath()%>/index.jsp"><span>Metro</span></a>
								
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						
						
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i> ${sessionScope.user.account_name}
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
 									<span>Account Settings</span>
								</li>
								<li><a href="<%=request.getContextPath()%>/user/profile"><i class="halflings-icon user"></i> Profile</a></li>
								<li><a href="<%=request.getContextPath()%>/static/login.html"><i class="halflings-icon off"></i> Logout</a></li>
							</ul>
						</li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->
				
			</div>
		</div>
	</div>
	<!-- start: Header -->
	
		<div class="container-fluid-full">
		<div class="row-fluid">
				
			<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li><a href="<%=request.getContextPath()%>/index.jsp"><i class="icon-bar-chart"></i><span class="hidden-tablet"> 主页</span></a></li>
						<li>
							<a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> 计划</span><span class="label label-important"> 3 </span></a>
							<ul>
								<s:if test="#session.user.userGroup.name == 'designer'">
									<li><a class="submenu" href="<%=request.getContextPath()%>/view/plan/addorprofile.jsp"><i class="icon-file-alt"></i><span class="hidden-tablet"> 添加</span></a></li>
								</s:if>
								<li><a class="submenu" href="<%=request.getContextPath()%>/plan/list"><i class="icon-file-alt"></i><span class="hidden-tablet"> 列表</span></a></li>
							</ul>
						</li>
						<li>
							<a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet">媒体资源</span><span class="label label-important">  </span></a>
							<ul>
								<li><a class="submenu" href="<%=request.getContextPath()%>/resource/list"><i class="icon-file-alt"></i><span class="hidden-tablet"> 列表</span></a></li>
							</ul>
						</li>
						<s:if test="#session.user.userGroup.name == 'admin'">
							<li><a href="<%=request.getContextPath()%>/user/list"><i class="icon-list-alt"></i><span class="hidden-tablet"> 用户</span></a></li>
						</s:if>

						
					</ul>
				</div>
			</div>
			<!-- end: Main Menu -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<!-- start: Content -->
			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="<%=request.getContextPath()%>/index.jsp">Home</a>
					<i class="icon-angle-right"></i>
				</li>
			</ul>

			

			<div class="row-fluid">	
				<s:if test="#session.user.userGroup.name == 'admin'">
				<a class="quick-button metro yellow span2">
					<i class="icon-group"></i>
					<p>用户</p>
					<span class="badge">${sessionScope.usercount}</span>
				</a>
				</s:if>
				<a class="quick-button metro red span2">
					<i class="icon-comments-alt"></i>
					<p>计划</p>
					<span class="badge">${sessionScope.plansize}</span>
				</a>
				<a class="quick-button metro green span2" href="<%=request.getContextPath()%>/resource/list">
					<i class="icon-barcode"></i>
					<p>媒体资源</p>
					<span class="badge">${sessionScope.mediacount}</span>
				</a>
				<div class="clearfix"></div>
								
			</div><!--/row-->

			<br/>

			<div class="row-fluid hideInIE8 circleStats">
				<%PercentCalculateData data=(PercentCalculateData)session.getAttribute("mediapercent");%>
				<div class="span2" onTablet="span4" onDesktop="span2">
                	<div class="circleStatsItemBox yellow">
						<div class="header">媒体资源总使用率</div>
						<span class="percent">percent</span>
						<div class="circleStat">
                    		<input type="text" value="<%=data.getCount()%>" class="whiteCircle" />
						</div>		
						<div class="footer">
							<span class="count">
								<span class="number"><%=data.getSum()%></span>
								<span class="unit"></span>
							</span>
							<span class="sep"> / </span>
							<span class="value">
								<span class="number"><%=data.getSum()%></span>
								<span class="unit"></span>
							</span>	
						</div>
                	</div>
				</div>


			</div>
						
			<div class="row-fluid">
				
				<div class="widget blue span5" onTablet="span6" onDesktop="span5">
					
					<h2><span class="glyphicons globe"><i></i></span> Demographics</h2>
					
					<hr>

					<div class="content">

						<div class="verticalChart">
							<s:iterator value="#session.medialist" var="v">
								<div class="singleBar">

									<div class="bar">

										<div class="value">
											<span><s:property value="#v.percent*100"/>%</span>
										</div>

									</div>

									<div class="title"><s:property value="#v.name"/></div>

								</div>
							</s:iterator>




							<div class="clearfix"></div>

						</div>

					</div>

				</div><!--/span-->

	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->

	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			<a href="#" class="btn btn-primary">Save changes</a>
		</div>
	</div>
	
	<div class="clearfix"></div>
	
	<footer>

		<p>
			<span style="text-align:left;float:left">&copy; 2016 </span>
			
		</p>

	</footer>
	
	<!-- start: JavaScript-->

		<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/jquery-migrate-1.0.0.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery-ui-1.10.0.custom.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.ui.touch-punch.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/modernizr.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.cookie.js"></script>
	
		<script src='<%=request.getContextPath()%>/js/fullcalendar.min.js'></script>
	
		<script src='<%=request.getContextPath()%>/js/jquery.dataTables.min.js'></script>

		<script src="<%=request.getContextPath()%>/js/excanvas.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.flot.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.flot.pie.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.flot.stack.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.flot.resize.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.chosen.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.uniform.min.js"></script>
		
		<script src="<%=request.getContextPath()%>/js/jquery.cleditor.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.noty.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.elfinder.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.raty.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.iphone.toggle.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.uploadify-3.1.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.gritter.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.imagesloaded.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.masonry.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.knob.modified.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/jquery.sparkline.min.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/counter.js"></script>
	
		<script src="<%=request.getContextPath()%>/js/retina.js"></script>

		<script src="<%=request.getContextPath()%>/js/custom.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>
