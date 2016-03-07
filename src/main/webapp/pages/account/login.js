var loginModule = angular.module("loginModule",[]);
var LoginFormController = loginModule.controller('LoginFormController', function($scope,$http){
	$scope.formData = {};
	$scope.processForm = function(){
		$http({
			method:'POST',
			url:'www.baidu.com',
			data:$.param($scope.formData),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).success(function(data){
			console.log(data);
			if(data.status==1){

			}
		})
	}
});
