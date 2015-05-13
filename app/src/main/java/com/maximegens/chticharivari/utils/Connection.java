package com.maximegens.chticharivari.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Connection {
    /**
     * Indique si le device est connecté à Internet
     * @param activity L'activity qui demande le test de connection à internet
     * @return boolean indique si le device est connecté ou non.
     */
    public static boolean isConnectedInternet(Activity activity)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null)
        {
            NetworkInfo.State networkState = networkInfo.getState();
            if (networkState.compareTo(NetworkInfo.State.CONNECTED) == 0)
            {
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}
