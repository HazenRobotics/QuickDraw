package org.example.Characters;

import org.example.Charachter;

public class Velorum extends Charachter {

    public Velorum() {
        super("Velorum", "TBD", 100,1,1.25);
    }
    @Override public void normal(Charachter enemy,double p) {
        for(Charachter c:enemy.getTeam().get) {

        }

    }
    @Override public void light(Charachter enemy,double p) {
        super.light(enemy,p);

    }
    @Override public void heavy(Charachter enemy,double p) {
        super.heavy(enemy,p);

    }
    @Override public void switchIn(Charachter enemy,double p) {
        super.switchIn(enemy,p);

    }
    @Override public void switchOut(Charachter enemy,double p) {
        super.switchOut(enemy,p);

    }
    @Override public void block(Charachter enemy,double p) {

    }
    @Override public void ultimate(Charachter enemy, double p) {

    }
}
