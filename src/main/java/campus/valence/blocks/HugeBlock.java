package campus.valence.blocks;



import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class HugeBlock extends Blocks{

    public HugeBlock(JPanel destroyer, Set<Blocks> blocks) {
        super(destroyer, blocks);
        setHeath(20);
        setWidth(60);
        setHeight(60);
        setSpeed(4);
        setX((int) Math.floor(Math.random() * 250 + 60));
        setY(0);
        panel.setBounds(getX(), getY(), getWidth(), getHeight());
        panel.setBackground(Color.MAGENTA);


    }


}
