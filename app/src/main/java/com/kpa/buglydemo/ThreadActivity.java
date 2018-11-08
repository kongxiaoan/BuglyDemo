package com.kpa.buglydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadActivity extends AppCompatActivity {

    final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 10, 1,
            TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(100));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_activity);
    }

    public void userThreadPollClick(View view) {
        for (int i = 0; i < 30; i++) {
            final int final1 = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        Log.d("ThreadPool", "run : " + final1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            poolExecutor.execute(runnable);
        }
    }
}
