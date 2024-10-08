package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;
import org.example.Main;

public class Leo extends Charachter {

    public Leo() {
        super("Leo", "TBD","Leo is a highly skilled marksman. They often hide on the sidelines only to hit the killing shot. No matter the target they never seem to miss.  Leo focuses on poisoning the opponents and dodging attacks. ",
                70,1.5,1);
    }
    @Override public void normal(Charachter enemy,double p) {
        super.normal(enemy,p);
        if(Main.random(0,10)<3 && enemy.hasEffect("Poison")) {
            this.addEffect(Effect.getAllEffects()[1]);
        }
    }
    @Override public void light(Charachter enemy,double p) {
        super.light(enemy,p);
        if(enemy.hasEffect("Poison")) {
            enemy.changeHp((int) (10*getAttackPower()));
        } else {
            enemy.addEffect(Effect.getAllEffects()[2]);
        }
    }
    @Override public void heavy(Charachter enemy,double p) {
        super.heavy(enemy,p);
        if(Main.random(0,10)<3) {
            this.addEffect(Effect.getAllEffects()[1]);
        }

    }
    @Override public void switchIn(Charachter enemy,double p) {
        super.switchIn(enemy,p);

    }
    @Override public void switchOut(Charachter enemy,double p) {
        super.switchOut(enemy,p);
        enemy.addEffect(Effect.getAllEffects()[2]);

    }
    @Override public void block(Charachter enemy,double p) {
        super.block(enemy,p);
    }
    @Override public void ultimate(Charachter enemy, double p) {
        Effect e = Effect.getAllEffects()[1];
        e.setDuration(2);
        addEffect(e);

    }
}
