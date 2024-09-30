package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Animation {
    double scale;
    double timeMillis;
    String folder;
    int[] frameChange;
    boolean framesLoop;
    ArrayList<CubicBezierCurve> curve;
    Point start;


    public Animation(double[] xp, double[] yp, double s, int tm, String f, int[] fc, boolean fl, Point st) {
        ArrayList<Vector2> points = new ArrayList<>();
        for (int i = 0; i < xp.length; i++) {
            points.add(new Vector2(xp[i], yp[i]));
        }
        curve = new ArrayList<>();
        curve.add(new CubicBezierCurve(points.get(0), points.get(1), points.get(2), points.get(3)));
        points.remove(0);
        points.remove(0);
        points.remove(0);
        points.remove(0);
        while (!points.isEmpty()) {
            curve.add(curve.get(curve.size() - 1).createC1ContinuousCurve(points.get(0), points.get(1)));
            points.remove(0);
            points.remove(0);
        }
        scale = s;
        timeMillis = tm;
        folder = f;
        frameChange = fc;
        framesLoop = fl;
        start = st;
    }

    public Animation(ArrayList<CubicBezierCurve> cv, double s, int tm, String f, int[] fc, boolean fl, Point st) {
        curve = cv;
        scale = s;
        timeMillis = tm;
        folder = f;
        frameChange = fc;
        framesLoop = fl;
        start = st;

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
            //start
            long startTime = System.currentTimeMillis();
            for (int i = 0; startTime + timeMillis > System.currentTimeMillis(); i++) {
                //get point
                double time = ((System.currentTimeMillis() - startTime) / timeMillis) * curve.size();

                Vector2 p = curve.get((int) time).calculate(time - (int) (time));
                //set postion of charachter
                System.out.println(p.getX() + " " + p.getY());
                jLabel.setBounds((int) (start.x + (p.getX() * scale)), (int) (start.y + (p.getY() * scale)), jLabel.getWidth(), jLabel.getHeight());

                try {
                    jLabel.setIcon(getFrameImage(getFrameIndex((int) timeMillis)));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }



    public ImageIcon getFrameImage(int frame) throws IOException {
        return new ImageIcon(ImageIO.read(new File(folder).listFiles()[frame]));
    }

}