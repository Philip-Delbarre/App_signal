package com.phd.imageapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class SignalStrengthHelper {

    private Context context;
    private int level;
    private TelephonyManager telephonyManager;


    public SignalStrengthHelper(Context context) {
        this.context = context;
        telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    public void startListening() {


        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Permission READ_PHONE_STATE requise", Toast.LENGTH_SHORT).show();
            return;
        }

        telephonyManager.listen(new PhoneStateListener() {
            @Override
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                super.onSignalStrengthsChanged(signalStrength);

                // Exemple : force du signal en dBm pour LTE
                SignalStrengthHelper.this.level = signalStrength.getLevel(); // valeur de 0 (mauvais) à 4 (excellent)
                //int dbm = signalStrength.getDbm();     // valeur réelle en dBm

                Toast.makeText(context,
                        "Signal: " + level + " / ",
                        Toast.LENGTH_SHORT).show(); // dbm + " Dbm" pour afficher la puissance di signal
            }
        }, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);

    }

public int getLevel(){
        return SignalStrengthHelper.this.level;
}

}
