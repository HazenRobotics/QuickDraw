package org.example;

import net.java.games.input.Controller;
import org.example.Characters.*;


//import net.java.games.input.Controller;
//import static org.example.Gamepad.createDefaultEnvironment;
import java.io.File;
import java.util.ArrayList;
public class Main {
   // static private ArrayList<Gamepad> gamepads;
    public static final GameScreen screen = new GameScreen();
    public static final Charachter[] CHARACTERS = new Charachter[] {
            new Orion(),new Leo(),new Baidam(),new Gleise(),new Velorum(),new Vela(),new Mir(),new Andromeda(),new Arrokoth(),new Skylar(),new Betelgeuse(),new Carina()
    };

    public static void main(String[] args) throws ReflectiveOperationException {
//        System.setProperty("net.java.games.input.librarypath", new File("..\\QuickDraw\\src\\main\\java\\org\\example\\jinput-jinput-2.0.10-49-gd9a5a7f\\jinput-jinput-d9a5a7f\\plugins\\windows\\src\\main").getAbsolutePath());
//        Controller[] controllers = createDefaultEnvironment().getControllers();
//        gamepads = new ArrayList<>();
//        for (int i = 0; i < controllers.length; i++) {
//            if (
//                    controllers[i].getType() == Controller.Type.STICK || controllers[i].getType() == Controller.Type.GAMEPAD ||
//                            controllers[i].getType() == Controller.Type.WHEEL || controllers[i].getType() == Controller.Type.FINGERSTICK
//            )
//                gamepads.add(new Gamepad(controllers[i]));
//        }
//        if(gamepads.size()>1) {
//            screen.characterSelect();
//        }


    }

    public static int random(int low, int high) {
        int range = high - low + 1;
        return (int) (Math.random() * range) + low;
    }

//    public static ArrayList<Gamepad> getGamepads() {
//        return gamepads;
//    }
//
//    public static int choice(int i, int limit, String text) {
//        Gamepad g = gamepads.get(i);
//        int choice = -1;
//        while (choice == -1 || choice < limit) {
//            if (g.a) {
//                choice = 0;
//            } else if (g.b) {
//                choice = 1;
//            } else if (g.x) {
//                choice = 2;
//            } else if (g.y) {
//                choice = 3;
//            } else if (g.l) {
//                choice = 4;
//            } else if (g.r) {
//                choice = 5;
//            } else if (g.zr) {
//                choice = 6;
//            } else if (g.zl) {
//                choice = 7;
//            } else if (g.start) {
//                choice = 8;
//            } else if (g.select) {
//                choice = 9;
//            } else if (g.dPadUp) {
//                choice = 10;
//            } else if (g.dPadLeft) {
//                choice = 11;
//            } else if (g.dPadDown) {
//                choice = 12;
//            } else if (g.dPadRight) {
//                choice = 13;
//            }
//        }
//        return choice;
//    }
//
//    public int choice(int i, int count, String text, String[] labels) {
//        return choice(i,count,text);
//    }
    public static void wait(int timeMillis) {
        long startTime = System.currentTimeMillis();
        while (startTime+timeMillis>System.currentTimeMillis());
    }
}
