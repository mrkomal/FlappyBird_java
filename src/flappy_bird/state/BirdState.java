package flappy_bird.state;

import flappy_bird.game_objects.Bird;

import java.awt.*;

public class BirdState {

    private Bird bird;

    public BirdState(){
        bird = new Bird();
    }

    protected void displayBird(Graphics2D graphics2D){
        int x = Bird.X_LOCATION;
        int y = bird.getyLocation();

        graphics2D.setColor(Bird.COLOR);
        graphics2D.fillRect(x , y, Bird.SIZE, Bird.SIZE);
    }

    protected void moveBird(boolean jumpRequest){
        bird.fall();
        if(jumpRequest){
            bird.jump();
        }
    }

    public Bird getBird() {
        return bird;
    }
}
