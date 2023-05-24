package com.application.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;

public class LocalAudioActivity extends AppCompatActivity {

    StyledPlayerView styledPlayerView;
    ExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_audio);

        styledPlayerView = findViewById(R.id.exoPlayer);

        player = new ExoPlayer.Builder(getBaseContext()).build();

        styledPlayerView.setPlayer(player);

        // Build the media item
        int audioResourceId = R.raw.motivational_electronic_distant;
        Uri audioUri = Uri.parse("android.resource://" + getPackageName() + "/" + audioResourceId);
        MediaItem mediaItem = MediaItem.fromUri(audioUri);
        // Set the media item to be played
        player.setMediaItem(mediaItem);
        // Prepare the player
        player.prepare();
        // Start the playback
        player.play();
    }

    @Override
    public void onBackPressed() {
        player.stop();
        player.release();
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        player.stop();
        player.release();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        player.stop();
        player.release();
        super.onDestroy();
    }

}