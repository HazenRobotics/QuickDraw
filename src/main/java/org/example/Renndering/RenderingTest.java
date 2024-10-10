package org.example.Renndering;

import org.example.GameScreen;
import org.example.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RenderingTest {
    public static void main(String[] args) throws IOException {
        Outline o = new Outline("src/main/java/org/example/Images/Charachter/Orion.png",Color.BLACK,new Point(0,0));
        JFrame jFrame = new JFrame();
        JLabel jLabel = new JLabel();

        jFrame.add(jLabel);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.getContentPane().setBackground(Color.GRAY);
        jFrame.setVisible(true);


        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        jFrame.pack();
        while (true) {
            o.addLightSource(new LightSource(new Point(Main.random(-100,100),Main.random(-100,100)),1000));
            jLabel.setIcon(o.placeOnTopOfImage());
            Main.wait(1000);
        }



    }
}
