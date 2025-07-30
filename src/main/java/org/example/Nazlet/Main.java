package org.example.Nazlet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    public Main() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame frame = new JFrame("Palafarm");

        //Apparance native

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


        ImageIcon iconAm = new ImageIcon(getClass().getResource("/Am.png"));
        frame.setIconImage(iconAm.getImage());

        ImageIcon iconUfn = new ImageIcon(getClass().getResource("/Ufn.png"));
        frame.setIconImage(iconAm.getImage());

        JButton btnAm = new JButton(iconAm);
        JButton btnUfn = new JButton(iconUfn);

        JLabel label = new JLabel("x et y texte");




        frame.setSize(600, 225);

        // j ai mis 2 heure a faire marcher l icone
        ImageIcon icon = new ImageIcon(getClass().getResource("/Pf.png"));
        frame.setIconImage(icon.getImage());







        label.setText("x / y");
        btnAm.setBounds(90,40,150,100);
        btnUfn.setBounds(340,40,150,100);


        frame.add(label);

        frame.add(btnAm);
        frame.add(btnUfn);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);



        //bouton on/off
        btnAm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Autominer autominer = new Autominer();

                    frame.setVisible(false);

                } catch (UnsupportedLookAndFeelException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (InstantiationException ex) {
                    throw new RuntimeException(ex);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }

                System.out.println("Appui du bouton on/off");
            }
        });

        //bouton Ufn
        btnUfn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    Unclaimfinder_notifier unclaimfinder_notifier = new Unclaimfinder_notifier(null);

                    frame.setVisible(false);

                } catch (UnsupportedLookAndFeelException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (InstantiationException ex) {
                    throw new RuntimeException(ex);
                } catch (IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }




            }
        });




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            JFrame frame = new JFrame("Palafarm");
            Main main = new Main();
        } catch(Exception e) {
            e.printStackTrace();
        }



        System.out.println("Rappel : ne pas etre en fullscreen");
    }
}

