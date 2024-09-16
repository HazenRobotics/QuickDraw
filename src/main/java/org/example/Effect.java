package org.example;

public abstract class Effect {
    /*
    * 0 before
    * 1 during
    * 2 after
    * */
    public final Effect[] ALL_EFFECTS = new Effect[] {
            new Effect("Block","TBD",0,1) {
                @Override
                public void trigger() {
                    target.addDefense(2);
                }

                @Override
                public void unTrigger() {
                    target.addDefense(1);
                }
            },
            new Effect("Perfect Block", "TBD", 1, 1) {
                @Override
                public void trigger() {

                }

                @Override
                public void unTrigger() {

                }
            },
            new Effect("Poison", "TBD", 2, 3) {
                @Override
                public void trigger() {
                    int damage = 10+(3*(4-duration));
                    target.changeHp(damage);
                }

                @Override
                public void unTrigger() {

                }
            },
            new Effect("Attack Boost","TBD",0,3) {
                @Override
                public void trigger() {
                    target.setAttackPower(target.getAttackPower()+0.25);
                }

                @Override
                public void unTrigger() {
                    target.setAttackPower(target.getBaseStats()[0]);
                }
            },
            new Effect("Sweeper","TBD",0,1) {
                @Override
                public void trigger() {
                    if(target.getTeam().fighter().equals(target)) {
                        setDuration(2);
                    } else {
                        setDuration(0);
                    }
                    target.setAttackPower(target.getAttackPower()+0.1);

                }

                @Override
                public void unTrigger() {
                    target.setAttackPower(target.getBaseStats()[0]);
                }
            },
            new Effect("Opening","TBD",0,1) {
                @Override
                public void trigger() {
                    target.setDefense(-0.5);
                }

                @Override
                public void unTrigger() {
                    target.setDefense(1);
                }
            },
            new Effect("Bulk up","TBD",0,2) {
                @Override
                public void trigger() {
                    target.addDefense(0.33);
                }

                @Override
                public void unTrigger() {
                    target.addDefense(-0.66);
                }
            },
            new Effect("Weakness","TBD",0,2) {
                @Override
                public void trigger() {
                    target.setAttackPower(0.5);
                }

                @Override
                public void unTrigger() {
                    target.setAttackPower(target.getBaseStats()[0]);
                }
            },
    };
    private Charachter target;
    private int triggerTime;
    private int duration;
    private String name;
    private String folder;




    public Effect(String n, String f, int tt, int d) {
        name=n;
        folder=f;
        triggerTime=tt;
        duration=d;
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
        return duration<=0;
    }

    public int getTriggerTime() {
        return triggerTime;
    }
    public static Effect[] getAllEffects() {
        return getAllEffects();
    }

    public abstract void trigger();

    public abstract void unTrigger();
}
interface EffectVoid {
    void run();
}
