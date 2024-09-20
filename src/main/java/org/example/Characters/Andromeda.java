package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;

public class Andromeda extends Charachter {

    public Andromeda() {
        super("Andromeda", "TBD", 175,0.66,1.05);
    }
    @Override public void normal(Charachter enemy,double p) {
        enemy.addEffect(Effect.getAllEffects()[10]);

    }
    @Override public void light(Charachter enemy,double p) {
        super.light(enemy,p);
        for(Effect e : enemy.getStatus()) {
            if(e.getName().equals("Future Attack")) {
                e.setDuration(0);
            }
        }

    }
    @Override public void heavy(Charachter enemy,double p) {
        enemy.addEffect(Effect.getAllEffects()[10]);
        enemy.addEffect(Effect.getAllEffects()[11]);


    }
    @Override public void switchIn(Charachter enemy,double p) {
        super.switchIn(enemy,p);
        boolean trigger=false;
        for(Effect e : enemy.getStatus()) {
            if(e.getName().equals("Future Attack")) {
                e.setDuration(0);
                trigger=true;
            }
        }
        if(!trigger) {
            enemy.addEffect(Effect.getAllEffects()[10]);
        }

    }
    @Override public void switchOut(Charachter enemy,double p) {
        super.switchOut(enemy,p);

    }
    @Override public void block(Charachter enemy,double p) {
        if(!(p ==2)) {
            for(Effect e : enemy.getStatus()) {
                if(e.getName().equals("Future Attack")) {
                    e.setDuration(0);
                }
            }
        }
    }
    @Override public void ultimate(Charachter enemy, double p) {
        enemy.addEffect(Effect.getAllEffects()[10]);
        enemy.addEffect(Effect.getAllEffects()[11]);
        enemy.addEffect(Effect.getAllEffects()[10]);
        enemy.addEffect(Effect.getAllEffects()[11]);
    }
}
