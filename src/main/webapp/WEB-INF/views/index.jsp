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
	<title>音乐标签</title>

	<!-- Bootstrap -->
	<link href="${ctx}/static/bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/static/css/common.css" rel="stylesheet">
	<link href="${ctx}/static/css/tag.css" rel="stylesheet">
	<link href="${ctx}/static/css/songlist.css" rel="stylesheet">
	<link href="${ctx}/static/trd/ngImgCrop/ng-img-crop.css" rel="stylesheet">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<script>var ctx = "${ctx}";</script>
	<div class="container">
		<div class="row">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Music Tag</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li>
								<a href="#" ui-sref="tag.tagindex">
									标签
									<span class="sr-only">(current)</span>
								</a>
							</li>
							<li>
								<a href="#" ui-sref="song.songpage">音乐</a>
							</li>
							<li>
								<a href="#" ui-sref="songlist.playlist">歌单</a>
							</li>

						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li>
								<a href="#">消息</a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
									用户名
									<span class="caret"></span>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="#">我的主页</a>
									</li>
									<li role="separator" class="divider"></li>
									<li>
										<a href="#">退出</a>
									</li>

								</ul>
							</li>
						</ul>
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search"></div>
							<button type="submit" class="btn btn-default">搜索</button>
						</form>
						
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
		<!-- //row -->
		<div class="row" ui-view>
			
		</div>
	</div>
	<!-- //container -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="${ctx}/static/jquery/jquery-2.2.0.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${ctx}/static/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script src="${ctx}/static/angular-1.4.8/angular.min.js"></script>
	<script src="${ctx}/static/angular-ui/angular-ui-router.js"></script>
	<script src="${ctx}/static/angular-ui/ui-bootstrap-tpls-1.2.5.js"></script>
	<script src="${ctx}/static/js/services.js"></script>
	<script src="${ctx}/static/js/router.js"></script>
	<script src="${ctx}/static/js/filter.js"></script>
	<script src="${ctx}/static/jsSHA-2.0.1/sha1.js"></script>
	<script src="${ctx}/static/js/directive.js"></script>
	<!-- 文件上传 -->
	 <script src="${ctx}/static/trd/plupload/moxie.js"></script>
	 <script src="${ctx}/static/trd/plupload/plupload.dev.js"></script>
	 <script src="${ctx}/static/trd/qiniu/qiniu.js"></script>
	<!-- 截图-->
	<script src="${ctx}/static/trd/ngImgCrop/ng-img-crop.js"></script>
	<!-- 各个子页面的js-->
	<script src="${ctx}/static/js/tag.js"></script>
	<script src="${ctx}/static/js/tagdetail.js"></script>
	<script src="${ctx}/static/js/tagindex.js"></script>
	<script src="${ctx}/static/js/song.js"></script>
	<script src="${ctx}/static/js/songpage.js"></script>
	<script src="${ctx}/static/js/songdetail.js"></script>
	<script src="${ctx}/static/js/songlist.js"></script>
	<script src="${ctx}/static/js/playlist.js"></script>
	<script src="${ctx}/static/js/songlistdetail.js"></script>
</body>
</html>