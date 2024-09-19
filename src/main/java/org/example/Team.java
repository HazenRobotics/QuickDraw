package org.example;

import java.util.ArrayList;

public class Team {
    private final ArrayList<Charachter> team;
    Charachter switchIn = null;
    private int specialCharge;
    private int gamepadIndex;


    public Team(ArrayList<Charachter> c,int g) {
        gamepadIndex=g;
        team = c;
        specialCharge = 0;
    }

    public Charachter getSwitchIn() {
        return switchIn;
    }

    public int getSpecialCharge() {
        return specialCharge;
    }

    public void addCharge(int a) {
        specialCharge += a;
    }

    public void setSpecialCharge(int specialCharge) {
        this.specialCharge = specialCharge;
    }
    public boolean isTeamLeft() {
        return team.isEmpty();
    }

    public Charachter fighter() {
        return team.get(0);
    }
    public void switchFighter(int i) {
        Charachter temp = team.get(i);
        team.set(i,fighter());
        team.set(0,temp);
    }
    
    public void switchFighter(Charachter c) {
        switchFighter(team.indexOf(c));
    }
    public void switchFighter() {
        switchFighter(switchIn);
    }

    public ArrayList<Charachter> getTeam() {
        return team;
    }

    public int getGamepadIndex() {
        return gamepadIndex;
    }
    public int size() {
        return team.size();
    }
    public Charachter get(int i) {
        return team.get(i);
    }

    public void attack(int a, Charachter enemy, double p) {
        switch (a) {
            case 0: {
                fighter().normal(enemy, p);
            }
            case 1: {
                fighter().normal(enemy, p);
            }
            case 2: {
                fighter().normal(enemy, p);
            }
            case 3: {
                fighter().normal(enemy, p);
            }
            case 4: {
                fighter().normal(enemy, p);
            }
        }

    }

    public int chooseAttack() {
        Gamepad gamepad = Main.getGamepads().get(gamepadIndex);
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


}
