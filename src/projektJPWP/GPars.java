package projektJPWP;

import javax.swing.*;
import java.awt.*;


public class GPars {
    public static Image bgImage;
    public static Image carImages[];
    public static Image signImages[];

    public final static int  number_of_levels = 6;

    public static long startTime;
    public static long GAME_TIME=Long.MAX_VALUE;


    public static void loadInitialImages() {
        bgImage = loadImage("images/crossroad.jpg");

        carImages = new Image[3];
        carImages[0]=loadImage("images/autotest4.png");
        carImages[1]=loadImage("images/auto_lewo1.png");
        carImages[2]=loadImage("images/auto_prawo.png");

        signImages = new Image[6];
        signImages[0]=loadImage("images/stop.png");
        signImages[1]=loadImage("images/ustap_pierwszenstwo.png");
        signImages[2]=loadImage("images/pierwszenstwo.png");
        signImages[3]=loadImage("images/nakazlewo.png");
        signImages[4]=loadImage("images/czerwone.png");
        signImages[5]=loadImage("images/zielone.png");

    }

    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }
}
