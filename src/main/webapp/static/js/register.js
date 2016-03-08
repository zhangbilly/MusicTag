var registerUrl = "/register";
var RegisterModule = angular.module("RegisterModule",[]);
RegisterModule.controller('RegisterController',function($scope,$http,$window){
	$scope.formData={};
	$scope.ctx = ctx;
	$scope.processForm = function(){
		$http({
			method:'POST',
			url:ctx+registerUrl,
			data:$.param($scope.formData),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).success(function(data){
			console.log(data);
			if(data.status){
				$window.location.href = ctx+data.url;
			}else{
				alert(data.msg);
			}
		})
	};
});
// 密码验证directive
RegisterModule.directive('pwCheck', [function () {
	return {
		require: 'ngModel',
		link: function (scope, elem, attrs, ctrl) {
			var firstPassword = '#' + attrs.pwCheck;
			elem.add(firstPassword).on('keyup', function () {
				scope.$apply(function () {
					var v = elem.val()===$(firstPassword).val();
					ctrl.$setValidity('pwmatch', v);
				});
			});
		}
	}
}]);