package com.tranquyet.controller;

import com.tranquyet.action.RobotActionCenter;
import com.tranquyet.event.GlobalMouseListener;
import com.tranquyet.event.RobotControl;
import com.tranquyet.service.ActionService;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.List;

import static com.tranquyet.event.GlobalMouseListener.*;
import static com.tranquyet.event.GlobalMouseListener.ACTION_CENTER;

@Controller
@RequestMapping("/index")
public class IndexController {
    static {
        System.setProperty("java.awt.headless", "false");
    }
    @Autowired
    private RobotActionCenter robotActionCenter;
    @Autowired
    private ActionService actionService;
    @GetMapping("/record")
    public ModelAndView recordActions() {
        ModelAndView modelAndView = new ModelAndView("index");
        new Thread(()->{
            try {
                ACTION_CENTER.clear();
                GlobalScreen.registerNativeHook();
                // Construct the example object.
                // Add the appropriate listeners.
                example.disableLog();
                GlobalScreen.addNativeKeyListener(harness);
                GlobalScreen.addNativeMouseListener(example);
                GlobalScreen.addNativeMouseMotionListener(example);
                GlobalScreen.addNativeMouseWheelListener(new GlobalMouseListener());
                example.start();
                System.out.println("Listener attached.");
                harness.startKeyboard();
                System.out.println("Listener detached.");
            } catch (NativeHookException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        return modelAndView;
    }
    @GetMapping("/stopRecord")
    public ModelAndView stopRecord() {
        ModelAndView modelAndView = new ModelAndView("index");
        try {
            actionService.truncate();
            GlobalScreen.unregisterNativeHook();
            robotActionCenter.recordActions(ACTION_CENTER);
        } catch (NativeHookException e) {
            throw new RuntimeException(e);
        }
        return modelAndView;
    }
    @GetMapping("/start")
    public ModelAndView startedActions() {
        ModelAndView modelAndView = new ModelAndView("index");
        new Thread(()->{
            List<Object> actions = actionService.getActions();
            System.out.println(ACTION_CENTER.size());
            try {
                Robot robot = new RobotControl();
//                GlobalScreen.unregisterNativeHook();
                new RobotActionCenter().robotActionFactory(actions, robot);
            } catch (AWTException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("DEMO MOVE MOUSE");
        }).start();
        return modelAndView;
    }

    @GetMapping("/end")
    public ModelAndView endActions() {
        ModelAndView modelAndView = new ModelAndView("index");
        System.out.println("TURN OFF");
        System.exit(1);
        return modelAndView;
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

}
