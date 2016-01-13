package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by a.g.seliverstov on 13.01.2016.
 */
public class JokesAsyncTaskTest extends AndroidTestCase {
    String mJoke;

    public void setUp(){
        mJoke=null;
    }

    public void testGetJoke() throws InterruptedException {

        final CountDownLatch signal = new CountDownLatch(1);

        JokesAsyncTask task = new JokesAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                mJoke=result;
                signal.countDown();
            }
        };

        task.execute(getContext());

        signal.await(60, TimeUnit.SECONDS);

        assertNotNull(mJoke);
        assertFalse(mJoke.isEmpty());
    }
}
