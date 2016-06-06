var registerUrl = "/register";
Register.controller('RegisterController',function($scope,$http,$window,encryptService){
	$scope.formData={};
	$scope.result={};
	$scope.ctx = ctx;
	$scope.processForm = function(){
		$scope.result={};
		$scope.data = angular.copy($scope.formData);
		$scope.data.plainPassword = encryptService.encrypt($scope.data.plainPassword);
		$scope.data.confirmPassword = $scope.data.plainPassword;
		$http({
			method:'POST',
			url:ctx+registerUrl,
			data:$.param($scope.data),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).success(function(data){
			console.log(data);
			if(data.status){
				$window.location.href = ctx+data.url;
			}else{
				$scope.result = data;
			}
		})
	};
});