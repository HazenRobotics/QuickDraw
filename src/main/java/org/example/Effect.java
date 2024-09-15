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
                    target.addDefense(0.5);
                }

                @Override
                public void unTrigger() {
                    target.addDefense(-0.5);
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
    };
    private Charachter target;
    private int triggerTime;
    private int duration=0;
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
