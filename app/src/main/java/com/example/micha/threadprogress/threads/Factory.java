package com.example.micha.threadprogress.threads;

import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 * Created by micha on 1/25/2018.
 */

public class Factory implements ThreadFactory {
    @Override
    public Thread newThread(@NonNull Runnable runnable) {
        return new Thread(runnable);
    }
}
