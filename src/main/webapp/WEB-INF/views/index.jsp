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
	<link href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/css/common.css" rel="stylesheet">

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
		index
		<!-- //row -->
	</div>
	<!-- //container -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ctx}/static/jquery/jquery-2.2.0.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script src="${ctx}/static/angular-1.3.9/angular.js"></script>
	<script src="${ctx}/static/js/services.js"></script>
	<script src="${ctx}/static/js/login.js"></script>
	<script src="${ctx}/static/jsSHA-2.0.1/sha1.js"></script>
</body>
</html>