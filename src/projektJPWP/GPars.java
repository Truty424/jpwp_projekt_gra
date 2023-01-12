package projektJPWP;

import javax.swing.*;
import java.awt.*;


public class GPars {
    public static Image bgImage;
    public static Image menuImage;
    public static Image endImage;
    public static Image passedImage;
    public static Image carImages[];
    public static Image signImages[];
    public static Image carNPCImage;
    public final static int  number_of_levels = 7;

    public static long startTime;
    public static long GAME_TIME=Long.MAX_VALUE;


    public static void loadInitialImages() {
        bgImage = loadImage("images/crossroad.jpg");

        menuImage = loadImage("images/menu.png");

        endImage = loadImage("images/notpass.png");

        passedImage = loadImage("images/passedExam.png");

        carImages = new Image[3];
        carImages[0]=loadImage("images/autotest4.png");
        carImages[1]=loadImage("images/auto_lewo1.png");
        carImages[2]=loadImage("images/auto_prawo.png");

        signImages = new Image[number_of_levels];
        signImages[0]=loadImage("images/stop.png");
        signImages[1]=loadImage("images/ustap_pierwszenstwo.png");
        signImages[2]=loadImage("images/pierwszenstwo.png");
        signImages[3]=loadImage("images/nakazlewo.png");
        signImages[4]=loadImage("images/czerwone.png");
        signImages[5]=loadImage("images/zielone.png");
        signImages[6]=loadImage("images/nakazprawostop.png");

        carNPCImage = loadImage("images/carNPC.png");

    }

    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }
}
