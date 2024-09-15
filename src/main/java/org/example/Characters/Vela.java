package org.example.Characters;

import org.example.Charachter;

public class Vela extends Charachter {

    public Vela() {
        super("Vela", "TBD", 100,1,1.25);
    }
    @Override public void normal(Charachter enemy,int p) {
        super.normal(enemy,p);

    }
    @Override public void light(Charachter enemy,int p) {
        super.light(enemy,p);

    }
    @Override public void heavy(Charachter enemy,int p) {
        super.heavy(enemy,p);

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
