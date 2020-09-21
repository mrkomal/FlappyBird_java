package flappy_bird.state;

import flappy_bird.game_objects.Bird;
import flappy_bird.game_objects.Pipe;
import flappy_bird.utils.Window;

import java.awt.*;

public class PipeState {

    private Pipe pipe;

    protected boolean pipeHasPassedBird;

    public PipeState(){
        pipe = new Pipe();
        pipeHasPassedBird = false;
    }

    protected void displayPipe(Graphics2D graphics2D){
        int y1 = pipe.getGapY1();
        int y2 = pipe.getGapY2();
        int x = pipe.getxLoc();

        graphics2D.setColor(Pipe.COLOR);
        //upper part of pipe
        graphics2D.fillRect(x , 0, Pipe.WIDTH, y1);
        //lower part of pipe
        graphics2D.fillRect(x , y2, Pipe.WIDTH, Window.HEIGHT);
    }

    protected void movePipe(){
        int newxLoc = pipe.getxLoc() - 3;
        checkIfPassedTheBird(newxLoc+Pipe.WIDTH);
        pipe.setxLoc(newxLoc);
    }

    private void checkIfPassedTheBird(int xLoc){
        if(xLoc < Bird.X_LOCATION){
            pipeHasPassedBird = true;
        }
    }

    public Pipe getPipe() {
        return pipe;
    }
}
