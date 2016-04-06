MusicTag.controller("PlayListController", function($scope, songListService) {
	songListService.getSongLists("1", "12").success(function(data) {
		if (data.status == 1) {
			$scope.songlists = data.songlists.content;
		}
	});
})