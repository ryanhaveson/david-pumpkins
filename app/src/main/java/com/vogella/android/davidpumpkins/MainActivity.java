package com.vogella.android.davidpumpkins;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer m_mediaPlayer;
    public int m_last = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.imdavidpumpkins);
    }

    @Override
    protected void onStop() {
        super.onStop();
        m_mediaPlayer.stop();
    }

    public void onClick( View v) {

        m_mediaPlayer.release();

        switch (m_last) {
            case 0:
                m_mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.imdavidpumpkins);
                m_mediaPlayer.start();
                m_last = 1;
                break;
            case 1:
                m_mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.whatsmyname);
                m_mediaPlayer.start();
                m_last = 2;
                break;
            default:
                m_last = 0;
        }
    }
}
