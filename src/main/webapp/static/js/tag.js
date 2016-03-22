var tagUrl = "/tag";
var addMusicTag = "/musictag";
var tagDetailUrl = "/tagdetail"
MusicTag.controller('TagController',function($scope,$http,$window,tagService,$state,songService,$timeout){
	$scope.result={};
	$scope.formData={};
	$scope.searchData={};
	$scope.ctx = ctx;
	$scope.isCollapsed = true;
	$scope.showResultTag = false;
	$scope.songs = {};
	$scope.showAddSong = true;
	$scope.songName="";
	tagService.getTags().success(function(data){
		if(data.status){
			$scope.tags = data.tags;
		}
		
	})
	$scope.processForm = function(){
		$http({
			method:'POST',
			url:ctx+tagUrl,
			data:$.param($scope.formData),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).success(function(data){
			console.log(data);
			if(data.status==1){
				$scope.isCollapsed = true;
			}else if(data.status==2){
				$scope.createResult = data.msg;
				$scope.ctag = data.tag;
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
	$scope.showDetail = function(tag){
		$scope.ctag = tag;
		console.log($scope.ctag);
		$state.go("tag.tagdetail");
		$scope.songs=songService.getSongByTag().success(function(data){
					if(data.status){
						$scope.songs = data.songs.content;
						console.log($scope.songs);
					}
	}
	)};
	$scope.$watch('searchData.songName', function (newVal, oldVal) {
        if (newVal !== oldVal) {
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
    			songName:$scope.searchData.song.songName
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
});