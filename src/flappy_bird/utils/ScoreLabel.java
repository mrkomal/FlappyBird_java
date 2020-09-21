package flappy_bird.utils;

import java.awt.*;

public class ScoreLabel {

    public String textToDisplay;
    private int score;

    public static final Color fontCol = Color.BLACK;
    public static final int fontSize = 50;
    public static final String fontName = "Dialog";
    public static final int fontStyle = Font.PLAIN;
    public static final int xLoc = 0;
    public static final int yLoc = fontSize;

    public ScoreLabel(){
        this.score = 0;
        updateText();
    }

    public void setScore(int score) {
        this.score = score;
        updateText();
    }

    private void updateText(){
        this.textToDisplay = String.format("Score: %d",score);
    }
}
