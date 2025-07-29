package org.example.Nazlet;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


public class boucleAm {

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


    public static void main(String[] args) throws InterruptedException {

        System.out.println("Mettez vous en position");
        System.out.println("Début du programme dans 3 secondes");
        Thread.sleep(1000);
        System.out.println("Début du programme dans 2 secondes");
        Thread.sleep(1000);
        System.out.println("Début du programme dans 1 secondes");
        Thread.sleep(1000);



        bot.keyPress(KeyEvent.VK_Z);
        bot.keyPress(KeyEvent.VK_D);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    }







/*
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
    */


}