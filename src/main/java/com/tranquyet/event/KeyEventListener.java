package com.tranquyet.event;

import com.tranquyet.action.RobotActionCenter;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.ActionEvent;
import java.util.concurrent.CountDownLatch;

import static com.tranquyet.event.GlobalMouseListener.*;
import static java.util.logging.Level.OFF;
import static java.util.logging.Logger.getLogger;
import static org.jnativehook.keyboard.NativeKeyEvent.getKeyText;

public class KeyEventListener implements NativeKeyListener {
    // Terminate after 100 keystrokes.
    private final CountDownLatch mLatch = new CountDownLatch(100);

    @Override
    public void nativeKeyPressed(final NativeKeyEvent e) {
//        System.out.println("CHECK: "+((e.getModifiers() & ActionEvent.CTRL_MASK) ==ActionEvent.CTRL_MASK));
//        System.out.println("nativeKeyPressed: "+getKeyText(e.getKeyCode()));
//        System.out.println("Pressed: " + getKeyText(e.getKeyCodre()));

        System.out.println("Pressed: " + e.getModifiers());

        mLatch.countDown();
    }

    @Override
    public void nativeKeyReleased(final NativeKeyEvent e) {
//        System.out.println("nativeKeyReleased: "+(int)e.getKeyChar() +", "+e.paramString());
        Thread myThread = null;
        if (getKeyText(e.getKeyCode()).equals("Q")) {
            System.out.println("TURN OFF");
            System.exit(1);
        }
        if(getKeyText(e.getKeyCode()).equals("A")){
            robot.stopThread();
            myThread.interrupt();
        }
        if (getKeyText(e.getKeyCode()).equals("R")) {
            System.out.println(ACTION_CENTER.size());
            new GlobalMouseListener().removeMouseEvent(example);
            System.out.println("DEMO MOVE MOUSE");
            new RobotActionCenter().robotActionFactory(ACTION_CENTER);
        }
    }

    @Override
    public void nativeKeyTyped(final NativeKeyEvent e) {
        System.out.println("Typed: "+e.getKeyChar() +", "+e.paramString());
    }

    public void startKeyboard() throws InterruptedException {
        System.out.println("Awaiting keyboard events.");
        mLatch.await();
        System.out.println("All keyboard events have fired, exiting.");
    }

    private static void disableNativeHookLogger() {
        final var logger = getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(OFF);
        logger.setUseParentHandlers(false);
    }
}