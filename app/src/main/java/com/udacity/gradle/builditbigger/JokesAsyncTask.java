package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.seliverstov.jokesactivity.JokesActivity;
import com.seliverstov.jokesbackend.jokesApi.JokesApi;

import java.io.IOException;

/**
 * Created by a.g.seliverstov on 12.01.2016.
 */
public class JokesAsyncTask extends AsyncTask<String, Void, String> {
    public static final String DEFAULT_ROOT_URL = "http://10.0.2.2:8080/_ah/api/";

    private static final String TAG = JokesAsyncTask.class.getSimpleName();
    private static JokesApi jokesApiService = null;


    @Override
    protected String doInBackground(String... params) {
        String url = (params==null || params.length==0 || params[0]==null || params[0].isEmpty())? DEFAULT_ROOT_URL: params[0];

        if(jokesApiService == null) {
            JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl(url)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            jokesApiService = builder.build();
        }

        try {
            return jokesApiService.getJoke().execute().getText();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
            return null;
        }
    }
}
