MusicTag.filter('searchSong', function(){

	// All filters must return a function. The first parameter
	// is the data that is to be filtered, and the second is an
	// argument that may be passed with a colon (searchFor:searchString)

	return function(arr, searchString){

		if(!searchString){
			return arr;
		}

		var result = [];

		searchString = searchString.toLowerCase();

		// Using the forEach helper method to loop through the array
		angular.forEach(arr, function(item){

			if(item.title.toLowerCase().indexOf(searchString) !== -1){
				result.push(item);
			}

		});

		return result;
	};

});
MusicTag.filter('durationFilter',function(){
	return function(input) {
    var pattern =new RegExp("^00(:\\d{2}){2}$");
    if (pattern.test(input)) {
      input = input.substring(3);
    }
    return input;
  };
});
