package projektJPWP;

import javax.swing.*;
import java.awt.*;

public class CarNPC extends JPanel{

    public int x;           //wsporzedne auta
    public int y;
    public int currX;
    public int currY;
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

    public void carNPCmovement(){
        currX = currX + dx;
    }


}
