package com.example.nehal.frag_example;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Nehal on 4/5/2017.
 */

public abstract class DropboxActivity extends AppCompatActivity
{
    @Override
    protected void onResume()
    {
        super.onResume();

        SharedPreferences prefs = getSharedPreferences("dropbox-sample", MODE_PRIVATE);
        String accessToken = prefs.getString("access-token", "FrzF67VWNp8AAAAAAAAA1-C-hQMSAFQz4uNGVLsamixbbNd2zUwF9l_mIjUrzImK");
        initAndLoadData(accessToken);
    }

    private void initAndLoadData(String accessToken)
    {
        DropboxClientFactory.init(accessToken);
        PicassoClient.init(getApplicationContext(), DropboxClientFactory.getClient());
        loadData();
    }

    protected abstract void loadData();

    protected boolean hasToken()
    {
        SharedPreferences prefs = getSharedPreferences("dropbox-sample", MODE_PRIVATE);
        String accessToken = prefs.getString("access-token", null);
        Log.e("Token : ", "hasToken: "+accessToken );
        return accessToken != null;
    }
}
