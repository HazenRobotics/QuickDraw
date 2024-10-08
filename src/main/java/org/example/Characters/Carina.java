package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;

public class Carina extends Charachter {

    public Carina() {
        super("Carina","Carina is an otter who owns a large spear that she uses to hunt. She can also call upon the spirits of the sea to help her. She uses these spirits to heal her teammates.",
                "TBD", 70, 1, 5);
    }

    @Override
    public void normal(Charachter enemy, double p) {
        super.normal(enemy, p);
        for (Charachter c : getTeam().getTeam()) {
            c.addEffect(Effect.getAllEffects()[14]);
        }

    }

    @Override
    public void light(Charachter enemy, double p) {
        super.light(enemy, p);
        for (Charachter c : getTeam().getTeam()) {
            for (Effect e : c.getStatus()) {
                if (e.isDebuff()) {
                    c.getStatus().remove(e);
                }
            }
        }

    }

    @Override
    public void heavy(Charachter enemy, double p) {
        super.heavy(enemy, p);
        for (Charachter c : getTeam().getTeam()) {
            c.changeHp(-10);
        }

    }

    @Override
    public void switchIn(Charachter enemy, double p) {
        getTeam().fighter().changeHp(-5);
        super.switchIn(enemy, p);

    }

    @Override
    public void switchOut(Charachter enemy, double p) {
        getTeam().getSwitchIn().changeHp(-5);
        super.switchOut(enemy, p);
    }

    @Override
    public void block(Charachter enemy, double p) {
        super.block(enemy, p);
        if (!(p == 2)) {
            for (Charachter c : getTeam().getTeam()) {
                c.changeHp(-5);
            }
        }
    }

    @Override
    public void ultimate(Charachter enemy, double p) {
        for (Charachter c : getTeam().getTeam()) {
            c.changeHp(-c.getMaxHP() / 3);
        }
    }

}
