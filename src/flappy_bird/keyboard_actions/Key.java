package flappy_bird.keyboard_actions;

public class Key {

    private boolean clicked;

    public Key(){
        this.clicked = false;
    }

    public boolean getClicked(){
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
