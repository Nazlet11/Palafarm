import java.awt.*;
import java.awt.event.InputEvent;

public class Msf {

    private static Robot bot;

    static {
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello");

        bougegrossac(100, 287);
        Thread.sleep(40);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        for (int i = 0; i < 10000; i++) {
            System.out.println("Itération :" + i);
            System.out.println("début du cycle");

            bougegrossac(100, 287);
            Thread.sleep(40);
            bougegrossac(100, 284);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println("clic");
            Thread.sleep(40);  // hold duration
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println("relache");
            Thread.sleep(500);

            System.out.println("case normalement lancée");
            Thread.sleep(6200);


            if (Screencolorgreen.main(null)) {
                bougegrossac(670, 757);
                Thread.sleep(70);
                bougegrossac(670, 760);
            } else if (detect2.main(null)) {
                bougegrossac(864, 757);
                Thread.sleep(70);
                bougegrossac(864, 760);
            } else if (detect3.main(null)) {
                bougegrossac(1018, 757);
                Thread.sleep(70);
                bougegrossac(1018, 760);
            }
            Thread.sleep(200);
            bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println("clic");
            Thread.sleep(40);
            bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println("relache");
            bougegrossac(1500, 960);
            Thread.sleep(100);
            bougegrossac(1500, 963);
            Thread.sleep(100);
            System.exit(0);







            if (i % 30 == 0 && i != 0) {
                System.out.println("Itération : " + i + "ème");
                System.out.println("Code qui d'éxecute toute les  30 itérations pour éviter le cap que le jeux te met quand tu as trop d'argent en main");
                bougegrossac(756, 113);
                Thread.sleep(100);
                bougegrossac(756, 110);
                Thread.sleep(100);
                bougegrossac(564, 379);
                Thread.sleep(100);
                bougegrossac(567, 379);
                bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("clic");
                Thread.sleep(40);
                bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println("relache");
                bougegrossac(678, 112);
                Thread.sleep(100);
                bougegrossac(678, 112);


            }
        }
    }

    public static void click() throws InterruptedException {
        Thread.sleep(20);  // safety delay
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);  // hold duration
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(20);  // post-release delay
    }

    public static void bougegrossac(int x, int y) throws InterruptedException {
        bot.mouseMove(x, y);
        Thread.sleep(60);  // ❗ Important: allow system to register move
    }
}
