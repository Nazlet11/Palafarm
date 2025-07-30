package org.example.Nazlet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class boucleUfn {

    private static Robot bot;
    static boolean state = false; // etat on ou off
    static int cooldown = 1000;
    static int x = 952;
    static int y = 516;

    private static Thread backgroundThread;

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
            } else {
                // gachi de performance admire le spaghetti code
                Thread.sleep(cooldown);
            }
        }
    }

    public static void changeState(JButton bouton){
        if (state == true){
            state = false;
            bouton.setText("Activer");
        } else {
            state = true;
            bouton.setText("Désactiver");
        }
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static void setCooldown(int cooldowndonné){
        System.out.println("Activation du mode switch");
        cooldown = cooldowndonné;
    }

    public static void pressç() throws InterruptedException {
        bot.keyPress(KeyEvent.VK_SHIFT);
        bot.keyPress(KeyEvent.VK_9);
        Thread.sleep(30);
        bot.keyRelease(KeyEvent.VK_SHIFT);
        bot.keyRelease(KeyEvent.VK_9);
        Thread.sleep(110);
        System.out.println("*Press ç*");
    }

    public static void pressx() throws InterruptedException {
        bot.keyPress(KeyEvent.VK_X);
        Thread.sleep(30);
        bot.keyRelease(KeyEvent.VK_X);
        Thread.sleep(2500);
        System.out.println("*Press x*");
    }

    public static void newThreadswitch(){

        backgroundThread = new Thread(() -> {
            try {
                while(true) {
                    pressç();
                    pressx();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        backgroundThread.start();
    }


    public static void endThreadswitch(){
        backgroundThread.interrupt();
    }

}
