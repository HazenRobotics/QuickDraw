package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;
import org.example.Main;

import java.util.ArrayList;

public class Velorum extends Charachter {

    public Velorum() {
        super("Velorum", "TBD", 70,1.1,1.35);
    }
    @Override public void normal(Charachter enemy,double p) {
        for(Charachter c:enemy.getTeam().getTeam()) {
            super.normal(c,p/2);
        }

    }
    @Override public void light(Charachter enemy,double p) {
        ArrayList<Charachter> c = enemy.getTeam().getTeam();
        super.light(c.get(Main.random(0,c.size()-1)),p/2);
        super.light(c.get(Main.random(0,c.size()-1)),p/2);


    }
    @Override public void heavy(Charachter enemy,double p) {
        for(Charachter c:enemy.getTeam().getTeam()) {
            c.addEffect(Effect.getAllEffects()[9]);
        }

    }
    @Override public void switchIn(Charachter enemy,double p) {
        super.switchIn(enemy,p);
        for(Charachter c:enemy.getTeam().getTeam()) {
           c.changeHp(3);
        }

    }
    @Override public void switchOut(Charachter enemy,double p) {
        super.switchOut(enemy,p);

    }
    @Override public void block(Charachter enemy,double p) {
        super.block(enemy,p);
        if(p==2) {
            ArrayList<Charachter> c = enemy.getTeam().getTeam();
            super.light(c.get(Main.random(0,c.size()-1)),p/2);
        }
    }
    @Override public void ultimate(Charachter enemy, double p) {
        for(Charachter c:enemy.getTeam().getTeam()) {
            c.changeHp(c.getHp()/3);
        }
    }
}
