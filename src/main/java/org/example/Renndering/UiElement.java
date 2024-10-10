package org.example.Renndering;

import org.example.GameScreen;

import javax.swing.*;
import java.awt.*;

public class UiElement {
    public static final float SCALE = Toolkit.getDefaultToolkit().getScreenSize().width/3840f;
    int i = 0;
    private ImageIcon[] imageStates;
    private JLabel jLabel = new JLabel();
    private int x, y;

    public UiElement(ImageIcon[] images, int w, int h, int x, int y) {
        imageStates = images;
        this.x = (int) (x*SCALE);
        this.y = (int) (y*SCALE);
        w = (int) (w*SCALE);
        h = (int) (h*SCALE);

        for (int j = 0; j < images.length; j++) {
            imageStates[j] = new ImageIcon(images[j].getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        }
        this.i = 0;
        GameScreen.SYSTEM.add(jLabel);
        jLabel.setIcon(images[0]);
        jLabel.setBounds(this.x, this.y,w, h);
        jLabel.setVisible(false);
    }
    public UiElement(UiElement ui,int x,int y) {
        imageStates= ui.imageStates;
        GameScreen.SYSTEM.add(jLabel);
        jLabel.setIcon(ui.getImage());
        jLabel.setBounds((int) (x*SCALE), (int) (y*SCALE),ui.jLabel.getWidth(), ui.jLabel.getHeight());
        jLabel.setVisible(false);
        i=ui.i;

    }


    public ImageIcon getImage() {
        return imageStates[i];
    }

    public void setImage(int i) {
        this.i = i;
        jLabel.setIcon(imageStates[i]);
    }

    public void setVisible(boolean b) {
        jLabel.setVisible(b);
    }
    public boolean isVisible() {
        return jLabel.isVisible();
    }

}
