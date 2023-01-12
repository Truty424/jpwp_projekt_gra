package projektJPWP;



import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import javax.swing.JPanel;


/** główny obszar graficzny gry*/
public class GamePanel extends JPanel {


    private Car car;
    private RoadSign sign;
    private CarNPC carNPC;

    private boolean PassCorrectly = false;
    private boolean hasGameStarted = false;
    private boolean gameEnd = false;
    private boolean examPassed = false;




    public GamePanel(){
        car = new Car(540,540, GPars.carImages);
        sign = new RoadSign(getX(),getY(), GPars.signImages);
        carNPC = new CarNPC(getX(),getY(),GPars.carNPCImage);


        // Dodanie obsługi zdarzenia - pobranie zawartości przy naciskaniu klawiatury
        this.setFocusable(true);
        addKeyListener(new KeyAdapter(){
                @Override
            public void keyPressed(KeyEvent ke){
                    switch(ke.getKeyCode()){
                        case  KeyEvent.VK_A :
                            car.dy=0;
                            car.dx=14;
                            car.currImage=1;
                            car.setCarHitbox();
                            checkIfCorrectTurnLeft(car);
                            break;
                        case  KeyEvent.VK_W :
                            car.dy=10;
                            car.dx=0;
                            car.currImage=0;
                            car.setCarHitbox();
                            checkIfCorrectDrive(car);
                            break;
                        case  KeyEvent.VK_S :
                            car.dy=-3;
                            car.dx=0;
                            car.currImage=0;
                            car.setCarHitbox();
                            break;
                        case  KeyEvent.VK_D :
                            car.dy=0;
                            car.dx=-14;
                            car.currImage=2;
                            car.setCarHitbox();
                            checkIfCorrectTurnRight(car);
                            break;
                        case  KeyEvent.VK_SPACE :
                            car.dy=0;
                            car.dx=0;
                            car.currImage=0;
                            car.setCarHitbox();
                            checkIfCorrectStop(car);
                            break;
                        case KeyEvent.VK_ENTER :
                            hasGameStarted = true;
                            break;
                        case KeyEvent.VK_C:
                            gameEnd = false;
                            examPassed = false;
                    }


            }

        });
    } // koniec konstruktora klasy GamePanel

    //Sprawdzenie czy auto zatrzymalo sie w odpowiednim miejscu
    public void checkIfCorrectStop(Car car){
        if (sign.currImage == 0 || sign.currImage == 1 || sign.currImage == 6) {

                if (car.currY > 170 && car.currY < 300) {
                    PassCorrectly = true;
                } else{ restartGame(); }
        }
        if (sign.currImage == 4){
            if (car.currY > 170 && car.currY < 300) {
                PassCorrectly = true;
                sign.currImage = 5;
            } else{ restartGame(); }
        }

    }

    //Sprawdzenie czy auto skręciło w odpowiednim miejscu
    public void checkIfCorrectTurnLeft(Car car){
        if (sign.currImage == 3){

            if(car.currY > 70 && car.currY < 180){
              PassCorrectly = true;
            } else { restartGame(); }
        }
    }

    //Sprawdzenie czy auto skręciło w odpowiednim miejscu
    public void checkIfCorrectTurnRight(Car car){
        if (sign.currImage == 3){

            if(car.currY > 70 && car.currY < 180){
                PassCorrectly = true;
            } else { restartGame(); }
        }
        if(sign.currImage == 6){
            if(PassCorrectly){
                PassCorrectly = true;
            } else {PassCorrectly = false;}
        }
    }

    //Sprawdzenie czy auto ruszyło
    public void checkIfCorrectDrive(Car car){
        if (sign.currImage == 2){
            PassCorrectly = true;
        }
    }

    //Sprawdzenie czy auto wyjechało z planszy w przeznaczonym do tego miejsca
    public void checkIfCorrectBorder(){
        if(car.currX < 0 ){                                 //lewa granica

            if(car.currY > 70 && car.currY < 180){
                if (PassCorrectly) {
                    nextLevel();
                } else { restartGame(); }
            }  else { restartGame(); }

        } else if(car.currY < -100){                        //gorna granica
            if(car.currX > 350 && car.currX < 550) {
                if (PassCorrectly) {
                    nextLevel();
                } else { restartGame();}
            }else { restartGame(); }
        }else if(car.currX > 1024)   {                      //prawa granica
            if(car.currY > 70 && car.currY < 180){
                if (PassCorrectly) {
                    nextLevel();
                } else { restartGame(); }
            }else { restartGame(); }
        }
    }

    //sprawdzenie czy auta nie zderzyły sie ze sobą
    public void checkIfCollision(){
        if(car.currX < carNPC.currX + 120 && car.currX + car.carWidth > carNPC.currX &&
                car.currY < carNPC.currY + 206 && car.currY + car.carHeight + 100> carNPC.currY){
            restartGame();
        }
    }


    //funkcja odpowiedzialna do umiejscawiania obiektów
    @Override
    protected void paintComponent(Graphics gs){
        Graphics2D g=(Graphics2D)gs;

        if(hasGameStarted) {
            g.drawImage(GPars.bgImage, 0, 0, null);     //rysowanie tła

            car.carMovement();
            carNPC.carNPCmovement();

            g.drawImage(car.carImages[car.currImage], car.currX, car.currY, null);

            //rysowanie auta które nie jest sterowane przez gracza
            if (sign.currImage == 1) {
                g.drawImage(GPars.carNPCImage, carNPC.currX, carNPC.y, null);
                if (carNPC.currX > 1024) {
                    resetPosition();
                }
                checkIfCollision();
            }

            g.drawImage(sign.signImages[sign.currImage], sign.x, sign.y, null);

            checkIfCorrectBorder();
        } else if (gameEnd) {
            g.drawImage(GPars.endImage, 0, 0, null);
        } else if (examPassed){
            g.drawImage(GPars.passedImage,-50,0,null);
        } else{
            g.drawImage(GPars.menuImage, -40, 0, null);
        }
    } // koniec paintComponent

    //zwiększanie liczby poziomu
    private void nextLevel()  {
        car = new Car(540,540, GPars.carImages);
        sign.currImage++;
        PassCorrectly = false;
        if(sign.currImage == GPars.number_of_levels){
            car = new Car(540,540, GPars.carImages);
            examPassed = true;
            PassCorrectly = false;
            hasGameStarted = false;
        }
    }

    //ustawienie początkowych parametrów
    private void restartGame(){
        car = new Car(540,540, GPars.carImages);
        sign.currImage = 0;
        PassCorrectly = false;
        hasGameStarted = false;
        gameEnd = true;
    }

    //resetowanie pozycji auta które nie jest sterowane przez gracza
    private void resetPosition(){
        carNPC = new CarNPC(-200,getY(),GPars.carNPCImage);
    }

}// koniec klasy GamePanel



