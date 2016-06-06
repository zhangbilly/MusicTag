MusicTag.controller('SongPageController',function($scope,singerService,$timeout,$http,albumService,songService,$state){
	$scope.pagination = {};
	$scope.pagination.pn = 1;
	$scope.pagination.ps = 10;
	songService.getSongs($scope.pagination.pn,$scope.pagination.ps).success(function(data){
		if(data.status==1){
			$scope.songs = data.songs.content;
			$scope.pagination.totalItems = data.songs.totalElements;
		}
	});
	//列表中点击歌手名
    $scope.showSongDetail = function(song){
    	var data = {"songid":song.id};
		$state.go("song.songdetail",data);
	};
    $scope.pageChange = function(){
    	songService.getSongs($scope.pagination.pn,$scope.pagination.ps).success(function(data){
		if(data.status==1){
			$scope.songs = data.songs.content;
			$scope.totalItems = data.songs.totalElements;
		}
	});
    };
});
