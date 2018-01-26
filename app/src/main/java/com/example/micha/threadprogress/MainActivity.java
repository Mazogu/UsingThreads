package com.example.micha.threadprogress;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.micha.threadprogress.threads.Factory;
import com.example.micha.threadprogress.threads.ProgressRun;
import com.example.micha.threadprogress.threads.ThreadExecutor;
import com.example.micha.threadprogress.utils.Constants;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    private ProgressBar zero;
    private ProgressBar one;
    private ProgressBar two;
    private ProgressBar three;
    private ProgressBar four;
    private Handler handler;
    private ThreadExecutor execution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero = findViewById(R.id.progress0);
        one = findViewById(R.id.progress1);
        two = findViewById(R.id.progress2);
        three = findViewById(R.id.progress3);
        four = findViewById(R.id.progress4);
        handler = new Handler(this);
        Factory factory = new Factory();
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
        queue.add(new ProgressRun(handler,0, 20.0));
        queue.add(new ProgressRun(handler,1, 100.0));
        queue.add(new ProgressRun(handler,2, 30.0));
        queue.add(new ProgressRun(handler,3, 10.0));
        queue.add(new ProgressRun(handler,4, 50.0));
        execution = ThreadExecutor.getInstance(5, 5, 100, TimeUnit.SECONDS, queue, factory);
    }

    public void start(View view) {
        execution.prestartAllCoreThreads();
    }

    @Override
    public boolean handleMessage(Message message) {
        Bundle bundle = message.getData();
        int num = bundle.getInt(Constants.KEYS.NUMPROGRESS);
        int progress = bundle.getInt(Constants.KEYS.PROGRESS);
        switch (num){
            case 0:
                zero.setProgress(progress);
                break;
             case 1:
                one.setProgress(progress);
                break;
             case 2:
                two.setProgress(progress);
                break;
             case 3:
                three.setProgress(progress);
                break;
             case 4:
                four.setProgress(progress);
                break;

        }
        return false;
    }
}
