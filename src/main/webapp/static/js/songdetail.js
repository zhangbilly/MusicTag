MusicTag.controller('SongDetailController',function($scope,songService,$state,$stateParams,tagService){
	$scope.tags ={};
	songService.getSongById($stateParams.songid).success(function(data){
		$scope.csong = data.song;
		tagService.getTagsBySong($scope.csong.id).success(function(data){
			if(data.status){
				if(data.tags.length>0)
					$scope.tags = data.tags;
			}
		});
	});
});
