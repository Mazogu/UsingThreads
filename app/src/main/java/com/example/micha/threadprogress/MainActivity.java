package com.example.micha.threadprogress;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressBar one = findViewById(R.id.progress1);
        ProgressBar two = findViewById(R.id.progress2);
        ProgressBar three = findViewById(R.id.progress3);
        ProgressBar four = findViewById(R.id.progress4);
        ProgressBar five = findViewById(R.id.progress5);
    }

    public void start(View view) {
    }

    @Override
    public boolean handleMessage(Message message) {
        return false;
    }
}
