var loginUrl = "/login";
MusicTag.controller('LoginFormController', function($scope,$http,encryptService,$window){
	$scope.formData = {};
	$scope.ctx = ctx;
	$scope.processForm = function(){
		$scope.data = angular.copy($scope.formData);
		$scope.data.password = encryptService.encrypt($scope.data.password);
		$http({
			method:'POST',
			url:$scope.ctx+loginUrl,
			data:$.param($scope.data),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).success(function(data){
			console.log(data);
			if(data.status==1){
				$window.location.href = ctx+data.url;
			}else{
				alert(data.msg);
			}
		})
	}
});
