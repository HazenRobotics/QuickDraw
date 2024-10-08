package org.example.Characters;

import org.example.Charachter;
import org.example.Dimension;

public class Betelgeuse extends Charachter {
    private Dimension lastDimension = Dimension.getCurrentDimension();

    public Betelgeuse() {
        super("Betelgeuse", "",
                "TBD", 70, 1, 5);
    }

    @Override
    public void normal(Charachter enemy, double p) {
        super.normal(enemy, p);
        Dimension.cycleDimension();
        lastDimension = Dimension.getCurrentDimension();
    }

    @Override
    public void light(Charachter enemy, double p) {
        if (Dimension.getCurrentDimension() != lastDimension) {
            p *= 1.5;
        }
        super.light(enemy, p);
        lastDimension = Dimension.getCurrentDimension();

    }

    @Override
    public void heavy(Charachter enemy, double p) {
        if (Dimension.getCurrentDimension() == lastDimension) {
            p = 2;
        }
        super.heavy(enemy, p);
        lastDimension = Dimension.getCurrentDimension();

    }

    @Override
    public void block(Charachter enemy, double p) {
        Dimension.Block();
        super.block(enemy, p);
        lastDimension = Dimension.getCurrentDimension();

    }

    @Override
    public void switchIn(Charachter enemy, double p) {
        super.switchIn(enemy, p);
        Dimension.setCurrentDimension(lastDimension);
        lastDimension = Dimension.getCurrentDimension();

    }

    @Override
    public void switchOut(Charachter enemy, double p) {
        super.switchOut(enemy, p);
        lastDimension = Dimension.getCurrentDimension();

    }

    @Override
    public void ultimate(Charachter enemy, double p) {
        super.ultimate(enemy, p);
        for(int i=0; i<Dimension.All_DIMENSIONS.length; i++) {
            Dimension.All_DIMENSIONS[i].effect(enemy);
        }
        lastDimension = Dimension.getCurrentDimension();

    }
}
