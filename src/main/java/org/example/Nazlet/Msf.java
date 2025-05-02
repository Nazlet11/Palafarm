package org.example.Nazlet;

import java.awt.*;
import java.awt.event.InputEvent;


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


    public static void main(String[] args) throws InterruptedException {
        System.out.println("");

        //Bouge sur la caisse
        bougegrossac(100, 287);
        Thread.sleep(40);
        click();


        //Boucle
        for (int i = 0; i < 10000; i++) {
            System.out.println("Itération : " + i);
            System.out.println("Début du cycle");

            //Clic sur la caisse
            bougegrossac(100, 287);
            Thread.sleep(40);
            bougegrossac(100, 284);
            click();
            Thread.sleep(500);

            //Attente de l'ouverture de la caisse
            System.out.println("ouverture de la caisse...");
            Thread.sleep(6200);

            //Detecte ou le bouton sell est et se met dessus
            if (detectpos1.main(null)) {
                bougegrossac(670, 757);
                Thread.sleep(70);
                bougegrossac(670, 760);
            } else if (detectpos2.main(null)) {
                bougegrossac(864, 757);
                Thread.sleep(70);
                bougegrossac(864, 760);
            } else if (detectpos3.main(null)) {
                bougegrossac(1018, 757);
                Thread.sleep(70);
                bougegrossac(1018, 760);
            }

            //clic sur le bouton
            Thread.sleep(200);
            click();

            //se deplace dans zone vide pr actualiser
            bougegrossac(1500, 960);
            Thread.sleep(100);
            bougegrossac(1500, 963);
            Thread.sleep(100);


            //System.exit(0);
        }
    }

    public static void click() throws InterruptedException {
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("clic");
        Thread.sleep(40);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("relache");
    }

    public static void bougegrossac(int x, int y) throws InterruptedException {
        bot.mouseMove(x, y);
        Thread.sleep(60);
    }


                /* Detecte du rouge pour si trop d'argent
            if (detectrouge.main(null)) {
                System.out.println("Code qui d'éxecute toute les  30 itérations pour éviter le cap que le jeux te met quand tu as trop d'argent en main");
                bougegrossac(756, 113);
                Thread.sleep(1000);
                bougegrossac(756, 110);
                click();
                Thread.sleep(100);
                bougegrossac(564, 379);
                Thread.sleep(1000);
                bougegrossac(567, 379);
                Thread.sleep(100);
                click();
                bougegrossac(678, 112);
                Thread.sleep(1000);
                bougegrossac(678, 109);
                Thread.sleep(100);
                click();
                continue;
            }
            */
}
