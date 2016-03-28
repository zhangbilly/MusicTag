var tagUrl = "/tag";
var addMusicTag = "/musictag";
var tagDetailUrl = "/tagdetail"
MusicTag.controller('TagIndexController',function($scope,$http,$window,tagService,$state,songService,$timeout,$stateParams){
	$scope.result={};
	$scope.searchData={};
	$scope.ctx = ctx;
	$scope.songs = {};
	$scope.songName="";
	tagService.getTags().success(function(data){
		if(data.status){
			$scope.tags = data.tags;
		}
		
	});
	$scope.$on("AddTag",function(){
		tagService.getTags().success(function(data){
			if(data.status){
				$scope.tags = data.tags;
				console.log(data.tags);
			}
		});
	});
	$scope.showDetail = function(tag){
		var data = {"tagid":tag.id};
		$state.go("tag.tagdetail",data);
	};
	$scope.$watch('searchData.song.songName', function (newVal, oldVal) {
		if (newVal !== oldVal&&newVal!=undefined&&newVal!==""&&newVal!==$scope.choosedSongName) {
			if ($scope.timeout) $timeout.cancel($scope.timeout);
			$scope.timeout = $timeout(function() {
				songService.getSongByName(newVal).success(function(data){
					if(data.status){
						$scope.items = data.songs.content;
					}else{
                		//$scope.showSingerForm = true;
                	}
                })
			}, 800);
		}
	}, true);
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
    		}
    	})
    }
    //模糊匹配歌曲时选择歌曲
    $scope.chooseSong = function(song){
    	$scope.searchData.song.songName = song.songName;
    	$scope.searchData.song.id = song.id;
    	$scope.choosedSongName = song.songName;
    	$scope.items = {};
    }
});