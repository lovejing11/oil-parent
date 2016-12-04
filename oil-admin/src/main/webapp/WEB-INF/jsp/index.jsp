<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱K线-运营管理系统</title>
<%@ include file="/WEB-INF/jsp/include/include_css.jsp"%>
<style type="text/css">
.sidebar-menu .treeview-menu {
    padding-left: 30px;
}



.menu-tree-checked a{
	color: #00c0ef!important;
	font-size: 16px!important;
}
</style>
</head>
<body class="sidebar-mini skin-red-light wysihtml5-supported">
	<div class="wrapper">
		<header class="main-header">
			<a href="${ctx}/index" class="logo"> <span class="logo-mini">爱<b>K</b>线
			</span> <span class="logo-lg">爱<b>K</b>线 运营管理平台
			</span>
			</a>
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- <li class="dropdown messages-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i class="fa fa-envelope-o"></i>
								<span class="label label-success msgNum">1</span>
						    </a> 
							 <ul class="dropdown-menu">
								<li class="header">您有<em class="msgNum">1</em>条消息
								</li>
								<li>
									<ul class="menu">
										<li><a href="#"> <div class="pull-left">
													 <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image"> 
													小图标
												</div>
												<h4>
													系统消息 <small><i class="fa fa-clock-o"></i> 2016-04-20</small>
												</h4>
												<p>有新用户注册</p>
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">查看所有消息</a></li>
							</ul></li>-->
							
							
						<!-- Notifications: style can be found in dropdown.less -->
						<!-- <li class="dropdown notifications-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i class="fa fa-bell-o"></i>
								<span class="label label-warning">10</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">您有<em>0</em>条通知
								</li>
								<li>
									inner menu: contains the actual data
									<ul class="menu">
										<li><a href="#"> <i class="fa fa-users text-aqua"></i> 通知1
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">查看所有</a></li>
							</ul></li> -->
						<!-- Tasks: style can be found in dropdown.less -->
						
						<!-- <li class="dropdown tasks-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <i class="fa fa-flag-o"></i> <span
								class="label label-danger taskNum">9</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">您有<em class="taskNum">9</em>项任务待处理
								</li>
								<li>
									inner menu: contains the actual data
									<ul class="menu">
										<li><a href="#">
												<h3>
													会员审核 <small class="pull-right">3</small>
												</h3>
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">查看所有任务</a></li>
							</ul></li> -->
							
							
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> <!--  <img
								src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image"> --> <span class="hidden-xs">${user.userCode }</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header">
									<!-- <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image"> -->
									<p>
										${user.userCode } - 运营经理 <small>入驻时间：${user.createTime }</small>
									</p>
								</li>
								<!-- Menu Body -->
								<li class="user-body">
									<div class="row">
										<div class="col-xs-4 text-center"><a  data-toggle="modal" href="${ctx}/system/user/modifyPassword/${user.id }" data-target="#modal" class="btn btn-default btn-flat">修改密码</a></div>
										<!-- <div class="col-xs-4 text-center">入口2</div>
										<div class="col-xs-4 text-center">入口3</div> -->
									</div>
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<%-- <a  data-toggle="modal" href="${ctx}/system/user/edit/${user.id }" data-target="#modal" class="btn btn-default btn-flat">修改个人信息</a> --%>
									</div>
									<div class="pull-right">
										<a href="${ctx}/logout" class="btn btn-default btn-flat">退出</a>
									</div>
								</li>
							</ul></li>
						<!-- <li><a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a></li> -->
					</ul>
				</div>
			</nav>
		</header>

		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
							
							
							
							<li class="active item">
											<a href="/report/workbench/dashboard" target="contentFrame"> 
														<i class="fa fa-dashboard"></i> 
														<span>工作台</span>
											</a>
							</li>
									<li class="treeview">
											<a href="#"> 
														<i class="fa fa-cogs"></i> 
														<span>系统配置</span> 
														<i class="fa fa-angle-left pull-right"></i>
											</a>
											<ul class="treeview-menu">
															<li class="item">
																		<a href="/system/property/all" target="contentFrame">
																						<i class="fa fa-circle-o"></i>系统参数设置
																		</a>
															</li>
											</ul>
									</li>
									<li class="treeview">
											<a href="#"> 
															<i class="fa fa-laptop"></i> 
															<span>系统管理</span> 
															<i class="fa fa-angle-left pull-right"></i>
											</a>
											<ul class="treeview-menu">
																	<li class="item">
																				<a href="/system/user/list" target="contentFrame">
																								<i class="fa fa-circle-o"></i>系统账号管理
																				</a>
																	</li>
																	<li class="item">
																				<a href="/system/resource/list" target="contentFrame">
																								<i class="fa fa-circle-o"></i>菜单资源
																				</a>
																	</li>
																	<li class="item">
																				<a href="/system/role/list" target="contentFrame">
																								<i class="fa fa-circle-o"></i>角色管理
																				</a>
																	</li>
											</ul>
									</li>
									<li class="treeview">
											<a href="#"> 
														<i class="fa fa-th-large"></i> 
														<span>运营设置</span> 
														<i class="fa fa-angle-left pull-right"></i>
											</a>
											<ul class="treeview-menu">
														 <li class="item">
																	<a href="/platform/config/company/list" target="contentFrame">
																						<i class="fa fa-circle-o"></i>企业管理
																	</a>
															</li>
											</ul>
									</li>
									<li class="treeview">
											<a href="#"> 
															<i class="fa fa-square"></i> 
															<span>运营管理</span> 
															<i class="fa fa-angle-left pull-right"></i>
											</a>
											<ul class="treeview-menu">
															<li class="item">
																			<a href="/platform/member/message/list" target="contentFrame">
																						<i class="fa fa-circle-o"></i>消息管理
																			</a>
															</li>
											</ul>
									</li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				  <h1>
					<label id="menuText">爱K线</label> <small>运营管理平台</small>
				</h1> 
				<ol class="breadcrumb" id="nav-list">
					<li class="real"><a href="./index"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li class="item"><a href="${ctx}/report/workbench/dashboard" target="contentFrame">工作台</a></li>
				</ol>
			</section>
			
			<iframe id="contentFrame" frameborder="0" name="contentFrame" src="${ctx}/report/workbench/dashboard" width="100%" height="100%" allowtransparency="true"
				style="">您的浏览器不支持嵌入式框架，或者当前配置为不显示嵌入式框架。 </iframe>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/jsp/include/include_js.jsp"%>
