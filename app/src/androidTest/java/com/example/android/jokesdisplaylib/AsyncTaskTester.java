package com.example.android.jokesdisplaylib;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.util.Pair;

import com.udacity.gradle.builditbigger.ApiCallback;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
//helped me a lot: https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTester implements ApiCallback {
    private SyncronizeTalker async;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        async = new SyncronizeTalker();
        Context appContext = InstrumentationRegistry.getTargetContext();
        new EndpointsAsyncTask().execute(new Pair<Context, ApiCallback>(appContext, this));
        async.doWait();
    }

    @Override
    public void showJoke(String joke) {
        assertNotNull(joke);
        async.doNotify();
    }

    class SyncronizeTalker {
        public void doWait(long l) {
            synchronized (this) {
                try {
                    this.wait(l);
                } catch (InterruptedException e) {
                }
            }
        }


        public void doNotify() {
            synchronized (this) {
                this.notify();
            }
        }


        public void doWait() {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}


