//package com.tranquyet.controller;
//
//import com.tranquyet.action.RobotActionCenter;
//import com.tranquyet.event.KeyEventListener;
//import com.tranquyet.event.MouseEventListener;
//import com.tranquyet.event.RobotControl;
//import com.tranquyet.service.ActionService;
//import org.jnativehook.GlobalScreen;
//import org.jnativehook.NativeHookException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//import java.awt.*;
//import java.util.List;
//
//import static com.tranquyet.event.MouseEventListener.*;
//
//@RestController
//@RequestMapping("/api/robot")
//public class ExecutedActionController {
//    static {
//        System.setProperty("java.awt.headless", "false");
//    }
//    @Autowired
//    private RobotActionCenter robotActionCenter;
//
//    @Autowired
//    private ActionService actionService;
//
//    @GetMapping("/record")
//    public ResponseEntity<String> recordActions() throws NativeHookException, InterruptedException {
//        new Thread(()->{
//            try {
//                KeyEventListener harness = new KeyEventListener();
//                MouseEventListener example = new MouseEventListener();
//                ACTION_CENTER.clear();
//                GlobalScreen.registerNativeHook();
//                // Construct the example object.
//                // Add the appropriate listeners.
//                example.disableLog();
//                GlobalScreen.addNativeKeyListener(harness);
//                GlobalScreen.addNativeMouseListener(example);
//                GlobalScreen.addNativeMouseMotionListener(example);
//                GlobalScreen.addNativeMouseWheelListener(new MouseEventListener());
//                example.start();
//                System.out.println("Listener attached.");
//                harness.startKeyboard();
//                System.out.println("Listener detached.");
//            } catch (NativeHookException e) {
//                throw new RuntimeException(e);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }).start();
//        return new ResponseEntity<>("record", HttpStatus.OK);
//    }
//    @GetMapping("/stopRecord")
//    public ResponseEntity<String> stopRecord() {
//        try {
//            if(ACTION_CENTER==null||ACTION_CENTER.isEmpty())
//                throw new RuntimeException("[insertActions]: no actions");
//            actionService.truncate();
//            GlobalScreen.unregisterNativeHook();
//            robotActionCenter.recordActions(ACTION_CENTER);
//        } catch (NativeHookException e) {
//            throw new RuntimeException(e);
//        }
//        return new ResponseEntity<>("stop record", HttpStatus.OK);
//    }
////    @GetMapping("/start")
////    public ResponseEntity<String> startedActions() {
////        new Thread(()->{
////            System.out.println(ACTION_CENTER.size());
////            try {
////                Robot robot = new RobotControl();
//////                GlobalScreen.unregisterNativeHook();
////                new RobotActionCenter().robotActionFactory(ACTION_CENTER, robot);
////            } catch (AWTException ex) {
////                throw new RuntimeException(ex);
////            }
////            System.out.println("DEMO MOVE MOUSE");
////        }).start();
////        return new ResponseEntity<>("start", HttpStatus.OK);
////    }
//
//    @GetMapping("/start")
//    public ResponseEntity<String> startedActions() {
//        new Thread(()->{
//            List<Object> actions = actionService.getActions();
//            System.out.println(ACTION_CENTER.size());
//            try {
//                Robot robot = new RobotControl();
////                GlobalScreen.unregisterNativeHook();
//                new RobotActionCenter().robotActionFactory(actions, robot);
//            } catch (AWTException ex) {
//                throw new RuntimeException(ex);
//            }
//            System.out.println("DEMO MOVE MOUSE");
//        }).start();
//        return new ResponseEntity<>("start", HttpStatus.OK);
//    }
//
//    @GetMapping("/end")
//    public ResponseEntity<String> endActions() {
//        System.out.println("TURN OFF");
//        System.exit(1);
//        return new ResponseEntity<>("end", HttpStatus.OK);
//    }
//}
