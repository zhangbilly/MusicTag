var createSongUrl = "/song"
MusicTag.controller('SongController',function($scope,singerService,$timeout,$http,albumService){
	$scope.isCollapsed = true;
	$scope.formData = {};
	$scope.showSingerForm = false;
	$scope.singers = {};
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
			$scope.isChoosed = false;
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
	//模糊匹配时选择歌手
	$scope.chooseSinger = function(singer){
		$scope.formData.singer.singerName = singer.singerName;
		$scope.formData.singer.id = singer.id;
		$scope.isChoosed = true;
		$scope.singers = {};
	}
	$scope.$watch('formData.singer', function (newVal, oldVal) {
        if (newVal !== oldVal&&newVal!=undefined&&newVal.singerName!==undefined&&newVal.singerName!==""&&!$scope.isChoosed) {
            if ($scope.timeout) $timeout.cancel($scope.timeout);
            $scope.timeout = $timeout(function() {
                singerService.getSingerByName(newVal).success(function(data){
                	if(data.status){
                		if(data.singers.length>0){
                			$scope.singers = data.singers;
                			$scope.isChoosed = false;
                		}else{
                			$scope.singers = {};
                		}
                		
                	}else{
                		//$scope.showSingerForm = true;
                	}
                })
            }, 800);
        }
    }, true);
    //模糊匹配时选择专辑
	$scope.chooseAlbum = function(album){
		$scope.formData.album.albumName = album.albumName;
		$scope.formData.album.id = album.id;
		$scope.isAlbumChoosed = true;
		$scope.albums = {};
	}
	$scope.$watch('formData.album', function (newVal, oldVal) {
        if (newVal !== oldVal&&newVal!=undefined&&newVal.albumName!==undefined&&newVal.albumName!==""&&!$scope.isAlbumChoosed) {
            if ($scope.timeout) $timeout.cancel($scope.timeout);
            $scope.timeout = $timeout(function() {
                albumService.getAlbumByName(newVal).success(function(data){
                	if(data.status){
                		if(data.albums.length>0){
                			$scope.albums = data.albums;
                			$scope.isAlbumChoosed = false;
                		}else{
                			$scope.albums = {};
                		}
                		
                	}else{
                		//$scope.showSingerForm = true;
                	}
                })
            }, 800);
        }
    }, true);
});
