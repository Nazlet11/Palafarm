package org.example.Nazlet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;


public class Unclaimfinder_notifier {

    JFrame frame;
    JRadioButton switchmod;

    int cooldown = 1000;
    int cooldownFast = 50;

    public Unclaimfinder_notifier(boucleUfn boucleufn) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        frame = new JFrame("Unclaimfinder notifier");

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JButton btn = new JButton("Lancer");
        JButton btncoords = new JButton("set x/y");
        JButton btnlogs = new JButton("logs");
        JLabel label = new JLabel("x et y texte");
        JTextField xzone = new JTextField();
        JTextField yzone = new JTextField();
        switchmod = new JRadioButton();





        frame.setSize(400, 235);





        //Apparance native
        /*
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        */


        ImageIcon icon = new ImageIcon(getClass().getResource("/Ufn.png"));
        frame.setIconImage(icon.getImage());



        xzone.setBounds(100, 110, 80, 20);
        yzone.setBounds(200, 110, 80, 20);
        xzone.setText("x");
        yzone.setText("y");
        btnlogs.setBounds(10,10,60,20);
        switchmod.setText("Switch mod");
        switchmod.setBounds(7, 153, 120, 50);

        label.setText("x / y");
        btn.setBounds(90,40,200,50);
        btncoords.setBounds(140,140,100,20);


        frame.add(label);
        frame.add(xzone);
        frame.add(yzone);
        frame.add(btn);
        frame.add(btncoords);
        frame.add(btnlogs);
        frame.add(switchmod);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);



        //bouton on/off
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boucleufn.changeState(btn);
                System.out.println("Appui du bouton on/off");
            }
        });

        //bouton pr set les coords
        btncoords.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(xzone.getText());
                int y = Integer.parseInt(yzone.getText());
                boucleufn.setXY(x,y);

                System.out.println("les coords on ete redefinies en " + x + " et " + y);
            }
        });

        //bouton logs
        btnlogs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ConsoleWindow();
            }
        });



        //bouton
        switchmod.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("Activation du mode switch");
                boucleufn.setCooldown(cooldownFast);
                boucleUfn.newThreadswitch();
            }

            if (e.getStateChange() == ItemEvent.DESELECTED) {
                System.out.println("Desactivation du mode switch");
                boucleufn.setCooldown(cooldown);
                boucleUfn.endThreadswitch();
            }
        });





        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);


    }

    public boolean getswitchState() {
        if (switchmod.isSelected()) {

            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        boucleUfn boucleufn = new boucleUfn();

        Unclaimfinder_notifier unclaimfinder_notifier = new Unclaimfinder_notifier(boucleufn);


        new Thread(() -> {
            try {
                boucleufn.main(null);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
        System.out.println("Rappel : ne pas etre en fullscreen");
    }

    /*

    */
}

