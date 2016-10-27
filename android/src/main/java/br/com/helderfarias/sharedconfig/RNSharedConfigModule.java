
package br.com.helderfarias.sharedconfig;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONObject;
import org.json.JSONException;

public class RNSharedConfigModule extends ReactContextBaseJavaModule {

  private static final String SHARED_NAME = "br.com.helderfarias.sharedconfig.PREFS_SHARED_CONFIG_MODULE";

  private final ReactApplicationContext reactContext;

  public RNSharedConfigModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNSharedConfig";
  }

  @ReactMethod
  public void setItem(String key, String value, Promise promise) {
      try {
          Context ctx = getReactApplicationContext();
          SharedPreferences sharedPref = ctx.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);

          SharedPreferences.Editor editor = sharedPref.edit();
          editor.putString(key, value);
          editor.commit();

          promise.resolve(true);
      } catch(Exception ex) {
          promise.reject(ex.getMessage());
      }
  }

  @ReactMethod
  public void getItem(String key, Promise promise) {
      try {
          Context ctx = getReactApplicationContext();
          SharedPreferences sharedPref = ctx.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);

          promise.resolve(sharedPref.getString(key, ""));
      } catch(Exception ex) {
          promise.reject(ex.getMessage());
      }
  }

  @ReactMethod
  public void removeItem(String key, Promise promise) {
      try {
          Context ctx = getReactApplicationContext();
          SharedPreferences sharedPref = ctx.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);

          SharedPreferences.Editor editor = sharedPref.edit();
          editor.remove(key);
          editor.commit();

          promise.resolve(true);
      } catch(Exception ex) {
          promise.reject(ex.getMessage());
      }
  }

}