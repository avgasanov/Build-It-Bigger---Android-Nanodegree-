package com.example.android.jokesdisplaylib;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

public class JokesActivity extends AppCompatActivity {
    public static String JOKE_EXTRA = "joke_extra";
    private String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        //Restore joke from saved instance, or get joke from intent
        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (intent != null) {
                joke = intent.getStringExtra(JOKE_EXTRA);
            }
        } else {
            joke = savedInstanceState.getString(JOKE_EXTRA);
        }

        //if joke is not empty (or null) show joke, otherwise show error toast
        if (TextUtils.isEmpty(joke)) {
            Toast
                    .makeText(this, getString(R.string.no_joke_found), Toast.LENGTH_SHORT)
                    .show();
        } else {
            TextView jokesTextView = findViewById(R.id.joke_tv);
            jokesTextView.setText(joke);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceStateCommon(outState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        saveInstanceStateCommon(outState);
    }

    private void saveInstanceStateCommon(Bundle outState) {
        outState.putString(JOKE_EXTRA, joke);
    }
}
