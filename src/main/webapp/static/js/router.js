var projectName = "musictag";
MusicTag.config(function ($stateProvider, $urlRouterProvider) {
   $urlRouterProvider.when("", "tag/tagindex");
   $stateProvider
   .state("tag", {
    url: "/tag",
    controller:"TagController",
    templateUrl: "/"+projectName+"/pages/tag/tag.html"
})
   .state("tag.tagdetail", {
    url:"/tagdetail/:tagid",
    controller:"TagDetailController",
    templateUrl: "/"+projectName+"/pages/tag/tagdetail.html",
    onEnter: function($stateParams,$state){
            if($stateParams.tagid==undefined||$stateParams.tagid==""){
                $state.go("tag.tagindex");
            }
        }

    })
   .state("tag.tagindex", {
    url:"/tagindex",
    controller:"TagIndexController",
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