package projektJPWP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;


public class Car extends JPanel{
    public int x;           //wsporzedne auta
    public int y;

    public int currX;
    public int currY;
    public int dy;
    public int dx;

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
        this.dy=10;
        this.dx=0;
        sWidth=1024;
        sHeight=768;
        currImage = 0;

        carImages=carImagesGpars;


    } // koniec konstruktora klasy Car


    public void carMovement(){

            currY = currY - dy;
            currX = currX - dx;
//            if (currY > sHeight) {
//                currY = 0;
//            }
    } //koniec carMovement




}//koniec klasy Car





