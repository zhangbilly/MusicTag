var tagUrl = "/tag";
var addtagformusicURL = "/addtagformusic";
var tagDetailUrl = "/tagdetail"
MusicTag.controller('TagController',function($scope,$http,$window,tagService,$state,songService,$timeout,$stateParams){
	$scope.formData={};
	$scope.searchData={};
	$scope.ctx = ctx;
	$scope.isCollapsed = true;
	$scope.processForm = function(){
		$http({
			method:'POST',
			url:ctx+tagUrl,
			data:$.param($scope.formData),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		}).success(function(data){
			if(data.status==1){
				$scope.isCollapsed = true;
				$scope.$broadcast("AddTag");			
				$scope.formData.tagName = "";
			}else if(data.status==2){
				$scope.createResult = data.msg;
				$scope.existTag = data.tag;
			}
			else{
				$scope.createResult = data.msg;
			}
		})
	};
	$scope.showExist = function(tag){
		var data = {"tagid":tag.id};
		$scope.formData.tagName = "";
		$scope.isCollapsed = true;
		$state.go("tag.tagdetail",data);
		$scope.createResult = "";
	}
});
MusicTag.controller('AddTagController',function($scope, $uibModalInstance, csong,tagService,$http){
  $scope.csong = csong;
  $scope.searchData = {};
  $scope.needRefresh = false;
  tagService.getTagsBySong(csong.id).success(function(data){
      if(data.status==1){
          if(data.tags.length>0)
					$scope.tags = data.tags;
      }
  });

  $scope.cancel = function () {
    $uibModalInstance.close($scope.needRefresh);
  };
  $scope.processForm = function(){
      $scope.showError = false;
      	var data = {
			song:{
				id:$scope.csong.id
			},
			tag:{
				name:$scope.searchData.tagName
			}
		};
		$http({
			method:'POST',
			url:ctx+addtagformusicURL,
			data:data
		}).success(function(data){
			if(data.status==1){
				//$scope.$broadcast("AddTag");			
				$scope.searchData.tagName = "";
                $scope.tags.push(data.tag);
                $scope.needRefresh = true;
			}else if(data.status==2){
				$scope.createResult = data.msg;
                $scope.showError = true;
			}
			else{
				$scope.createResult = data.msg;
                $scope.showError = true;
			}
		})
	};
});