package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Dimension {
    public static final Dimension[] All_DIMENSIONS = new Dimension[]{

            new Dimension("High color city", "TBD", new Color[]{}) {
                @Override
                public void effect(Charachter c) {
                    super.effect(c);
                }
            },
            new Dimension("Sketch world", "TBD",new Color[]{}) {
                @Override
                public void effect(Charachter c) {
                    super.effect(c);
                }
            },
            new Dimension("Endless void", "TBD",new Color[]{}) {
                @Override
                public void effect(Charachter c) {
                    super.effect(c);
                }
            },
            new Dimension("Upside-down world", "TBD",new Color[]{}) {
                @Override
                public void effect(Charachter c) {
                    super.effect(c);
                }
            },
            new Dimension("Free Fall", "TBD",new Color[]{}) {
                @Override
                public void effect(Charachter c) {
                    super.effect(c);
                }
            },
            new Dimension("Shattered islands", "TBD",new Color[]{}) {
                @Override
                public void effect(Charachter c) {
                    super.effect(c);
                }
            },


    };
    private static Dimension currentDimension = All_DIMENSIONS[0];
    public static final Color[] PALLET_TO_CHANGE = {};
    private final Color[] pallet;
    private final String name, folder;
    private static boolean blocked = false;
    public static void Block() {
        blocked=true;
    }
    public Dimension(String n, String f,Color[] p) {
        pallet=p;
        name = n;
        folder = f;
    }

    public static void dimensionLoop() {
        long startTime = System.currentTimeMillis();
        while (true) {
            while (startTime + 10000 > System.currentTimeMillis()) ;
            if(!blocked) {
                cycleDimension();
            } else {
                blocked=false;
            }
        }
    }
    public static void cycleDimension() {
        currentDimension = All_DIMENSIONS[Main.random(0, All_DIMENSIONS.length - 1)];
    }

    public static Dimension getCurrentDimension() {
        return currentDimension;
    }

    public void runForEveryone(Team t1, Team t2) {
        for (Charachter c : t1.getTeam()) {
            effect(c);
        }
        for (Charachter c : t2.getTeam()) {
            effect(c);
        }
    }

    public static void setCurrentDimension(Dimension currentDimension) {
        Dimension.currentDimension = currentDimension;
    }

    public void effect(Charachter c) {
    }
    public ImageIcon changeToPallet(ImageIcon i) {
        BufferedImage b = (BufferedImage) i.getImage();
        for(int j=0; j<b.getWidth(); j++) {
            for(int k=0; k<b.getHeight(); k++) {
                Color c1 = new Color(b.getRGB(j,k));
                for(int l=0; l<PALLET_TO_CHANGE.length; l++) {
                    Color c2 = PALLET_TO_CHANGE[l];
                    if(Math.sqrt((c1.getRed()-c2.getRed())^2+(c1.getGreen()-c2.getGreen())^2+(c1.getBlue()-c2.getBlue()^2))<=10) {
                        b.setRGB(j,k,pallet[l].getRGB());
                    }
                }
            }
        }
        return new ImageIcon(b);
    }
}
