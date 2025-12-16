package com.phd.imageapp;


import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

public class NetManager {
   private String txtRetour;
   private Network activeNetwork;
   private ConnectivityManager cm;
      public NetManager (ConnectivityManager cm, String txtRetour, Network activeNetwork ){
        this.txtRetour = txtRetour;
        this.activeNetwork = activeNetwork;
        this.cm = cm;
    }

    public String statusFeedback ( Network activeNetwork)  {

    String txtRetour;
        if (activeNetwork != null) {
            NetworkCapabilities caps = this.cm.getNetworkCapabilities(activeNetwork);
            if (caps != null && caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
                txtRetour = "Connecté à Internet ✅";

            } else {
                txtRetour = "Pas de connexion mobile";
            }
        }
        else { txtRetour = "Pas de connexion";}

        return txtRetour;
    }
}
