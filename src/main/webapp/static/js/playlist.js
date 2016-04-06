MusicTag.controller("PlayListController", function($scope, songListService,$state) {
	songListService.getSongLists("1", "12").success(function(data) {
		if (data.status == 1) {
			$scope.songlists = data.songlists.content;
		}
	});
	$scope.showSongListDetail = function(songlist){
		var data = {"songlistid":songlist.id};
		$state.go("songlist.songlistdetail",data);
	}
})