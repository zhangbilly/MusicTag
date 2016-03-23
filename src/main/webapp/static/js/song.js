var createSongUrl = "/song"
MusicTag.controller('SongController',function($scope,singerService,$timeout,$http){
	$scope.isCollapsed = true;
	$scope.formData = {};
	$scope.showSingerForm = false;
	$scope.processForm = function(){
		//$scope.formData.singerid=1;
		//$scope.formData.albumid=1
		console.log($scope.formData);
		console.log(JSON.stringify($scope.formData));
		$http({
			method:'POST',
			url:ctx+createSongUrl,
			//data:$.param($scope.formData),
			data:$scope.formData
		}).success(function(data){
			console.log(data);
			if(data.status==1){
				$scope.isCollapsed = true;
				$scope.formData={};
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
	$scope.$watch('formData.singer', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            if ($scope.timeout) $timeout.cancel($scope.timeout);
            $scope.timeout = $timeout(function() {
                singerService.getSingerByName(newVal).success(function(data){
                	if(data.status){
                		if(data.singers.length>0){
                			$scope.items = data.songs;
                		}else{
                			//$scope.showSingerForm = true;
                		}
                		
                	}else{
                		//$scope.showSingerForm = true;
                	}
                })
            }, 800);
        }
    }, true);
});
