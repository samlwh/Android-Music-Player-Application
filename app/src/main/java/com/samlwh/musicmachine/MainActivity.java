package com.samlwh.musicmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mDownloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDownloadButton = (Button) findViewById(R.id.downloadButton);

        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Downloading", Toast.LENGTH_SHORT).show();

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        downloadSong();
                    }
                };

                Thread thread = new Thread(runnable);
                thread.setName("DownloadThread");
                thread.start();
            }
        });
    }

    private void downloadSong() {
        long endTime = System.currentTimeMillis() + 10*1000;
        while (System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "Song downloaded!");
    }
}