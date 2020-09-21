package flappy_bird.utils;

import javax.swing.JFrame;

public class Window {

    public static final int HEIGHT = 660;
    public static final int WIDTH = 1200;
    private static final String TITLE = "Flappy Bird";

    public Window(){
        JFrame window = new JFrame();
        window.setSize(WIDTH, HEIGHT);
        window.setContentPane(new GamePanel(WIDTH, HEIGHT));
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle(TITLE);
        window.setVisible(true);
    }
}
