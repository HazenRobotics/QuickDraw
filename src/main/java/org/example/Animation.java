package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class Animation {
    double scale;
    double timeMillis;
    String folder;
    int[] frameChange;
    boolean framesLoop;
    double resolution = 1000;
    CubicBezierCurve curve;


    public Animation(double[] xp, double[] yp, double s, int tm, String f, int[] fc, boolean fl) {
        Vector2[] points = new Vector2[xp.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Vector2(xp[i], yp[i]);
            System.out.println(xp[i]);
        }
        curve = new CubicBezierCurve(points[0], points[1], points[2], points[3]);
        for (int i = 4; i < points.length - 1; i++) {
            curve.createC1ContinuousCurve(points[i], points[i + 1]);
        }
        scale = s;
        timeMillis = tm;
        folder = f;
        frameChange = fc;
        framesLoop = fl;
    }

    public Animation(CubicBezierCurve cv, double s, int tm, String f, int[] fc, boolean fl) {
        curve = cv;
        scale = s;
        timeMillis = tm;
        folder = f;
        frameChange = fc;
        framesLoop = fl;
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
                Vector2 p = curve.calculate((System.currentTimeMillis() - startTime) / timeMillis);
                //set postion of charachter
                jLabel.setBounds((int) (p.getX() * scale), (int) (p.getY() * scale), jLabel.getWidth(), jLabel.getHeight());

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