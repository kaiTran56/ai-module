package com.tranquyet.controller;

import com.tranquyet.action.RobotActionCenter;
import com.tranquyet.event.GlobalMouseListener;
import com.tranquyet.event.RobotControl;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

import static com.tranquyet.event.GlobalMouseListener.*;

@RestController
@RequestMapping("/api/robot")
public class ExecutedActionController {
    static {
        System.setProperty("java.awt.headless", "false");
    }
    @GetMapping("/record")
    public ResponseEntity<String> recordActions() throws NativeHookException, InterruptedException {
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
        return new ResponseEntity<>("record", HttpStatus.OK);
    }

    @GetMapping("/start")
    public ResponseEntity<String> startedActions() {
        System.out.println(ACTION_CENTER.size());
        try {
            Robot robot = new RobotControl();
            GlobalScreen.unregisterNativeHook();
            new RobotActionCenter().robotActionFactory(ACTION_CENTER, robot);
        } catch (AWTException | NativeHookException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("DEMO MOVE MOUSE");

        return new ResponseEntity<>("start", HttpStatus.OK);
    }

    @GetMapping("/end")
    public ResponseEntity<String> endActions() {
        System.out.println("TURN OFF");
        System.exit(1);
        return new ResponseEntity<>("end", HttpStatus.OK);
    }
}
