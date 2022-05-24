package campus.valence.blocks;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class FastBlock extends Blocks {


    public FastBlock(JPanel destroyer, Set<Blocks> blocks) {
        super(destroyer, blocks);
        setHeath(1);
        setWidth(20);
        setHeight(20);
        setSpeed(30);
        setX((int) Math.floor(Math.random() * 290 + 30));
        setY(0);
        panel.setBounds(getX(), getY(), getWidth(), getHeight());
        panel.setBackground(Color.MAGENTA);

    }


}
