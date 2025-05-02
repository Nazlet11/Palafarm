package org.example.Nazlet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.SwingUtilities.updateComponentTreeUI;

public class Fenetre {
    public Fenetre() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame frame = new JFrame("Window");
        JButton btn = new JButton("Start");

        frame.setSize(400, 350);

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        updateComponentTreeUI(frame);

        frame.setIconImage(new ImageIcon("C:/Users/User/Documents/Cours/1SIO/Bloc_2/Java/Restaurant/automation_RobloxCaseOpeningSimulator/dice.ico").getImage());


        btn.setBounds(90,125,200,50);

        frame.add(btn);
        frame.setLayout(null);
        frame.setVisible(true);


        //bouton
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    try {
                        Msf.main(null);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }).start();
                System.out.println("Lancement du programme");
            }
        });




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Fenetre fenetre = new Fenetre();
    }
}