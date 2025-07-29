package org.example.Nazlet;

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenetre {

    Boucle Boucle = new Boucle();

    public Fenetre() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame frame = new JFrame("Unclaimfinder notifier");
        JButton btn = new JButton("Activer/Désactiver");
        JButton redefcoords = new JButton("set x/y");
        JLabel label = new JLabel("x et y texte");
        JTextField xzone = new JTextField();
        JTextField yzone = new JTextField();



        frame.setSize(400, 350);





        //Apparance native
        /*
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        */

        /*
        frame.setIconImage(new ImageIcon("C:/Users/User/Documents/Cours/1SIO/Bloc_2/Java/Restaurant/automation_RobloxCaseOpeningSimulator/dice.ico").getImage());
        */



        xzone.setBounds(100, 110, 80, 20); // position x, y, largeur, hauteur
        yzone.setBounds(200, 110, 80, 20); // position x, y, largeur, hauteur

        label.setText("x / y");
        btn.setBounds(90,40,200,50);
        redefcoords.setBounds(140,140,100,20);


        frame.add(label);
        frame.add(xzone);
        frame.add(yzone);
        frame.add(btn);
        frame.add(redefcoords);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);



        //bouton
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Boucle.changeState();
                System.out.println("Appui du bouton on/off");
            }
        });




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Fenetre fenetre = new Fenetre();
        Boucle Boucle = new Boucle();
        new ConsoleWindow();

        new Thread(() -> {
            try {
                Boucle.main(null);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }
}

