package com.example.addictedman.flappybird;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameView gameView= findViewById(R.id.gameview1);
    }
    //play button
    public void play (View view){
        //go to game activity
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
    }
}
