package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;
import org.example.Main;

public class Leo extends Charachter {

    public Leo() {
        super("Leo", "TBD", 100,1,1.25);
    }
    @Override public void normal(Charachter enemy,int p) {
        super.normal(enemy,p);
        if(Main.random(0,10)<3 && enemy.hasEffect("Poison")) {
            this.addEffect(Effect.getAllEffects()[1]);
        }
    }
    @Override public void light(Charachter enemy,int p) {
        super.light(enemy,p);
        if(enemy.hasEffect("Poison")) {
            enemy.changeHp((int) (10*getAttackPower()));
        } else {
            enemy.addEffect(Effect.getAllEffects()[2]);
        }
    }
    @Override public void heavy(Charachter enemy,int p) {
        super.heavy(enemy,p);
        if(Main.random(0,10)<3) {
            this.addEffect(Effect.getAllEffects()[1]);
        }

    }
    @Override public void switchIn(Charachter enemy,int p) {
        super.switchIn(enemy,p);

    }
    @Override public void switchOut(Charachter enemy,int p) {
        super.switchOut(enemy,p);

    }
    @Override public void block(Charachter enemy,int p) {

    }
    @Override public void ultimate(Charachter enemy, int p) {

    }
}
