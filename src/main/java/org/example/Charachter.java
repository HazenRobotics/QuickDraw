package org.example;

import java.util.ArrayList;

public class Charachter {
    public static final double[][] MATCHUP_TABLE = new double[][]{
            new double[]{0, 1, 1, -2, -1},
            new double[]{-1, 0, 2, -2, 1},
            new double[]{-1, -2, 0.5, 1, 0},
            new double[]{2, 1.5, -1, 0, 2},
            new double[]{1, -1, 0, -2, 0}
    };

    private int maxHP;
    private double attackPower;
    private double chargeRatio;
    private String name;
    private ArrayList<Effect> status;
    private String folder;
    private int hp;
    private int priorityBonus = 0;
    private int priorityMinimum = -2;
    private double defense = 1;
    private Team team;

    public Charachter(String n, String f, int m, double a, double c) {
        maxHP = m;
        name = n;
        status = new ArrayList<>();
        folder = f;
        attackPower = a;
        chargeRatio = c;
        hp = maxHP;
    }
    public int changeHp(int h) {
        if(hasEffect("Perfect Block")) {
            return 0;
        }
        hp-=h/defense;
        return (int) (h/defense);
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public double getDefense() {
        return defense;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }
    public void addDefense(double defense) {
        this.defense += defense;
    }
    public boolean hasEffect(String name) {
        boolean has = false;
        for(int i =0; i<status.size(); i++) {
            if(status.get(i).getName().equals(name)) {
                has = true;
            }
        }
        return has;
    }
    public void addEffect(Effect e) {
        status.add(e);
    }
    public void updateStatus() {
        for(Effect stat : status) {
            stat.tickDown();
            if(stat.getDuration()<=0) {
                status.remove(stat);
            }
        }
    }


    public void normal(Charachter enemy, int p) {
        enemy.changeHp((int) (15*attackPower*p));
    }

    public void light(Charachter enemy, int p) {
        enemy.changeHp((int) (7*attackPower*p));

    }

    public void heavy(Charachter enemy, int p) {
        enemy.changeHp((int) (25*attackPower*p));

    }

    public void switchIn(Charachter enemy, int p) {
        enemy.changeHp((int) (12*attackPower*p));
        team.switchFighter();
        team.fighter().switchOut(enemy,p);
    }

    public void switchOut(Charachter enemy, int p) {
        enemy.changeHp((int) (10*attackPower*p));
    }

    public void block(Charachter enemy, int p) {
        addEffect(Effect.getAllEffects()[0]);
    }
    public void ultimate(Charachter enemy, int p) {

    }


        public int getAttackPriority(int t1, int t2, boolean first) {
        double p = MATCHUP_TABLE[t1][t2];
        if (p == 0) {
            p = -1;
            if (first) {
                p = 1;
            }
        }
        if (p == 0.5) {
            p = -2;
            if (first) {
                p = 2;
            }
        }
        if (p == 1.5) {
            p = -1;
            if (first) {
                p = 1;
            }
        }
        p += priorityBonus;
        if (p < priorityMinimum) {
            p = priorityMinimum;
        }
        if (p > 2) {
            p = 2;
        }
        if (p < -2) {
            p = -2;
        }
        return (int) p;
    }


}
