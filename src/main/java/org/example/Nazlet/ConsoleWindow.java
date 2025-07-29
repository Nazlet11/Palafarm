package org.example.Nazlet;

import javax.swing.*;
import java.io.*;

public class ConsoleWindow extends JFrame {

    private JTextArea textArea;

    public ConsoleWindow() {
        setTitle("Logs");
        setSize(600, 400);
        setLocationRelativeTo(null); // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        add(scrollPane);
        setVisible(true);

        redirectSystemOut();
    }

    private void redirectSystemOut() {
        // redirige le texte de la console vers cette fenetre
        OutputStream out = new OutputStream() {
            @Override
            public void write(int b) {
                textArea.append(String.valueOf((char) b));
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
        };

        PrintStream printStream = new PrintStream(out, true);
        System.setOut(printStream);
        System.setErr(printStream);
    }
}
