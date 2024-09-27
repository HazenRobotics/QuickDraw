package org.example;

import java.awt.*;
import java.util.ArrayList;


public class Main {
    static private ArrayList<Gamepad> gamepads;

    public static void main(String[] args) throws ReflectiveOperationException {
        Animation a = new Animation(
                new double[] {8.83,2.47,7.87,9.32,4.11,4.25,6.48,3.13,8.55,5.57},
                new double[] {8.25,4.29,7.99,6.98,5.93,8.89,4.58,7.42,9.97,2.45},
                1,
                2000,
                "C:/Users/C1nner/IdeaProjects/QuickDraw/src/main/java/org/example/Orion",
                new int[]{0},
                false,
                new Point(0,0)
        );
        //new GameScreen();
        //GameScreen.SYSTEM.add(GameScreen.TEST);
        //GameScreen.TEST.setBounds(500,100,500,700);
//        wait(1000);
//        a.animation(GameScreen.TEST).run();

        System.out.println(a.curve.calculate(0.1)+"");
        System.out.println(a.curve.calculate(0.2)+"");
        System.out.println(a.curve.calculate(0.3)+"");
        System.out.println(a.curve.calculate(0.4)+"");
        System.out.println(a.curve.calculate(0.5)+"");
        System.out.println(a.curve.calculate(0.6)+"");
        System.out.println(a.curve.calculate(0.7)+"");
        System.out.println(a.curve.calculate(0.7)+"");

    }


    public static int random(int low, int high) {
        int range = high - low + 1;
        return (int) (Math.random() * range) + low;
    }

    public static ArrayList<Gamepad> getGamepads() {
        return gamepads;
    }

    public static int choice(int i, int limit, String text) {
        Gamepad g = gamepads.get(i);
        int choice = -1;
        while (choice == -1 || choice < limit) {
            if (g.a) {
                choice = 0;
            } else if (g.b) {
                choice = 1;
            } else if (g.x) {
                choice = 2;
            } else if (g.y) {
                choice = 3;
            } else if (g.l) {
                choice = 4;
            } else if (g.r) {
                choice = 5;
            } else if (g.zr) {
                choice = 6;
            } else if (g.zl) {
                choice = 7;
            } else if (g.start) {
                choice = 8;
            } else if (g.select) {
                choice = 9;
            } else if (g.dPadUp) {
                choice = 10;
            } else if (g.dPadLeft) {
                choice = 11;
            } else if (g.dPadDown) {
                choice = 12;
            } else if (g.dPadRight) {
                choice = 13;
            }
        }
        return choice;
    }

    public int choice(int i, int count, String text, String[] labels) {
        return choice(i,count,text);
    }
    public static void wait(int timeMillis) {
        long startTime = System.currentTimeMillis();
        while (startTime+timeMillis>System.currentTimeMillis());
    }
}
