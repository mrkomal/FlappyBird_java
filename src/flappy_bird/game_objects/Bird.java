package flappy_bird.game_objects;

import flappy_bird.utils.Window;

import java.awt.*;

public class Bird {

    public static final Color COLOR = Color.RED;
    public static final int SIZE = 40;
    public static final int X_LOCATION = Window.WIDTH/8;

    private static final int GRAVITY_FORCE = 2;
    private static final int LIFT = 10;

    private int yLocation;

    public Bird(){
        this.yLocation = Window.HEIGHT/3;
    }

    public void jump() {
        if(yLocation >= LIFT){
            yLocation -= LIFT;
        }
    }

    public void fall() {
        int birdBottom = yLocation + SIZE*3/2;

        if(birdBottom <= Window.HEIGHT - GRAVITY_FORCE){
            yLocation += GRAVITY_FORCE;
        }
    }

    public int getyLocation() {
        return yLocation;
    }

}
