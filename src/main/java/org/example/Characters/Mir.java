package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;

public class Mir extends Charachter {

    public Mir() {
        super("Mir", "TBD", 150,1,1);
    }
    @Override public void normal(Charachter enemy,double p) {
        super.normal(enemy,p);
        addEffect(Effect.getAllEffects()[6]);

    }
    @Override public void light(Charachter enemy,double p) {
        super.light(enemy,p);
        if(p>=1) {
            addEffect(Effect.getAllEffects()[7]);
        } else {
            enemy.addEffect(Effect.getAllEffects()[7]);
        }

    }
    @Override public void heavy(Charachter enemy,double p) {
        super.heavy(enemy,p);
        if(hasEffect("Block")) {
            super.heavy(enemy,p);
            getStatus().remove(Effect.getAllEffects()[0]);
        }

    }
    @Override public void switchIn(Charachter enemy,double p) {
        super.switchIn(enemy,p);

    }
    @Override public void switchOut(Charachter enemy,double p) {
        super.switchOut(enemy,p);
        getTeam().getSwitchIn().block(enemy,p);

    }
    @Override public void block(Charachter enemy,double p) {
        Effect e = Effect.getAllEffects()[1];
        if(p==2) {
            e.setDuration(2);
        }
        addEffect(e);

    }
    @Override public void ultimate(Charachter enemy, double p) {
        addEffect(Effect.getAllEffects()[6]);
        addEffect(Effect.getAllEffects()[1]);

    }
}
