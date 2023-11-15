package com.tranquyet.event;

import com.tranquyet.Constants;
import com.tranquyet.action.RobotActionCenter;
import com.tranquyet.dto.KeyValue;
import com.tranquyet.dto.KeyboardActionDto;
import com.tranquyet.enums.KeyboardActionType;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.ActionEvent;
import java.util.Optional;
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
        KeyboardActionType keyboardActionType = KeyboardActionType.PRESSED;
        String value = getKeyText(e.getKeyCode());
        KeyValue keyValue = KeyValue.fromContent(value);
        KeyboardActionDto keyboardActionDto = initialize(keyboardActionType, keyValue);
        System.out.println(keyboardActionDto);
        ACTION_CENTER.add(keyboardActionDto);
        mLatch.countDown();
    }

    @Override
    public void nativeKeyReleased(final NativeKeyEvent e) {
//        System.out.println("nativeKeyReleased: "+(int)e.getKeyChar() +", "+e.paramString());
        KeyboardActionType keyboardActionType = KeyboardActionType.RELEASED;
        String value = getKeyText(e.getKeyCode());
        KeyValue keyValue = KeyValue.fromContent(value);
        KeyboardActionDto keyboardActionDto = initialize(keyboardActionType, keyValue);
        System.out.println(keyboardActionDto);
        ACTION_CENTER.add(keyboardActionDto);
        if (getKeyText(e.getKeyCode()).equals("Q")) {
            System.out.println("TURN OFF");
            System.exit(1);
        }
        if(getKeyText(e.getKeyCode()).equals("A")){
            robot.stopThread();
        }
        if (getKeyText(e.getKeyCode()).equals("R")) {
            System.out.println(ACTION_CENTER.size());
            new GlobalMouseListener().removeMouseEvent(example);
            System.out.println("DEMO MOVE MOUSE");
            new RobotActionCenter().robotActionFactory(ACTION_CENTER);
        }
    }

    private KeyboardActionDto initialize(KeyboardActionType keyboardActionType, KeyValue keyValue){
        Long time = System.nanoTime();
        String desc = keyboardActionType.getAction() + ": " ;
        KeyboardActionDto keyboardActionDto = KeyboardActionDto.builder()
                .action(keyboardActionType.getAction())
                .keyboardActionType(keyboardActionType)
                .keyValue(keyValue)
                .key(keyValue.getContent())
                .description(desc)
                .build();
        keyboardActionDto.setId(time);
        keyboardActionDto.setStatus(Constants.ACTIVE_KEY_ACTION);
        return keyboardActionDto;
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