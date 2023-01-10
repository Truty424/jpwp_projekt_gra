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
                animation();
                }

        private void initGUI(int width, int height) {
                setLayout(new GridLayout(1,1)); //ustaw rozkład
                //ustaw zasoby i parametry początkowe
                //Toolkit tk = Toolkit.getDefaultToolkit();
                GPars.loadInitialImages();
                add(new GamePanel());
        }

        private void animation() {
                //pobierz liczbę milisekund od daty referencyjnej (w ms)
                GPars.startTime = System.currentTimeMillis();
                long currTime = GPars.startTime;

                while (true) {
                        long elapsedTime = System.currentTimeMillis() - currTime;
                        //licz czas gry - może się przydać w ograniczeniach czasowych
                        //w tej demonstracji nie wykorzystane
                        currTime += elapsedTime;

                        //odrysuj kolejny ekran gry (nowe pozycje obiektów - symulacja ruchu)
                        repaint();

                        // przerwa w czasie
                        try {
                                Thread.sleep(80);
                        } catch (InterruptedException ex) {System.out.println("Wyjątek: "+ex);      }
                }//koniec while
        }//koniec animationLoop()
}