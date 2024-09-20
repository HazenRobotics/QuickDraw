package org.example.Characters;

import org.example.Charachter;

public class Arrokoth extends Charachter {


    public Arrokoth() {
        super("Arrokoth", "TBD", 100,1,1.25);
    }
    @Override public void normal(Charachter enemy,double p) {
        super.normal(enemy,p);
        for(Charachter c:enemy.getTeam().getTeam()) {
            c.changeHp((int) (-5*p));
        }
    }
    @Override public void light(Charachter enemy,double p) {
        super.light(enemy,p);

    }
    @Override public void heavy(Charachter enemy,double p) {
        super.heavy(enemy,p);
        for(Charachter c:enemy.getTeam().getTeam()) {
            c.changeHp((int) (-10*p));
        }

    }
    @Override public void switchIn(Charachter enemy,double p) {
        super.switchIn(enemy,p);
        getTeam().getSwitchIn().changeHp(-3);

    }
    @Override public void switchOut(Charachter enemy,double p) {
        super.switchOut(enemy,p);

    }
    @Override public void block(Charachter enemy,double p) {
        super.block(enemy, p);
        if(!(p==2)) {
            for(Charachter c:enemy.getTeam().getTeam()) {
                c.changeHp((int) (-5*p));
            }
        }
    }
    @Override public void ultimate(Charachter enemy, double p) {
        for(Charachter c:enemy.getTeam().getTeam()) {
            c.changeHp(-c.getMaxHP()/3);
        }
    }
}
