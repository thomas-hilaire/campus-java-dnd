package campus.valence.blocks;



import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class HugeBlock extends Blocks{

    public HugeBlock(JPanel destroyer, Set<Blocks> blocks) {
        super(destroyer, blocks);
        setHealth(20);
        setWidth(60);
        setHeight(60);
        setSpeed(4);
        setX((int) Math.floor(Math.random() * 250 + 60));
        setY(0);
        panel.setBounds(getX(), getY(), getWidth(), getHeight());
        panel.setBackground(Color.MAGENTA);
        lifePoints.setText(String.valueOf(getHealth()));
        lifePoints.setFont(new Font("Verdana",1,20));
        lifePoints.setBounds(20,20,20 ,20);
        panel.add(lifePoints);
        panel.repaint();
        lifePoints.repaint();

    }
}
