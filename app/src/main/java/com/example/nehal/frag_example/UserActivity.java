package com.example.nehal.frag_example;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.provider.Settings;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.Toast;


/**
 * Activity that shows information about the currently logged in user
 */
public class UserActivity extends DropboxActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_user);

        Log.e("User Activity : ", "onCreate: " );

//        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
//        setSupportActionBar(toolbar);

//        Button filesButton = (Button)findViewById(R.id.files_button);
//        filesButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {

                Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();


                if(haveNetworkConnection())
                {
                    //Default call back value taking -3 for some reason
                    startActivity(FilesActivity.getIntent(UserActivity.this, "",1));
                }
                else
                {
                    new AlertDialog.Builder(UserActivity.this)
                            .setTitle("Network not available.")
                            .setMessage("Press OK to open settings.")
                            .setNegativeButton(android.R.string.cancel, null) // dismisses by default
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                  startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                                }
                            })
                            .create()
                            .show();

                }
            }
       // });
    //}

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void loadData()
    {}


    private boolean haveNetworkConnection()
    {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
