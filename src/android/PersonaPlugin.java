
import android.util.Log;
import android.webkit.WebView;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import  ly.persona.sdk.PersonaSdk;


public class PersonaPlugin extends CordovaPlugin {
	public static final String TAG = "PersonaPlugin";
	
	
	
	public PersonaPlugin() {}
	
	 @Override
    protected void pluginInitialize() {
    	super.pluginInitialize();
    	
	}

	
	@Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            Log.i(TAG, action);
			//webView.loadUrl("javascript:console.log('" + action + "');");
            if (action.equals("init")) {
				
				//MonetizationManager.createSession(this.cordova.getActivity().getApplicationContext() , args.getString(0), args.getString(1), sessionListener);
				PersonaSdk.init (this.cordova.getActivity().getApplicationContext(), args.getString(0), args.getString(1));
				Log.v(TAG, "Create Sesssion");
                callbackContext.success();
            }else if (action.equals("fetchAd")) {
					PersonaSdk.showOffers();
				Log.v(TAG, "fetchAd");
                callbackContext.success();
            }  else {

                callbackContext.error("Unknown Action");
                return false;
            }
            return true;
        } catch (Exception e) {

            Log.e("Persona.lyPlugin", e.getMessage());
            callbackContext.error("Persona.lyPlugin: " + e.getMessage());
            return false;
        }
    }
	
	
}