<script type="text/javascript">
	$(function() {
		$(".sidebar-menu .item").click(function() {
			$(".breadcrumb .real").nextAll().remove();
			$("#menuText").html($(this).text())

			$(".breadcrumb").append(
					"<li class='active'>" + $(this).text() + "</li>");
			
			$(".sidebar-menu .item").removeClass("menu-tree-checked");
			$(this).addClass("menu-tree-checked");
		});
		
		$('.sidebar-menu .treeview').each(function() {
			var $this = $(this);
			if ($this.find('a span').text() == "系统配置") {
				$this.find('a i:first').addClass('fa-cogs');
			} else if ($this.find('a span:first').text() == "系统管理") {
				$this.find('a i:first').addClass('fa-laptop');
			} else if ($this.find('a span:first').text() == "运营设置") {
				$this.find('a i:first').addClass('fa-th-large');
			} else if ($this.find('a span:first').text() == "运营管理") {
				$this.find('a i:first').addClass('fa-square');
			} else if ($this.find('a span:first').text() == "直播间管理") {
				$this.find('a i:first').addClass('fa-video-camera');
			} else if ($this.find('a span:first').text() == "客服管理") {
				$this.find('a i:first').addClass('fa-phone-square');
			} else if ($this.find('a span:first').text() == "财务管理") {
				$this.find('a i:first').addClass('fa-rmb');
			} else if ($this.find('a span:first').text() == "统计分析") {
				$this.find('a i:first').addClass('fa-bar-chart');
			} else if ($this.find('a span:first').text() == "腾讯点播") {
				$this.find('a i:first').addClass('fa-qq');
			}else if ($this.find('a span:first').text() == "对象存储服务") {
				$this.find('a i:first').addClass('fa-send');
			}else if ($this.find('a span:first').text() == "精彩回放") {
				$this.find('a i:first').addClass('fa-history');
			}
		});
		
		

	});
	
</script>
<%@ include file="/WEB-INF/jsp/include/include_modal.jsp"%>
</html>