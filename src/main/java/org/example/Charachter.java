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
    private double attackPower;
    private final double chargeRatio;
    private final String name;
    private final ArrayList<Effect> status;
    private final String folder;
    private int hp;
    private final int priorityBonus = 0;
    private final int priorityMinimum = -2;
    private double defense = 1;
    private Team team;
    private double[] baseStats;

    public Charachter(String n, String f, int m, double a, double c) {
        maxHP = m;
        name = n;
        status = new ArrayList<>();
        folder = f;
        attackPower = a;
        chargeRatio = c;
        hp = maxHP;
        baseStats= new double[]{a, c};
    }

    public int changeHp(int h) {
        if (hasEffect("Perfect Block")) {
            return 0;
        }
        hp -= h / defense;
        return (int) (h / defense);
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public double getDefense() {
        return defense;
    }

    public double[] getBaseStats() {
        return baseStats;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public ArrayList<Effect> getStatus() {
        return status;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public Team getTeam() {
        return team;
    }

    public void addDefense(double defense) {
        this.defense += defense;
    }

    public boolean hasEffect(String name) {
        boolean has = false;
        for (int i = 0; i < status.size(); i++) {
            if (status.get(i).getName().equals(name)) {
                has = true;
                break;
            }
        }
        return has;
    }

    public void addEffect(Effect e) {
        status.add(e);
    }

    public void updateStatus() {
        for (Effect stat : status) {
            stat.tickDown();
            if (stat.getDuration() <= 0) {
                status.remove(stat);
            }
        }
    }


    public void normal(Charachter enemy, double p) {
        enemy.changeHp((int) (15 * attackPower * p));
        team.addCharge((int) (((15 * p) / 2) * chargeRatio));
    }

    public void light(Charachter enemy, double p) {
        enemy.changeHp((int) (7 * attackPower * p));
        team.addCharge((int) (((7 * p) / 2) * chargeRatio));

    }

    public void heavy(Charachter enemy, double p) {
        enemy.changeHp((int) (25 * attackPower * p));
        team.addCharge((int) (((25 * p) / 2) * chargeRatio));

    }

    public void switchIn(Charachter enemy, double p) {
        enemy.changeHp((int) (12 * attackPower * p));
        team.switchFighter();
        team.fighter().switchOut(enemy, p);
    }

    public void switchOut(Charachter enemy, double p) {
        enemy.changeHp((int) (10 * attackPower * p));
        team.addCharge((int) (((10 * p) / 2) * chargeRatio));
    }

    public void block(Charachter enemy, double p) {
        addEffect(Effect.getAllEffects()[0]);
    }

    public void ultimate(Charachter enemy, double p) {

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
