package flappy_bird.game_objects;

import flappy_bird.utils.Window;

import java.awt.Color;

public class Pipe {

    public static final Color COLOR = Color.GREEN.darker();
    public static final int WIDTH = 80;

    private static final int overallLength = Window.HEIGHT;
    private static final int minimalLength = 50;
    private static final int gapSize = 250;

    private int xLoc;

    private int gapY1;
    private int gapY2;

    public Pipe(){
        this.xLoc = Window.WIDTH;
        generateGapCoords();
    }

    private void generateGapCoords(){
        this.gapY1 = minimalLength + (int) (Math.random()*calculateMaxY1Add());
        this.gapY2 = gapY1 + gapSize;
    }

    private int calculateMaxY1Add(){
        return overallLength-(2*minimalLength+gapSize);
    }

    public int getGapY1() {
        return gapY1;
    }

    public int getGapY2() {
        return gapY2;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }
}
