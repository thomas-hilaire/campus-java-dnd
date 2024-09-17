package campus.valence.blocks.enemiesBlocks;



import campus.valence.Destroyer;

import javax.swing.*;
import java.awt.*;


public class SlowBlock extends EnemyBlock {

    public SlowBlock(Destroyer destroyer, JPanel panel) {
        super(destroyer, panel);
        setValue(1);
        setHealth(1);
        setWidth(20);
        setHeight(20);
        setSpeed(1);
        setX((int) Math.floor(Math.random()*290+30));
        setY(0);
        getOneBlockPanel().setBounds(getX(), getY(), getWidth(), getHeight());
        getOneBlockPanel().setBackground(Color.red);

    }



}
