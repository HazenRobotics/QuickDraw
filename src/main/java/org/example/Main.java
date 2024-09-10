package org.example;
import net.java.games.input.Controller;
import java.io.File;
import java.util.ArrayList;

import static org.example.Gamepad.createDefaultEnvironment;

public class Main {
    static private ArrayList<Gamepad> gamepads;
    public static void main(String[] args) throws ReflectiveOperationException {
        System.setProperty("net.java.games.input.librarypath", new File("C:\\Users\\C1nner\\Downloads\\jinput-jinput-2.0.10-49-gd9a5a7f\\jinput-jinput-d9a5a7f\\plugins\\windows\\src\\main").getAbsolutePath());
        Controller[] controllers = createDefaultEnvironment().getControllers();
        gamepads = new ArrayList<>();
        for(int i=0; i<controllers.length; i++) {
            if (
            controllers[i].getType() == Controller.Type.STICK || controllers[i].getType() == Controller.Type.GAMEPAD ||
            controllers[i].getType() == Controller.Type.WHEEL || controllers[i].getType() == Controller.Type.FINGERSTICK
            )
                gamepads.add( new Gamepad(controllers[i].getName()));
            }

        new GameScreen();

    }

    public static ArrayList<Gamepad> getGamepads() {
        return gamepads;
    }
}
