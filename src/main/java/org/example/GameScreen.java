package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen {
    public static final JFrame SYSTEM = new JFrame("");
    public static final JLabel LABEL = new JLabel();
    public static final UiElement CHARACTER_SELECT_BG = new UiElement(new ImageIcon[]{new ImageIcon("src/main/java/org/example/Images/Ui/charachter select.png")}, 3842, 2160, 0, 0);
    public static final UiElement CHARACTER_SELECT_HIGHLIGHT = new UiElement(new ImageIcon[]{new ImageIcon("src/main/java/org/example/Images/Ui/red select.png"), new ImageIcon("src/main/java/org/example/Images/Ui/blue select.png"), new ImageIcon("src/main/java/org/example/Images/Ui/grayed out.png"),}, 431, 355, 0, 0);

    public static UiElement[] CHARACTER_SELECT_HIGHLIGHTS = new UiElement[]{new UiElement(new ImageIcon[]{new ImageIcon("src/main/java/org/example/Images/Ui/red first select.png"), new ImageIcon("src/main/java/org/example/Images/Ui/blue first select.png"), new ImageIcon("src/main/java/org/example/Images/Ui/grayed out first.png"),}, 431, 355, 0, 1806), new UiElement(CHARACTER_SELECT_HIGHLIGHT, 253, 1806), new UiElement(CHARACTER_SELECT_HIGHLIGHT, 573, 1806), new UiElement(CHARACTER_SELECT_HIGHLIGHT, 893, 1806), new UiElement(CHARACTER_SELECT_HIGHLIGHT, 1213, 1806), new UiElement(CHARACTER_SELECT_HIGHLIGHT, 1540, 1806), new UiElement(CHARACTER_SELECT_HIGHLIGHT, 1858, 1806), new UiElement(CHARACTER_SELECT_HIGHLIGHT, 2183, 1806), new UiElement(CHARACTER_SELECT_HIGHLIGHT, 2513, 1806), new UiElement(CHARACTER_SELECT_HIGHLIGHT, 2830, 1806), new UiElement(CHARACTER_SELECT_HIGHLIGHT, 3153, 1806),


            new UiElement(new ImageIcon[]{new ImageIcon("src/main/java/org/example/Images/Ui/red edge select.png"), new ImageIcon("src/main/java/org/example/Images/Ui/blue edge select.png"), new ImageIcon("src/main/java/org/example/Images/Ui/grayed out first.png"),}, 431, 355, 3482, 1806),

    };

    public GameScreen() {


        SYSTEM.add(LABEL);
        LABEL.setIcon(CHARACTER_SELECT_BG.getImage());
        LABEL.setBounds(0, 0, (int) (3840 * UiElement.SCALE), (int) (2160 * UiElement.SCALE));
        System.out.println(UiElement.SCALE);
        SYSTEM.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SYSTEM.getContentPane().setBackground(Color.GRAY);
        SYSTEM.setVisible(true);
        SYSTEM.pack();


    }

    public void characterSelect() throws ReflectiveOperationException {
        LABEL.setIcon(CHARACTER_SELECT_BG.getImage());
        ArrayList<Charachter> team1 = new ArrayList<>();
        ArrayList<Charachter> team2 = new ArrayList<>();
        int i1 = 0;
        int i2 = 1;
        int lastI1 = 0;
        int lastI2 = 1;

        int cooldown1 = 0;
        int cooldown2 = 0;
        long lastTime = 0;
        CHARACTER_SELECT_HIGHLIGHTS[i1].setVisible(true);
        CHARACTER_SELECT_HIGHLIGHTS[i1].setImage(0);
        CHARACTER_SELECT_HIGHLIGHTS[i2].setVisible(true);
        CHARACTER_SELECT_HIGHLIGHTS[i2].setImage(1);
        ArrayList<Integer> skips1 = new ArrayList<>();
        ArrayList<Integer> skips2 = new ArrayList<>();

        while (!(team1.size() == 3 && team2.size() == 3) ) {
            Main.getGamepads().get(1).update();
            Main.getGamepads().get(0).update();

            //gamepad 1 input
            if (cooldown1 <= 0 ) {
                if (Main.getGamepads().get(0).dPadLeft && team1.size() != 3) {
                    i1--;
                    cooldown1 = 200;
                    System.out.println("left0 " + System.currentTimeMillis());
                } else if (Main.getGamepads().get(0).dPadRight && team1.size() != 3) {
                    i1++;
                    cooldown1 = 200;
                    System.out.println("Right0 " + System.currentTimeMillis());

                } else if (Main.getGamepads().get(0).a && team1.size() != 3) {
                    team1.add(Main.CHARACTERS[i1]);
                    skips1.add(i1);
                    i1++;
                    cooldown1 = 200;
                    System.out.println("a0 " + System.currentTimeMillis());

                } else if (Main.getGamepads().get(0).b) {
                    if (!team1.isEmpty()) {
                        CHARACTER_SELECT_HIGHLIGHTS[skips1.get(skips1.size() - 1)].setVisible(false);
                        skips1.remove(skips1.size() - 1);
                        team1.remove(team1.size() - 1);
                        cooldown1 = 200;

                    }

                }
            } else {
                if (team1.size() == 3) {
                    i1 = -100;
                }else if(i1==-100){
                    i1=0;
                }
                cooldown1 -= System.currentTimeMillis() - lastTime;
            }
            //gamepad 2 input
            if (cooldown2 <= 0 ) {

                if (Main.getGamepads().get(1).dPadLeft && team2.size() != 3) {
                    i2--;
                    cooldown2 = 200;
                    System.out.println("left1 " + System.currentTimeMillis());


                } else if (Main.getGamepads().get(1).dPadRight && team2.size() != 3) {
                    i2++;
                    cooldown2 = 200;
                    System.out.println("Right1 " + System.currentTimeMillis());

                } else if (Main.getGamepads().get(1).a && team2.size() != 3) {
                    team2.add(Main.CHARACTERS[i2]);
                    skips2.add(i2);
                    i2++;
                    cooldown2 = 200;
                    System.out.println("a1 " + System.currentTimeMillis());

                } else if (Main.getGamepads().get(1).b) {
                    if (!team2.isEmpty()) {
                        CHARACTER_SELECT_HIGHLIGHTS[skips2.get(skips2.size() - 1)].setVisible(false);
                        skips2.remove(skips2.size() - 1);
                        team2.remove(team2.size() - 1);
                        cooldown2 = 200;
                    }


                }
            } else {
                if (team2.size() == 3) {
                    i2 = -100;
                } else if(i2==-100){
                    i2=0;
                }
                cooldown2 -= System.currentTimeMillis() - lastTime;

            }
            for (int i = 0; i < skips1.size(); i++) {
                if (skips1.get(i) == i1) {
                    if (Main.getGamepads().get(0).dPadLeft) {
                        i1--;
                    } else  {
                        i1++;
                    }
                    i=0;
                }
                if (skips1.get(i) == i2) {
                    if (Main.getGamepads().get(1).dPadLeft) {
                        i2--;
                    } else  {
                        i2++;
                    }
                    i=0;
                }
            }
            for (int i = 0; i < skips2.size(); i++) {
                if (skips2.get(i) == i1) {
                    if (Main.getGamepads().get(0).dPadLeft) {
                        i1--;
                    } else  {
                        i1++;
                    }
                    i = 0;
                }
                if (skips2.get(i) == i2) {
                    if (Main.getGamepads().get(1).dPadLeft) {
                        i2--;
                    } else  {
                        i2++;
                    }
                    i = 0;

                }
            }
            if (i2 == i1) {
                if (Main.getGamepads().get(0).dPadLeft || Main.getGamepads().get(0).dPadRight) {
                    if (Main.getGamepads().get(0).dPadLeft) {
                        i1--;
                    } else  {
                        i1++;
                    }
                } else {
                    if (Main.getGamepads().get(1).dPadLeft) {
                        i2--;
                    } else {
                        i2++;

                    }
                }
            }

            if (i1 < 0 && i1 != -100) {
                i1 = CHARACTER_SELECT_HIGHLIGHTS.length - 1;
            }
            if (i1 >= CHARACTER_SELECT_HIGHLIGHTS.length) {
                i1 = 0;
            }
            if (i2 < 0 && i2 != -100) {
                i2 = CHARACTER_SELECT_HIGHLIGHTS.length - 1;

            }
            if (i2 >= CHARACTER_SELECT_HIGHLIGHTS.length) {
                i2 = 0;
            }
            //output the current selection
            if (i1 != lastI1 || i2 != lastI2) {

                for (int i = 0; i < CHARACTER_SELECT_HIGHLIGHTS.length; i++) {
                    if (CHARACTER_SELECT_HIGHLIGHTS[i].isVisible()) {
                        boolean isOpen = true;
                        for (int j = 0; j < skips1.size(); j++) {
                            if (skips1.get(j) == i) {
                                isOpen = false;
                                CHARACTER_SELECT_HIGHLIGHTS[skips1.get(j)].setVisible(true);
                                CHARACTER_SELECT_HIGHLIGHTS[skips1.get(j)].setImage(0);


                            }
                        }
                        for (int j = 0; j < skips2.size(); j++) {
                            if (skips2.get(j) == i) {
                                isOpen = false;
                                CHARACTER_SELECT_HIGHLIGHTS[skips2.get(j)].setVisible(true);
                                CHARACTER_SELECT_HIGHLIGHTS[skips2.get(j)].setImage(1);

                            }
                        }
                        if (isOpen) {
                            CHARACTER_SELECT_HIGHLIGHTS[i].setVisible(false);
                        }
                    }
                }
                if (i1 != -100) {
                    CHARACTER_SELECT_HIGHLIGHTS[i1].setVisible(true);
                    CHARACTER_SELECT_HIGHLIGHTS[i1].setImage(0);
                }
                if (i2 != -100) {
                    CHARACTER_SELECT_HIGHLIGHTS[i2].setVisible(true);
                    CHARACTER_SELECT_HIGHLIGHTS[i2].setImage(1);
                }
            }
            lastTime = System.currentTimeMillis();
            lastI1 = i1;
            lastI2 = i2;


        }
        System.out.println("Done");
    }

}
