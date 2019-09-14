# Retro Game - FlappyMario

## Team structure and roles 
+ Zhenyu Ni u6099206 - team leader, help page code, morale builder
+ Zhoujing Yang u6490332 - note taker, documentation checker, user input
+ Weidi Wang u6781177 - tricky android code, game state, game graphics rendering

## Game Overview 

This game is based on the Flappy Bird and make some UI change from bird to Mario. The score is the count of tubes be safely passed.

![initial-screen](https://gitlab.cecs.anu.edu.au/u6490332/RetroGame2018s2/uploads/3ca435219185428f9e3d63e25e0df578/Screen_Shot_2018-10-19_at_11.48.21.png)
Initial Game Lauch 
![game-in-progress](https://gitlab.cecs.anu.edu.au/u6490332/RetroGame2018s2/uploads/390400457568670cd1b95587d94e9a2c/Screen_Shot_2018-10-19_at_11.58.50.png)
Game In-Progress
![score-board](https://gitlab.cecs.anu.edu.au/u6490332/RetroGame2018s2/uploads/ee5f290e3a038a8aa4f83e36bfb4e1d9/Screen_Shot_2018-10-19_at_12.05.11.png)
Gameover
## Design Documentation 
+ [Design Summary](designsummary)
+ [UML Diagram](umldiagram)
+ [Testing Summary](testingsummary)

## Minuted Meetings
+ [Meeting 1 - 01/10/2018 - decide team structure and game](meeting1)
+ [Meeting 2 - 04/10/2018 - divide up tasks](meeting2)
+ [Meeting 3 - 05/10/2018 - consider and plan extension aspects](meeting3)
+ [Meeting 4 - 19/10/2018 - review and practice demo](meeting4)

## Statement of Originality

I, Zhenyu Ni, declare that everything I have submitted in this assignment is entirely my own work, with exceptions given below.

I, Zhoujing Yang, declare that everything I have submitted in this assignment is entirely my own work, with exceptions given below.

I, Weidi Wang, declare that everything I have submitted in this assignment is entirely my own work, with exceptions given below.

### Inspiration

Because we both love Mario and flappy bird. And we want to combine these two classic game into one to arouse people's memories and bring them happiness. 

### Code

``public static Bitmap getResizedBitmap(Bitmap image, int newWidth, int newHeight){
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
    }``

### Assets 

![backgroundtest2](/uploads/bd16838a5138e3bd0383cb048ccebc17/backgroundtest2.jpg)

![backgroundtest](/uploads/e7d42dae05cce30b3c421f427577670b/backgroundtest.png)

![btn_play_hover](/uploads/59497cf350ef820721c57b9d650f4b91/btn_play_hover.png)

![btn_play](/uploads/951d75e8c0c95703ddcfea06ae450af1/btn_play.png)

![m1](/uploads/3a15cda76947026756b356e850989727/m1.png)

![m2](/uploads/908255317aac91f5d25deedc838941dc/m2.png)

![main](/uploads/8c8ae8b91519022d03fdd32ae47bf253/main.png)

![replay](/uploads/a78dda55f8e90175f179f5614d3e6dc7/replay.png)

![title](/uploads/e1d7104909f2ca3a9dfd6193a4cefe18/title.png)

![tubedown](/uploads/7ca507aef75f6212126f237d4b8eae85/tubedown.png)

![tubeup](/uploads/bb94fadb8cd6488b5e93ccf7264937b9/tubeup.png)
