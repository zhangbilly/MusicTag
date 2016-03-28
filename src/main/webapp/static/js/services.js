var MusicTag = angular.module("MusicTag",['ui.router','ui.bootstrap']);
var getTagsUrl = "/tag/tags";
var getSongByTagURL = "/songlistbytag";
var getSingerUrl = "/singer/singers";
var getSongs = "/songlist";
var getAlbumsUrl = "/albums";
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
	this.getTagsBySong = function(songId){
		return $http({
			method:'GET',
			url:ctx+getTagsUrl,
			params:songId,
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		});
	}
}]);
MusicTag.service('songService', ['$http', function($http){
	this.getSongByTag = function(tagId){
		var data = {tagid:tagId};
		return $http({
			method:'GET',
			url:ctx+getSongByTagURL,
			params:data,
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		});
	};
	this.getSongByName = function(songName){
		var data = {songName:songName};
		return $http({
			method:'GET',
			url:ctx+getSongs,
			params:data,
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		})
	};
	this.getSongs = function(){
		var data = {songName:songName};
		return $http({
			method:'GET',
			url:ctx+getSongs,
			params:data,
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		})
	};
	this.getSongs = function(pn,ps){
		var data = {pn:pn,ps:ps};
		return $http({
			method:'GET',
			url:ctx+getSongs,
			params:data,
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		})
	};
}]);
MusicTag.service('albumService', ['$http', function($http){
	this.getAlbumByName = function(albumName){
		//var data = {albumName:albumName};
		return $http({
			method:'GET',
			url:ctx+getAlbumsUrl,
			params:albumName,
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		})
	}
}]);
MusicTag.service('singerService', ['$http', function($http){
		this.getSingerByName = function(singerName){
		//var data = {singerName:singerName};
		return $http({
			method:'GET',
			url:ctx+getSingerUrl,
			params:singerName,
			headers : { 'Content-Type': 'application/x-www-form-urlencoded' }
		});
	};
}]);