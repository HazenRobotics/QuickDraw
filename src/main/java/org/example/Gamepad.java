package org.example;

//import net.java.games.input.Controller;
//import net.java.games.input.ControllerEnvironment;
//import net.java.games.input.Event;
//import net.java.games.input.EventQueue;

import java.io.File;
import java.lang.reflect.Constructor;

/**
 * This class shows how to use the event queue system in JInput. It will show
 * how to get the controllers, how to get the event queue for a controller, and
 * how to read and process events from the queue.
 *
 * @author Endolf
 */
public class Gamepad {

    private final String name;
    volatile boolean dPadUp, dPadDown, dPadRight, dPadLeft, a, b, x, y, r, l, zr, zl, start, select, home, screenshot;
    volatile double rightXAxis, leftXAxis, rightYAxis, leftYAxis;

    public Gamepad(String n) {
        dPadUp = false;
        dPadDown = false;
        dPadRight = false;
        dPadLeft = false;
        a = false;
        b = false;
        x = false;
        y = false;
        r = false;
        l = false;
        zr = false;
        zl = false;
        start = false;
        select = false;
        home = false;
        screenshot = false;
        name = n;
        rightXAxis = 0;
        leftXAxis = 0;
        rightYAxis = 0;
        leftYAxis = 0;
    }

//    static ControllerEnvironment createDefaultEnvironment() throws ReflectiveOperationException {
//
//        // Find constructor (class is package private, so we can't access it directly)
//        Constructor<ControllerEnvironment> constructor = (Constructor<ControllerEnvironment>)
//                Class.forName("net.java.games.input.DefaultControllerEnvironment").getDeclaredConstructors()[0];
//
//        // Constructor is package private, so we have to deactivate access control checks
//        constructor.setAccessible(true);
//
//        // Create object with default constructor
//        return constructor.newInstance();
//    }
//
//    public void update() throws ReflectiveOperationException {
//        /* Get the available controllers */
//        System.setProperty("net.java.games.input.librarypath", new File("C:\\Users\\C1nner\\Downloads\\jinput-jinput-2.0.10-49-gd9a5a7f\\jinput-jinput-d9a5a7f\\plugins\\windows\\src\\main").getAbsolutePath());
//
//        Controller[] controllers = createDefaultEnvironment().getControllers();
//        Controller controller = null;
//        for (int i = 0; i < controllers.length; i++) {
//            if (controllers[i].getName().equals(name)) {
//                controller = controllers[i];
//            }
//        }
//
//        /* Remember to poll each one */
//        controller.poll();
//
//        /* Get the controllers event queue */
//        EventQueue queue = controller.getEventQueue();
//
//        /* Create an event object for the underlying plugin to populate */
//        Event event = new Event();
//
//        /* For each object in the queue */
//        while (queue.getNextEvent(event)) {
//            String name = event.getComponent().getName();
//            float value = event.getValue();
//            switch (name) {
//                case "Button 0": {
//                    y = value == 1;
//                    break;
//                }
//                case "Button 1": {
//                    b = value == 1;
//                    break;
//                }
//                case "Button 2": {
//                    a = value == 1;
//                    break;
//                }
//                case "Button 3": {
//                    x = value == 1;
//                    break;
//                }
//                case "Button 4": {
//                    l = value == 1;
//                    break;
//                }
//                case "Button 5": {
//                    r = value == 1;
//                    break;
//                }
//                case "Button 6": {
//                    zl = value == 1;
//                    break;
//                }
//                case "Button 7": {
//                    zr = value == 1;
//                    break;
//                }
//                case "Button 8": {
//                    select = value == 1;
//                    break;
//                }
//                case "Button 9": {
//                    start = value == 1;
//                    break;
//                }
//                case "Button 12": {
//                    home = value == 1;
//                    break;
//                }
//                case "Button 13": {
//                    screenshot = value == 1;
//                    break;
//                }
//                case "Hat Switch": {
//                    dPadUp = false;
//                    dPadDown = false;
//                    dPadRight = false;
//                    dPadLeft = false;
//                    if (value == 0.125) {
//                        dPadUp = true;
//                        dPadLeft = true;
//                    } else if (value == 0.25) {
//                        dPadUp = true;
//                    } else if (value == 0.375) {
//                        dPadUp = true;
//                        dPadRight = true;
//                    } else if (value == 0.5) {
//                        dPadRight = true;
//                    } else if (value == 0.625) {
//                        dPadRight = true;
//                        dPadDown = true;
//                    } else if (value == 0.75) {
//                        dPadDown = true;
//                    } else if (value == 0.875) {
//                        dPadDown = true;
//                        dPadLeft = true;
//                    } else if (value == 1) {
//                        dPadLeft = true;
//                    }
//                }
//                case "X Axis": {
//                    rightXAxis = value;
//                    if (Math.abs(rightXAxis) < 0.001) {
//                        rightXAxis = 0;
//                    }
//                    break;
//                }
//                case "Y Axis": {
//                    rightYAxis = value;
//                    if (Math.abs(rightYAxis) < 0.001) {
//                        rightYAxis = 0;
//                    }
//                    break;
//                }
//                case "Z Axis": {
//                    leftYAxis = value;
//                    if (Math.abs(leftYAxis) < 0.001) {
//                        leftYAxis = 0;
//                    }
//                    break;
//                }
//                case "Z Rotation": {
//                    leftXAxis = value;
//                    if (Math.abs(leftXAxis) < 0.001) {
//                        leftXAxis = 0;
//                    }
//                    break;
//                }
//            }
//        }
//    }

    @Override
    public String toString() {
        return "A: " + a + " B: " + b + " X: " + x + " Y: " + y + " R: " + r + " L: " + l + " ZR: " + zr + " ZL: " + zl + "\nStart: " + start + " Select: " + select + " Home: " + home + " Screenshot: " + screenshot + " Dpad: " + dPadUp + " " + dPadDown + " " + dPadRight + " " + dPadLeft + "\n" +
                "Right X: " + rightXAxis + " Left X: " + leftXAxis + " Right Y: " + rightYAxis + " Left Y: " + leftYAxis;
    }


    public String getName() {
        return name;
    }
}