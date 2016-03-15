var projectName = "musictag";
MusicTag.config(function ($stateProvider, $urlRouterProvider) {
     $urlRouterProvider.when("", "tag");
     $stateProvider
        .state("tag", {
            url: "/tag",
            templateUrl: "/"+projectName+"/pages/tag.html"
        })
        .state("song", {
            url:"/song",
            templateUrl: "/"+projectName+"/pages/song.html"
        })
        .state("songlist", {
            url:"/songlist",
            templateUrl: "/"+projectName+"/pages/songlist.html"
        })
});