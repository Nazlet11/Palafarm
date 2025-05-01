import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre {
    public static void main(String[] args) {
        // Create a new JFrame object
        JFrame frame = new JFrame("Window");
        JButton btn = new JButton("Lancer le programme");
        // Set the window size
        frame.setSize(400, 350);  // Width = 400, Height = 300


        //Définir la position du bouton
        btn.setBounds(90,125,200,50);

        //Ajouter le bouton
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



        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the application when window is closed

        // Set the window to be visible
        frame.setVisible(true);  // Make the window visible
    }
}