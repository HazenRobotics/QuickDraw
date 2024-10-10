package org.example.Rendering;

import org.example.Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class RenderingTest {
    public static void main(String[] args) throws IOException {
        Outline o = new Outline("src/main/java/org/example/Images/Charachters/Orion.png", Color.BLACK, new Point(0, 0));
        JFrame jFrame = new JFrame();
        JLabel jLabel = new JLabel();
        jFrame.add(jLabel);
        jFrame.getContentPane().setBackground(Color.GRAY);
        jFrame.setVisible(true);
        jFrame.pack();
        int i=1;

        while (true) {
            System.out.println(i);
            o.clearLightSources();
            o.addLightSource(new LightSource(new Point(i, i), 100));
            jLabel.setIcon(o.placeOnTopOfImage());
            Main.wait(100);
            i++;
        }

    }


}
