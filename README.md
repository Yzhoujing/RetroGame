# Retro Game - FlappyMario


## Game Overview 

This game is based on the Flappy Bird and make some UI change from bird to Mario. The score is the count of tubes be safely passed.

Initial Game Lauch </n>

![initial-screen](https://gitlab.cecs.anu.edu.au/u6490332/RetroGame2018s2/uploads/3ca435219185428f9e3d63e25e0df578/Screen_Shot_2018-10-19_at_11.48.21.png)

Game In-Progress </n>

![game-in-progress](https://gitlab.cecs.anu.edu.au/u6490332/RetroGame2018s2/uploads/390400457568670cd1b95587d94e9a2c/Screen_Shot_2018-10-19_at_11.58.50.png)

Gameover </n>

![score-board](https://gitlab.cecs.anu.edu.au/u6490332/RetroGame2018s2/uploads/ee5f290e3a038a8aa4f83e36bfb4e1d9/Screen_Shot_2018-10-19_at_12.05.11.png)


### Inspiration

Because I love Mario and flappy bird. And we want to combine these two classic game into one to arouse people's memories and bring them happiness. 

### Code

```
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
```


### Assets 

![backgroundtest2](https://drive.google.com/uc?id=1GMsI9_D9EXJl1Bx7_h_Uj2WT7KD4qpnb)

![backgroundtest](https://drive.google.com/uc?id=1DnHlgsMUAr4F4CU1UmpJT4NhIO1bfP5E)

![btn_play_hover](https://drive.google.com/uc?id=1qRddjLA6XEjtOmR5r5BkrZbvViKuyTqW)

![btn_play](https://drive.google.com/uc?id=1QAQ20rF4AKXPdsMapofsCdApWWTB2NSp)

![m1](https://drive.google.com/uc?id=1ZITpr5YWMerlzM59iGE6g9-senRdSK1_)

![m2](https://drive.google.com/uc?id=1HGKSLP1mFON0YpWw3aU5FeEOEwuLLKYj)

![main](https://drive.google.com/uc?id=1aGTh5wKCENTPMGMt_M65xhNCbddVrB1h)

![replay](https://drive.google.com/uc?id=1OuNd4dhDYH9n7p4glQVzR7qMW8MznE4A)

![title](https://drive.google.com/uc?id=1Mc7ERToEbr8rvpevtFYEv16LNifPlry7)

![tubedown](https://drive.google.com/uc?id=1UViin-P87Fr8PpMIk8zOl0JKq7I9KbBx)

![tubeup](https://drive.google.com/uc?id=1Xja9eGOcT6j1GqYeuwrU0RUzavP8p5lR)
