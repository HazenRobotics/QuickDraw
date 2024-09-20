package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;
import org.example.Main;

public class Skylar extends Charachter {


    public Skylar() {
        super("Skylar", "TBD", 125, 0.7, 1.1);
    }

    public Skylar(String n, String f, int m, double a, double c) {
        super(n, f, m, a, c);
    }

    @Override
    public void normal(Charachter enemy, double p) {
        super.normal(enemy, p);
        enemy.addEffect(Effect.getAllEffects()[12]);
    }

    @Override
    public void light(Charachter enemy, double p) {
        super.light(enemy, p);

    }

    @Override
    public void heavy(Charachter enemy, double p) {
        super.heavy(enemy, p);
        if (enemy.getTeam().getTeam().size() > 1) {
            enemy.getTeam().switchFighter(Main.random(1,enemy.getTeam().getTeam().size()-1));
        }

    }

    @Override
    public void switchIn(Charachter enemy, double p) {
        super.switchIn(enemy, p);


    }

    @Override
    public void switchOut(Charachter enemy, double p) {
        super.switchOut(enemy, p);
        getTeam().getSwitchIn().addEffect(Effect.getAllEffects()[13]);


    }

    @Override
    public void block(Charachter enemy, double p) {
        super.block(enemy, p);
        if(Main.choice(getTeam().getGamepadIndex(),1,"Would you like to switch")==0) {
            getTeam().switchFighter(Main.choice(getTeam().getGamepadIndex(),1,"Who would you like to switch"));
        }
    }

    @Override
    public void ultimate(Charachter enemy, double p) {

    }
}
