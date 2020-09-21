package flappy_bird.utils;

import flappy_bird.collisions.CollisionChecker;
import flappy_bird.keyboard_actions.KeyHandler;
import flappy_bird.state.GameStateHandler;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{

    private boolean isRunning = false;

    private int width;
    private int height;

    private ScoreLabel scoreLabel;
    private CollisionChecker collisionChecker;

    private Thread thread;

    private BufferedImage img;
    private Graphics2D graph;

    private GameStateHandler gameState;
    private KeyHandler keyHandler;

    public GamePanel(int width, int height){
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        if(thread==null){
            thread = new Thread(this,"GameThread");
            thread.start();
        }
    }

    @Override
    public void run() {
        init();

        final double FPS = 60.0;
        final double refreshGap = Math.pow(10,9) / 60.0;

        long lastUpdateTime = System.nanoTime();
        long lastRenderTime;

        while(isRunning){
            input();
            update();
            render();
            draw();
        }
    }

    private void init(){
        isRunning = true;

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graph = (Graphics2D) img.getGraphics();

        gameState = new GameStateHandler();
        keyHandler = new KeyHandler(this);

        scoreLabel = new ScoreLabel();
        collisionChecker = new CollisionChecker(gameState);
    }

    private void input(){
        gameState.input(keyHandler);
    }

    private void update(){
        gameState.updateStates();
        gameState.updateScore(scoreLabel);
        collisionChecker.check();
    }

    private void render(){
        //background
        graph.setColor(new Color(0,255,255));
        graph.fillRect(0,0,width,height);
        //game state
        gameState.displayStates(graph);
        //game score
        graph.setColor(ScoreLabel.fontCol);
        graph.setFont(new Font(ScoreLabel.fontName, ScoreLabel.fontStyle, ScoreLabel.fontSize));
        graph.drawString(scoreLabel.textToDisplay, ScoreLabel.xLoc, ScoreLabel.yLoc);
    }

    private void draw(){
        Graphics graph2 = this.getGraphics();
        graph2.drawImage(img, 0, 0, width, height, null);
        graph2.dispose();
    }
}
