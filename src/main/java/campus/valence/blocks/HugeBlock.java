package campus.valence.blocks;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Set;

public class HugeBlock extends Blocks{
    private JPanel destroyer;
    private Set<Blocks> blocks;

    public HugeBlock(JPanel destroyer, Set<Blocks> blocks) {
        this.destroyer = destroyer;
        this.blocks = blocks;
        setHeath(20);
        setWidth(60);
        setHeight(60);
        setSpeed(4);
        setX((int) Math.floor(Math.random() * 250 + 60));
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
