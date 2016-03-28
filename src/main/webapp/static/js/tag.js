var tagUrl = "/tag";
var addMusicTag = "/musictag";
var tagDetailUrl = "/tagdetail"
MusicTag.controller('TagController',function($scope,$http,$window,tagService,$state,songService,$timeout,$stateParams){
	$scope.formData={};
	$scope.searchData={};
	$scope.ctx = ctx;
	$scope.isCollapsed = true;
	$scope.processForm = function(){
		$http({
			method:'POST',
			url:ctx+tagUrl,
			data:$.param($scope.formData),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).success(function(data){
			if(data.status==1){
				$scope.isCollapsed = true;
				$scope.$broadcast("AddTag");			
				$scope.formData.tagName = "";
			}else if(data.status==2){
				$scope.createResult = data.msg;
				$scope.existTag = data.tag;
			}
			else{
				$scope.createResult = data.msg;
			}
		})
	};
	$scope.showExist = function(tag){
		var data = {"tagid":tag.id};
		$scope.formData.tagName = "";
		$scope.isCollapsed = true;
		$state.go("tag.tagdetail",data);
		$scope.createResult = "";
	}
});