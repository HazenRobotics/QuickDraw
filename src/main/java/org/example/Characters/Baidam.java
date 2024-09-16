package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;

public class Baidam extends Charachter {

    public Baidam() {
        super("Baidam", "TBD", 90,1.75,0.75);
    }
    @Override public void normal(Charachter enemy,double p) {
        super.normal(enemy,p);
        for(Effect e:getStatus()) {
            e.setDuration(e.getDuration()+2);
        }
    }
    @Override public void light(Charachter enemy,double p) {
        changeHp((int) (7*(getAttackPower()*2)*p));

    }
    @Override public void heavy(Charachter enemy,double p) {
        changeHp((int) ((getMaxHP()-getHp())*p));
    }
    @Override public void switchIn(Charachter enemy,double p) {
        for(Effect e:enemy.getStatus()) {
            if(e.getName().equals("Perfect Block")) {
                enemy.getStatus().remove(e);
            }
        }
        enemy.setDefense(1);
        super.switchIn(enemy,p);
    }
    @Override public void switchOut(Charachter enemy,double p) {
        super.switchOut(enemy,p);
    }
    @Override public void block(Charachter enemy,double p) {
        super.block(enemy, p);
        addEffect(Effect.getAllEffects()[3]);

    }
    @Override public void ultimate(Charachter enemy, double p) {
        addEffect(Effect.getAllEffects()[4]);
    }
}
