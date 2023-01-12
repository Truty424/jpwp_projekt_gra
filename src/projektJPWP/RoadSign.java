package projektJPWP;


import javax.swing.*;
import java.awt.*;


public class RoadSign extends JPanel {

    /** zmiena określająca obecny znak */
    public int currImage;

    /** współrzędne znaku */
    int x;
    int y;

    /** szerokość i wysokość pola graficznego */
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
    }

}
