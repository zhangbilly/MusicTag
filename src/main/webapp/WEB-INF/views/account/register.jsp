<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-CN" ng-app="MusicTag">
<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<meta name="renderer" content="webkit">
	<title>注册</title>

	<!-- Bootstrap -->
	<link href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="${ctx}/static/css/common.css" rel="stylesheet">
	<link href="${ctx}/static/css/register.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>

<body ng-controller="RegisterController">
	<div class="container vertical-center">
		<script>var ctx = "${ctx}";</script>
		<div class="row">
			<div class="col-md-6 col-md-offset-3 panel panel-default">
				<form name="registerForm" id = "registerForm" class="form-horizontal"
					ng-submit="processForm()" novalidate>
					<h1 class="text-center">注册</h1>
					<div class="form-group  has-feedback">
						<label for="loginName" class="col-md-2 control-label">用&nbsp;户&nbsp;名</label>
						<div class="col-md-9" ng-class="{'has-success' : !registerForm.loginName.$pristine && registerForm.loginName.$valid, 'has-error':!registerForm.loginName.$pristine && registerForm.loginName.$invalid }">
							<input type="text" class="form-control" id="registerForm" name="loginName"
								placeholder="请输入用户名" ng-model="formData.loginName" required
								ng-minlength="2" ng-maxlength="18" ng-pattern="/^[a-zA-Z][a-zA-Z0-9_]{1,17}$/">
							<div ng-show="!registerForm.loginName.$pristine && registerForm.loginName.$valid">
								<span class="glyphicon glyphicon-ok form-control-feedback"></span>
							</div>

							<div ng-show="!registerForm.loginName.$pristine && registerForm.loginName.$invalid">
								<span class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>

							<span id="helpBlock" ng-class={'hidewithspace':!registerForm.loginName.$pristine&&registerForm.loginName.$valid} class="help-block">2~18个字符，可使用字母、数字、下划线，需以字母开头</span>
							<span id="helpBlock" class="help-block">{{result.error_loginName}}</span>
						</div>
					</div>
					<div class="form-group  has-feedback">
						<label for="userName" class="col-md-2 control-label">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称</label>
						<div class="col-md-9" ng-class="{'has-success' : !registerForm.userName.$pristine && registerForm.userName.$valid, 'has-error':!registerForm.userName.$pristine && registerForm.userName.$invalid }">
							<input type="text" class="form-control" id="userName" name="userName"
								placeholder="请输入昵称" ng-model="formData.userName" required
								ng-minlength="2" ng-maxlength="30">
							<div ng-show="!registerForm.userName.$pristine && registerForm.userName.$valid">
								<span class="glyphicon glyphicon-ok form-control-feedback"></span>
							</div>

							<div ng-show="!registerForm.userName.$pristine && registerForm.userName.$invalid">
								<span class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<span
								class="help-block" ng-class={'hidewithspace':!registerForm.userName.$pristine&&registerForm.userName.$valid}>2~30个字符</span>
						</div>
					</div>
					<div class="form-group  has-feedback">
						<label for="pw1" class="col-md-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>
						<div class="col-md-9" ng-class="{'has-success' : !registerForm.plainPassword.$pristine && registerForm.plainPassword.$valid, 'has-error':!registerForm.plainPassword.$pristine && registerForm.plainPassword.$invalid }">
							<input type="password" class="form-control" id="plainPassword"
								name="plainPassword" placeholder="请输入密码"
								ng-model="formData.plainPassword" required  ng-minlength="6" ng-maxlength="18" ng-pattern="/^[a-zA-Z0-9]{6,16}$/">
								<ul id="strength" check-strength="formData.plainPassword"></ul>
							<div ng-show="!registerForm.plainPassword.$pristine && registerForm.plainPassword.$valid">
								<span class="glyphicon glyphicon-ok form-control-feedback"></span>
							</div>

							<div ng-show="!registerForm.plainPassword.$pristine && registerForm.plainPassword.$invalid">
								<span class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>

							<span
								class="help-block" ng-class={'hidewithspace':!registerForm.plainPassword.$pristine&&registerForm.plainPassword.$valid}>6-18位，可使用字母、数字</span>
						</div>
					</div>
					<div class="form-group  has-feedback">
						<label for="pw2" class="col-md-2 control-label">确认密码</label>
						<div class="col-md-9" ng-class="{'has-success' : !registerForm.confirmPassword.$pristine && registerForm.confirmPassword.$valid, 'has-error':!registerForm.confirmPassword.$pristine && registerForm.confirmPassword.$invalid }">
							<input type="password" class="form-control" id="confirmPassword"
								name="confirmPassword" placeholder="请再次输入密码"
								ng-model="formData.confirmPassword" required
								pw-check="plainPassword" ng-minlength="6" ng-maxlength="18" ng-pattern="/^[a-zA-Z0-9]{6,16}$/">
							<div ng-show="!registerForm.confirmPassword.$pristine && registerForm.plainPassword.$valid&&!registerForm.confirmPassword.$error.pwmatch">
								<span class="glyphicon glyphicon-ok form-control-feedback"></span>
							</div>

							<div ng-show="!registerForm.confirmPassword.$pristine && registerForm.confirmPassword.$error.pwmatch">
								<span class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<span class="help-block" ng-class={'hidewithspace':!registerForm.confirmPassword.$error.pwmatch||!registerForm.confirmPassword.$dirty||egisterForm.plainPassword.$invalid}>两次密码不一致</span>
						</div>
					</div>
					<div
						ng-show="!registerForm.confirmPassword.$pristine && tagName.confirmPassword.$valid">
						<span class="glyphicon glyphicon-ok form-control-feedback"></span>
					</div>
					<div
						ng-show="!registerForm.confirmPassword.$pristine && registerForm.confirmPassword.$invalid">
						<span class="glyphicon glyphicon-remove form-control-feedback"></span>
					</div>
					<div class="form-group">
						<div class="col-md-offset-2 col-md-10">
							<button type="submit" class="btn btn-default"
								ng-disabled="registerForm.$invalid">
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
	<script src="${ctx}/static/jquery/jquery-2.2.0.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script src="${ctx}/static/angular-1.3.9/angular.js"></script>
	<script src="${ctx}/static/js/services.js"></script>
	<script src="${ctx}/static/js/register.js"></script>
	<script src="${ctx}/static/jsSHA-2.0.1/sha1.js"></script>
</body>
</html>