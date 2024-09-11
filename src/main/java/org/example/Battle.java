package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Battle {
    int team1Index = -1;
    int team2Index = -1;
    private final ArrayList<Gamepad> gamepads = Main.getGamepads();
    private final ArrayList<Charachter> team1;
    private final ArrayList<Charachter> team2;
    private boolean team1goesFirst = false;

    public Battle(Charachter[] t1, Charachter[] t2) {
        team1 = (ArrayList<Charachter>) Arrays.stream(t1).toList();
        team2 = (ArrayList<Charachter>) Arrays.stream(t2).toList();
        while (!team2.isEmpty() || !team1.isEmpty()) {
            planPhase();
            choosePhase();
            attackPhase();
        }

    }

    public void choosePhase() {
        team1Index = -1;
        team2Index = -1;
        long startTime = System.currentTimeMillis();
        while (startTime + 3000 > System.currentTimeMillis() && (team1Index == -1 || team2Index == -1)) {
            int timeLeft = (int) (3000 - (System.currentTimeMillis() - startTime));
            if (chooseAttack(0) != -1) {
                if (chooseAttack(1) == -1) {
                    team1goesFirst = true;
                }
                team1Index = chooseAttack(0);
            }
            if (chooseAttack(0) != -1) {
                if (chooseAttack(1) == -1) {
                    team1goesFirst = false;
                }
                team2Index = chooseAttack(0);
            }

        }

    }

    public void attackPhase() {
        int type1 = team1.get(0).getAttack(team1Index).getType();
        int type2 = team1.get(0).getAttack(team1Index).getType();


    }

    public void planPhase() {
        long startTime = System.currentTimeMillis();
        int time = 10000;
        while (startTime + time > System.currentTimeMillis()) {
            int timeLeft = (int) (time - (System.currentTimeMillis() - startTime));
        }
    }

    public int chooseAttack(int i) {
        Gamepad gamepad = gamepads.get(i);
        if (gamepad.a) {
            return 0;
        } else if (gamepad.b) {
            return 1;
        } else if (gamepad.x) {
            return 2;
        } else if (gamepad.y) {
            return 3;
        } else if (gamepad.r || gamepad.l) {
            return 4;
        } else if (gamepad.zl || gamepad.zr) {
            return 5;
        } else {
            return -1;
        }
    }


}
