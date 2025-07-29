package org.example.Nazlet;

import java.awt.*;


public class Msf {

    private static Robot bot;

    //Initialisation
    static {
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // 950 501

    public static void main(String[] args) throws InterruptedException {
        System.out.println("");

        boolean act = true;
        detectcolor dtctclr = new detectcolor(955,501);

        //Boucle
        for (int i = 0; i < 99999; i++) {
            if (act == true){
                detectcolor.detect();

                Thread.sleep(1000);
                //System.exit(0);
            }
        }
    }
}
