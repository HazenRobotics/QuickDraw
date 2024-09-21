package org.example;

interface EffectVoid {
    void run();
}

public abstract class Effect {
    private final int triggerTime;
    private final String name;
    private final String folder;
    private Charachter target;
    private int duration;
    private boolean isDebuff;
    /*
     * 0 before
     * 1 during
     * 2 after
     * */
    public final Effect[] ALL_EFFECTS = new Effect[]{
            new Effect("Block", "TBD", 0, 1,false) {
                @Override
                public void trigger() {
                    target.addDefense(2);
                }

            },
            new Effect("Perfect Block", "TBD", 1, 1,false) {
                @Override
                public void trigger() {

                }


            },
            new Effect("Poison", "TBD", 2, 3,true) {
                @Override
                public void trigger() {
                    int damage = (3 * (4 - duration));
                    target.changeHp(damage);
                }

            },
            new Effect("Attack Boost", "TBD", 0, 3,false) {
                @Override
                public void trigger() {
                    target.addAttackPower(0.5);
                }

            },
            new Effect("Sweeper", "TBD", 0, 1,false) {
                @Override
                public void trigger() {
                    if (target.getTeam().fighter().equals(target)) {
                        setDuration(2);
                    } else {
                        setDuration(0);
                    }
                    target.setAttackPower(target.getAttackPower() + 0.1);

                }

            },
            new Effect("Opening", "TBD", 0, 1,true) {
                @Override
                public void trigger() {
                    target.setDefense(-0.5);
                }

            },
            new Effect("Bulk up", "TBD", 0, 2,false) {
                @Override
                public void trigger() {
                    target.addDefense(0.5);
                }

            },
            new Effect("Weakness", "TBD", 0, 2,true) {
                @Override
                public void trigger() {
                    target.setAttackPower(0.5);
                }

            },
            new Effect("Haunt", "TBD", 0, 2,true) {
                @Override
                public void trigger() {
                    target.changeHp(5);
                }

            },
            new Effect("Future Attack", "TBD", 0, 3,true) {
                @Override
                public void trigger() {
                    if (duration == 0) {
                        target.changeHp(20);

                    }
                }

            },
            new Effect("Future Attack", "TBD", 2, 5,true) {
                @Override
                public void trigger() {
                    if (duration == 0) {
                        target.changeHp(20);

                    }
                }

            },
            new Effect("Locked", "TBD", 0, 2,true) {
                @Override
                public void trigger() {
                }

            },
            new Effect("Switch", "TBD", 2, 1,false) {
                @Override
                public void trigger() {
                    if (Main.choice(target.getTeam().getGamepadIndex(), 1, "Would you like to switch") == 0) {
                        target.getTeam().switchFighter(Main.choice(target.getTeam().getGamepadIndex(), 1, "Who would you like to switch"));
                    }
                }

            },
            new Effect("Healing", "TBD", 2, 3,false) {
                @Override
                public void trigger() {
                    target.changeHp(-3);
                }

            },

    };


    public Effect(String n, String f, int tt, int d, boolean de) {
        name = n;
        folder = f;
        triggerTime = tt;
        duration = d;
        isDebuff = de;
    }

    public boolean isDebuff() {
        return isDebuff;
    }

    public static Effect[] getAllEffects() {
        return getAllEffects();
    }

    public String getName() {
        return name;
    }

    public Charachter getTarget() {
        return target;
    }

    public void setTarget(Charachter target) {
        this.target = target;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean tickDown() {
        duration--;
        return duration <= 0;
    }

    public int getTriggerTime() {
        return triggerTime;
    }

    public abstract void trigger();

}
