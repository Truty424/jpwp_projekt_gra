package projektJPWP;

import javax.swing.JFrame;
import java.awt.*;


public class Window extends JFrame{


        /** Tworzenie okna */
        public Window(int width,int height, int x, int y){
                super(); //wywołaj konstruktor klasy nadrzędnej - utwórz okno
                setSize(width, height); //ustaw wymiary okna
                setLocation(x,y); //ustaw pozycję okna
                setResizable(false); //zablokuj możliwość zmian rozmiaru okna
                setUndecorated(true); //ukryj ramkę okna i przyciski kontrolne
                initGUI(width,height); //wywołaj metodę budowy interfejsu
                setVisible(true); //pokaż okno
                animation();  //uruchom animacje gry
                }

        private void initGUI(int width, int height) {
                setLayout(new GridLayout(1,1)); //ustaw rozkład
                GPars.loadInitialImages();
                add(new GamePanel()); //dodanie panelu gry z grafiką i dalszym działaniem gry
        }

        private void animation() {
                //pobierz liczbę milisekund od daty referencyjnej (w ms)
                GPars.startTime = System.currentTimeMillis();
                long currTime = GPars.startTime;

                while (true) {
                        repaint();

                        // poczekanie 80ms do kolejnej animacji
                        try {
                                Thread.sleep(80);
                        } catch (InterruptedException ex) {System.out.println(ex);      }
                }
        }//koniec animation()
}