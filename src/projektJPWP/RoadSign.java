package projektJPWP;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RoadSign extends JPanel {
    public int currImage;
    //wspolrzedne znaku
    int x;
    int y;

    public int sWidth;
    public int sHeight;

    public Image signImages[];

    public RoadSign(int x, int y, Image[] signImagesGpars){
        this.x = 670;
        this.y = 100;

        sWidth=1024;
        sHeight=768;
        currImage = 0;

        signImages =  signImagesGpars;

        // Random rd = new Random();



    }

}
