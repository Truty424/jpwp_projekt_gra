package projektJPWP;

import javax.swing.*;
import java.awt.*;



public class Car extends JPanel{

    /** współrzędne auta */
    public int x;
    public int y;

    /** tymczasowe położenie auta */
    public int currX;
    public int currY;

    /** parametry przesunięcia sie auta */
    public int dy;
    public int dx;

    /** szerokość i wysokość auta */
    public int carWidth;
    public int carHeight;

    /** szerokość i wysokość pola graficznego */
    public int sWidth;
    public int sHeight;

    /** zmiena określająca obecny profil auta */
    public int currImage;

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

    //poruszanie sie auta w lini prostej x i y
    public void carMovement(){

            currY = currY - dy;
            currX = currX - dx;

    } //koniec carMovement

    //ustawienie szerokości i wysokości zależące od profilu auta
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





