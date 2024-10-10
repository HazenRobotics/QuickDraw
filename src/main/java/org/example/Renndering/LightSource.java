package org.example.Renndering;

import java.awt.*;

public class LightSource {
    private final Point pos;
    private final double power;
    public final double PIXELS_PER_UNIT=1000;

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
        return Math.pow(power*PIXELS_PER_UNIT,-d);
    }

    public double getSlopeFromPoint(Point p) {
        return (pos.y - p.y) / (pos.x -p.x);
    }
}
