package com.wang.yashi.player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.session.MediaController;
import android.os.Bundle;

import com.pili.pldroid.player.widget.PLVideoView;
import com.wang.yashi.R;

public class PlayerPage extends AppCompatActivity {
    private PLVideoView mPLVideoView;
    MediaController mMediaController;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_page);
    }
}
