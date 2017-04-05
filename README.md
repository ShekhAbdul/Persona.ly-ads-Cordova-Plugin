# README #

PersonaPlugin for IONIC android app Persona.ly ads

### How to use it in IONIC APP? ###

document.addEventListener('deviceready', function onDeviceReady() {
					        var AppHash = 'Your Hash Key';
						var per = new PersonaPlugin(AppHash, user_id);
						per.init();
						per.fetchAd();
}, false);