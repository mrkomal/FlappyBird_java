package flappy_bird.state;

import flappy_bird.game_objects.Pipe;
import flappy_bird.utils.Window;

import java.util.ArrayList;

public class PipesStateHandler {

    private static int NUM_OF_PIPES_AT_1TIME = 2;
    private static int X_LOC_OF_LAST_PIPE = Window.WIDTH*(NUM_OF_PIPES_AT_1TIME-1)/NUM_OF_PIPES_AT_1TIME;

    public int currentNumOfPipes;
    private int xLocOfLastPipe;
    private int xLocOfFirstPipe;

    public int numOfPipesThatPassedTheBird;

    public ArrayList<PipeState> pipeStates;

    private ArrayList<PipeState> pipesThatAlreadyPassed;

    public PipesStateHandler(){
        pipeStates = new ArrayList<>();
        pipesThatAlreadyPassed = new ArrayList<>();
        currentNumOfPipes = 0;
        xLocOfLastPipe = Window.WIDTH;
        xLocOfFirstPipe = 0;
        numOfPipesThatPassedTheBird = 0;
    }

    public void checkPipes(){
        currentNumOfPipes = pipeStates.size();

        // condition required for the beginning of the game, when no pipes has been generated yet
        if(!pipeStates.isEmpty()){
            PipeState firstPipeState = pipeStates.get(0);
            if(firstPipeState.pipeHasPassedBird && !pipesThatAlreadyPassed.contains(firstPipeState)){
                numOfPipesThatPassedTheBird += 1;
                pipesThatAlreadyPassed.add(firstPipeState);
            }
            xLocOfFirstPipe = firstPipeState.getPipe().getxLoc() + Pipe.WIDTH;
            PipeState lastPipeState = pipeStates.get(currentNumOfPipes-1);
            xLocOfLastPipe = lastPipeState.getPipe().getxLoc();
        }

        if(currentNumOfPipes==0) {
            generateNewPipeState(); // start of the game
        } else if(currentNumOfPipes<NUM_OF_PIPES_AT_1TIME && xLocOfLastPipe<=X_LOC_OF_LAST_PIPE) {
            generateNewPipeState(); // creating pipes till desired limit is achieved
        } else if(currentNumOfPipes==NUM_OF_PIPES_AT_1TIME && xLocOfFirstPipe<0){
            removeOldStates();
            generateNewPipeState();  // getting rid of old states and generating new pipes
        }
    }

    private void generateNewPipeState(){
        pipeStates.add(new PipeState());
    }

    private void removeOldStates(){
        pipeStates.remove(0);
        pipesThatAlreadyPassed.remove(0);
    }
}
