package com.application.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Sample Video URI: http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4
    // Sample Audio URI: https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3

    Button localAudioBtn, cameraBtn, streamAudioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localAudioBtn = findViewById(R.id.localAudioBtn);
        cameraBtn = findViewById(R.id.cameraBtn);
        streamAudioBtn = findViewById(R.id.streamAudioBtn);

        cameraBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
        });

        localAudioBtn.setOnClickListener(v -> {
            openLocalAudioActivity();
        });

        streamAudioBtn.setOnClickListener(v -> {
            openStreamContentActivity();
        });

    }

    public void openStreamContentActivity() {
        Intent intent = new Intent(this, StreamContentActivity.class);
        startActivity(intent);
    }

    public void openLocalAudioActivity() {
        Intent intent = new Intent(this, LocalAudioActivity.class);
        startActivity(intent);
    }

}