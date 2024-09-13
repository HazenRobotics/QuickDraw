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
    private final int maxHP;
    private final int attackPower;
    private final double chargeRatio;
    private final String name;
    private final ArrayList<Effect> status;
    private final String folder;
    private final int hp;
    private final int priorityBonus = 0;
    private final int priorityMininum = -2;

    public Charachter(String n, String f, int m, int a, double c) {
        maxHP = m;
        name = n;
        status = new ArrayList<>();
        folder = f;
        attackPower = a;
        chargeRatio = c;
        hp = maxHP;
    }

    public void normal(Charachter enemy, int p) {
    }

    public void light(Charachter enemy, int p) {
    }

    public void heavy(Charachter enemy, int p) {
    }

    public void switchIn(Charachter enemy, int p, Charachter switchIn) {
    }

    public void switchOut(Charachter enemy, int p) {
    }

    public void block(Charachter enemy, int p) {
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
        if (p < priorityMininum) {
            p = priorityMininum;
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
