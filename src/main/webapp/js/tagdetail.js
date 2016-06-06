MusicTag.controller('TagDetailController', function(tagService,$http,$scope,$stateParams,songService,$state,$timeout){
	$scope.showAddSong = true;
	$scope.canSubmit = false;
	$scope.AddSong = false;
	//歌曲已存在的提示
	$scope.showExistTip = false;
	tagService.getTagById($stateParams.tagid).success(function(data){
		$scope.ctag = data.tag;
		songService.getSongByTag($scope.ctag.id).success(function(data){
			if(data.status){
				if(data.songs.content.length>0)
					$scope.songs = data.songs.content;
			}
		});
	});
	$scope.jumpToSongList = function(){
		$state.go("song.songpage");
	};
	//增加音乐标签
	$scope.processSearchForm = function(){
		var data = {
			song:{
				songName:$scope.searchData.song.songName,
				id:$scope.searchData.song.id
			},
			tag:{
				id:$scope.ctag.id
			}
		};
		$http({
			method:'POST',
			url:ctx+addMusicTag,
			data:data
		}).success(function(data){
			console.log(data);
			if(data.status==1){
				console.log("添加成功");
				$scope.showAddSong = true;
				songService.getSongByTag($scope.ctag.id).success(function(data){
					if(data.status==1){
						if(data.songs.content.length>0)
							$scope.songs = data.songs.content;
					}
					
				});
			}
		else if(data.status==2){
			$scope.showExistTip = true;
		}
		});
	};
	$scope.$watch('searchData.song.songName', function (newVal, oldVal) {
		if (newVal !== oldVal&&newVal!=undefined&&newVal!==""&&newVal!==$scope.choosedSongName) {
			if ($scope.timeout) $timeout.cancel($scope.timeout);
			$scope.timeout = $timeout(function() {
				songService.getSongByName(newVal).success(function(data){
					if(data.status){
						if(data.songs.content.length>0){
							$scope.AddSong = false;
							$scope.items = data.songs.content;
						}else{
							$scope.AddSong = true;
						}
					}else{
                		//$scope.showSingerForm = true;
                	}
                })
			}, 800);
		}
	}, true);
    //模糊匹配歌曲时选择歌曲
    $scope.chooseSong = function(song){
    	$scope.searchData.song.songName = song.songName;
    	$scope.searchData.song.id = song.id;
    	$scope.choosedSongName = song.songName;
    	$scope.canSubmit = true;
    	$scope.items = {};
    }
    //关闭提示
    $scope.closeAlert = function(){
    	$scope.showExistTip = false;
    };
    
});