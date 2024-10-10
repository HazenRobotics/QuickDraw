package org.example.Rendering;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Outline {
    private BufferedImage image;
    private BufferedImage starting;
    private Color color;
    private Point location;
    private ArrayList<LightSource> lightSources = new ArrayList<>();

    public Outline(String path,Color c,Point l) throws IOException {
        image = ImageIO.read(new File(path));
        starting = ImageIO.read(new File(path));
        location = l;
        setColor(c);
    }

    public ArrayList<LightSource> getLightSources() {
        return lightSources;
    }
    public void addLightSource(LightSource l) {
        lightSources.add(l);
    }
    public void removeLightSource(int i) {
        lightSources.remove(i);
    }
    public void clearLightSources() {
        lightSources.clear();
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point applyLightSource(LightSource l) {
        double p = l.getPowerFromPoint(location);
        double s = l.getSlopeFromPoint(location);
        return new Point((int) (p*s), (int) (p*(1/s)));
    }
    public Point applyLightSources() {
        int x=0;
        int y=0;
        for(int i=0; i<lightSources.size(); i++) {
            Point p = applyLightSource(lightSources.get(i));
            x+=p.x;
            y+=p.y;
        }
        return new Point(x/lightSources.size(), y/lightSources.size());
    }
    public void setColor(Color c) {
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                if( (image.getRGB(i,j)>>24) != 0x00 ) {
                image.setRGB(i,j,c.getRGB());
                }
            }
        }
        color = c;
    }
    public Icon placeOnTopOfImage() {
        BufferedImage c = new BufferedImage(starting.getWidth(), starting.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Point p = applyLightSources();
        Graphics g = c.getGraphics();
        System.out.println(p.x+" "+p.y);
        g.drawImage(image, p.x, p.y, null);
        g.drawImage(starting, 0, 0, null);

        return new ImageIcon(c);
    }

}
