package org.example.Nazlet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Unclaimfinder_notifier {

    boucleUfn Boucle = new boucleUfn();

    public Unclaimfinder_notifier() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        JFrame frame = new JFrame("Unclaimfinder notifier");
        JButton btn = new JButton("Activer/Désactiver");
        JButton btncoords = new JButton("set x/y");
        JButton btnlogs = new JButton("logs");
        JLabel label = new JLabel("x et y texte");
        JTextField xzone = new JTextField();
        JTextField yzone = new JTextField();



        frame.setSize(400, 235);





        //Apparance native
        /*
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        */


        ImageIcon icon = new ImageIcon(getClass().getResource("/Ufn.png"));
        frame.setIconImage(icon.getImage());



        xzone.setBounds(100, 110, 80, 20); // position x, y, largeur, hauteur
        yzone.setBounds(200, 110, 80, 20); // position x, y, largeur, hauteur
        btnlogs.setBounds(10,10,60,20);

        label.setText("x / y");
        btn.setBounds(90,40,200,50);
        btncoords.setBounds(140,140,100,20);


        frame.add(label);
        frame.add(xzone);
        frame.add(yzone);
        frame.add(btn);
        frame.add(btncoords);
        frame.add(btnlogs);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);



        //bouton on/off
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Boucle.changeState();
                System.out.println("Appui du bouton on/off");
            }
        });

        //bouton pr set les coords
        btncoords.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(xzone.getText());
                int y = Integer.parseInt(yzone.getText());
                Boucle.setXY(x,y);

                System.out.println("les coords on ete redefinies en " + x + " et " + y);
            }
        });

        //bouton logs
        btnlogs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsoleWindow();
            }
        });



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Unclaimfinder_notifier unclaimfinder_notifier = new Unclaimfinder_notifier();
        boucleUfn Boucle = new boucleUfn();

        new Thread(() -> {
            try {
                Boucle.main(null);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
        System.out.println("Rappel : ne pas etre en fullscreen");
    }
}

