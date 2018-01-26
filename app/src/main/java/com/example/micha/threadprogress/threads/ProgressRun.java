package com.example.micha.threadprogress.threads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.micha.threadprogress.utils.Constants;



/**
 * Created by micha on 1/25/2018.
 */

public class ProgressRun implements Runnable{

    public static final String TAG = ProgressRun.class.getSimpleName();
    private Handler handler;
    private int number;
    private double toReach;

    public ProgressRun(Handler handler, int number, double toReach) {
        this.handler = handler;
        this.number = number;
        this.toReach = toReach;
    }

    @Override
    public void run() {
        for (int i = 0; i <= toReach ; i++) {
              int percent = (int) Math.round(i/toReach*100);
              if(percent%10==0){
                  sendProgress(percent);
              }
              try {
                  Thread.sleep(500);
              }
              catch (InterruptedException e) {
                  e.printStackTrace();
              }
        }
    }


    private void sendProgress(int percent){
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.KEYS.NUMPROGRESS,number);
        bundle.putInt(Constants.KEYS.PROGRESS,percent);
        Message message = new Message();
        message.setData(bundle);
        handler.sendMessage(message);
        Log.d(TAG, "sendProgress: "+percent+" "+Thread.currentThread());
    }
}
