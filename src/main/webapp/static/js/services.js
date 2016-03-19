var MusicTag = angular.module("MusicTag",['ui.router','ui.bootstrap']);
var getTagsUrl = "/tag/tags";
MusicTag.service('encryptService', function(){
	this.encrypt = function(string){
		var shaObj = new jsSHA("SHA-1", "TEXT");
		shaObj.update(string);
		var hash = shaObj.getHash("HEX");
		return hash;
	}
});
MusicTag.service('tagService', ['$http', function($http){
	this.getTags = function(){
		return $http({
			method:'GET',
			url:ctx+getTagsUrl,
			//data:$.param($scope.data),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		});
	}
}])