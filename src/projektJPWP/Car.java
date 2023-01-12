package projektJPWP;

import javax.swing.*;
import java.awt.*;



public class Car extends JPanel{
    public int x;           //wsporzedne auta
    public int y;

    public int currX;
    public int currY;
    public int dy;
    public int dx;

    public int carWidth;
    public int carHeight;

    public int sWidth;
    public int sHeight;

    public int currImage;

    public boolean hasStopped=false;




    public Image carImages[];


    public Car(int x, int y,Image[] carImagesGpars){
        this.x=540;
        this.y=540;
        currX=x;
        currY=y;
        this.dy=0;
        this.dx=0;
        sWidth=1024;
        sHeight=768;
        currImage = 0;

        carImages=carImagesGpars;




    } // koniec konstruktora klasy Car


    public void carMovement(){

            currY = currY - dy;
            currX = currX - dx;

    } //koniec carMovement

    public void setCarHitbox(){
        if(this.currImage == 0){
            this.carHeight = 254;
            this.carWidth = 200;
        }else {
            this.carHeight = 150;
            this.carWidth = 305;
        }
    }

}//koniec klasy Car





