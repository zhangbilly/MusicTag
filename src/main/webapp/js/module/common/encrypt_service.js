Common.service('encryptService', function() {
	this.encrypt = function(string) {
		var shaObj = new jsSHA("SHA-1", "TEXT");
		shaObj.update(string);
		var hash = shaObj.getHash("HEX");
		return hash;
	}
});