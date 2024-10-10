package org.example.Rendering;

import java.awt.*;

public class LightSource {
    private final Point pos;
    private final double power;
    public final double PIXELS_PER_UNIT=100000;

    public LightSource(Point po, double p) {
        pos = po;
        power = p;
    }

    public double getPower() {
        return power;
    }

    public double getPowerFromPoint(Point p) {
        return getPowerFromDistance(Math.hypot(p.x - pos.x, p.y - pos.y));
    }

    public double getPowerFromDistance(double d) {
        double i=(-(1/16.5)*d)+17;
        System.out.println(i);
        if(d>40) {
            i=0.5;
        }
        return power/(Math.pow(d,i));
    }

    public double getSlopeFromPoint(Point p) {
        return (pos.y - p.y) / (pos.x -p.x);
    }
}
