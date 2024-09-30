package org.example;

public class Dimension {
    public static final Dimension[] All_DIMENSIONS = new Dimension[]{

            new Dimension("High color city", "TBD") {

            },
            new Dimension("Sketch world", "TBD") {

            },
            new Dimension("High color city", "TBD") {

            },
            new Dimension("Endless void", "TBD") {

            },
            new Dimension("Upside-down world", "TBD") {

            },
            new Dimension("Free Fall", "TBD") {

            },
            new Dimension("Shattered islands", "TBD") {

            },


    };
    private static Dimension currentDimension = All_DIMENSIONS[0];
    private String name, folder;

    public Dimension(String n, String f) {
        name = n;
        folder = f;
    }

    public static void dimensionLoop() {
        long startTime = System.currentTimeMillis();
        while (true) {
            while (startTime + 10000 > System.currentTimeMillis()) ;
            currentDimension = All_DIMENSIONS[Main.random(0, All_DIMENSIONS.length - 1)];
        }
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

    public void effect(Charachter c) {
    }
}
