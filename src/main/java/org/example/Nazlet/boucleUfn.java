package org.example.Nazlet;

import java.awt.*;


public class boucleUfn {

    private static Robot bot;
    static boolean state = false; // etat on ou off
    static int cooldown = 1000;
    static int x = 952;
    static int y = 516;

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



        //Boucle
        for (int i = 0; i < 999999; i++) {
            if (state == true){
                detectcolor dtctclr = new detectcolor(x,y);
                detectcolor.detect();

                Thread.sleep(cooldown);
                //System.exit(0);
            } else {
                // gachi de performance admire le spaghetti code
                System.out.println("etat : off");
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
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

}
