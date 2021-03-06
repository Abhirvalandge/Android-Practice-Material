package com.abhirva.abhirvatube;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView b612 =  findViewById(R.id.b612);
        b612.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.clip);
        MediaController mediaController = new MediaController(this);
        b612.setMediaController(mediaController);
        mediaController.setAnchorView(b612);
        b612.start();
    }
}
