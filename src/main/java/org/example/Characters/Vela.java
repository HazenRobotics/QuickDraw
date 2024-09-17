package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;

public class Vela extends Charachter {

    public Vela() {
        super("Vela", "TBD", 125,1.1,0.90);
    }
    @Override public void normal(Charachter enemy,double p) {
        super.normal(enemy,p);
        changeHp((int) ((getMaxHP()-getHp())*p)/2);

    }
    @Override public void light(Charachter enemy,double p) {
        super.light(enemy,p);
        if(enemy.getHp()>getHp()) {
            enemy.changeHp(-(enemy.getHp()-getHp())/2);
        }

    }
    @Override public void heavy(Charachter enemy,double p) {
        for(int i=0; i<4-getTeam().size(); i++) {
            super.heavy(enemy,p);

        }
    }
    @Override public void switchIn(Charachter enemy,double p) {
        super.switchIn(enemy,p);
        if(p<1) {
            getTeam().addCharge(10);
        }

    }
    @Override public void switchOut(Charachter enemy,double p) {
        super.switchOut(enemy,p);
        if(p<1) {
            getTeam().addCharge(10);
        }

    }
    @Override public void block(Charachter enemy,double p) {
        super.block(enemy,p);
        for(int i=enemy.getTeam().size(); i>0; i--) {
            addEffect(Effect.getAllEffects()[6]);
        }
    }
    @Override public void ultimate(Charachter enemy, double p) {
        int total = 0;
        for (int i=0; i<getTeam().size(); i++) {
            Charachter c = getTeam().get(i);
            total+=c.getMaxHP()-c.getHp();
        }
        enemy.changeHp(total/getTeam().size());
    }
}
