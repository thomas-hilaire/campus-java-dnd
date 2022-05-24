package campus.valence.blocks;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Set;


public class Blocks extends AbstractAction {
    JPanel panel = new JPanel();
    Set<JPanel> blocks;

    private int heath;
    private int speed;
    private int width;
    private int height;
    private int x;
    private int y;


    public void moveForward() {
        panel.setLocation(getX(), getY() + getSpeed());
        setY(getY() + getSpeed());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
    }



    public int getHeath() {
        return heath;
    }

    public void setHeath(int heath) {
        this.heath = heath;
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
