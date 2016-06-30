package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.you_and_the_6);

        Button playButton = (Button)findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer){
                        Toast.makeText(MainActivity.this, "I'm Done", Toast.LENGTH_SHORT);
                    }
                });
            }
        });
        Button pauseButton = (Button)findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
            }

        });
    }
}
