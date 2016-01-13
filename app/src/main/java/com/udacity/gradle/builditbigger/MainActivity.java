package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.seliverstov.jokesactivity.JokesActivity;


public class MainActivity extends AppCompatActivity {
    ProgressBar mProgressBar;
    View mMainView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        mMainView = findViewById(R.id.mainView);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        /*Toast.makeText(this, Jokes.getRandomJoke(), Toast.LENGTH_SHORT).show();*/

        /*Intent intent = new Intent(this, JokesActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,Jokes.getRandomJoke());
        startActivity(intent);*/
        showJoke();
    }

    protected void showJoke(){
        AsyncTask<String,Void,String> task = new JokesAsyncTask(){
            @Override
            protected void onPreExecute() {
                if (mProgressBar!=null){
                    mProgressBar.setVisibility(View.VISIBLE);
                }
                if (mMainView!=null){
                    mMainView.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            protected void onPostExecute(String result) {
                if (mProgressBar!=null){
                    mProgressBar.setVisibility(View.GONE);
                }
                if (mMainView!=null){
                    mMainView.setVisibility(View.VISIBLE);
                }
                Intent intent = new Intent(MainActivity.this, JokesActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT,result);
                startActivity(intent);
            }
        };
        task.execute();
    }

}
