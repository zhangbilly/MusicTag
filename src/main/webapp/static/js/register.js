var registerUrl = "/register";
MusicTag.controller('RegisterController',function($scope,$http,$window,encryptService){
	$scope.formData={};
	$scope.ctx = ctx;
	$scope.processForm = function(){
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
				alert(data.msg);
			}
		})
	};
});
// 密码验证directive
MusicTag.directive('pwCheck', [function () {
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