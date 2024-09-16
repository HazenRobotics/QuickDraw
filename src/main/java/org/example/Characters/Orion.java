package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;
import org.example.Main;
import org.example.Team;

public class Orion extends Charachter {
    Team team;
    public Orion() {
        super("Orion", "TBD", 100,1,1.25);
    }


    @Override public void normal(Charachter enemy, double p) {
        super.normal(enemy, p);
        double damage = 15+team.getSpecialCharge()/5;
        enemy.changeHp((int) (damage*p));
    }
    @Override public void light(Charachter enemy,double p) {
        super.light(enemy, p);
        if(p>1) {
            team.addCharge(10);
        }
    }
    @Override public void heavy(Charachter enemy,double p) {
        super.heavy(enemy, p);
        enemy.changeHp((int) (25*p));
        team.addCharge(10);
    }
    @Override public void switchIn(Charachter enemy,double p) {
        super.switchIn(enemy,p);
        enemy.changeHp((int) (15*p));
        if(team.getSpecialCharge()>75) {
            team.setSpecialCharge(100);
        }

    }
    @Override public void switchOut(Charachter enemy,double p) {
        super.switchOut(enemy,p);
        enemy.changeHp((int) (15*p));

    }
    @Override public void block(Charachter enemy,double p) {
        super.block(enemy,p);
        if(p>1) {
            team.addCharge(10);
        }

    }
    @Override public void ultimate(Charachter enemy, double p) {
        if(team.size()>1) {
            if (Main.choice(team.getGamepadIndex(),team.size()-1,"Whos ultimate would you like to use?")==0){
                team.get(1);
            } else {
                team.get(2);
            }
        }

    }
}
