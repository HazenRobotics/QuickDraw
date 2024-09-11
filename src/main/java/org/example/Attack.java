package org.example;

interface AttackVoid {
    int run(int mul);
}

public class Attack {
    public static final double[][] MATCHUP_TABLE = new double[][]{
            new double[]{0, 1, 1, -2, -1},
            new double[]{-1, 0, 2, -2, 1},
            new double[]{-1, -2, 0.5, 1, 0},
            new double[]{2, 1.5, -1, 0, 2},
            new double[]{1, -1, 0, -2, 0}
    };
    private final AttackVoid attack;
    private final int type;

    public Attack(AttackVoid a, int t) {
        attack = a;
        type = t;
    }

    public int getAttackPriority(int t, int bonus,int minimum, boolean first) {
        double p = MATCHUP_TABLE[type][t];
        if(p==0) {
            p=-1;
            if(first) {
                p=1;
            }
        }
        if(p==0.5) {
            p=-2;
            if(first) {
                p=2;
            }
        }
        if(p==1.5) {
            p=-1;
            if(first) {
                p=1;
            }
        }
        p+=bonus;
        if(p<minimum) {
            p=minimum;
        }
        return (int) p;
    }

    public int getType() {
        return type;
    }
}

