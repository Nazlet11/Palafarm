package org.example.Nazlet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Autominer {

    boolean state = false;
    private static Thread backgroundThread; // référence au thread lancé

    public Autominer() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame frame = new JFrame("Autominer");

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JButton btn = new JButton("Lancer");
        JButton btnlogs = new JButton("logs");
        JLabel label = new JLabel("x et y texte");
        JTextField xzone = new JTextField();
        JTextField yzone = new JTextField();



        frame.setSize(400, 170);






        ImageIcon icon = new ImageIcon(getClass().getResource("/Am.png"));
        frame.setIconImage(icon.getImage());


        xzone.setBounds(100, 110, 80, 20); // position x, y, largeur, hauteur
        yzone.setBounds(200, 110, 80, 20); // position x, y, largeur, hauteur

        label.setText("x / y");
        btn.setBounds(90,40,200,50);
        btnlogs.setBounds(10,10,60,20);


        frame.add(label);
        /*
        frame.add(xzone);
        frame.add(yzone);
        */

        frame.add(btn);
        frame.add(btnlogs);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);




        //bouton on/off
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (state) {
                    state = false;
                    btn.setText("Désactiver");
                    System.out.println("Appui du bouton off");
                    if (backgroundThread != null && backgroundThread.isAlive()) {
                        backgroundThread.interrupt();
                    }
                } else {
                    state = true;
                    btn.setText("Activer");
                    System.out.println("Appui du bouton on");
                    System.out.println("thread running");

                    backgroundThread = new Thread(() -> {
                        try {
                            boucleAm.straightmining();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    });
                    backgroundThread.start();
                }



            }
        });

        //bouton pr
        btnlogs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsoleWindow();
            }
        });




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Autominer autominer = new Autominer();



        System.out.println("Rappel : ne pas etre en fullscreen");
    }
}

