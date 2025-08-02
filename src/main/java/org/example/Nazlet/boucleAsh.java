package org.example.Nazlet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class boucleAsh {

    private static Robot bot;
    static boolean state = false; // etat on ou off
    static int cooldown = 1000;
    static String homeName = null;

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

    public static void main(String[] args) throws InterruptedException {
        System.out.println("bleeeh");



        //Boucle
        for (int i = 0; i < 999999; i++) {
            if (state == true){


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

    public static void setCooldown(int cooldowndonné){
        System.out.println("Activation du mode switch");
        cooldown = cooldowndonné;
    }

}
