import java.awt.*;
import java.awt.event.InputEvent;

public class Msf {
    public static void main(String[] args) throws InterruptedException, AWTException {
        System.out.println("hello");
        //ScreenColorScan.main(null);
        while (true) {
            System.out.println("début du cycle");
            Thread.sleep(500);
            bougeclic(100, 287);
            clic();
            Thread.sleep(6700);
            bougegrossac(100, 287);
            if (Screencolorgreen.main(null) == true){
                clic();
                Thread.sleep(150);
            }
            bougegrossac(100, 287);
            if (detect2.main(null) == true){
                clic();
                Thread.sleep(150);
            }
            bougegrossac(100, 287);
            if (detect3.main(null) == true){
                clic();
                Thread.sleep(150);
            }
            bougegrossac(100, 287);
            Thread.sleep(1500);
        }


        }
    public static void bougeclic(int x, int y) throws AWTException, InterruptedException {
        Robot bot = new Robot();
        Thread.sleep(500);
        bot.mouseMove(x, y);
        Thread.sleep(500);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public static void clic() throws AWTException, InterruptedException {
        Robot bot = new Robot();
        Thread.sleep(30);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);
        bougeclic(100, 287);
    }

    public static void bougegrossac(int x, int y) throws AWTException, InterruptedException {
        Robot bot = new Robot();
        bot.mouseMove(x, y);
    }

    public static void relachegrossac() throws AWTException, InterruptedException {
        Robot bot = new Robot();
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public static void detectgreen(String[] args) {
        try {
            Robot robot = new Robot();

            int x = 500;
            int y = 300;

            // Read the color at the specific screen coordinate
            Color pixelColor = robot.getPixelColor(x, y);

            // Define your target color (pure green)
            Color targetColor = new Color(0, 255, 0);

            // Allow a small tolerance in color matching
            int tolerance = 10;

            if (isColorMatch(pixelColor, targetColor, tolerance)) {
                System.out.println("Green detected at (" + x + ", " + y + ")");
            } else {
                System.out.println("No green detected at (" + x + ", " + y + ")");
                System.out.println("Found color: " + pixelColor);
            }

        } catch (AWTException e) {
            System.err.println("Screen access failed:");
            e.printStackTrace();
        }
    }

    public static boolean isColorMatch(Color c1, Color c2, int tolerance) {
        int redDiff = Math.abs(c1.getRed() - c2.getRed());
        int greenDiff = Math.abs(c1.getGreen() - c2.getGreen());
        int blueDiff = Math.abs(c1.getBlue() - c2.getBlue());

        return redDiff <= tolerance && greenDiff <= tolerance && blueDiff <= tolerance;
    }


}