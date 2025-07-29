package org.example.Nazlet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre {

    Boucle Boucle = new Boucle();

    public Fenetre() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame frame = new JFrame("Window");
        JButton btn = new JButton("Start");
        JLabel labelstat = new JLabel("Itération");





        frame.setSize(400, 350);

        /*




        public void statactualisation() {
            for(int i =0;1==1;i++){
                labelstat.setText("Iteration : " + Msf.i);
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
          System.out.println("Thread is running...");
    }

        Thread thread = new Thread(statactualisation);
        thread.start(); // This will call the run() method
        */

        //Apparance native
        /*
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        */

        /*
        frame.setIconImage(new ImageIcon("C:/Users/User/Documents/Cours/1SIO/Bloc_2/Java/Restaurant/automation_RobloxCaseOpeningSimulator/dice.ico").getImage());
        */

        btn.setBounds(90,125,200,50);

        frame.add(btn);
        frame.setLayout(null);
        frame.setVisible(true);



        //bouton
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Boucle.changeState();
                System.out.println("Lancement du programme");
            }
        });




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Fenetre fenetre = new Fenetre();
        Boucle Boucle = new Boucle();

        new Thread(() -> {
            try {
                Boucle.main(null);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}

