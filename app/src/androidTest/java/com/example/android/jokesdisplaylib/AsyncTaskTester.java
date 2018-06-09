package com.example.android.jokesdisplaylib;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import com.udacity.gradle.builditbigger.ApiCallback;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTester implements ApiCallback {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        new EndpointsAsyncTask().execute(new Pair<Context, ApiCallback>(appContext, this));
    }

    @Override
    public void showJoke(String joke) {
        assertNotNull(joke);
    }
}


