package org.example;

import java.util.ArrayList;

public class Battle {
    //private final ArrayList<Gamepad> gamepads = Main.getGamepads();
    private final Team team1;
    private final Team team2;
    int team1Index = -1;
    int team2Index = -1;
    private boolean team1goesFirst = false;


    public Battle(Team t1, Team t2) throws ReflectiveOperationException {
        team1 = t1;
        team2 = t2;
        Thread t = new Thread(Dimension::cycleDimension);
        t.start();
        while (!team2.isTeamLeft() || !team1.isTeamLeft()) {
            planPhase();
            //choosePhase();
            attackPhase();
        }

    }

//    public void choosePhase() {
//        team1Index = -1;
//        team2Index = -1;
//        long startTime = System.currentTimeMillis();
//        while (startTime + 3000 > System.currentTimeMillis() && (team1Index == -1 || team2Index == -1)) {
//            int timeLeft = (int) (3000 - (System.currentTimeMillis() - startTime));
//            if (team1.chooseAttack() != -1) {
//                if (team1.chooseAttack() == -1) {
//                    team1goesFirst = true;
//                }
//                team1Index = team1.chooseAttack();
//            }
//            if (team2.chooseAttack() != -1) {
//                if (team1.chooseAttack() == -1) {
//                    team1goesFirst = false;
//                }
//                team2Index = team1.chooseAttack();
//            }
//
//        }
//
//    }

    public void attackPhase() {
        Dimension.getCurrentDimension().runForEveryone(team1,team2);
        for (Charachter c : team1.getTeam()) {
            c.setToBaseStats();
            c.applyEffects(0);
        }
        for (Charachter c : team2.getTeam()) {
            c.setToBaseStats();
            c.applyEffects(0);
        }
        if (team2Index == -1 || team1Index == -1) {
            if (team2Index == -1) {
                team1.attack(team1Index, team2.fighter(), 2);
            } else if (team1Index == -1) {
                team2.attack(team2Index, team1.fighter(), 2);
            }
            return;
        }

        int p1 = team1.fighter().getAttackPriority(team2Index, team1Index, team1goesFirst);
        int p2 = team2.fighter().getAttackPriority(team1Index, team2Index, !team1goesFirst);
        int p;
        if (p1 - p2 == 0) {
            p = p1;
        } else {
            p = p1 - p2;
        }
        for (Charachter c : team1.getTeam()) {
            c.applyEffects(2);
        }
        for (Charachter c : team2.getTeam()) {
            c.applyEffects(2);
        }
        switch (p) {
            case 2: {
                team1.attack(team1Index, team2.fighter(), 1.5);
                break;
            }
            case -2: {
                team2.attack(team2Index, team1.fighter(), 1.5);
                break;

            }
            case -1: {
                team2.attack(team2Index, team1.fighter(), 1);
                team1.attack(team1Index, team2.fighter(), 0.75);
                break;

            }
            case 1: {
                team2.attack(team2Index, team1.fighter(), 0.75);
                team1.attack(team1Index, team2.fighter(), 1);
                break;

            }
            case 0: {
                team2.attack(team2Index, team1.fighter(), 1);
                team1.attack(team1Index, team2.fighter(), 1);
                break;
            }
        }
        for (Charachter c : team1.getTeam()) {
            c.applyEffects(2);
        }
        for (Charachter c : team2.getTeam()) {
            c.applyEffects(2);
        }


    }

    public void planPhase() throws ReflectiveOperationException {
        long startTime = System.currentTimeMillis();
        int time = 10000;
        boolean team1Skip = false;
        boolean team2Skip = false;
//        while (startTime + time > System.currentTimeMillis() && !(team2Skip && team1Skip)) {
//            for(Gamepad g:gamepads) {
//                g.update();
//            }
//            int timeLeft = (int) (time - (System.currentTimeMillis() - startTime));
//            if(gamepads.get(0).a && !team1Skip) {
//                team1Skip=true;
//            }
//            if(gamepads.get(1).a && !team2Skip) {
//                team2Skip=true;
//            }
//
//        }
    }


}
