package com.example.labdesenvolvimento.mbfinal;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    MediaPlayer mySound;

    @Override
    protected void onPause() {
        super.onPause();
        mySound.release();
    }

    Button btn_abrir;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySound = MediaPlayer.create(this, R.raw.m1);

        btn_abrir = (Button)findViewById(R.id.btn_abrir);
        btn_abrir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_abrir){
            String url = "http://murillobacchi.com.br/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

    }
    public void playMusic(View view) {
        mySound.start();
    }
}
