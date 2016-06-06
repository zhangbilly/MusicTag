<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="zh-CN" ng-app="MusicTag">
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<meta name="renderer" content="webkit">
	<title>登录页</title>

	<!-- Bootstrap -->
	<link href="${ctx}/trd/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/css/common.css" rel="stylesheet">
	<link href="${ctx}/css/login.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body ng-controller="LoginFormController">
	<script>var ctx = "${ctx}";</script>
	<div class="container vertical-center">
		<div class="row">
			<div class="col-md-6 col-md-offset-3 panel panel-default">
				<div id="messages" ng-show="message">{{ message }}</div>
				<form name="loginForm" class="form-horizontal" ng-submit="processForm()" novalidate>
					<h1 class="text-center">登录</h1>
					<div class="form-group">
						<label for="userName" class="col-md-2 control-label">用户名</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="userName" placeholder="请输入用户名" ng-model="formData.username" required ng-minlength="2" ng-maxlength="18">
							<span class="help-block" ng-show="errorName">{{ errorName }}</span>
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-md-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
						<div class="col-md-9">
							<input type="password" class="form-control" id="password" placeholder="请输入密码" ng-model="formData.password" required>
							<span class="help-block" ng-show="errorName">{{ errorName }}</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-2 col-md-5">
							<div class="checkbox">
								<label>
									<input type="checkbox" id="rememberMe" name="rememberMe" ng-model="formData.rememberme">记住我</label>
							</div>
						</div>
												<div class="col-md-5">
							<div class="checkbox">
								<label>
									<a href="{{ctx}}/register">立即注册</a>
									</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-2 col-md-10">
							<button type="submit" class="btn btn-default" ng-disabled="loginForm.$invalid">
								<span class="glyphicon glyphicon-flash"></span>
								Sign in
							</button>
						</div>
					</div>
				</form>

			</div>
			<!-- //main content -->
		</div>
		<!-- //row -->
	</div>
	<!-- //container -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ctx}/trd/jquery/jquery-2.2.0.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/trd/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script src="${ctx}/trd/angular-1.4.8/angular.min.js"></script>
	<script src="${ctx}/trd/angular-ui/angular-ui-router.js"></script>
	<script src="${ctx}/trd/angular-ui/ui-bootstrap-1.2.4.min.js"></script>
	<script src="${ctx}/js/services.js"></script>
	<script src="${ctx}/trd/angular-ui/angular-ui-router.js"></script>
	<script src="${ctx}/js/login.js"></script>
	<script src="${ctx}/trd/jsSHA-2.0.1/sha1.js"></script>
	<!-- 截图-->
	<script src="${ctx}/trd/ngImgCrop/ng-img-crop.js"></script>
</body>
</html>