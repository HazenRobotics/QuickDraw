package org.example;

import java.util.ArrayList;

public class Charachter {
    private int maxHP;
    private int attackPower;
    private int defensePower;
    private int speedPower;
    private Attack[] attacks;
    private String name;
    private ArrayList<Effects> status;
    private String[] fileLinks;
    private int hp;
    public Charachter(int m,Attack[] attacks1,String n,String[] f, int a,int d,int s) {
        maxHP=m;
        attacks=attacks1;
        name=n;
        status=new ArrayList<>();
        fileLinks=f;
        attackPower=a;
        defensePower=d;
        speedPower=s;
        hp=maxHP;
    }

    public Attack[] getAttacks() {
        return attacks;
    }
}
