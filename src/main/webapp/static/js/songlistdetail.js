MusicTag.controller('SongListDetailController', function($scope, $state, $stateParams,songListService,songService) {
    console.log($stateParams.songlistid);
    songListService.getSongListById($stateParams.songlistid).success(function(data) {
        $scope.csonglist = data.songList;
    });
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
     $scope.formatDate = function(date){
          var dateOut = new Date(date);
          return dateOut;
    };
    $scope.editSongList = function(){
    	var data = {"songlistid":$scope.csonglist.id};
		$state.go("songlist.editsonglist",data);
    }
});
//修改歌单信息的Controller
MusicTag.controller('SongListInfoController', function($scope, $state, $stateParams,songListService){
	songListService.getSongListById($stateParams.songlistid).success(function(data) {
        $scope.csonglist = data.songList;
    });
});
