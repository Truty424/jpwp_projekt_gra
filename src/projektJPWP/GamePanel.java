package projektJPWP;



import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.JPanel;

public class GamePanel extends JPanel {


    private Car car;
    private RoadSign sign;

    private boolean PassCorrectly = false;



    public GamePanel(){
        car = new Car(540,540, GPars.carImages);
        sign = new RoadSign(getX(),getY(), GPars.signImages);
        this.setFocusable(true);
        addKeyListener(new KeyAdapter(){
                @Override
            public void keyPressed(KeyEvent ke){
                    switch(ke.getKeyCode()){
                        case  KeyEvent.VK_A :
                            car.dy=0;
                            car.dx=14;
                            car.currImage=1;
                            checkIfCorrectTurnLeft(car);
                            break;
                        case  KeyEvent.VK_W :
                            car.dy=10;
                            car.dx=0;
                            car.currImage=0;
                            break;
                        case  KeyEvent.VK_S :
                            car.dy=-3;
                            car.dx=0;
                            car.currImage=0;
                            break;
                        case  KeyEvent.VK_D :
                            car.dy=0;
                            car.dx=-14;
                            car.currImage=2;
                            break;
                        case  KeyEvent.VK_SPACE:
                            car.dy=0;
                            car.dx=0;
                            car.currImage=0;
                            checkIfCorrectStop(car);
                            break;
                    }


            }

        });
    } // koniec konstruktora klasy GamePanel

    public void checkIfCorrectStop(Car car){
        if (sign.currImage == 0) {

                if (car.currY > 170 && car.currY < 300) {
                    PassCorrectly = true;
                } else{
                    restartGame();
                }
        }
    }

    public void checkIfCorrectTurnLeft(Car car){
        if (sign.currImage == 3){

            if(car.currY > 70 && car.currY < 180){
              //
            }else { restartGame(); }

        }



    }


    @Override
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;

        g.drawImage(GPars.bgImage, 0, 0, null);

        car.carMovement();

        g.drawImage(car.carImages[car.currImage], car.currX, car.currY, null);
        g.drawImage(sign.signImages[sign.currImage],sign.x , sign.y, null);

        if(car.currY < -100) {
            if (PassCorrectly) {
                nextLevel();
            } else {
                restartGame();
            }
        }
    }

    private void nextLevel()  {
        car = new Car(540,540, GPars.carImages);
        sign.currImage++;
        PassCorrectly = false;

    }

    private void restartGame(){
        car = new Car(540,540, GPars.carImages);
        //car.currX=540;
        //car.currY=540;
        //car.currImage=0;
        //car.dy=10;
        //car.dx=0;
    }


}// koniec klasy GamePanel



