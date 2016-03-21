var MusicTag = angular.module("MusicTag",['ui.router','ui.bootstrap']);
var getTagsUrl = "/tag/tags";
var getSongs = "/song/songs";
var getSingerUrl = "/singer/singers";
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
}]);
MusicTag.service('songService', ['$http', function($http){
	this.getSongByTag = function(){
		return $http({
			method:'GET',
			url:ctx+getSongs,
			//data:$.param($scope.data),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		});
	};
	this.getSongByName = function(songName){
		return $http({
			method:'GET',
			url:ctx+getSongs,
			data:$.param(songName),
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		})
	}
}]);
MusicTag.service('singerService', ['$http', function($http){
		this.getSingerByName = function(singerName){
		var data = {singerName:singerName};
		return $http({
			method:'GET',
			url:ctx+getSingerUrl,
			params:data,
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		});
	};
}])