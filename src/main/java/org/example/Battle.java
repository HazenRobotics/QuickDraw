package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Battle {
    private final ArrayList<Gamepad> gamepads = Main.getGamepads();
    private final ArrayList<Charachter> team1;
    private final ArrayList<Charachter> team2;
    int team1Index = -1;
    int team2Index = -1;
    private boolean team1goesFirst = false;
    Charachter switchIn1 = null;
    Charachter switchIn2 = null;


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
                team2Index = chooseAttack(1);
            }

        }

    }

    public void attackPhase() {

        int p1 = team1.get(0).getAttackPriority(team2Index,team1Index,team1goesFirst);
        int p2 = team2.get(0).getAttackPriority(team1Index,team2Index,!team1goesFirst);
        int p;
        if(p1-p2==0) {
            p=p1;
        } else {
            p=p1-p2;
        }
        switch (p) {
            case 2: {
                team1.get(0).attack(team1Index,team2.get(0),2);
                break;
            }
            case -2: {
                team2.get(0).attack(team2Index,team1.get(0),2);
                break;

            }
            case -1: {
                team2.get(0).attack(team2Index,team1.get(0),1);
                team1.get(0).attack(team1Index,team2.get(0),0);
                break;

            }
            case 1: {
                team2.get(0).attack(team2Index,team1.get(0),0);
                team1.get(0).attack(team1Index,team2.get(0),1);
                break;

            }
            case 0: {
                team2.get(0).attack(team2Index,team1.get(0),0);
                team1.get(0).attack(team1Index,team2.get(0),0);
                break;
            }
        }


    }

    public void planPhase() {
        long startTime = System.currentTimeMillis();
        int time = 10000;
        while (startTime + time > System.currentTimeMillis()) {
            int timeLeft = (int) (time - (System.currentTimeMillis() - startTime));
        }
    }

    public int chooseAttack(int i,ArrayList<Charachter> team) {
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
            if(i==0) {
                switchIn1=null;
            } else {
                switchIn2=null;
            }
            if(team.size()>1) {
                if(i==0) {
                    switchIn1=team.get(1);
                } else {
                    switchIn2=team.get(1);
                }
                if(gamepad.l && team.size()>2) {
                    if(i==0) {
                        switchIn1=team.get(2);
                    } else {
                        switchIn2=team.get(2);
                    }
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
