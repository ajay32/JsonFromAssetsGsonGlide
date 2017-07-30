package ajaymehta.jsonfromassetsgsonglide;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajay Mehta on 7/30/2017.
 */

public class Utils {

    private static final String TAG = "Utils";

    public static List<Profile> loadProfiles(Context context) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();                                                     // create gson..
            JSONArray jsonArray = new JSONArray(loadJSONFromAsset(context, "profiles.json")); //jsongArray getting json in form of String    // call the method loadJSONFROMAsset to get string value ..n put it in json array (see profile.json --> we have array outside n have several objects in it .)
            List<Profile> profileList = new ArrayList<>();       // arrray list that will (in loop) store objects of type Profile         // so there are no of objects we getting from json file type(Profile objects)[details of every user- every user has a object in json file]
            for (int i = 0; i < jsonArray.length(); i++) {
                // gson.fromJson (will work as a setter n whole line will behave like  profile.setName, profile.setLocation, profile.setAge etc..)
                Profile profile = gson.fromJson(jsonArray.getString(i), Profile.class);   // getting string value from every position of jsonArray (at every position object will be in string form)  n setting into Profile object
                profileList.add(profile);   // then added object in profile type arraylist ..
            }
            return profileList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }





    // getting data from json file (in asset folder)
    private static String loadJSONFromAsset(Context context, String jsonFileName) {
        String json = null;
        InputStream is = null;
        try {
            AssetManager manager = context.getAssets();    // fist get asset manager
            Log.d(TAG, "path " + jsonFileName);
            is = manager.open(jsonFileName);           // then open jsonfile we pass in parameter of this method..
            int size = is.available();                 // take size of input stream
            byte[] buffer = new byte[size];             // create buffer arrary with input stream
            is.read(buffer);                            // then read from input stream into buffer..
            is.close();
            json = new String(buffer, "UTF-8");            // then put buffer in the String named json..
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;                                        // then return the sting
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

}

