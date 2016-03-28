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
			console.log(data);
			if(data.status==1){
				$scope.isCollapsed = true;
				$scope.$broadcast("AddTag");
			}else if(data.status==2){
				$scope.createResult = data.msg;
				$scope.ctag = data.tag;
				$state.go("tag.tagdetail");
				songService.getSongByTag().success(function(data){
					if(data.status){
						$scope.songs = data.songs;
					}
				})
			}
			else{
				$scope.createResult = data.msg;
			}
		})
	};
});