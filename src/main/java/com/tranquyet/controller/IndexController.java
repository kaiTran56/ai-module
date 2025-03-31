package com.tranquyet.controller;

import com.tranquyet.action.RobotActionCenter;
import com.tranquyet.event.KeyEventListener;
import com.tranquyet.event.MouseEventListener;
import com.tranquyet.event.RobotControl;
import com.tranquyet.service.ActionService;
import lombok.extern.slf4j.Slf4j;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.List;
import java.util.Set;

import static com.tranquyet.event.MouseEventListener.*;
import static com.tranquyet.event.MouseEventListener.ACTION_CENTER;

@Controller
@RequestMapping("/index")
@Slf4j
public class IndexController {
    static {
        System.setProperty("java.awt.headless", "false");
    }
    @Autowired
    private RobotActionCenter robotActionCenter;
    @Autowired
    private ActionService actionService;

    KeyEventListener harness = new KeyEventListener();
    MouseEventListener example = new MouseEventListener();

    @GetMapping("/record")
    public ModelAndView recordActions() {
        ModelAndView modelAndView = new ModelAndView("index");
        Thread thread = new Thread(()->{
            try {

                ACTION_CENTER.clear();
//                GlobalScreen.unregisterNativeHook();
                GlobalScreen.registerNativeHook();
                // Construct the example object.
                // Add the appropriate listeners.
                example.disableLog();
                GlobalScreen.addNativeKeyListener(harness);
                GlobalScreen.addNativeMouseListener(example);
                GlobalScreen.addNativeMouseMotionListener(example);
                GlobalScreen.addNativeMouseWheelListener(new MouseEventListener());
                example.start();
                System.out.println("Listener attached.");
                harness.startKeyboard();
                System.out.println("Listener detached.");
            } catch (NativeHookException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.setName("start-record");
        thread.start();
        return modelAndView;
    }
    @GetMapping("/stopRecord")
    public ModelAndView stopRecord() {
        ModelAndView modelAndView = new ModelAndView("index");
        try {
            if(GlobalScreen.isNativeHookRegistered()){
                GlobalScreen.removeNativeKeyListener(harness);
                GlobalScreen.removeNativeMouseListener(example);
                GlobalScreen.removeNativeMouseMotionListener(example);
                GlobalScreen.removeNativeMouseWheelListener(new MouseEventListener());
                GlobalScreen.unregisterNativeHook();
            }
            if(ACTION_CENTER==null||ACTION_CENTER.isEmpty()){
                log.error("[insertActions]: no actions");
                return modelAndView;
            }
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
