import java.awt.*;

public class detectrouge {
    public static boolean main(String[] args) {
        int x = 600;
        int y = 1043;

        try {
            Robot robot = new Robot();


            Color targetGreen = new Color(255, 71, 71);
            int tolerance = 30;


            Color pixelColor = robot.getPixelColor(x, y);

            if (isColorMatch(pixelColor, targetGreen, tolerance)) {
                System.out.println("Red detected at (" + x + ", " + y + ")");

                return true;
            } else {
                System.out.println("No green at (" + x + ", " + y + "). Color was: " + pixelColor);
                return false;
            }

        } catch (AWTException e) {
            System.err.println("Robot initialization failed:");
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isColorMatch(Color c1, Color c2, int tolerance) {
        int redDiff = Math.abs(c1.getRed() - c2.getRed());
        int greenDiff = Math.abs(c1.getGreen() - c2.getGreen());
        int blueDiff = Math.abs(c1.getBlue() - c2.getBlue());

        return redDiff <= tolerance && greenDiff <= tolerance && blueDiff <= tolerance;
    }
}