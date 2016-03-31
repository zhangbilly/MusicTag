MusicTag.controller('SongListDetailController', function($scope, $state, $stateParams,songListService) {
    console.log($stateParams.songlistid);
    songListService.getSongListById($stateParams.songlistid).success(function(data) {
        $scope.csonglist = data.songList;
    });
});
