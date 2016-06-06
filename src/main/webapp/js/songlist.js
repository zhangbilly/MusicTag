var addSongListUrl = "/songlist";
MusicTag.controller("SongListController",function($scope,$http,songListService,$state) {
    $scope.isCollapsed = true;
    $scope.showAddSongListForm = function() {
         $scope.isCollapsed = ! $scope.isCollapsed;
    };
    $scope.formData = {};
    	$scope.processForm = function(){
		$http({
			method:'POST',
			url:ctx+addSongListUrl,
			data:$.param($scope.formData),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).success(function(data){
			if(data.status==1){
				$scope.isCollapsed = true;
				$scope.formData.tagName = "";
                var data = {"songlistid":data.songList.id};
		        $state.go("songlist.songlistdetail",data);
			}else if(data.status==2){
				$scope.createResult = data.msg;
				$scope.existTag = data.tag;
			}
			else{
				$scope.createResult = data.msg;
			}
		})
	};
});