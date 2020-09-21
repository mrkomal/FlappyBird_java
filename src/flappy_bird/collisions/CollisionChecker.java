package flappy_bird.collisions;

import flappy_bird.game_objects.Bird;
import flappy_bird.game_objects.Pipe;
import flappy_bird.state.BirdState;
import flappy_bird.state.GameStateHandler;
import flappy_bird.state.PipeState;

import java.util.ArrayList;

public class CollisionChecker {

    private GameStateHandler gameStateHandler;

    public CollisionChecker(GameStateHandler gameStateHandler){
        this.gameStateHandler = gameStateHandler;
    }

    public void check(){
        ArrayList<PipeState> pipeStates = gameStateHandler.getPipesStateHandler().pipeStates;

        //1st step: there must be at least one pipe
        if(!pipeStates.isEmpty()) {
            int pipeX1 = pipeStates.get(0).getPipe().getxLoc();
            int birdX1 = Bird.X_LOCATION;
            int birdX2 = birdX1 + Bird.SIZE;

            //2nd step: check conditions if pipe's beginning reaches the bird's beginning (x coordinates)
            if(pipeX1 <= birdX2){

                int pipeX2 = pipeX1 + Pipe.WIDTH;
                int pipeY1 = pipeStates.get(0).getPipe().getGapY1();
                int pipeY2 = pipeStates.get(0).getPipe().getGapY2();

                int birdY1 = gameStateHandler.getBirdState().getBird().getyLocation();
                int birdY2 = birdY1 + Bird.SIZE;

                //3rd step: conditions
                //1st condition: bird's y coordinates must be inside pipe gap - required: true
                boolean YCond = checkIfIsBetween(pipeY1, pipeY2, birdY1, birdY2);
                //2nd condition: bird's last x coordinate must be bigger than pipe's last x coordinate - required:true
                boolean XCond = compareToFirstVal(pipeX2, birdX1);
                //if both conditions are false => collision has occurred => reset all states
                if(!YCond && !XCond){
                    gameStateHandler.reset();
                }
            }
        }
    }

    private boolean checkIfIsBetween(int min, int max, int ... ints){
        boolean isBetween = true;

        for (int n : ints) {
            if (n < min || n > max) {
                isBetween = false;
                break;
            }
        }
        return isBetween;
    }

    private boolean compareToFirstVal(int firstVal, int valToCompare){
        boolean isSmaller = true;

        if(firstVal>=valToCompare){
            isSmaller = false;
        }
        return isSmaller;
    }

}
