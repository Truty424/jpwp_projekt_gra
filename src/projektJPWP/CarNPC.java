package projektJPWP;

import javax.swing.*;
import java.awt.*;

public class CarNPC extends JPanel{

    /** współrzędne auta */
    public int x;
    public int y;

    /** tymczasowe położenie auta */
    public int currX;
    public int currY;

    /** parametry przesunięcia sie auta */
    public int dy;
    public int dx;

    public Image carNPCImage;


    public CarNPC(int x, int y, Image carNPCImageGPars){
        this.x = 0;
        this.y = 200;
        currX = x;
        currY = y;
        this.dy=0;
        this.dx=10;

        carNPCImage = carNPCImageGPars;

    }

    //poruszanie się auta w lini prostej X
    public void carNPCmovement(){
        currX = currX + dx;
    }


}
