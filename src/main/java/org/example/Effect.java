package org.example;

public class Effect {
    private Charachter target;
    private int triggerTime;
    private int duration;

    public Effect(Charachter t, int tt,int d) {
        target=t;
        triggerTime=tt;
        duration=d;
    }
    public void trigger() {

    }

    public Charachter getTarget() {
        return target;
    }

    public int getDuration() {
        return duration;
    }

    public int getTriggerTime() {
        return triggerTime;
    }
}
