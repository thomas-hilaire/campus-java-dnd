package campus.valence;

import javax.swing.*;
import java.awt.*;

public class Destroyer {

    private static int STEP = 20;

    private final JPanel panel;

    private Fireballs fireballs;
    Destroyer(Fireballs fireballs) {
        this.fireballs = fireballs;
        panel = new JPanel();
        panel.setBounds(150, 500, 60, 30);
        panel.setBackground(Color.PINK);

    }

    public void moveLeft() {
        if (panel.getX() > 10) {
            moveX(-STEP);
        }
    }

    public void moveRight() {
        if (panel.getX() < 290) {
            moveX(STEP);
        }
    }

    private void moveX(int step) {
        Rectangle bounds = panel.getBounds();
        panel.setBounds(bounds.x + step, bounds.y, bounds.width, bounds.height);
    }

    public void destroyerFire() {
        int x = panel.getX();
        this.fireballs.send(new BigFireball(x));
    }

    public JPanel getPanel() {
        return panel;
    }
}
