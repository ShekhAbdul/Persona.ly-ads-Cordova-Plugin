function PersonaPlugin(appHash, userId) {
	
	this.init = function(successCallback, failureCallback) {
		cordova.exec(successCallback, failureCallback, 'PersonaPlugin', 'init', [appHash, userId]);
		console.log("PersonaPlugin.js: init");
	};
	this.fetchAd = function(successCallback, failureCallback) {
		cordova.exec(successCallback, failureCallback, 'PersonaPlugin', 'fetchAd', []);
		console.log("PersonaPlugin.js: fetchAd");
	};
}

if(typeof module !== undefined && module.exports) {

	module.exports = PersonaPlugin;
}