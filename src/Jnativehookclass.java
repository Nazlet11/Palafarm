import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.keyboard.NativeKeyEvent;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.*;

public class GlobalKeyDetect implements NativeKeyListener {
    public static void main(String[] args) throws Exception {
        GlobalScreen.registerNativeHook();
        GlobalScreen.addNativeKeyListener(new GlobalKeyDetect());
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Touche pressée : " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Touche relâchée : " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    public void nativeKeyTyped(NativeKeyEvent e) {}
}
