package flappy_bird.utils;

import flappy_bird.game_objects.Bird;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FlappyBirdGame{

    private void launch(){
        new Window();
    }

    public static void main(String[] args)
    {
        FlappyBirdGame flappyBirdGame = new FlappyBirdGame();
        flappyBirdGame.launch();
    }
}
