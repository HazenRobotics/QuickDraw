package org.example;

import java.util.ArrayList;

public class Team {
    private final ArrayList<Charachter> team;
    private final int specialCharge;
    Charachter switchIn = null;


    public Team(ArrayList<Charachter> c) {
        team = c;
        specialCharge = 0;
    }

    public void attack(int a,Charachter enemy, int p) {
        if (a == 0) {
            fighter().normal(enemy, p);
        } else if (a == 1) {
            fighter().normal(enemy, p);
        } else if (a == 2) fighter().normal(enemy, p);
        else if (a == 3) {
            fighter().normal(enemy, p);
        } else if (a == 4) {
            fighter().normal(enemy, p);
        }
    }

    public int chooseAttack(int i) {
        Gamepad gamepad = Main.getGamepads().get(i);
        if (gamepad.a) {
            return 0;
        } else if (gamepad.b) {
            return 1;
        } else if (gamepad.x) {
            return 2;
        } else if (gamepad.y) {
            return 3;
        } else if (gamepad.r || gamepad.l) {
            if (team.size() > 0) {
                if (gamepad.l && team.size() < 2) {
                    switchIn = team.get(2);
                } else {
                    switchIn = team.get(1);
                }
            }
            return 4;
        } else if (gamepad.zl || gamepad.zr) {
            return 5;
        } else {
            return -1;
        }
    }
    public boolean isTeamLeft() {
        return team.isEmpty();
    }
    public Charachter fighter() {
        return team.get(0);
    }
}
