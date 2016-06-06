MusicTag.controller('SongDetailController', function($scope, songService, $state, $stateParams, tagService, $uibModal) {
    $scope.tags = {};
    songService.getSongById($stateParams.songid).success(function(data) {
        $scope.csong = data.song;
        tagService.getTagsBySong($scope.csong.id).success(function(data) {
            if (data.status) {
                if (data.tags.length > 0)
                    $scope.tags = data.tags;
            }
        });
    });
    $scope.addTag = function() {
        var modalInstance = $uibModal.open({
            templateUrl: ctx + '/pages/template/addtag.html',
            controller: 'AddTagController',
            //size: "lg",
            resolve: {
                csong: function() {
                    return $scope.csong;
                }
            }
        });
        modalInstance.result.then(function(needRefresh) {
            if (needRefresh) {
                tagService.getTagsBySong($scope.csong.id).success(function(data) {
                    if (data.status) {
                        if (data.tags.length > 0)
                            $scope.tags = data.tags;
                    }
                });
            }
        });
    };
});
