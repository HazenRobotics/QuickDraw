package org.example.Characters;

import org.example.Charachter;
import org.example.Effect;
import org.example.Main;

public class Arrokoth extends Charachter {

    public boolean transformedLastTurn = false;


    public Arrokoth() {
        super("Arrokoth", "Arrokoth was a dragon prince a long time ago. However, he was exiled for reasons only known to him. Through his magical cape, he can transform from an anthropomorphic dragon to a normal one. Transforming between these forms allows you to deal extra damage.",
                "TBD", 150, 0.75, 1.25);
    }

    @Override
    public Charachter[] getForms() {
        return new Charachter[]{
                new Arrokoth() {
                    @Override
                    public void normal(Charachter enemy, double p) {
                        getTeam().transform(0, getForms()[1]);
                        super.normal(enemy, p);
                    }

                    @Override
                    public void light(Charachter enemy, double p) {
                        super.light(enemy, p);
                        if (transformedLastTurn) {
                            light(enemy, p);
                        }
                    }

                    @Override
                    public void heavy(Charachter enemy, double p) {
                        super.heavy(enemy, p);
                        if (transformedLastTurn) {
                            if (getTeam().size() > 1) {
                                if (Main.choice(getTeam().getGamepadIndex(), getTeam().size() - 1, "Whos attack would you like to use?") == 0 || getTeam().size() == 2) {
                                    getTeam().get(1).heavy(enemy, p);
                                } else {
                                    getTeam().get(2).heavy(enemy, p);
                                }
                            }
                        }
                    }

                    @Override
                    public void switchIn(Charachter enemy, double p) {
                        super.switchIn(enemy, p);

                    }

                    @Override
                    public void switchOut(Charachter enemy, double p) {
                        super.switchOut(enemy, p);
                        getTeam().transform(0,  getForms()[1]);
                    }

                    @Override
                    public void block(Charachter enemy, double p) {
                        super.block(enemy, p);
                        if (transformedLastTurn) {
                            addEffect(Effect.getAllEffects()[6]);
                        }
                    }

                },
                new Arrokoth()
        };
    }

    @Override
    public void normal(Charachter enemy, double p) {
        super.normal(enemy, p);
        getTeam().transform(0,  getForms()[0]);

    }

    @Override
    public void light(Charachter enemy, double p) {
        super.light(enemy, p);
        if (transformedLastTurn) {
            if (getTeam().size() > 1) {
                if (Main.choice(getTeam().getGamepadIndex(), getTeam().size() - 1, "Whos attack would you like to use?") == 0 || getTeam().size() == 2) {
                    getTeam().get(1).light(enemy, p);
                } else {
                    getTeam().get(2).light(enemy, p);
                }
            }
        }
    }

    @Override
    public void heavy(Charachter enemy, double p) {
        super.heavy(enemy, p);
        if (transformedLastTurn) {
            heavy(enemy, p);
            getTeam().transform(0, getForms()[1]);
        }
    }

    @Override
    public void switchIn(Charachter enemy, double p) {
        super.switchIn(enemy, p);

    }

    @Override
    public void switchOut(Charachter enemy, double p) {
        super.switchOut(enemy, p);

    }

    @Override
    public void block(Charachter enemy, double p) {
        super.block(enemy, p);
        if (transformedLastTurn) {
            addEffect(Effect.getAllEffects()[6]);
        }
    }

    @Override
    public void ultimate(Charachter enemy, double p) {
        for (Charachter a : getForms()) {
            a.heavy(enemy, p);
        }
    }

}
