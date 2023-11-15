package com.tranquyet.cloud;

import com.tranquyet.enums.MouseActionType;
import org.jnativehook.keyboard.NativeKeyEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String ... args) throws AWTException {
        try {
            // Create an instance of the Robot class
            Robot robot = new Robot();
            Thread.sleep(1000);
            // Press and release the Meta (Windows) key
            robot.keyPress(KeyEvent.VK_WINDOWS);
            Thread.sleep(1000);
            robot.keyRelease(KeyEvent.VK_WINDOWS);

            // Add a delay to allow time for the key press to be recognized
            robot.delay(1000);

            // You can also perform other actions after pressing the Meta key if needed

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
