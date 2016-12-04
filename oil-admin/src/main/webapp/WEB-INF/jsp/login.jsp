<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/public.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>爱K线运营管理系统</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="${ctx}/resources/plugins/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="${ctx}/resources/plugins/font-awesome/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="${ctx}/resources/plugins/ionicons/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${ctx}/resources/plugins/admin-lte2/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="${ctx}/resources/plugins/iCheck/square/blue.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="${ctx}/resources/plugins/html5/html5shiv.min.js"></script>
  <script src="${ctx}/resources/plugins/html5/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
		<div class="login-box">
				<div class="login-logo">
						<b>爱K线</b>运营管理平台
				</div>
				<!-- /.login-logo -->
				<div class="login-box-body">
						<p class="login-box-msg">填写账户名密码，登录运营管理平台</p>
						<form action="${ctx}/login" method="post">
								<div class="form-group has-feedback">
										<input type="text" id="username" name="username" class="form-control" placeholder="用户名"> <span class="glyphicon glyphicon-user form-control-feedback"></span>
								</div>
								<div class="form-group has-feedback">
										<input type="password" id="password" name="password" class="form-control" placeholder="密码"> <span class="glyphicon glyphicon-lock form-control-feedback"></span>
								</div>
								<div class="form-group has-feedback" id="sms" style="display:block;">
										<input type="text" name="captcha" class="form-control" placeholder="验证码"> 
										<input type="button" style="margin-top:5px;width:130px;" id="captcha" value="发送验证码" />
								</div>
								<div class="row">
										<div class="col-xs-8">
												<div class="checkbox icheck" >
														<label style="color:red" id="errorMessage"> <!-- <input type="checkbox" name="rememberMe" value="true"> 记住我 -->
														${errorMessage }
														</label>
												</div>
										</div>
										<!-- /.col -->
										<div class="col-xs-4">
												<button type="submit" id="sb" name="submit" class="btn btn-primary btn-block btn-flat">登录</button>
										</div>
										<!-- /.col -->
								</div>
						</form>
				</div>
				<!-- /.login-box-body -->
		</div>
		<!-- /.login-box -->
		<!-- jQuery 2.2.0 -->
		<script src="${ctx}/resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
		<!-- Bootstrap 3.3.6 -->
		<script src="${ctx}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
		<!-- iCheck -->
		<script src="${ctx}/resources/plugins/iCheck/icheck.min.js"></script>
		<script>
			$(function() {

				 
				
				 $('input').iCheck({
					checkboxClass : 'icheckbox_square-blue',
					radioClass : 'iradio_square-blue',
					increaseArea : '20%' // optional
				});
				$("#captcha").click(function(){
				 $.ajax({
							type : "post",
							url : "${ctx}/doCaptcha",
							dataType : "json",
							data : {date:new Date(),username:$("input[name='username']").val()},
							async : false,
							success : function(items) {
								 if(items.data == 1){
									 $("#errorMessage").text("请勿重复发送！");
									return false;
								 }
                                   if(!items.success){
                                	   alert('您的验证码已超过今日发送最大次数。如需登录，请联系管理员！');
                                	   $("#captcha").attr("disabled", true);
                                	   return;
                                   }
                            	   $("#captcha").attr("disabled", true);
                             	   var num = 180;
                                   var i = setInterval(function() {
                                       num --;
                                       $("#errorMessage").text("");
                                       $("#captcha").val("验证码已发送"+num+"s");
                                       
                                       if(num < 1){
                                    	   clearInterval(i);
                                    	   $("#captcha").attr("disabled", false);
                                		   $("#captcha").val("重新发送验证码");
                                       }
                                   }, 1000);
							}
						});
				});
				
			});
			
			 if (self != top) {
				top.location.reload();
			}
		</script>
</body>
</html>