package campus.valence.blocks;

import campus.valence.Destroyer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Set;
import java.util.zip.DeflaterInputStream;

public abstract class Block extends AbstractAction {
    JPanel oneBlockPanel = new JPanel();
    JPanel panel;


    private Destroyer destroyer;



    private int speed;
    private int width;
    private int height;
    private int x;
    private int y;


    public void moveForward() {
        oneBlockPanel.setLocation(getX(), getY() + getSpeed());
        setY(getY() + getSpeed());
    }

    public Block(Destroyer destroyer, JPanel panel) {
        this.destroyer = destroyer;
        this.panel = panel;
        Timer timer = new Timer(15, this);
        timer.setRepeats(true);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        moveForward();
        if (getOneBlockPanel().getBounds().intersects(destroyer.getPanel().getBounds())) {
            panel.remove(getOneBlockPanel());
            blockInteraction();
        }
    }

    public abstract void blockInteraction();


    public Destroyer getDestroyer() {
        return destroyer;
    }
    public JPanel getOneBlockPanel() {
        return oneBlockPanel;
    }

    public JPanel getPanel() {
        return panel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
