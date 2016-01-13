package com.seliverstov.jokesactivity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);
        TextView joke = (TextView)findViewById(R.id.joke);
        if (text==null) text = getString(R.string.error_message);
        joke.setText(text);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: finish(); return true;
            default: return super.onOptionsItemSelected(item);
        }

    }
}
