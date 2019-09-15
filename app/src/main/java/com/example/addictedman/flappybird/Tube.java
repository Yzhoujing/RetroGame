package com.example.addictedman.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.Random;


public class Tube {
    private static Bitmap image;
    private static Bitmap image1;
    public static float x1;
    public static float y1;
    static float screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
    static float screenWeight = Resources.getSystem().getDisplayMetrics().widthPixels;
    static Random random=new Random();
    static int gapDistance=random.nextInt((int)screenWeight/4);
    //the distance between two tubes
    static int baselineTube;
    //length of the part of tubedown outside the screen




    public Tube(Bitmap a,Bitmap b,int x,int y){
        image=a;
        image1=b;
        x1=x;
        y1=y;
    }
    public static Bitmap getResizedBitmap(Bitmap image, int newWidth, int newHeight){
        int width = image.getWidth();
        int height = image.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap =
                Bitmap.createBitmap(image, 0, 0, width, height, matrix, false);
        image.recycle();
        return resizedBitmap;
    }

    public float getX(){
        return x1;
    }
    public float getY(){
        return y1;
    }
    //get Y coordinate of Tube

    public static void update(){
        x1-=GameView.vel;
        if (x1<=-screenWeight/5){
            x1=screenWeight;
            gapDistance=random.nextInt((int)screenWeight/4);
            baselineTube=random.nextInt( (int)(screenWeight/3));

        }

    }
    //change the x coordinate of tubes

    public static void draw(Canvas t) {
        t.drawBitmap(image, x1,-baselineTube -GameView.gapBonus /2+y1,null);
        t.drawBitmap(image1,x1, screenWeight- baselineTube +gapDistance+GameView.gapBonus /2+y1, null);
        update();
    }
    //draw the tubes according to x1,y1.
    //u6490332 ZhoujingYang
}
