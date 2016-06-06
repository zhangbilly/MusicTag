var MusicTag = angular.module("MusicTag", ['ui.router', 'ui.bootstrap','ngImgCrop']);
var Register = angular.module("Register", []);
var getTagsUrl = "/tag/tags";
var getSongByTagURL = "/songlistbytag";
var getSingerUrl = "/singer/singers";
var getSongs = "/songlist";
var getAlbumsUrl = "/albums";
var getTagByIdUrl = "/tag/tag/";
var getSongbyIdUrl = "/song/";
var getTagsBySongUrl = "/tag/tagListbySong"
var getSongListUrl = "/songlist/"
	//获取歌单
var getSongListsURL = "/songlists";
//获取上传token
var getUpTokenURL = "/uptoken";
//添加评论
var addCommentUrl = "/comment"
var getComments = "/comment/list";

MusicTag.service('encryptService', function() {
	this.encrypt = function(string) {
		var shaObj = new jsSHA("SHA-1", "TEXT");
		shaObj.update(string);
		var hash = shaObj.getHash("HEX");
		return hash;
	}
});
MusicTag.service('tagService', ['$http', function($http) {

	this.getTags = function() {
		return $http({
			method: 'GET',
			url: ctx + getTagsUrl,
			//data:$.param($scope.data),
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		});
	}
	this.getTagsBySong = function(songId) {
		var data = {
			songId: songId
		};
		return $http({
			method: 'GET',
			url: ctx + getTagsBySongUrl,
			params: data,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		});
	};
	this.getTagById = function(tagId) {
		return $http({
			method: 'GET',
			url: ctx + getTagByIdUrl + tagId,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		})
	};
	this.tags = {};
}]);
MusicTag.service('songService', ['$http', function($http) {
	this.songs = {};
	this.getSongByTag = function(tagId) {
		var data = {
			tagId: tagId
		};
		return $http({
			method: 'GET',
			url: ctx + getSongByTagURL,
			params: data,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		});
	};
	this.getSongByName = function(songName) {
		var data = {
			songName: songName
		};
		return $http({
			method: 'GET',
			url: ctx + getSongs,
			params: data,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		})
	};
	this.getSongById = function(songId) {
		return $http({
			method: 'GET',
			url: ctx + getSongbyIdUrl + songId,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		})
	};
	this.getSongs = function() {
		var data = {
			songName: songName
		};
		return $http({
			method: 'GET',
			url: ctx + getSongs,
			params: data,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		})
	};
	this.getSongs = function(pn, ps) {
		var data = {
			pn: pn,
			ps: ps
		};
		return $http({
			method: 'GET',
			url: ctx + getSongs,
			params: data,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		})
	};
}]);
MusicTag.service('albumService', ['$http', function($http) {
	this.getAlbumByName = function(albumName) {
		//var data = {albumName:albumName};
		return $http({
			method: 'GET',
			url: ctx + getAlbumsUrl,
			params: albumName,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		})
	}
}]);
MusicTag.service('singerService', ['$http', function($http) {
	this.getSingerByName = function(singerName) {
		//var data = {singerName:singerName};
		return $http({
			method: 'GET',
			url: ctx + getSingerUrl,
			params: singerName,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		});
	};
}]);
MusicTag.service('songListService', ['$http', function($http) {
	this.getSongListById = function(songListId) {
		return $http({
			method: 'GET',
			url: ctx + getSongListUrl + songListId,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		});
	};
	this.getSongLists = function(pn, ps) {
		var data = {
			pn: pn,
			ps: ps
		};
		return $http({
			method: 'GET',
			url: ctx + getSongListsURL,
			params: data,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		})
	};
}]);
MusicTag.service('QiniuService', ['$http', function($http) {
	this.getUpToken = function() {
		return $http({
			method: 'GET',
			url: ctx + getUpTokenURL
		});
	};
}]);
MusicTag.service('commentService', ['$http', function($http) {
	this.addComment = function(data) {
		return $http({
			method: 'POST',
			url: ctx + addCommentUrl,
			data:data
		});
	};
	this.getComments = function(resourceId,type){
		var data = {
			resourceId: resourceId,
			type: type
		};
		return $http({
			method: 'GET',
			url: ctx + getComments,
			params: data,
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			}
		})
	};
}]);