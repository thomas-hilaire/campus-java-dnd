package campus.valence.blocks;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Set;


public class Blocks extends AbstractAction {
    JPanel panel = new JPanel();
    JLabel lifePoints = new JLabel("1");
    private JPanel destroyer;
    private Set<Blocks> blocks;

    private int health;
    private int speed;
    private int width;
    private int height;
    private int x;
    private int y;


    public void moveForward() {
        panel.setLocation(getX(), getY() + getSpeed());
        setY(getY() + getSpeed());
    }
    Blocks(JPanel destroyer, Set<Blocks> blocks) {
        this.destroyer = destroyer;
        this.blocks = blocks;
        Timer timer = new Timer(100, this);
        timer.setRepeats(true);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        moveForward();
        for (Blocks block : blocks) {
            if (block.getPanel().getBounds().intersects(destroyer.getBounds())) {
                System.out.println("game over");
                System.exit(0);
            }
        }
    }



    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public JPanel getPanel() {
        return panel;
    }

    public JLabel getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(JLabel lifePoints) {
        this.lifePoints = lifePoints;
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
