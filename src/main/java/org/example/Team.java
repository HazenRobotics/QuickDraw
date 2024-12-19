package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
                fighter().light(enemy, p);
            }
            case 2: {
                fighter().heavy(enemy, p);
            }
            case 3: {
                fighter().block(enemy, p);
            }
            case 4: {
                fighter().switchIn(enemy, p);
            }
            case 5: {
                fighter().ultimate(enemy,p);
                setSpecialCharge(0);
            }
            case 6: {
                int i = Arrays.asList(fighter().getForms()).indexOf(fighter())+1;
                if(i==fighter().getForms().length) {
                    i=0;
                }
                fighter().getTeam().transform(0,fighter().getForms()[i]);
            }

        }

    }
    public void set(int i,Charachter c) {
        team.set(i,c);
    }

//    public int chooseAttack() {
//        Gamepad gamepad = Main.getGamepads().get(gamepadIndex);
//        if (gamepad.a) {
//            return 0;
//        } else if (gamepad.b) {
//            return 1;
//        } else if (gamepad.x) {
//            return 2;
//        } else if (gamepad.y) {
//            return 3;
//        } else if (gamepad.r || gamepad.l) {
//            if (team.size() > 0) {
//                if (gamepad.l && team.size() < 2) {
//                    switchIn = team.get(2);
//                } else {
//                    switchIn = team.get(1);
//                }
//            }
//            return 4;
//        } else if ((gamepad.zl || gamepad.zr))  {
//            if(getSpecialCharge()==100) {
//                return 5;
//            } else {
//                return 6;
//            }
//        }
//        else {
//            return -1;
//        }
//
//    }
    //i grabs target
    //c is switch out
    public void transform(int i,Charachter c) {
        Charachter target = get(i);
        c.setHp(target.getHp());
        c.setStatus(target.getStatus());
        set(i,c);
    }


}
