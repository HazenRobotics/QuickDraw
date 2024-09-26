package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Animation {
    Point[] points;
    double scale;
    int timeMillis;
    String folder;
    int[] frameChange;
    boolean framesLoop;
    int resolution=1000;

    public Animation(Point[] p, double s, int tm, String f, int[] fc, boolean fl) {
        points = p;
        scale = s;
        timeMillis = tm;
        folder = f;
        frameChange = fc;
        framesLoop = fl;
    }
    public Animation(double[] xp,double[] yp, double s, int tm, String f, int[] fc, boolean fl) {
        points = new Point[xp.length];
        for(int i=0; i<points.length; i++) {
            points[i] = new Point((int) xp[i], (int) yp[i]);
        }
        scale = s;
        timeMillis = tm;
        folder = f;
        frameChange = fc;
        framesLoop = fl;
    }

    public Point getPosition(double n) {
        int x =  bezierCurve(points[0].x,points[1].x,points[2].x,points[3].x,n);
        int y =  bezierCurve(points[0].y,points[1].y,points[2].y,points[3].y,n);
        if(points.length>4) {
            for(int i=0; i<points.length-5; i+=2) {
                x +=  bezierCurve(points[i+3].x,(2*points[i+3].x-points[i+2].x),points[i+4].x,points[i+5].x,n);
                y +=  bezierCurve(points[i+3].y,(2*points[i+3].y-points[i+2].y),points[i+4].y,points[i+5].y,n);

            }
        }

        return new Point((int) (x*scale), (int) (y*scale));
    }

    public int bezierCurve(double w, double x, double y, double z, double t) {
        return (int) (Math.pow(x, 3) * (z - y * 3 + x * 3 - w) +
                        Math.pow(x, 2) * (y * 3 - x * 6 + w * 3) +
                        t * (3 * x - 3 * w) +
                        w);
    }

    public int getFrameIndex(int timeMillis) {
        int i = 0;
        if (framesLoop) {
            while (frameChange[i] > timeMillis) {
                i++;
                if (i < frameChange.length) {
                    i = 0;
                    timeMillis -= frameChange[i];
                }
            }
        } else {
            while (frameChange[i] > timeMillis && i < frameChange.length) {
                i++;
            }

        }
        return i;

    }

    public Thread animation(JLabel jLabel) {
        return new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (startTime + timeMillis > System.currentTimeMillis()) {
                Point p = getPosition((int) ((System.currentTimeMillis() - startTime) / timeMillis));
                jLabel.setBounds(p.x, p.y, jLabel.getWidth(), jLabel.getHeight());
                getPosition(timeMillis);
                Main.wait(timeMillis / resolution);
                System.out.println(p.x+" "+p.y);
                try {
                    jLabel.setIcon(getFrameImage(getFrameIndex(timeMillis)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public ImageIcon getFrameImage(int frame) throws IOException {
        return new ImageIcon( ImageIO.read(new File(folder).listFiles()[frame]));
    }

}