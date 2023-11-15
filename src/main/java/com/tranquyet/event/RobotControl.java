package com.tranquyet.event;

import java.awt.*;

public class RobotControl extends Robot implements Runnable {
    private volatile boolean isStopped = false;
    public RobotControl() throws AWTException {
    }

    public RobotControl(GraphicsDevice screen) throws AWTException {
        super(screen);
    }

    @Override
    public void run() {
        try {
            while (!isStopped) {
                // Your thread logic here
                // Check for interruption and exit if necessary
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            // Handle the interruption if necessary
            System.out.println("Thread interrupted and stopped.");
        }
    }
    public void stopThread() {
        isStopped = true;
    }
}
