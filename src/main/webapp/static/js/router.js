var projectName = "musictag";
MusicTag.config(function($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.when("", "tag/tagindex");
  $stateProvider
    .state("tag", {
      url: "/tag",
      controller: "TagController",
      templateUrl: "/" + projectName + "/pages/tag/tag.html"
    })
    .state("tag.tagdetail", {
      url: "/tagdetail/:tagid",
      controller: "TagDetailController",
      templateUrl: "/" + projectName + "/pages/tag/tagdetail.html",
      onEnter: function($stateParams, $state) {
        if ($stateParams.tagid == undefined || $stateParams.tagid == "") {
          $state.go("tag.tagindex");
        }
      }

    })
    .state("tag.tagindex", {
      url: "/tagindex",
      controller: "TagIndexController",
      templateUrl: "/" + projectName + "/pages/tag/tagindex.html"
    })
    .state("song", {
      url: "/song",
      controller: "SongController",
      templateUrl: "/" + projectName + "/pages/song/song.html"
    })
    .state("song.songpage", {
      url: "/songpage",
      controller: "SongPageController",
      templateUrl: "/" + projectName + "/pages/song/songlist.html"
    })
    .state("song.songdetail", {
      url: "/songdetail/:songid",
      controller: "SongDetailController",
      templateUrl: "/" + projectName + "/pages/song/songdetail.html",
      onEnter: function($stateParams, $state) {
        if ($stateParams.songid == undefined || $stateParams.songid == "") {
          $state.go("song.songpage");
        }
      }

    })
    .state("songlist", {
      url: "/songlist",
      controller: "SongListController",
      templateUrl: "/" + projectName + "/pages/songlist/songlist.html"
    })
    .state("songlist.playlist", {
      url: "/playlist",
      controller: "PlayListController",
      templateUrl: "/" + projectName + "/pages/songlist/playlist.html"
    })
    .state("songlist.songlistdetail", {
      url: "/songlistdetail/:songlistid",
      controller: "SongListDetailController",
      templateUrl: "/" + projectName + "/pages/songlist/songlistdetail.html",
      onEnter: function($stateParams, $state) {
        if ($stateParams.songlistid == undefined || $stateParams.songlistid == "") {
          $state.go("songlist.playlist");
        }
      }

    })
  .state("songlist.editsonglist", {
    url: "/songlist/edit/:songlistid",
    controller: "SongListInfoController",
    templateUrl: "/" + projectName + "/pages/songlist/songlistedit.html",
    onEnter: function($stateParams, $state) {
      if ($stateParams.songlistid == undefined || $stateParams.songlistid == "") {
        $state.go("songlist.playlist");
      }
    }
  })
});