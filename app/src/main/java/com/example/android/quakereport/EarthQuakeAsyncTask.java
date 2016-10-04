package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by ProJava on 8/30/2016.
 */
public class EarthQuakeAsyncTask extends AsyncTaskLoader<List<Earthquake>> {


    private static final String LOG_TAG = EarthQuakeAsyncTask.class.getName();

    private String mUrl;

    public EarthQuakeAsyncTask(Context context,String mUrl) {
        super(context);

        this.mUrl = mUrl;
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if(mUrl == null)
        {

            return null;

        }

        List<Earthquake> quakes  = QueryUtils.fetchEarthquakeData(mUrl);

        return quakes;
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }
}
