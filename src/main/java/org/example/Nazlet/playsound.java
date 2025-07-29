package org.example.Nazlet;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class playsound {
    public static void playSound(String resourcePath) {
        try {
            URL soundURL = playsound.class.getResource(resourcePath);
            if (soundURL == null) {
                System.err.println("Son introuvable : " + resourcePath);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        playSound("/notifson.wav"); // chemin relatif depuis resources
    }
}


