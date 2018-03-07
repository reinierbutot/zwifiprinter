package com.github.jmier.zwifiprinter;

import java.io.IOException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import android.os.Looper;
import com.zebra.android.discovery.*;
import com.zebra.sdk.comm.*;
import com.zebra.sdk.printer.*;


 import java.util.ArrayList;
 import java.util.List;

public class ZebraWiFiPrinter extends CordovaPlugin {

    private static final String LOG_TAG = "ZebraWiFiPrinter";

    public ZebraWiFiPrinter() {}

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("find")) {
            try {
                findPrinter(callbackContext);
            } catch (Exception e) {
                Log.e(LOG_TAG, e.getMessage());
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
	
	DiscoveryHandler discoveryHandler = new DiscoveryHandler() {
		 List<DiscoveredPrinter> printers = new ArrayList<DiscoveredPrinter>();

		 public void foundPrinter(DiscoveredPrinter printer) {
			 printers.add(printer);
		 }

		 public void discoveryFinished() {
			 for (DiscoveredPrinter printer : printers) {
				 System.out.println(printer);
			 }
		 }

		 public void discoveryError(String message) {

		 }
	 };

    public void findPrinter(final CallbackContext callbackContext) {
      	try {
			NetworkDiscoverer.findPrinters(discoveryHandler);
        });
      	} catch (Exception e) {
        	// Handle communications error here.
        	callbackContext.error(e.getMessage());
      	}
    }

}

