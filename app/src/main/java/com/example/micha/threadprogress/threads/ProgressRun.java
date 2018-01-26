package com.example.micha.threadprogress.threads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.micha.threadprogress.utils.Constants;



/**
 * Created by micha on 1/25/2018.
 */

public class ProgressRun implements Runnable{
    Handler handler;
    int number;
    double toReach;

    public ProgressRun(Handler handler, int number, double toReach) {
        this.handler = handler;
        this.number = number;
        this.toReach = toReach;
    }

    @Override
    public void run() {
        for (int i = 0; i < toReach ; i++) {
              int percent = (int) Math.round(i/toReach);
              if(percent%10==0){
                  sendProgress(i,percent);
              }
        }
    }


    private void sendProgress(int currentProgress, int percent){
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.KEYS.NUMPROGRESS,number);
        bundle.putInt(Constants.KEYS.PROGRESS,currentProgress);
        Message message = new Message();
        message.setData(bundle);
        handler.sendMessage(message);
    }
}
