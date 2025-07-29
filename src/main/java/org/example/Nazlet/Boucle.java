package org.example.Nazlet;

import java.awt.*;


public class Boucle {

    private static Robot bot;
    static boolean state = false; // etat on ou off
    static int cooldown = 1000;

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
    // 1269 982
    public static void main(String[] args) throws InterruptedException {
        System.out.println("");

        detectcolor dtctclr = new detectcolor(950,501);

        //Boucle
        for (int i = 0; i < 999999; i++) {
            if (state == true){
                detectcolor.detect();

                Thread.sleep(cooldown);
                //System.exit(0);
            } else {
                // gachi de performance admire le spaghetti code
                System.out.println("state : off");
                Thread.sleep(cooldown);
            }
        }
    }

    public static void changeState(){
        if (state == true){
            state = false;
        } else {
            state = true;
        }
    }

}
