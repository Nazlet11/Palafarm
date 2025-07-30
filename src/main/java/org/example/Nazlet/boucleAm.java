package org.example.Nazlet;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class boucleAm {

    private static Robot bot;
    static int smcalibration = 22;
    static int pmcalibration = 26;

    //Initialisation
    static {
        try {
            bot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public static void main(String[] args) throws InterruptedException {


    }

    public static void click() throws InterruptedException {
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("clic");
        Thread.sleep(40);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("relache");
    }

    public static void moveMouse(int x, int y) throws InterruptedException {
        bot.mouseMove(x, y);
        Thread.sleep(60);
    }

    public static void calibration(int axe_y) throws InterruptedException {
        //regarde tt en bas, ses pieds
        for(int i = 0; i<10;i++){
            moveMouse(960,800);
            Thread.sleep(5);
        }

        //regarde vers le haut
        for(int i = 0; i<axe_y;i++){
            moveMouse(960,490);
            Thread.sleep(4);
        }
    }


    public static void zdclick() throws InterruptedException {
        bot.keyPress(KeyEvent.VK_Z);
        bot.keyPress(KeyEvent.VK_D);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(5000);
        bot.keyRelease(KeyEvent.VK_Z);
        bot.keyRelease(KeyEvent.VK_D);
        bot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(50);
        bot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(50);
        bot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(50);
        bot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(50);
        bot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(50);
        bot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(50);
        bot.keyPress(KeyEvent.VK_Z);
        bot.keyPress(KeyEvent.VK_D);
        Thread.sleep(5000);
        bot.keyRelease(KeyEvent.VK_Z);
        bot.keyRelease(KeyEvent.VK_D);
        Thread.sleep(500);
    }

    public static void paladiumminer() throws InterruptedException {
        System.out.println("Mettez vous en position");
        System.out.println("Début du programme dans 3 secondes");
        Thread.sleep(1000);
        System.out.println("Début du programme dans 2 secondes");
        Thread.sleep(1000);
        System.out.println("Début du programme dans 1 secondes");
        Thread.sleep(1000);

        calibration(pmcalibration);

        Thread.sleep(100);
        bot.keyPress(KeyEvent.VK_Z);
        bot.keyPress(KeyEvent.VK_SHIFT);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        for(int i = 0; i<1000000;i++){

            Thread.sleep(3000);
            bot.keyRelease(KeyEvent.VK_Z);
            Thread.sleep(105);
            bot.keyPress(KeyEvent.VK_Z);

        }

    }

    public static void straightmining() throws InterruptedException {

        System.out.println("Mettez vous en position");
        System.out.println("Début du programme dans 3 secondes");
        Thread.sleep(1000);
        System.out.println("Début du programme dans 2 secondes");
        Thread.sleep(1000);
        System.out.println("Début du programme dans 1 secondes");
        Thread.sleep(1000);


        for(int k=0;k<10000000;k++){


            calibration(smcalibration);


            zdclick();

            System.out.println("1er bloc");

            //regarde a gauche
            for(int i = 0; i<3;i++){
                moveMouse(0,540);
                Thread.sleep(20);
            }

            //regarde a droite
            for(int i = 0; i<3;i++){
                moveMouse(1920,540);
                Thread.sleep(20);
            }

            //regarde legerement vers le bas pr ajuster la vision qui se leve petit a petit
            for(int i = 0; i<1;i++){
                moveMouse(960,618);
                Thread.sleep(20);
            }

            zdclick();
            System.out.println("2eme bloc");

            zdclick();
            System.out.println("3eme bloc");

            zdclick();
            System.out.println("4eme bloc");

            zdclick();
            System.out.println("5eme bloc");

            zdclick();
            System.out.println("6eme bloc");

            zdclick();
            System.out.println("7eme bloc");

            zdclick();
            System.out.println("8eme bloc");

            zdclick();
            System.out.println("10eme bloc");

            zdclick();
            System.out.println("11eme bloc");

            zdclick();
            System.out.println("12eme bloc");

            zdclick();
            System.out.println("13eme bloc");
            Thread.sleep(1000);
            System.out.println("Boucle numéro " + k);
        }
    }

}