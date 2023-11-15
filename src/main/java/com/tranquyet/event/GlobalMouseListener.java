package com.tranquyet.event;

import com.tranquyet.Constants;
import com.tranquyet.dto.MouseActionDto;
import com.tranquyet.enums.MouseActionType;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.jnativehook.GlobalScreen.removeNativeKeyListener;

public class GlobalMouseListener implements NativeMouseInputListener, NativeMouseWheelListener {
    private final CountDownLatch mLatch = new CountDownLatch(100);
    public static GlobalMouseListener example = new GlobalMouseListener();
    public static KeyEventListener harness = new KeyEventListener();

    public static List<Object> ACTION_CENTER = new ArrayList<>();

    public void nativeMouseClicked(NativeMouseEvent e) {
        mLatch.countDown();
    }

    public static RobotControl robot = null;

    public void initRobot() throws AWTException {
        robot = new RobotControl();
    }

    public void removeMouseEvent(GlobalMouseListener example) {
        System.out.println("removeEvent");
        GlobalScreen.removeNativeMouseWheelListener(example);
        GlobalScreen.removeNativeMouseListener(example);
        GlobalScreen.removeNativeMouseMotionListener(example);
    }

    private void disableLog() {
        // Get the logger for "com.github.kwhat.jnativehook" and set the level to warning.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        // Don't forget to disable the parent handlers.
        logger.setUseParentHandlers(false);
    }

    private MouseActionDto initializeMouseAction(NativeMouseEvent e, MouseActionType mouseActionType, NativeMouseWheelEvent ... ew) {
        Long time = System.nanoTime();
        MouseActionDto action = MouseActionDto.builder()
                .mouseActionType(mouseActionType)
                .value(mouseActionType.getValue())
                .tag(mouseActionType.getTag())
                .action(mouseActionType.getAction())
                .x(e.getX())
                .y(e.getY())
                .build();
        if(mouseActionType.equals(MouseActionType.WHEEL))
            action.setWheel(ew[0].getWheelRotation());
        action.setId(time);
        action.setStatus(Constants.ACTIVE_MOUSE_ACTION);
        return action;
    }

    public void nativeMousePressed(NativeMouseEvent e) {
        Long value = (long) e.getButton();
        String tag = value.equals(MouseActionType.LEFT_CLICK.getValue())
                ? MouseActionType.LEFT_CLICK.getTag()
                : MouseActionType.RIGHT_CLICK.getTag();
        MouseActionType mouseActionType = MouseActionType.fromValue(value, tag);
        MouseActionDto action = initializeMouseAction(e, mouseActionType);
        System.out.println("nativeMousePressed: " + action);
        ACTION_CENTER.add(action);
        mLatch.countDown();
    }

    public void nativeMouseReleased(NativeMouseEvent e) {
        Long value = (long) e.getButton();
        String tag = value.equals(MouseActionType.LEFT_RELEASE.getValue())
                ? MouseActionType.LEFT_RELEASE.getTag()
                : MouseActionType.RIGHT_RELEASE.getTag();
        MouseActionType mouseActionType = MouseActionType.fromValue(value, tag);
        MouseActionDto action = initializeMouseAction(e, mouseActionType);
        System.out.println("nativeMouseReleased: " + action);
        ACTION_CENTER.add(action);
    }

    public void nativeMouseMoved(NativeMouseEvent e) {
        MouseActionType mouseActionType = MouseActionType.MOVED;
        MouseActionDto action = initializeMouseAction(e, mouseActionType);
        System.out.println("nativeMouseMoved: " + action);
        ACTION_CENTER.add(action);
        mLatch.countDown();
    }

    /**
     * press left click at first and hang up to the end of action => left release
     * same with right click
     *
     * @param e
     */
    public void nativeMouseDragged(NativeMouseEvent e) {
        Long value = (long) e.getModifiers();
        String tag = value.equals(MouseActionType.LEFT_DRAGGED_CLICK.getValue())
                ? MouseActionType.LEFT_DRAGGED_CLICK.getTag()
                : MouseActionType.RIGHT_DRAGGED_CLICK.getTag();
        MouseActionType mouseActionType = MouseActionType.fromValue(value, tag);
        MouseActionDto action = initializeMouseAction(e, mouseActionType);
        System.out.println("nativeMouseDragged: " + action);
        ACTION_CENTER.add(action);
        mLatch.countDown();
    }

    @Override
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
        MouseActionType mouseActionType = MouseActionType.WHEEL;
        MouseActionDto action = initializeMouseAction(e, mouseActionType, e);
        System.out.println("nativeMouseWheelMoved: " + action);
        ACTION_CENTER.add(action);
    }

    private void start() throws InterruptedException {
        System.out.println("Awaiting Mouse events.");
        mLatch.await();
        System.out.println("All Mouse, exiting.");
    }

    public static void main(String[] args) {
        try {
            example.disableLog();
            GlobalScreen.registerNativeHook();
            // Construct the example object.
            // Add the appropriate listeners.
            GlobalScreen.addNativeKeyListener(harness);
            GlobalScreen.addNativeMouseListener(example);
            GlobalScreen.addNativeMouseMotionListener(example);
            GlobalScreen.addNativeMouseWheelListener(new GlobalMouseListener());
            example.start();
            System.out.println("Listener attached.");
            harness.startKeyboard();
            System.out.println("Listener detached.");


//            example.removeMouseEvent(example);

        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            ex.printStackTrace();
            System.exit(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}