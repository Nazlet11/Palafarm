import java.awt.*;

public class ScreenColorScan {
    public static void main(String[] args) {
        System.out.println("hello");

        try {
            Robot robot = new Robot();


            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int) screenSize.getWidth();
            int height = (int) screenSize.getHeight();


            Color targetColor = new Color(255, 0, 0);
            int tolerance = 3;

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Color pixelColor = robot.getPixelColor(x, y);
                    if (isColorMatch(pixelColor, targetColor, tolerance)) {
                        System.out.println("Color match found at (" + x + ", " + y + ")");
                        return;
                    }
                }
            }

            System.out.println("No match found on screen.");

        } catch (AWTException e) {
            System.err.println("Failed to access screen for scanning:");
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