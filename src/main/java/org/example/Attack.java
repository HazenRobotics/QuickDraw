package org.example;

public class Attack {
    public static final double[][] MATCHUP_TABLE = new double[][]{
            new double[] {0,1,1,-2,-1},
            new double[] {-1,0,2,-2,1},
            new double[] {-1,-2,0.5,1,0},
            new double[] {2,1.5,-1,0,2},
            new double[] {1,-1,0,-2,0}
    };
    private AttackVoid attack;
    private int type;
    public Attack(AttackVoid a,int t) {
        attack=a;
        type=t;
    }
    public int getAttackPriority(int t,int bonus,boolean first) {
        int p=0;

        return p;
    }

}

interface AttackVoid {
    int run(int mul);
}

