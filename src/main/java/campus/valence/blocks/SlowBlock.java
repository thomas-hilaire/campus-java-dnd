package campus.valence.blocks;



import javax.swing.*;
import java.awt.*;
import java.util.Set;


public class SlowBlock extends Blocks{

    public SlowBlock(JPanel destroyer, Set<Blocks> blocks) {
        super(destroyer,blocks);
        setHeath(1);
        setWidth(20);
        setHeight(20);
        setSpeed(5);
        setX((int) Math.floor(Math.random()*290+30));
        setY(0);
        panel.setBounds(getX(), getY(), getWidth(), getHeight());
        panel.setBackground(Color.red);


    }



}
