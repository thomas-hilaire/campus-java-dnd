package campus.valence;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {

    private Destroyer destroyer;

    public GameKeyListener(Destroyer spaceCampus) {
        this.destroyer = spaceCampus;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 37) {
            destroyer.moveLeft();
        } else if (keyEvent.getKeyCode() == 39) {
            destroyer.moveRight();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
    }
}
