package flappy_bird.keyboard_actions;

import flappy_bird.utils.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public Key spaceKey;

    public KeyHandler(GamePanel gamePanel){
        gamePanel.addKeyListener(this);
        this.spaceKey = new Key();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_SPACE) {
            spaceKey.setClicked(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE){
            spaceKey.setClicked(false);
        }
    }
}
