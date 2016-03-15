var tagUrl = "/tag";
MusicTag.controller('TagController',function($scope,$http,$window){
	$scope.result={};
	$scope.formData={};
	$scope.ctx = ctx;
	$scope.isCollapsed = true;
	$scope.processForm = function(){
		$http({
			method:'POST',
			url:ctx+tagUrl,
			data:$.param($scope.formData),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).success(function(data){
			console.log(data);
			if(data.status){
				$scope.isCollapsed = true;
			}else{
				$scope.result = data;
			}
		})
	};
});