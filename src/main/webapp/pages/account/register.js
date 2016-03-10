var RegisterModule = angular.module("RegisterModule",[]);
RegisterModule.controller('RegisterController',function($scope,$http){
	$scope.formData={};
	$scope.processForm = function(){
		$http({
			method:'POST',
			url:'/musictag/register',
			data:$.param($scope.formData),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).success(function(data){
			console.log(data);
			if(data.status==1){

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