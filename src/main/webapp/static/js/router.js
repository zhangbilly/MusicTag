var projectName = "musictag";
MusicTag.config(function ($stateProvider, $urlRouterProvider) {
     $urlRouterProvider.when("", "tag/tagindex");
     $stateProvider
        .state("tag", {
            url: "/tag",
            templateUrl: "/"+projectName+"/pages/tag/tag.html"
        })
        .state("tag.tagdetail", {
            url:"/tagdetail",
            templateUrl: "/"+projectName+"/pages/tag/tagdetail.html"
        })
        .state("tag.tagindex", {
            url:"/tagindex",
            templateUrl: "/"+projectName+"/pages/tag/tagindex.html"
        })
        .state("song", {
            url:"/song",
            templateUrl: "/"+projectName+"/pages/song/song.html"
        })
        .state("song.songpage", {
            url:"/songpage",
            templateUrl: "/"+projectName+"/pages/song/songlist.html"
        })
        .state("song.songdetail", {
            url:"/songdetail",
            templateUrl: "/"+projectName+"/pages/song/songdetail.html"
        })
        .state("songlist", {
            url:"/songlist",
            templateUrl: "/"+projectName+"/pages/songlist.html"
        })
});