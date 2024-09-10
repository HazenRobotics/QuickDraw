package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Battle {
    ArrayList<Gamepad> gamepads = Main.getGamepads();
    ArrayList<Charachter> team1;
    ArrayList<Charachter> team2;
    public Battle(Charachter[] t1,Charachter[] t2) {
        team1= (ArrayList<Charachter>) Arrays.stream(t1).toList();
        team2=(ArrayList<Charachter>) Arrays.stream(t2).toList();
        while (!team2.isEmpty() || !team1.isEmpty()) {
            planPhase();
            choosePhase();
            attackPhase();
        }
        
    }
    public void choosePhase() {
        long startTime = System.currentTimeMillis();
        while (startTime+3000>System.currentTimeMillis() && (chooseAttack(0,team1.get(0))==null || chooseAttack(1,team2.get(0))==null)) {
            int timeLeft= (int) (3000-(System.currentTimeMillis()-startTime));
        }
    }
    public void attackPhase() {

    }
    public void planPhase() {
        long startTime = System.currentTimeMillis();
        int time = 10000;
        while (startTime+time>System.currentTimeMillis()) {
            int timeLeft= (int) (time-(System.currentTimeMillis()-startTime));
        }
    }
    public Attack chooseAttack(int i,Charachter c) {
        Gamepad gamepad = gamepads.get(i);
        if(gamepad.a) {
            return c.getAttacks()[0];
        }else if(gamepad.b) {
            return c.getAttacks()[1];
        }else if(gamepad.x) {
            return c.getAttacks()[2];
        }else if(gamepad.y) {
            return c.getAttacks()[3];
        }else if(gamepad.r||gamepad.l) {
            return c.getAttacks()[4];
        }else if(gamepad.zl||gamepad.zr) {
            return c.getAttacks()[5];
        } else {
            return null;
        }
    }


}
