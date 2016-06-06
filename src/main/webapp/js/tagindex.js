var tagUrl = "/tag";
var addMusicTag = "/musictag";
var tagDetailUrl = "/tagdetail"
MusicTag.controller('TagIndexController',function($scope,$http,$window,tagService,$state,songService,$timeout,$stateParams){
	$scope.result={};
	$scope.searchData={};
	$scope.ctx = ctx;
	$scope.songs = {};
	$scope.songName="";
	tagService.getTags().success(function(data){
		if(data.status){
			$scope.tags = data.tags;
		}
		
	});
	$scope.$on("AddTag",function(){
		tagService.getTags().success(function(data){
			if(data.status){
				$scope.tags = data.tags;
				console.log(data.tags);
			}
		});
	});
	$scope.showDetail = function(tag){
		var data = {"tagid":tag.id};
		$state.go("tag.tagdetail",data);
	};
});