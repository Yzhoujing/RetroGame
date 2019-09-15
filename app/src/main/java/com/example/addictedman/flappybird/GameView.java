package com.example.addictedman.flappybird;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


import java.util.ArrayList;


public class GameView extends View implements Runnable {
    //canvas width,height
    int canvasW, canvasH;
    //flying mario for testing
    private Bitmap marios[]=new Bitmap[2];;//ctrl + F replace all mario
    //vertical position
    int marioY;
    int marioX;
    //drop gravity
    int gravity = 0;
    //canvas setup
    public static int gapBonus = (int) (Tube.screenWeight/3);
    //fixed length, change the difficulty of game
    public static int vel=3;
    //the speed of game
    Tube tube1;
    Tube tube2;
    Tube tube3;
    Paint paint = new Paint();
    int score=0;
    int count=0;
    boolean fly=false;
    boolean die=false;
    ArrayList<Tube> tubeList= new ArrayList<>();


    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        Bitmap bitmap1;
        Bitmap bitmap2;
        //bitmap for tube
        bitmap1 = Tube.getResizedBitmap(BitmapFactory.decodeResource
                        (getResources(), R.drawable.tubedown), Resources.getSystem().getDisplayMetrics().widthPixels/5,
                Resources.getSystem().getDisplayMetrics().widthPixels);
        bitmap2= Tube.getResizedBitmap(BitmapFactory.decodeResource
                        (getResources(), R.drawable.tubeup), Resources.getSystem().getDisplayMetrics().widthPixels/5,
                Resources.getSystem().getDisplayMetrics().widthPixels);

        tube1= new Tube(bitmap1,bitmap2, (int) (Tube.screenWeight*0.8),0);
        tube2= new Tube(bitmap1,bitmap2, (int) (Tube.screenWeight),0);
        tube3= new Tube(bitmap1,bitmap2, (int) (Tube.screenWeight*1.2),0);
        tubeList.add(tube1);
        tubeList.add(tube2);
        tubeList.add(tube3);

        // initial mario
        marios [0]= Tube.getResizedBitmap(BitmapFactory.decodeResource
                        (getResources(), R.drawable.m1), Resources.getSystem().getDisplayMetrics().widthPixels/6,
                Resources.getSystem().getDisplayMetrics().widthPixels/6);
        marios [1]= Tube.getResizedBitmap(BitmapFactory.decodeResource
                        (getResources(), R.drawable.m2), Resources.getSystem().getDisplayMetrics().widthPixels/6,
                Resources.getSystem().getDisplayMetrics().widthPixels/6);



    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Tube i:tubeList){
            i.draw(canvas);
        }
    //draw tube in tubelist


        drawM(canvas);
        moveM();
        hit();
        scoring();
        checkDeath();



        //TODO score system
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        canvas.drawText("Score : "+score, canvasW-0.3f*canvasW, 50, paint);



        this.postDelayed(this, 30);

    }

    //method to check and change the score
    public void scoring(){
        for(Tube i :tubeList){
                if ( (int)i.getX() +canvasW/5==canvasW / 2-marios[1].getWidth()/2 ){
                    count++;
                    System.out.println(count);
                    score=count/3;
                }
        }
    }

    public void hit(){
        if (marioY < Tube.screenWeight-Tube.baselineTube-gapBonus/2
                && canvasW / 2+marios[1].getWidth()/2> tube1.getX() && canvasW / 2 < tube1.getX() + canvasW/5)
        {die=true;}
        //tubedown hit judge
        if (marioY > Tube.screenWeight-Tube.baselineTube +Tube.gapDistance
                && canvasW / 2+marios[1].getWidth()/2> tube1.getX() && canvasW / 2 < tube1.getX() + canvasW/5)
        {die=true;}
        //tubeup hit judge

    }


    @Override
    //when touch add a minus gravity
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            fly=true;
            gravity -= Tube.screenWeight/10;
        }
        return true;

    }

    @Override
    public void run() {
        invalidate();
    }

    public void drawM(Canvas canvas){

        //get canvas width , height
        canvasW = canvas.getWidth();
        canvasH = canvas.getHeight();
        //set mario Y position
        marioY = marios[1].getHeight();
        marioX = canvasW / 2-marios[1].getWidth()/2;
        //mario keep dropping
        marioY = marioY + gravity;

        if(fly){
            canvas.drawBitmap(marios[1], marioX, marioY, null);
            fly=false;
        }else {
            canvas.drawBitmap(marios[0], marioX, marioY, null);
        }
    }
    public void moveM(){
        //mario cannot fly higher than ceiling; lower than floor
        //set ceiling and floor
        int ceiling = marios[1].getHeight();
        int floor = canvasH - marios[1].getHeight();


        //condition check
        if (marioY < ceiling) {             //higher than ceiling , mario stay at ceiling
            marioY = 200;
            gravity = 0;

        } else if (marioY > floor) {        //lower than floor , mario stay at floor
            marioY = floor;

            die=true;

        } else
            gravity += Tube.screenWeight/100;                  //mario keep dropping



    }
    public void checkDeath(){
        if (die) {
            Intent gameoverIntent = new Intent(this.getContext(), GameOverActivity.class);
            gameoverIntent.putExtra("Score",score);
            gameoverIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION);
            getContext().startActivity(gameoverIntent);
        }
    }

}