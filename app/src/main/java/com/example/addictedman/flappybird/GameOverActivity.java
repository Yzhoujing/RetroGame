package com.example.addictedman.flappybird;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Intent gameoverIntent = getIntent();
        int info = gameoverIntent.getIntExtra("Score", 0);
        TextView textView = findViewById(R.id.textView);
        textView.setText("Score: "+ info);
    }
    //play button
    public void Main (View view){
        //go to main activity
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    //main button
    public void rePlay (View view){
        //go to game activity
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
    }

}
