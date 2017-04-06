package com.example.nehal.frag_example;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Nehal on 4/4/2017.
 */

class Send_Form_Data extends AsyncTask<String,Void,Void>
{
    private int responseCode=0;
    private Context mContext;

    public Send_Form_Data(Context context)
    {
        mContext=context;
    }

    @Override
    protected Void doInBackground(String... strings)
    {


        try {

            Log.e("Sendfordata : ", "doInBackground: "+strings[0] );



            URL mUrl = new URL(strings[0]);
            HttpURLConnection httpConnection = (HttpURLConnection) mUrl.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Content-length", "0");
            httpConnection.setUseCaches(false);
            httpConnection.setAllowUserInteraction(false);
            httpConnection.setConnectTimeout(1000);
            httpConnection.setReadTimeout(10000);

            httpConnection.connect();

            responseCode = httpConnection.getResponseCode();





        }
        catch (Exception e)
        {
            Log.e("SendFormData : ", "doInBackground: "+e );
        }
        return null;

    }

    @Override
    protected void onPostExecute(Void Void)
    {

        super.onPostExecute(Void);
        if(responseCode==200)
        {

            Log.e("Response code", "Data succesfully sent.");
            Toast.makeText(mContext,"Thank you for your feedback!",Toast.LENGTH_LONG).show();


        }
        else
        {
            Log.e("Response code", "Data not sent." );
            Toast.makeText(mContext,"Some error occured! Please try again!",Toast.LENGTH_LONG).show();



        }

    }
}
