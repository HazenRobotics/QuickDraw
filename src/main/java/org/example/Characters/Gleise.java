package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;

public class Gleise extends Charachter {
    double kill =0;

    public Gleise() {
        super("Gleise","We know very little about Gliese. They are silent and unfeeling. They wield a katana and focus on finishing off opponents.",
                "TBD", 110,1.25,0.85);
    }
    @Override public void normal(Charachter enemy,double p) {
        super.normal(enemy,p);
        if(enemy.getHp()<15 * getAttackPower() * p) {
            super.normal(enemy, p);
        }
        if(enemy.getHp()<=0) {
            kill++;
        }

    }
    @Override public void light(Charachter enemy,double p) {
        super.light(enemy,p);
        if(enemy.getHp()<=0) {
            addEffect(Effect.getAllEffects()[3]);
        }
        if(enemy.getHp()<=0) {
            kill++;
        }

    }
    @Override public void heavy(Charachter enemy,double p) {
        super.heavy(enemy,p);
        enemy.changeHp((int) (6 * kill * getAttackPower() * p));
        if(enemy.getHp()<=0) {
            kill++;
        }

    }
    @Override public void switchIn(Charachter enemy,double p) {
        super.switchIn(enemy,p);

        if(enemy.getHp()<=0) {
            kill++;
        }
    }
    @Override public void switchOut(Charachter enemy,double p) {
        super.switchOut(enemy,p);

        if(enemy.getHp()<=0) {
            kill++;
        }
    }
    @Override public void block(Charachter enemy,double p) {
        if(p>0) {
            normal(enemy,p);
        } else {
            addEffect(Effect.getAllEffects()[5]);
        }
    }
    @Override public void ultimate(Charachter enemy, double p) {
        enemy.changeHp(enemy.getHp()/3);
    }
}
