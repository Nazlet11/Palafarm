package org.example.Nazlet;

import java.awt.*;

public class detectcolor{

    static int x;
    static int y;

    public detectcolor(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static boolean detect(){

        try {
            Robot robot = new Robot();


            Color targetColor = new Color(255, 255, 255);
            int tolerance = 30;

            // couleur du pixel
            Color pixelColor = robot.getPixelColor(x, y);

            if (isColorMatch(pixelColor, targetColor, tolerance)) {
                System.out.println("Blanc detecté au  (" + x + ", " + y + ")");

                return true;
            } else {
                System.out.println("Pas de blanc au (" + x + ", " + y + "), la couleur était : " + pixelColor);
                return false;
            }

        } catch (AWTException e) {
            System.err.println("Problème dans la detection:");
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