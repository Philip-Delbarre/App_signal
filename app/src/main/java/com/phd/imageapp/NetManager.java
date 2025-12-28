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

    public String statusFeedback ( Network network)  {

        if (cm == null) {
            return "Service réseau indisponible";
        }

        if (network == null) {
            return "Aucun réseau actif";
        }

        NetworkCapabilities caps = cm.getNetworkCapabilities(network);
        if (caps == null) {
            return "Pas de capacités réseau";
        }

        if (caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
            return "Connecté à Internet \uD83D\uDCF6 - \uD83D\uDC4D";
        } else {
            return "Pas d'accès Internet";
        }
    }
}
