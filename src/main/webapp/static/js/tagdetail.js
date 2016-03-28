MusicTag.controller('TagDetailController', function(tagService,$scope,$stateParams,songService){
	$scope.showAddSong = true;
	tagService.getTagById($stateParams.tagid).success(function(data){
		$scope.ctag = data.tag;
		$scope.songs=songService.getSongByTag($scope.ctag.id).success(function(data){
		if(data.status){
			$scope.songs = data.songs.content;
			console.log($scope.songs);
		}
	});
	});
	
});