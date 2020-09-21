package flappy_bird.state;

import flappy_bird.game_objects.Bird;
import flappy_bird.game_objects.Pipe;
import flappy_bird.keyboard_actions.KeyHandler;
import flappy_bird.utils.ScoreLabel;
import flappy_bird.utils.Window;

import java.awt.*;

public class GameStateHandler {

    private BirdState birdState;
    private PipesStateHandler pipesStateHandler;
    private boolean spaceKeyState;
    private int scoreState;

    public GameStateHandler(){
        reset();
    }

    public void reset(){
        this.birdState = new BirdState();
        this.pipesStateHandler = new PipesStateHandler();
        this.spaceKeyState = false;
        this.scoreState = 0;
    }

    public void input(KeyHandler keyHandler){
        spaceKeyState = keyHandler.spaceKey.getClicked();
    }

    public void displayStates(Graphics2D graphics2D){
        birdState.displayBird(graphics2D);

        int iRange = pipesStateHandler.pipeStates.size();
        for(int i = 0; i<iRange; i++){
            pipesStateHandler.pipeStates.get(i).displayPipe(graphics2D);
        }
    }

    public void updateStates(){
        pipesStateHandler.checkPipes();

        int iRange = pipesStateHandler.pipeStates.size();
        for(int i = 0; i<iRange; i++) {
            pipesStateHandler.pipeStates.get(i).movePipe();
        }

        birdState.moveBird(spaceKeyState);
    }

    public void updateScore(ScoreLabel scoreLabel) {
        scoreState = pipesStateHandler.numOfPipesThatPassedTheBird;
        scoreLabel.setScore(scoreState);
    }

    public BirdState getBirdState() {
        return birdState;
    }

    public PipesStateHandler getPipesStateHandler() {
        return pipesStateHandler;
    }
}
