package campus.valence.blocks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Set;

public class FastBlock extends Blocks {
    private JPanel destroyer;
    private Set<Blocks> blocks;

    public FastBlock(JPanel destroyer, Set<Blocks> blocks) {
        this.destroyer = destroyer;
        this.blocks = blocks;
        setHeath(1);
        setWidth(20);
        setHeight(20);
        setSpeed(30);
        setX((int) Math.floor(Math.random() * 290 + 30));
        setY(0);
        panel.setBounds(getX(), getY(), getWidth(), getHeight());
        panel.setBackground(Color.MAGENTA);

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
}
