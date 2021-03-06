package com.abhirva.timer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("lpg","onTick: I am hero");
            }

            @Override
            public void onFinish() {
                Log.d("lpg","Finish it");
            }
        }.start();

        // Task Scheduler using Handler and Runnable
        //        final Handler handler = new Handler();
        //        Runnable run = new Runnable() {
        //            @Override
        //            public void run() {
        //                // Code to Execute
        //                number++;
        //                Toast.makeText(MainActivity.this, "This is toast" + number , Toast.LENGTH_SHORT).show();
        //                handler.postDelayed(this,1000);
        //
        //            }
        //        };
        //        handler.post(run);


    }
}
