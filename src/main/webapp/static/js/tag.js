var tagUrl = "/tag";
var tagDetailUrl = "/tagdetail"
MusicTag.controller('TagController',function($scope,$http,$window,tagService,$state,songService){
	$scope.result={};
	$scope.formData={};
	$scope.ctx = ctx;
	$scope.isCollapsed = true;
	$scope.showResultTag = false;
	$scope.songs = {};
	$scope.showAddSong = true;
	tagService.getTags().success(function(data){
		if(data.status){
			$scope.tags = data.tags;
		}
		
	})
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
			}else if(data.status==2){
				$scope.createResult = data.msg;
				$scope.existTag = data.tag;
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